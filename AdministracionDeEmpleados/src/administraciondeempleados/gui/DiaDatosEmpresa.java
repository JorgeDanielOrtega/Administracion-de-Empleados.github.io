package administraciondeempleados.gui;

import java.awt.Color;
import administraciondeempleados.Cuenta;
import javax.swing.border.SoftBevelBorder;
import administraciondeempleados.Empresa;
import javax.swing.JOptionPane;
import administraciondeempleados.Gerente;

public class DiaDatosEmpresa extends javax.swing.JDialog {

    private DiaLogin diaLogin;
    private Cuenta cuentaActual = new Cuenta("admin", "admin");
    private SoftBevelBorder softBevelBorder;
    private Empresa empresa;
    private Gerente gerente;
    private java.awt.Frame parent;
       
    private int xPos, yPos;
    
    public DiaDatosEmpresa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        setLocationRelativeTo(null);
    }
    
    public DiaDatosEmpresa(java.awt.Frame parent, boolean modal, Empresa empresa) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        if(empresa == null){
            setValoresDefecto();
        }else{
            this.empresa = empresa;
            setValoresEmpresa();
        }
        this.setVisible(true);
        setLocationRelativeTo(null);        
    }
    
    private void setValoresEmpresa(){
        txtNombreEmpresa.setText(empresa.getNombre());
        txtFundacionYear.setText(String.valueOf(empresa.getFundacionYear()));
        txtRubroEmpresa.setText(empresa.getRubro());
        txtLeyendaEmpresa.setText(empresa.getLeyenda());
    }
    
    private void setValoresDefecto(){
        txtNombreEmpresa.setText("Nombre Empresa");
        txtFundacionYear.setText("Año Fundacion");
        txtRubroEmpresa.setText("Rubro");
        txtLeyendaEmpresa.setText("Leyenda");
    }
    
    public void resetearTxt(){
        txtNombreEmpresa.setBorder(null);
        txtNombreEmpresa.setBackground(new Color(125,133,151)); 
        txtNombreEmpresa.setForeground(new Color(204,204,204));
        txtNombreEmpresa.setEditable(false);
        
        txtFundacionYear.setBorder(null);
        txtFundacionYear.setBackground(new Color(125,133,151));
        txtFundacionYear.setForeground(new Color(204,204,204));
        txtFundacionYear.setEditable(false);
        
        txtRubroEmpresa.setBorder(null);
        txtRubroEmpresa.setBackground(new Color(125,133,151));
        txtRubroEmpresa.setForeground(new Color(204,204,204));
        txtRubroEmpresa.setEditable(false);
        
        txtLeyendaEmpresa.setBorder(null);
        txtLeyendaEmpresa.setBackground(new Color(125,133,151));
        txtLeyendaEmpresa.setForeground(new Color(204,204,204));
        txtLeyendaEmpresa.setEnabled(false);            
        txtLeyendaEmpresa.setEditable(false);
    }
    
    public void crearEmpresa(){
        if(!txtNombreEmpresa.getText().equals("Nombre Empresa") && !txtFundacionYear.getText().equals("Año Fundacion") && !txtRubroEmpresa.getText().equals("Rubro") && !txtLeyendaEmpresa.getText().equals("Leyenda") && !txtNombreEmpresa.getText().isEmpty() && !txtFundacionYear.getText().isEmpty() && !txtRubroEmpresa.getText().isEmpty() && !txtLeyendaEmpresa.getText().isEmpty()){
            this.empresa = new Empresa(txtNombreEmpresa.getText(), Integer.parseInt(txtFundacionYear.getText()), txtRubroEmpresa.getText(), txtLeyendaEmpresa.getText());
        }
    }
    
    public void guardarDatos(){       
        if(empresa == null){
            crearEmpresa();
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
        lblInformacion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblAnioFundacion = new javax.swing.JLabel();
        lblRubro = new javax.swing.JLabel();
        scpLeyendaEmpresa = new javax.swing.JScrollPane();
        txtLeyendaEmpresa = new javax.swing.JTextArea();
        txtFundacionYear = new javax.swing.JTextField();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtRubroEmpresa = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        pnlBackground.setBackground(new java.awt.Color(125, 133, 151));
        pnlBackground.setMinimumSize(new java.awt.Dimension(1035, 460));
        pnlBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBackgroundMouseClicked(evt);
            }
        });
        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInformacion.setBackground(new java.awt.Color(255, 255, 255));
        lblInformacion.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblInformacion.setForeground(new java.awt.Color(51, 51, 51));
        lblInformacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInformacion.setText("INFORMACION");
        pnlBackground.add(lblInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 180, 50));

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
        txtLeyendaEmpresa.setBackground(new java.awt.Color(125, 133, 151));
        txtLeyendaEmpresa.setColumns(20);
        txtLeyendaEmpresa.setFont(new java.awt.Font("Roboto Light", 2, 18)); // NOI18N
        txtLeyendaEmpresa.setForeground(new java.awt.Color(204, 204, 204));
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
        txtFundacionYear.setBackground(new java.awt.Color(125, 133, 151));
        txtFundacionYear.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        txtFundacionYear.setForeground(new java.awt.Color(204, 204, 204));
        txtFundacionYear.setText("Año Fundacion");
        txtFundacionYear.setBorder(null);
        txtFundacionYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFundacionYearMouseClicked(evt);
            }
        });
        pnlBackground.add(txtFundacionYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 720, 30));

        txtNombreEmpresa.setEditable(false);
        txtNombreEmpresa.setBackground(new java.awt.Color(125, 133, 151));
        txtNombreEmpresa.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        txtNombreEmpresa.setForeground(new java.awt.Color(204, 204, 204));
        txtNombreEmpresa.setText("Nombre Empresa");
        txtNombreEmpresa.setBorder(null);
        txtNombreEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreEmpresaMouseClicked(evt);
            }
        });
        pnlBackground.add(txtNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 720, 30));

        txtRubroEmpresa.setEditable(false);
        txtRubroEmpresa.setBackground(new java.awt.Color(125, 133, 151));
        txtRubroEmpresa.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        txtRubroEmpresa.setForeground(new java.awt.Color(204, 204, 204));
        txtRubroEmpresa.setText("Rubro");
        txtRubroEmpresa.setBorder(null);
        txtRubroEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRubroEmpresaMouseClicked(evt);
            }
        });
        pnlBackground.add(txtRubroEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 720, 30));

        btnAceptar.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        pnlBackground.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void pnlBackgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBackgroundMouseClicked
        this.guardarDatos();
    }//GEN-LAST:event_pnlBackgroundMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.guardarDatos();
    }//GEN-LAST:event_formMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        this.guardarDatos();
        this.dispose();
    }//GEN-LAST:event_btnAceptarMouseClicked

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
            java.util.logging.Logger.getLogger(DiaDatosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiaDatosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiaDatosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiaDatosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiaDatosEmpresa dialog = new DiaDatosEmpresa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel lblAnioFundacion;
    private javax.swing.JLabel lblInformacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRubro;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JScrollPane scpLeyendaEmpresa;
    private javax.swing.JTextField txtFundacionYear;
    private javax.swing.JTextArea txtLeyendaEmpresa;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtRubroEmpresa;
    // End of variables declaration//GEN-END:variables
}
