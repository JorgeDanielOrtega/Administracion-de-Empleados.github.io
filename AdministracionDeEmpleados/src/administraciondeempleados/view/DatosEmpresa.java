
package administraciondeempleados.view;

import java.awt.Color;
import administraciondeempleados.Cuenta;
import javax.swing.border.SoftBevelBorder;
import administraciondeempleados.Empresa;
import javax.swing.JOptionPane;

public class DatosEmpresa extends javax.swing.JFrame {

    DiaLogin diaLogin;
    Cuenta cuentaActual;
    SoftBevelBorder softBevelBorder;
    Empresa empresa;
       
    int xPos, yPos;
    
    public DatosEmpresa() {
        initComponents();
        setLocationRelativeTo(null);
        abrirLogin();
    }
    
    public void abrirLogin(){
        diaLogin = new DiaLogin(this, true);
        this.setVisible(false);
        diaLogin.setVisible(true);
        cuentaActual = diaLogin.getCuenta();
    }

    public void resetearTxt(){
        txtNombreEmpresa.setBorder(null);
        txtNombreEmpresa.setBackground(new Color(246,246,246));
        txtNombreEmpresa.setForeground(new Color(153,153,153));
        txtNombreEmpresa.setEditable(false);
        
        txtFundacionYear.setBorder(null);
        txtFundacionYear.setBackground(new Color(246,246,246));
        txtFundacionYear.setForeground(new Color(153,153,153));
        txtFundacionYear.setEditable(false);
        
        txtRubroEmpresa.setBorder(null);
        txtRubroEmpresa.setBackground(new Color(246,246,246));
        txtRubroEmpresa.setForeground(new Color(153,153,153));
        txtRubroEmpresa.setEditable(false);
        
        txtLeyendaEmpresa.setBorder(null);
        txtLeyendaEmpresa.setBackground(new Color(246,246,246));
        txtLeyendaEmpresa.setForeground(new Color(153,153,153));
        txtLeyendaEmpresa.setEnabled(false);            
        txtLeyendaEmpresa.setEditable(false);
    }
    
    public void guardarDatos(){       
        if(empresa == null){
            if(!txtNombreEmpresa.getText().equals("Nombre Empresa") && !txtFundacionYear.getText().equals("Año Fundacion") && !txtRubroEmpresa.getText().equals("Rubro") && !txtLeyendaEmpresa.getText().equals("Leyenda") && !txtNombreEmpresa.getText().isEmpty() && !txtFundacionYear.getText().isEmpty() && !txtRubroEmpresa.getText().isEmpty() && !txtLeyendaEmpresa.getText().isEmpty()){
                System.out.println("w");
                empresa = new Empresa(txtNombreEmpresa.getText(), Integer.parseInt(txtFundacionYear.getText()), txtRubroEmpresa.getText());
                empresa.setLeyenda(txtLeyendaEmpresa.getText());
            }
        }else{
            if(txtLeyendaEmpresa.getText().equals("")){
                txtLeyendaEmpresa.setText(empresa.getLeyenda());
            }else{
                empresa.setLeyenda(txtLeyendaEmpresa.getText());
            }
        
            if(txtFundacionYear.getText().equals("Año fundacion") || txtFundacionYear.getText().equals("") && empresa.getFundacionYear() != 0){
                txtFundacionYear.setText(String.valueOf(empresa.getFundacionYear()));
            }
        
            if(txtNombreEmpresa.getText().equals("")){
                txtNombreEmpresa.setText(empresa.getNombre());
            }else{
                empresa.setNombre(txtNombreEmpresa.getText());
            }
        
            if(txtRubroEmpresa.getText().equals("")){
                txtRubroEmpresa.setText(empresa.getRubro());
            }else{
                empresa.setRubro(txtRubroEmpresa.getText());
            }
        }
        
        resetearTxt();
    }
    
    public Cuenta getCuentaActual() {
        return cuentaActual;
    }

