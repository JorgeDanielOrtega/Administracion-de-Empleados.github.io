package administraciondeempleados.view;

import java.awt.Color;
import administraciondeempleados.Horario;
import administraciondeempleados.Gerente;

public class Horarios extends javax.swing.JFrame {

    int xPos, yPos;
    private DiaHorario diaHorario;
    private Horario horario;
    private Gerente gerente;

    public Horarios() {
        initComponents();
        setLocationRelativeTo(this);
    }

    public Horarios(Gerente gerente) {
        this();
        this.gerente = gerente;
        this.horario = new Horario();
        modelTableHorarios.cargarModelo(gerente.getEmpresa());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modelTableHorarios = new administraciondeempleados.view.ModelTableHorarios();
        pnlBackground = new javax.swing.JPanel();
        lblHorarios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorarios = new javax.swing.JTable();
        btnAgregarHorario = new javax.swing.JButton();
        btnEliminarHorario = new javax.swing.JButton();
        btnEditarHorario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1035, 450));

        pnlBackground.setBackground(new java.awt.Color(246, 246, 246));
        pnlBackground.setMinimumSize(new java.awt.Dimension(1035, 460));
        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHorarios.setBackground(new java.awt.Color(255, 255, 255));
        lblHorarios.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblHorarios.setForeground(new java.awt.Color(51, 51, 51));
        lblHorarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHorarios.setText("HORARIOS");
        pnlBackground.add(lblHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 180, 50));

        tblHorarios.setModel(modelTableHorarios);
        jScrollPane1.setViewportView(tblHorarios);

        pnlBackground.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 920, 280));

        btnAgregarHorario.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
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
        pnlBackground.add(btnAgregarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, -1, -1));

        btnEliminarHorario.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        btnEliminarHorario.setText("Eliminar Horario");
        btnEliminarHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarHorarioMouseClicked(evt);
            }
        });
        btnEliminarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHorarioActionPerformed(evt);
            }
        });
        pnlBackground.add(btnEliminarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, -1, -1));

        btnEditarHorario.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        btnEditarHorario.setText("Editar Horario");
        btnEditarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarHorarioActionPerformed(evt);
            }
        });
        pnlBackground.add(btnEditarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarHorarioMouseClicked
        diaHorario = new DiaHorario(this, true, gerente);
        //diaHorario.setGerente(gerente);
        diaHorario.setVisible(true);
        modelTableHorarios.cargarModelo(gerente.getEmpresa());
    }//GEN-LAST:event_btnAgregarHorarioMouseClicked

    private void btnEliminarHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarHorarioMouseClicked
        //modelTableHorarios.getSelectedValue();
    }//GEN-LAST:event_btnEliminarHorarioMouseClicked

    private void btnAgregarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarHorarioActionPerformed

    private void btnEditarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarHorarioActionPerformed
        diaHorario = new DiaHorario(this, true, gerente);
        diaHorario.setIndice(tblHorarios.getSelectedRow());
        diaHorario.completarCampos();
        diaHorario.setVisible(true);
        modelTableHorarios.cargarModelo(gerente.getEmpresa());
    }//GEN-LAST:event_btnEditarHorarioActionPerformed

    private void btnEliminarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHorarioActionPerformed
        gerente.getEmpresa().getHorarioList().remove(tblHorarios.getSelectedRow());
        modelTableHorarios.cargarModelo(gerente.getEmpresa());
    }//GEN-LAST:event_btnEliminarHorarioActionPerformed

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
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Horarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarHorario;
    private javax.swing.JButton btnEditarHorario;
    private javax.swing.JButton btnEliminarHorario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHorarios;
    private administraciondeempleados.view.ModelTableHorarios modelTableHorarios;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTable tblHorarios;
    // End of variables declaration//GEN-END:variables
}
