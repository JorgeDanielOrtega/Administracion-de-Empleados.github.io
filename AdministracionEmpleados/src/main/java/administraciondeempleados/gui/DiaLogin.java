package administraciondeempleados.gui;

import java.awt.Color;
import administraciondeempleados.Cuenta;
import administraciondeempleados.Departamento;
import javax.swing.JOptionPane;
import administraciondeempleados.Empresa;
import administraciondeempleados.Rol;
import administraciondeempleados.Trabajador;

public class DiaLogin extends javax.swing.JDialog {

    private Cuenta cuenta;
    private Empresa empresa;
    private java.awt.Frame parent;
    private int xPos, yPos;
    
    public DiaLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.parent = parent;
        parent.setVisible(false);
    }
    
    public DiaLogin(java.awt.Frame parent, boolean modal, Empresa empresa) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.parent = parent;
        parent.setVisible(false);
        this.empresa = empresa;
    }
    
//    public void llenarCampos(){
//        txtUsuario.setText(cuenta.getCorreoEmpresarial());
//        txtContraseña.setText(cuenta.getContraseña());
//        //System.out.println(cuenta);
//    }
    
    public void obtenerCuenta(){
        Rol rol = null;
        for(int i = 0; i < empresa.getDepartamentoList().size(); i++){
            for(int j = 0; j < empresa.getDepartamentoList().get(i).getTrabajadorList().size(); j++){
                if(empresa.getDepartamentoList().get(i).getTrabajadorList().get(j).getUsuario().equals(txtUsuario.getText())){
                    rol = empresa.getDepartamentoList().get(i).getTrabajadorList().get(j).getRol();
                    break;
                }
            }
        }
        this.cuenta = new Cuenta(txtUsuario.getText(), String.valueOf(txtContraseña.getPassword()), rol);
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lbUsuario = new javax.swing.JLabel();
        lbContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        lbBarraSuperior = new javax.swing.JPanel();
        pnlExit = new javax.swing.JPanel();
        lbExit = new javax.swing.JLabel();
        pnlIngresar = new javax.swing.JPanel();
        lbIngresar = new javax.swing.JLabel();
        lbNombreEmpresa = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbRecuperarContraseña = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        pnlBackground.setBackground(new java.awt.Color(246, 246, 246));
        pnlBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBackgroundMouseClicked(evt);
            }
        });

        lbUsuario.setFont(new java.awt.Font("Serif", 1, 19)); // NOI18N
        lbUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUsuario.setText("Usuario");

        lbContraseña.setFont(new java.awt.Font("Serif", 1, 19)); // NOI18N
        lbContraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbContraseña.setText("Contraseña");

        txtContraseña.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(204, 204, 204));
        txtContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContraseña.setText("**********");
        txtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtContraseñaMouseClicked(evt);
            }
        });
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setText("Nombre de usuario");
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseClicked(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

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
                .addGap(0, 310, Short.MAX_VALUE)
                .addComponent(pnlExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        lbBarraSuperiorLayout.setVerticalGroup(
            lbBarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbBarraSuperiorLayout.createSequentialGroup()
                .addComponent(pnlExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlIngresar.setBackground(new java.awt.Color(204, 204, 204));

        lbIngresar.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        lbIngresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIngresar.setText("INGRESAR");
        lbIngresar.setToolTipText("");
        lbIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIngresarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlIngresarLayout = new javax.swing.GroupLayout(pnlIngresar);
        pnlIngresar.setLayout(pnlIngresarLayout);
        pnlIngresarLayout.setHorizontalGroup(
            pnlIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        pnlIngresarLayout.setVerticalGroup(
            pnlIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresarLayout.createSequentialGroup()
                .addComponent(lbIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbNombreEmpresa.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbNombreEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNombreEmpresa.setText("NOMBRE EMPRESA");

        lbRecuperarContraseña.setFont(new java.awt.Font("Roboto Thin", 2, 14)); // NOI18N
        lbRecuperarContraseña.setText("Recuperar contraseña");
        lbRecuperarContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbRecuperarContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRecuperarContraseñaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(lbContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(pnlIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbRecuperarContraseña)
                .addGap(98, 98, 98))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(lbBarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbNombreEmpresa)
                .addGap(41, 41, 41)
                .addComponent(lbUsuario)
                .addGap(5, 5, 5)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lbContraseña)
                .addGap(5, 5, 5)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbRecuperarContraseña)
                .addGap(60, 60, 60)
                .addComponent(pnlIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMouseClicked
        if(String.valueOf(txtContraseña.getPassword()).equals("**********")){
            txtContraseña.setForeground(Color.black);
            txtContraseña.setText("");
        }

        if(txtUsuario.getText().isEmpty()){
            txtUsuario.setForeground(new Color(204, 204, 204));
            txtUsuario.setText("Nombre de usuario");
        }
    }//GEN-LAST:event_txtContraseñaMouseClicked

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseClicked
        if(txtUsuario.getText().equals("Nombre de usuario")){
            txtUsuario.setForeground(Color.black);
            txtUsuario.setText("");
        }

        if(String.valueOf(txtContraseña.getPassword()).isEmpty()){
            txtContraseña.setForeground(new Color(204, 204, 204));
            txtContraseña.setText("**********");
        }
    }//GEN-LAST:event_txtUsuarioMouseClicked

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        System.exit(0);
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

    private void lbIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIngresarMouseClicked

        boolean ingreso = false;
        System.out.println("Trabajadores");
        System.out.println(empresa.getTrabajadorList());
        System.out.println("\n");
        System.out.println("Departamentos");
        System.out.println(empresa.getDepartamentoList());
        System.out.println("\n");
        System.out.println(empresa.getGerenteList());
        System.out.println("Roles");
        System.out.println(empresa.getRolList());
        
        
        for (int i = 0; i < empresa.getTrabajadorList().size(); i++) {
            if(empresa.getTrabajadorList().get(i).getUsuario().equals(txtUsuario.getText())){
                if(empresa.getTrabajadorList().get(i).getPassword().equals(String.valueOf(txtContraseña.getPassword()))){
                    ingreso = true;
                    obtenerCuenta();
                    parent.setVisible(true);
                    this.setVisible(false);
                    break;
                }else{
                    ingreso = true;
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    break;
                }
            }
        }
        
        if(ingreso == false){
            for (int i = 0; i < empresa.getGerenteList().size(); i++) {
                if(empresa.getGerenteList().get(i).getUsuario().equals(txtUsuario.getText())){
                    if(empresa.getGerenteList().get(i).getPassword().equals(String.valueOf(txtContraseña.getPassword()))){
                        ingreso = true;
                        obtenerCuenta();
                        parent.setVisible(true);
                        this.setVisible(false);
                        break;
                    }else{
                        ingreso = true;
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                        break;
                    }
                }
            }
        }
        
        if(ingreso == false){
            for(int i = 0; i < empresa.getDepartamentoList().size(); i++){
                System.out.println(empresa.getDepartamentoList().get(i));
                for(int j = 0; j < empresa.getDepartamentoList().get(i).getTrabajadorList().size(); j++){
                        System.out.println(empresa.getDepartamentoList().get(i).getTrabajadorList().get(j));
                    if(empresa.getDepartamentoList().get(i).getTrabajadorList().get(j).getUsuario().equals(txtUsuario.getText())){
                        if(empresa.getDepartamentoList().get(i).getTrabajadorList().get(j).getPassword().equals(String.valueOf(txtContraseña.getPassword()))){
                            ingreso = true;
                            obtenerCuenta();
                            parent.setVisible(true);
                            this.setVisible(false);
                            break;
                        }else{
                            ingreso = true;
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                            break;
                        }
                    }
                }
            }
        }      
        
        if(ingreso == false){
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
    }//GEN-LAST:event_lbIngresarMouseClicked

    private void pnlBackgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBackgroundMouseClicked
        if(txtUsuario.getText().isEmpty()){
            txtUsuario.setForeground(new Color(204, 204, 204));
            txtUsuario.setText("Nombre de usuario");
        }

        if(String.valueOf(txtContraseña.getPassword()).isEmpty()){
            txtContraseña.setForeground(new Color(204, 204, 204));
            txtContraseña.setText("**********");
        }
    }//GEN-LAST:event_pnlBackgroundMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void lbRecuperarContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRecuperarContraseñaMouseClicked
        if(!txtUsuario.getText().equals("Nombre de usuario") && !txtUsuario.getText().isEmpty()){
            for(int i = 0; i < empresa.getDepartamentoList().size(); i++){
                empresa.getDepartamentoList().get(i);
                for(int j = 0; j < empresa.getDepartamentoList().get(i).getTrabajadorList().size(); i++){
                    empresa.getDepartamentoList().get(i).getTrabajadorList().get(j);
                    if(empresa.getDepartamentoList().get(i).getTrabajadorList().get(j).getUsuario().equals(txtUsuario.getText())){
                        empresa.getDepartamentoList().get(i).getTrabajadorList().get(j).setPassword("1234");
                        JOptionPane.showMessageDialog(this, "Su nueva contraseña es: \"1234\"\nRecuerde cambiarla");
                        break;
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor ingrese su usuario");
        }
    }//GEN-LAST:event_lbRecuperarContraseñaMouseClicked

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
            java.util.logging.Logger.getLogger(DiaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiaLogin dialog = new DiaLogin(new javax.swing.JFrame(), true);
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel lbBarraSuperior;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbIngresar;
    private javax.swing.JLabel lbNombreEmpresa;
    private javax.swing.JLabel lbRecuperarContraseña;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlExit;
    private javax.swing.JPanel pnlIngresar;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