    public void setCuentaActual(Cuenta cuentaActual) {
        this.cuentaActual = cuentaActual;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lbBarraSuperior = new javax.swing.JPanel();
        pnlExit = new javax.swing.JPanel();
        lbExit = new javax.swing.JLabel();
        lblInformacion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblAnioFundacion = new javax.swing.JLabel();
        lblRubro = new javax.swing.JLabel();
        scpLeyendaEmpresa = new javax.swing.JScrollPane();
        txtLeyendaEmpresa = new javax.swing.JTextArea();
        txtFundacionYear = new javax.swing.JTextField();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtRubroEmpresa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1035, 460));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

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
        lbExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGap(0, 990, Short.MAX_VALUE)
                .addComponent(pnlExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        lbBarraSuperiorLayout.setVerticalGroup(
            lbBarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbBarraSuperiorLayout.createSequentialGroup()
                .addComponent(pnlExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlBackground.add(lbBarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 40));

        lblInformacion.setBackground(new java.awt.Color(255, 255, 255));
        lblInformacion.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblInformacion.setForeground(new java.awt.Color(51, 51, 51));
        lblInformacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInformacion.setText("INFORMACION");
        pnlBackground.add(lblInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 180, 50));

        lblNombre.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblNombre.setText("Nombre:");
        pnlBackground.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 30));

        lblAnioFundacion.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblAnioFundacion.setText("Año de fundación:");
        pnlBackground.add(lblAnioFundacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, 30));

        lblRubro.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblRubro.setText("Rubro:");
        pnlBackground.add(lblRubro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 30));

        txtLeyendaEmpresa.setEditable(false);
        txtLeyendaEmpresa.setBackground(new java.awt.Color(246, 246, 246));
        txtLeyendaEmpresa.setColumns(20);
        txtLeyendaEmpresa.setFont(new java.awt.Font("Roboto Light", 2, 18)); // NOI18N
        txtLeyendaEmpresa.setRows(10);
        txtLeyendaEmpresa.setText("Leyenda");
        txtLeyendaEmpresa.setEnabled(false);
        txtLeyendaEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLeyendaEmpresaMouseClicked(evt);
            }
        });
        scpLeyendaEmpresa.setViewportView(txtLeyendaEmpresa);

        pnlBackground.add(scpLeyendaEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 910, 130));

        txtFundacionYear.setEditable(false);
        txtFundacionYear.setBackground(new java.awt.Color(246, 246, 246));
        txtFundacionYear.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        txtFundacionYear.setForeground(new java.awt.Color(153, 153, 153));
        txtFundacionYear.setText("Año Fundacion");
        txtFundacionYear.setBorder(null);
        txtFundacionYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFundacionYearMouseClicked(evt);
            }
        });
        pnlBackground.add(txtFundacionYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 720, 30));

        txtNombreEmpresa.setEditable(false);
        txtNombreEmpresa.setBackground(new java.awt.Color(246, 246, 246));
        txtNombreEmpresa.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        txtNombreEmpresa.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreEmpresa.setText("Nombre Empresa");
        txtNombreEmpresa.setBorder(null);
        txtNombreEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreEmpresaMouseClicked(evt);
            }
        });
        pnlBackground.add(txtNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 720, 30));

        txtRubroEmpresa.setEditable(false);
        txtRubroEmpresa.setBackground(new java.awt.Color(246, 246, 246));
        txtRubroEmpresa.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        txtRubroEmpresa.setForeground(new java.awt.Color(153, 153, 153));
        txtRubroEmpresa.setText("Rubro");
        txtRubroEmpresa.setBorder(null);
        txtRubroEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRubroEmpresaMouseClicked(evt);
            }
        });
        pnlBackground.add(txtRubroEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 720, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtLeyendaEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLeyendaEmpresaMouseClicked
        if(cuentaActual.getCorreoEmpresarial().equals("admin")){
            txtLeyendaEmpresa.setText("");
            txtLeyendaEmpresa.setEnabled(true);            
            txtLeyendaEmpresa.setEditable(true);
            txtLeyendaEmpresa.setBorder(softBevelBorder);
            txtLeyendaEmpresa.setBackground(Color.white);
            txtLeyendaEmpresa.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtLeyendaEmpresaMouseClicked

    private void txtFundacionYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFundacionYearMouseClicked
        if(txtFundacionYear.getText().equals("Año Fundacion")){
            if(cuentaActual.getCorreoEmpresarial().equals("admin")){
                txtFundacionYear.setText("");          
                txtFundacionYear.setEditable(true);
                txtFundacionYear.setBorder(softBevelBorder);
                txtFundacionYear.setBackground(Color.white);
                txtFundacionYear.setForeground(Color.black);
            }
        }
    }//GEN-LAST:event_txtFundacionYearMouseClicked

    private void txtNombreEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreEmpresaMouseClicked
        if(cuentaActual.getCorreoEmpresarial().equals("admin")){
            txtNombreEmpresa.setText("");
            txtNombreEmpresa.setEditable(true);
            txtNombreEmpresa.setBorder(softBevelBorder);
            txtNombreEmpresa.setBackground(Color.white);
            txtNombreEmpresa.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNombreEmpresaMouseClicked

    private void txtRubroEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRubroEmpresaMouseClicked
        if(cuentaActual.getCorreoEmpresarial().equals("admin")){
            txtRubroEmpresa.setText("");
            txtRubroEmpresa.setEditable(true);
            txtRubroEmpresa.setBorder(softBevelBorder);
            txtRubroEmpresa.setBackground(Color.white);
            txtRubroEmpresa.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtRubroEmpresaMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        guardarDatos();
    }//GEN-LAST:event_formMouseClicked

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
            java.util.logging.Logger.getLogger(DatosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatosEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel lbBarraSuperior;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lblAnioFundacion;
    private javax.swing.JLabel lblInformacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRubro;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlExit;
    private javax.swing.JScrollPane scpLeyendaEmpresa;
    private javax.swing.JTextField txtFundacionYear;
    private javax.swing.JTextArea txtLeyendaEmpresa;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtRubroEmpresa;
    // End of variables declaration//GEN-END:variables
}
