package administraciondeempleados.view;

import administraciondeempleados.Horario;
import administraciondeempleados.DiasLaborales;
import administraciondeempleados.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import prueb.DBConnect;

public class DiaHorario extends javax.swing.JDialog {

    private Horario horario;
    private Gerente gerente;
    int indice;
    private DBConnect dbConnect;
    private Connection connection;
    private String sql;
    private PreparedStatement ps;
    private ResultSet result;

    public DiaHorario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dbConnect = new DBConnect();
    }

    public DiaHorario(java.awt.Frame parent, boolean modal, Gerente gerente) {
        this(parent, modal);
        this.gerente = gerente;
    }

    public void generarHorario() {
        List<DiasLaborales> diasLaboralesList = recuperarComboBoxSelecionados();
        this.horario = new Horario(txtTipo.getText().trim(), diasLaboralesList, Float.valueOf(txtHorasSemanales.getText()));
        long id = 0;
        try {
            connection = dbConnect.conectar();
            sql = "INSERT INTO \"horarios\" (tipo,horas_semanales) VALUES (?,?)";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, horario.getTipo());
            ps.setFloat(2, horario.getHorasLaborablesSemanales());
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            while (result.next()) {
                id = result.getLong(1);
            }
            subirDiasLaborales(diasLaboralesList, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo subir el horario");
            System.out.println("erro en horario xd " + e.getMessage());
        } finally {
            dbConnect.desconectar();
        }
    }

    public void actualizarHorario() {
        this.horario = gerente.getEmpresa().getHorarioList().get(indice);
        long id = retornarId(horario);
        this.horario.setDiasLaborablesList(recuperarComboBoxSelecionados());
        this.horario.setHorasLaborablesSemanales(Float.parseFloat(txtHorasSemanales.getText()));
        this.horario.setTipo(txtTipo.getText().trim());
        actualizarHorarioDB(id);
    }

    private long retornarId(Horario horario) {
        try {
            connection = dbConnect.conectar();
            String query = "SELECT id FROM \"horarios\" WHERE tipo='" + horario.getTipo() + "';";
            PreparedStatement p = connection.prepareStatement(query);
            result = p.executeQuery();
            while (result.next()) {
                return result.getLong("id");
            }
        } catch (Exception e) {
            System.out.println("error al retornar idxdxd " + e.getMessage());
        }
        return 0;
    }

    private void actualizarHorarioDB(long id) {
        try {
            eliminarDiasLaboralesDB(id);
            subirDiasLaborales(recuperarComboBoxSelecionados(), id);
            sql = "  UPDATE \"horarios\" SET tipo= '" + horario.getTipo()
                    + "',horas_semanales=" + horario.getHorasLaborablesSemanales()
                    + " WHERE id =" + id + ";";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("no se puedo acualizar el horario " + e.getMessage());
        } finally {
            dbConnect.desconectar();
        }
    }

    private void eliminarDiasLaboralesDB(long id) {
        try {
            String query = "DELETE FROM \"horarios_dias_laborables\" WHERE id_horarios =" + id;
            PreparedStatement p = connection.prepareStatement(query);
            p.execute();
        } catch (Exception e) {
            System.out.println("error al eliminar dias laborales " + e.getMessage());
        }
    }

    public List<DiasLaborales> recuperarComboBoxSelecionados() {
        List<DiasLaborales> diasLaboralesList = new LinkedList<>();
        if (chbLunes.isSelected()) {
            diasLaboralesList.add(DiasLaborales.LU);
        }

        if (chbMartes.isSelected()) {
            diasLaboralesList.add(DiasLaborales.MA);
        }

        if (chbMiercoles.isSelected()) {
            diasLaboralesList.add(DiasLaborales.MI);
        }

        if (chbJueves.isSelected()) {
            diasLaboralesList.add(DiasLaborales.JU);
        }

        if (chbViernes.isSelected()) {
            diasLaboralesList.add(DiasLaborales.VI);
        }

        if (chbSabado.isSelected()) {
            diasLaboralesList.add(DiasLaborales.SA);
        }

        if (chbDomingo.isSelected()) {
            diasLaboralesList.add(DiasLaborales.DO);
        }
        return diasLaboralesList;
    }

    private void subirDiasLaborales(List<DiasLaborales> diasLaboralesList, long id) {
        try {
            String query = " INSERT INTO \"horarios_dias_laborables\" (id_dias_Laborables, id_horarios) VALUES (?,?);"; // quizas poner las comillas simples
            for (DiasLaborales diasLaborales : diasLaboralesList) {
                PreparedStatement p = connection.prepareStatement(query);
                p.setLong(1, diasLaborales.getDiaLaboral());
                p.setLong(2, id);
                p.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("error a la hora de subir dias laborables " + e.getMessage());
        }
    }

    public void completarCampos() {
        txtTipo.setText(gerente.getEmpresa().getHorarioList().get(indice).getTipo());
        rellenarDiasLaborables();
        txtHorasSemanales.setText(String.valueOf(gerente.getEmpresa().getHorarioList().get(indice).getHorasLaborablesSemanales()));
    }

    private void rellenarDiasLaborables() {
        List<DiasLaborales> diasLaboralesList = gerente.getEmpresa().getHorarioList().get(indice).getDiasLaborablesList();
        for (DiasLaborales diasLaborales : diasLaboralesList) {

            switch (diasLaborales) {
                case LU:
                    chbLunes.setSelected(true);
                    break;
                case MA:
                    chbMartes.setSelected(true);
                    break;
                case MI:
                    chbMiercoles.setSelected(true);
                    break;
                case JU:
                    chbJueves.setSelected(true);
                    break;
                case VI:
                    chbViernes.setSelected(true);
                    break;
                case SA:
                    chbSabado.setSelected(true);
                    break;
                case DO:
                    chbDomingo.setSelected(true);
                    break;
            }
        }
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblHorarios = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblDiasLaborables = new javax.swing.JLabel();
        lblHorasSemanales = new javax.swing.JLabel();
        txtHorasSemanales = new javax.swing.JTextField();
        btnAgregarHorario = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        chbMiercoles = new javax.swing.JCheckBox();
        chbViernes = new javax.swing.JCheckBox();
        chbJueves = new javax.swing.JCheckBox();
        chbDomingo = new javax.swing.JCheckBox();
        chbLunes = new javax.swing.JCheckBox();
        chbMartes = new javax.swing.JCheckBox();
        chbSabado = new javax.swing.JCheckBox();
        btn_actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(760, 310));

        jPanel1.setBackground(new java.awt.Color(246, 246, 246));
        jPanel1.setMinimumSize(new java.awt.Dimension(760, 310));

        lblHorarios.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblHorarios.setForeground(new java.awt.Color(0, 0, 0));
        lblHorarios.setText("HORARIO");

        lblTipo.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(0, 0, 0));
        lblTipo.setText("Tipo:");

        txtTipo.setBackground(new java.awt.Color(255, 255, 255));
        txtTipo.setForeground(new java.awt.Color(0, 0, 0));

        lblDiasLaborables.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        lblDiasLaborables.setForeground(new java.awt.Color(0, 0, 0));
        lblDiasLaborables.setText("Dias Laborales:");

        lblHorasSemanales.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        lblHorasSemanales.setForeground(new java.awt.Color(0, 0, 0));
        lblHorasSemanales.setText("Horas laborables semanales:");

        txtHorasSemanales.setBackground(new java.awt.Color(255, 255, 255));
        txtHorasSemanales.setForeground(new java.awt.Color(0, 0, 0));

        btnAgregarHorario.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarHorario.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        btnAgregarHorario.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarHorario.setText("Agregar Horario");
        btnAgregarHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarHorarioMouseClicked(evt);
            }
        });
        btnAgregarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHorarioActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        chbMiercoles.setBackground(new java.awt.Color(246, 246, 246));
        chbMiercoles.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbMiercoles.setForeground(new java.awt.Color(0, 0, 0));
        chbMiercoles.setText("Miercoles");

        chbViernes.setBackground(new java.awt.Color(246, 246, 246));
        chbViernes.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbViernes.setForeground(new java.awt.Color(0, 0, 0));
        chbViernes.setText("Viernes");

        chbJueves.setBackground(new java.awt.Color(246, 246, 246));
        chbJueves.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbJueves.setForeground(new java.awt.Color(0, 0, 0));
        chbJueves.setText("Jueves");

        chbDomingo.setBackground(new java.awt.Color(246, 246, 246));
        chbDomingo.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbDomingo.setForeground(new java.awt.Color(0, 0, 0));
        chbDomingo.setText("Domingo");

        chbLunes.setBackground(new java.awt.Color(246, 246, 246));
        chbLunes.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbLunes.setForeground(new java.awt.Color(0, 0, 0));
        chbLunes.setText("Lunes");

        chbMartes.setBackground(new java.awt.Color(246, 246, 246));
        chbMartes.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbMartes.setForeground(new java.awt.Color(0, 0, 0));
        chbMartes.setText("Martes");

        chbSabado.setBackground(new java.awt.Color(246, 246, 246));
        chbSabado.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbSabado.setForeground(new java.awt.Color(0, 0, 0));
        chbSabado.setText("Sabado");

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(lblHorarios))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTipo)
                .addGap(5, 5, 5)
                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblDiasLaborables)
                .addGap(5, 5, 5)
                .addComponent(chbLunes)
                .addGap(4, 4, 4)
                .addComponent(chbMartes)
                .addGap(10, 10, 10)
                .addComponent(chbMiercoles)
                .addGap(9, 9, 9)
                .addComponent(chbJueves)
                .addGap(6, 6, 6)
                .addComponent(chbViernes)
                .addGap(3, 3, 3)
                .addComponent(chbSabado)
                .addGap(5, 5, 5)
                .addComponent(chbDomingo))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(txtHorasSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHorasSemanales)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(btnAgregarHorario)
                .addGap(17, 17, 17)
                .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCancelar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblHorarios)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiasLaborables)
                    .addComponent(chbLunes)
                    .addComponent(chbMartes)
                    .addComponent(chbMiercoles)
                    .addComponent(chbJueves)
                    .addComponent(chbViernes)
                    .addComponent(chbSabado)
                    .addComponent(chbDomingo))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorasSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHorasSemanales))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarHorario)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarHorarioMouseClicked
        generarHorario();
        gerente.getEmpresa().getHorarioList().add(horario);
        JOptionPane.showMessageDialog(this, "Horario Generado");
        this.dispose();
    }//GEN-LAST:event_btnAgregarHorarioMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnAgregarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarHorarioActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        actualizarHorario();
        dispose();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiaHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiaHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiaHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiaHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiaHorario dialog = new DiaHorario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarHorario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JCheckBox chbDomingo;
    private javax.swing.JCheckBox chbJueves;
    private javax.swing.JCheckBox chbLunes;
    private javax.swing.JCheckBox chbMartes;
    private javax.swing.JCheckBox chbMiercoles;
    private javax.swing.JCheckBox chbSabado;
    private javax.swing.JCheckBox chbViernes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDiasLaborables;
    private javax.swing.JLabel lblHorarios;
    private javax.swing.JLabel lblHorasSemanales;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtHorasSemanales;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
