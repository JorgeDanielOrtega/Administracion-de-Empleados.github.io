package administraciondeempleados.view;

import administraciondeempleados.Horario;
import administraciondeempleados.DiasLaborales;
import administraciondeempleados.Gerente;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class DiaHorario extends javax.swing.JDialog {

    private Horario horario;
    private Gerente gerente;
    int indice;

    public DiaHorario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //horario = new Horario();
    }

    public DiaHorario(java.awt.Frame parent, boolean modal, Gerente gerente) {
        this(parent, modal);
        this.gerente = gerente;
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

    public void generarHorario() {
        this.horario = new Horario(txtTipo.getText().trim(), recuperarComboBoxSelecionados(), Float.valueOf(txtHorasSemanales.getText()));
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

    public void completarCampos() {
        txtTipo.setText(gerente.getEmpresa().getHorarioList().get(indice).getTipo());
        rellenarDiasLaborables();
        txtHorasSemanales.setText(String.valueOf(gerente.getEmpresa().getHorarioList().get(indice).getHorasLaborablesSemanales()));
    }

    public void actualizarHorario() {
        this.horario = gerente.getEmpresa().getHorarioList().get(indice);
        this.horario.setDiasLaborablesList(recuperarComboBoxSelecionados());
        this.horario.setHorasLaborablesSemanales(Float.parseFloat(txtHorasSemanales.getText()));
        this.horario.setTipo(txtTipo.getText().trim());
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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHorarios.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblHorarios.setForeground(new java.awt.Color(0, 0, 0));
        lblHorarios.setText("HORARIO");
        jPanel1.add(lblHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        lblTipo.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(0, 0, 0));
        lblTipo.setText("Tipo:");
        jPanel1.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        txtTipo.setBackground(new java.awt.Color(255, 255, 255));
        txtTipo.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 660, -1));

        lblDiasLaborables.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        lblDiasLaborables.setForeground(new java.awt.Color(0, 0, 0));
        lblDiasLaborables.setText("Dias Laborales:");
        jPanel1.add(lblDiasLaborables, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        lblHorasSemanales.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        lblHorasSemanales.setForeground(new java.awt.Color(0, 0, 0));
        lblHorasSemanales.setText("Horas laborables semanales:");
        jPanel1.add(lblHorasSemanales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtHorasSemanales.setBackground(new java.awt.Color(255, 255, 255));
        txtHorasSemanales.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtHorasSemanales, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 460, -1));

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
        jPanel1.add(btnAgregarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, -1));

        chbMiercoles.setBackground(new java.awt.Color(246, 246, 246));
        chbMiercoles.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbMiercoles.setForeground(new java.awt.Color(0, 0, 0));
        chbMiercoles.setText("Miercoles");
        jPanel1.add(chbMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        chbViernes.setBackground(new java.awt.Color(246, 246, 246));
        chbViernes.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbViernes.setForeground(new java.awt.Color(0, 0, 0));
        chbViernes.setText("Viernes");
        jPanel1.add(chbViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, -1));

        chbJueves.setBackground(new java.awt.Color(246, 246, 246));
        chbJueves.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbJueves.setForeground(new java.awt.Color(0, 0, 0));
        chbJueves.setText("Jueves");
        jPanel1.add(chbJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        chbDomingo.setBackground(new java.awt.Color(246, 246, 246));
        chbDomingo.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbDomingo.setForeground(new java.awt.Color(0, 0, 0));
        chbDomingo.setText("Domingo");
        jPanel1.add(chbDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        chbLunes.setBackground(new java.awt.Color(246, 246, 246));
        chbLunes.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbLunes.setForeground(new java.awt.Color(0, 0, 0));
        chbLunes.setText("Lunes");
        jPanel1.add(chbLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        chbMartes.setBackground(new java.awt.Color(246, 246, 246));
        chbMartes.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbMartes.setForeground(new java.awt.Color(0, 0, 0));
        chbMartes.setText("Martes");
        jPanel1.add(chbMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        chbSabado.setBackground(new java.awt.Color(246, 246, 246));
        chbSabado.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        chbSabado.setForeground(new java.awt.Color(0, 0, 0));
        chbSabado.setText("Sabado");
        jPanel1.add(chbSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
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
