package administraciondeempleados.gui;

import administraciondeempleados.Empresa;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Busqueda extends javax.swing.JPanel {

    private Empresa empresa;
    DefaultComboBoxModel modelComboDepartamento;
    DefaultComboBoxModel modelComboRol;
    DefaultComboBoxModel modelComboHorario;

    /**
     * Creates new form Busqueda
     */
    public Busqueda() {
        initComponents();
        modelComboDepartamento = new DefaultComboBoxModel();
        modelComboRol = new DefaultComboBoxModel();
        modelComboHorario = new DefaultComboBoxModel();
    }

    public Busqueda(Empresa empresa) {
        this();
        this.empresa = empresa;
        modelTableBusqueda.setEmpresa(empresa);
        cargarComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        modelTableBusqueda = new administraciondeempleados.gui.ModelTableBusqueda();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBusqueda = new javax.swing.JTable();
        cmb_departamento = new javax.swing.JComboBox();
        txt_busqueda = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        cmb_horario = new javax.swing.JComboBox();
        cmb_rol = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btn_limpiarBusqueda = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1035, 460));

        tblBusqueda.setAutoCreateRowSorter(true);
        tblBusqueda.setBackground(new java.awt.Color(204, 204, 204));
        tblBusqueda.setForeground(new java.awt.Color(51, 51, 51));
        tblBusqueda.setModel(modelTableBusqueda);
        tblBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblBusqueda.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tblBusqueda.setFillsViewportHeight(true);
        tblBusqueda.setName(""); // NOI18N
        tblBusqueda.setRowSelectionAllowed(false);
        tblBusqueda.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblBusqueda.setShowGrid(false);
        tblBusqueda.getTableHeader().setResizingAllowed(false);
        tblBusqueda.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBusqueda);

        cmb_departamento.setBackground(new java.awt.Color(204, 204, 204));
        cmb_departamento.setForeground(new java.awt.Color(51, 51, 51));
        cmb_departamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Departamento", "Item 2", "Item 3", "Item 4" }));
        cmb_departamento.setBorder(null);

        txt_busqueda.setBackground(new java.awt.Color(204, 204, 204));
        txt_busqueda.setForeground(new java.awt.Color(51, 51, 51));
        txt_busqueda.setToolTipText("");
        txt_busqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_busqueda.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        btn_buscar.setBackground(new java.awt.Color(204, 204, 204));
        btn_buscar.setForeground(new java.awt.Color(51, 51, 51));
        btn_buscar.setText("Buscar");
        btn_buscar.setFocusable(false);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        cmb_horario.setBackground(new java.awt.Color(204, 204, 204));
        cmb_horario.setForeground(new java.awt.Color(51, 51, 51));
        cmb_horario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Horario", "Item 2", "Item 3", "Item 4" }));
        cmb_horario.setBorder(null);

        cmb_rol.setBackground(new java.awt.Color(204, 204, 204));
        cmb_rol.setForeground(new java.awt.Color(51, 51, 51));
        cmb_rol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rol", "Item 2", "Item 3", "Item 4" }));
        cmb_rol.setBorder(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Realice una busqueda por el nombre del empleado, departamento, rol u horario");

        btn_limpiarBusqueda.setText("Limpiar busqueda");
        btn_limpiarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_horario, 0, 151, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_limpiarBusqueda)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_limpiarBusqueda)
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cargaModeloDepartamento() {
        modelComboDepartamento.addElement(null);
        modelComboDepartamento.addAll(empresa.getDepartamentoList());
        cmb_departamento.setModel(modelComboDepartamento);
    }

    private void cargarModeloRol() {
        modelComboRol.addElement(null);
        modelComboRol.addAll(empresa.getRolList());
        cmb_rol.setModel(modelComboRol);
    }

    private void cargarModeloHorario() {
        modelComboHorario.addElement(null);
        modelComboHorario.addAll(empresa.getHorarioList());
        cmb_horario.setModel(modelComboHorario);
    }

    private void cargarComponentes() {
        modelTableBusqueda.llenarEmpleadoList();
        modelTableBusqueda.cargarModelo();
        cargaModeloDepartamento();
        cargarModeloRol();
        cargarModeloHorario();
    }

    private String mandarComponente() {
        String value = txt_busqueda.getText();
        return (value.matches("-?\\d+")) ? "Id" : "Fullname";
    }

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        boolean camposNull = true;
        if (cmb_departamento.getSelectedItem() != null) {
            modelTableBusqueda.filtrarEmpleados(String.valueOf(cmb_departamento.getSelectedItem()), "Departamento");
            camposNull = false;
        }
        if (cmb_horario.getSelectedItem() != null) {
            modelTableBusqueda.filtrarEmpleados(String.valueOf(cmb_horario.getSelectedItem()), "Horario");
            camposNull = false;
        }
        if (cmb_rol.getSelectedItem() != null) {
            modelTableBusqueda.filtrarEmpleados(String.valueOf(cmb_rol.getSelectedItem()), "Rol");
            camposNull = false;
        }
        if (!txt_busqueda.getText().isEmpty()) {
            modelTableBusqueda.filtrarEmpleados(txt_busqueda.getText().toLowerCase(), mandarComponente());
            camposNull = false;
        }

        if (!camposNull) {
            modelTableBusqueda.cargarEmpleadosFiltrados();
        } else {
            JOptionPane.showMessageDialog(null, "Los filtros estan vacios",
                    "Campos vacios", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed


    private void btn_limpiarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarBusquedaActionPerformed
        txt_busqueda.setText("");
        cmb_departamento.setSelectedItem(null);
        cmb_horario.setSelectedItem(null);
        cmb_rol.setSelectedItem(null);
        modelTableBusqueda.cargarModelo();
    }//GEN-LAST:event_btn_limpiarBusquedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_limpiarBusqueda;
    private javax.swing.JComboBox<String> cmb_departamento;
    private javax.swing.JComboBox<String> cmb_horario;
    private javax.swing.JComboBox<String> cmb_rol;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private administraciondeempleados.gui.ModelTableBusqueda modelTableBusqueda;
    private javax.swing.JTable tblBusqueda;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
