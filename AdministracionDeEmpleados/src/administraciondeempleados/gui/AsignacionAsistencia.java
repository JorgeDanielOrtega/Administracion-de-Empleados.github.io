package administraciondeempleados.gui;

import administraciondeempleados.Asistencia;
import administraciondeempleados.EstadoAsistencia;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;


public class AsignacionAsistencia extends javax.swing.JDialog {

    private final int TIMEMPO_ESPERA = 10;
    private List<Asistencia> asistenciaList;
    private Calendar horaEntrada;
    private Calendar horaActual;
   
    /**
     * Creates new form AsistenciaGUI
     */
    public AsignacionAsistencia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        buttonGroup = new ButtonGroup();
        this.horaActual = Calendar.getInstance();
    }

    public AsignacionAsistencia(java.awt.Frame parent, boolean modal, List<Asistencia> asistenciaList, Calendar horaEntrada) {
        this(parent, modal);
        addElementostoButtonGroup();
        this.asistenciaList = asistenciaList;
        this.horaEntrada = horaEntrada;
        desactivarPresente();
    }

    private void addElementostoButtonGroup() {
        buttonGroup.add(rbt_presente);
        buttonGroup.add(rbt_faltaJustificada);
        buttonGroup.add(rbt_faltaInjustificada);
    }

    private void desactivarPresente() {
        boolean desactivarPresente = horaEntrada.get(Calendar.MINUTE) < horaActual.get(Calendar.MINUTE) 
                && horaActual.get(Calendar.MINUTE) < (horaEntrada.get(Calendar.MINUTE) + TIMEMPO_ESPERA); 
        if (!desactivarPresente) {
            rbt_presente.setEnabled(false); //configurar la activacion de nuevo mas tarde
        }else{
            rbt_presente.setEnabled(true);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        btn_marcar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        rbt_presente = new javax.swing.JRadioButton();
        rbt_faltaJustificada = new javax.swing.JRadioButton();
        rbt_faltaInjustificada = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Marcar Asistencia");
        setBackground(new java.awt.Color(204, 204, 204));

        btn_marcar.setText("Marcar");
        btn_marcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_marcarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        buttonGroup.add(rbt_presente);
        rbt_presente.setText("Presente");
        rbt_presente.setName("PRESENTE"); // NOI18N

        buttonGroup.add(rbt_faltaJustificada);
        rbt_faltaJustificada.setText("Falta justificada");
        rbt_faltaJustificada.setName("FALTA_JUSTIFICADA"); // NOI18N

        buttonGroup.add(rbt_faltaInjustificada);
        rbt_faltaInjustificada.setText("Retraso");
        rbt_faltaInjustificada.setName("RETRASO"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_marcar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbt_presente, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbt_faltaInjustificada)
                        .addGap(18, 18, 18)
                        .addComponent(rbt_faltaJustificada)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbt_faltaJustificada)
                    .addComponent(rbt_presente)
                    .addComponent(rbt_faltaInjustificada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_marcar)
                    .addComponent(btn_cancelar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    //IMPLEMENTAR METODO para que guarde el estado de lo marcado, y que se pueda modificar, y no se agregue otro elemento a la asistenciaList
    
    
    
    private EstadoAsistencia recuperarEstado() { //quizas
        String estado = "";
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                estado = button.getText(); 
                return EstadoAsistencia.valueOf(button.getName());
            }
        }
        return null;
    }

    private void btn_marcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_marcarActionPerformed
        Asistencia asistencia = new Asistencia(recuperarEstado());
        asistenciaList.add(asistencia);
        dispose();
    }//GEN-LAST:event_btn_marcarActionPerformed

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
            java.util.logging.Logger.getLogger(AsignacionAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignacionAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignacionAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignacionAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AsignacionAsistencia dialog = new AsignacionAsistencia(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_marcar;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JRadioButton rbt_faltaInjustificada;
    private javax.swing.JRadioButton rbt_faltaJustificada;
    private javax.swing.JRadioButton rbt_presente;
    // End of variables declaration//GEN-END:variables
}
