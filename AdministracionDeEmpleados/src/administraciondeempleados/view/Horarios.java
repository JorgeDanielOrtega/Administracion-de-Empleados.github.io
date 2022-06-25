package administraciondeempleados.view;
import java.awt.Color;
import administraciondeempleados.Horario;
import administraciondeempleados.Gerente;

public class Horarios extends javax.swing.JFrame {

    int xPos, yPos;
    DiaHorario diaHorario;
    Horario horario;
    Gerente gerente;
    
    public Horarios() {
        initComponents();
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modelTableHorarios1 = new administraciondeempleados.view.ModelTableHorarios();
        pnlBackground = new javax.swing.JPanel();
        lbBarraSuperior = new javax.swing.JPanel();
        pnlExit = new javax.swing.JPanel();
        lbExit = new javax.swing.JLabel();
        lblHorarios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorarios = new javax.swing.JTable();
        btnAgregarHorario = new javax.swing.JButton();
        btnEliminarHorario = new javax.swing.JButton();
        btnEditarHorario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1035, 450));

        pnlBackground.setBackground(new java.awt.Color(246, 246, 246));
        pnlBackground.setMinimumSize(new java.awt.Dimension(1035, 460));
        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbBarraSuperior.setBackground(new java.awt.Color(221, 221, 221));
        lbBarraSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbBarraSuperiorMouseDragged(evt);
            }
        });
        lbBarraSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbBarraSuperiorMousePressed(evt);
            }
        });

        pnlExit.setBackground(new java.awt.Color(221, 221, 221));
        pnlExit.setPreferredSize(new java.awt.Dimension(30, 30));

        lbExit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExit.setText("X");
        lbExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlExitLayout = new javax.swing.GroupLayout(pnlExit);
        pnlExit.setLayout(pnlExitLayout);
        pnlExitLayout.setHorizontalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbExit, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );
        pnlExitLayout.setVerticalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbExit, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout lbBarraSuperiorLayout = new javax.swing.GroupLayout(lbBarraSuperior);
        lbBarraSuperior.setLayout(lbBarraSuperiorLayout);
        lbBarraSuperiorLayout.setHorizontalGroup(
            lbBarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbBarraSuperiorLayout.createSequentialGroup()
                .addGap(0, 1000, Short.MAX_VALUE)
                .addComponent(pnlExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        lbBarraSuperiorLayout.setVerticalGroup(
            lbBarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbBarraSuperiorLayout.createSequentialGroup()
                .addComponent(pnlExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlBackground.add(lbBarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 40));

        lblHorarios.setBackground(new java.awt.Color(255, 255, 255));
        lblHorarios.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblHorarios.setForeground(new java.awt.Color(51, 51, 51));
        lblHorarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHorarios.setText("HORARIOS");
        pnlBackground.add(lblHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 180, 50));

        tblHorarios.setModel(modelTableHorarios1);
        jScrollPane1.setViewportView(tblHorarios);

        pnlBackground.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 920, 280));

        btnAgregarHorario.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        btnAgregarHorario.setText("Agregar Horario");
        btnAgregarHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarHorarioMouseClicked(evt);
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
        pnlBackground.add(btnEliminarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, -1, -1));

        btnEditarHorario.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        btnEditarHorario.setText("Editar Horario");
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

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        System.exit(0); //dispose()
    }//GEN-LAST:event_lbExitMouseClicked

    private void lbExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseEntered
        pnlExit.setBackground(Color.red);
        lbExit.setForeground(Color.white);
    }//GEN-LAST:event_lbExitMouseEntered

    private void lbExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseExited
        pnlExit.setBackground(new Color(221,221,221));
        lbExit.setForeground(Color.black);
    }//GEN-LAST:event_lbExitMouseExited

    private void lbBarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBarraSuperiorMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xPos, y - yPos);
    }//GEN-LAST:event_lbBarraSuperiorMouseDragged

    private void lbBarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBarraSuperiorMousePressed
        xPos = evt.getX();
        yPos = evt.getY();
    }//GEN-LAST:event_lbBarraSuperiorMousePressed

    private void btnAgregarHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarHorarioMouseClicked
        diaHorario = new DiaHorario(this, true);
        diaHorario.setVisible(true);
        if(diaHorario.getHorario() != null){
            this.horario = diaHorario.getHorario();
            gerente.crearHorario(horario.getTipo(), horario.getDiasLaborablesList(), horario.getHorasLaborablesSemanales());
            //modelTableHorarios.agregarHo
        }
    }//GEN-LAST:event_btnAgregarHorarioMouseClicked

    private void btnEliminarHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarHorarioMouseClicked
        //modelTableHorarios.getSelectedValue();
    }//GEN-LAST:event_btnEliminarHorarioMouseClicked

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
    private javax.swing.JPanel lbBarraSuperior;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lblHorarios;
    private administraciondeempleados.view.ModelTableHorarios modelTableHorarios1;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlExit;
    private javax.swing.JTable tblHorarios;
    // End of variables declaration//GEN-END:variables
}
