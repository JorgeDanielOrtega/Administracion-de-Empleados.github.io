package administraciondeempleados.gui;

import assets.colors.Palette;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal extends javax.swing.JFrame {

    private final int WIDTH_BACKGROUND = 990;
    private final int HEIGHT_BACKGROUND = 630;
    private ImageIcon imageIcon;
    private Icon icon;
    private JPanel panelClicked;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        pintarImagen(jLabel1, "src/assets/icons/user3.png");
        pintarImagen(jLabel20, "src/assets/icons/user3.png");
        jLabel1.setText("Gerente");
        jLabel20.setText("Empleado");
        setLocationRelativeTo(null);
        panelClicked = new JPanel();
        cargarComponentes();
        mouseEvents();
    }

    private void cargarComponentes() {
        //Realizar una condicional para cargar los componenetes de un menu u otro
        head_empleado.setBackground(Palette.HEAD);
        head_gerente.setBackground(Palette.HEAD);
        menuGerente.setBackground(Palette.MENU);
        menuEmpleado.setBackground(Palette.MENU);
        btn_perfil.setBackground(Palette.BUTTON);
        jPanel5.setBackground(Palette.BUTTON);
        jPanel6.setBackground(Palette.BUTTON);
        jPanel7.setBackground(Palette.BUTTON);
        jPanel8.setBackground(Palette.BUTTON);
        jPanel9.setBackground(Palette.BUTTON);
        jPanel10.setBackground(Palette.BUTTON);
        jPanel11.setBackground(Palette.BUTTON);
        background.setBackground(Palette.BACKGROUND);
    }

    public void mouseEvents() {
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getSource() == btn_perfil && panelClicked != btn_perfil) {
                    btn_perfil.setBackground(Palette.BUTTON_CLICK);
                    panelClicked.setBackground(Palette.BUTTON);
                    panelClicked = btn_perfil;
                    Perfil p = new Perfil();
                    p.setSize(WIDTH_BACKGROUND, HEIGHT_BACKGROUND);
                    p.setLocation(0, 0);
                    background.removeAll();
                    background.add(p);
                    background.revalidate();
                    background.repaint();
                }
                if (e.getSource() == jPanel5 && panelClicked != jPanel5) {
                    jPanel5.setBackground(Palette.BUTTON_CLICK);
                    panelClicked.setBackground(Palette.BUTTON);
                    panelClicked = jPanel5;
                    DepartamentoGUi depa = new DepartamentoGUi();
                    depa.setSize(WIDTH_BACKGROUND, HEIGHT_BACKGROUND);
                    depa.setLocation(0, 0);
                    background.removeAll();
                    background.add(depa);
                    background.revalidate();
                    background.repaint();
                }
                if (e.getSource() == jPanel6 && panelClicked != jPanel6) {
                    jPanel6.setBackground(Palette.BUTTON_CLICK);
                    panelClicked.setBackground(Palette.BUTTON);
                    panelClicked = jPanel6;
                    Busqueda bus = new Busqueda();
                    bus.setSize(WIDTH_BACKGROUND, HEIGHT_BACKGROUND);
                    bus.setLocation(0, 0);
                    background.removeAll();
                    background.add(bus);
                    background.revalidate();
                    background.repaint();
                }
                if (e.getSource() == jPanel7 && panelClicked != jPanel7) {
                    jPanel7.setBackground(Palette.BUTTON_CLICK);
                    panelClicked.setBackground(Palette.BUTTON);
                    panelClicked = jPanel7;
                    AsignacionAsistencia aa = new AsignacionAsistencia(null, true);
                    aa.setVisible(true);
                }
                if (e.getSource() == jPanel8 && panelClicked != jPanel8) {
                    jPanel8.setBackground(Palette.BUTTON_CLICK);
                    panelClicked.setBackground(Palette.BUTTON);
                    panelClicked = jPanel8;
                }
                if (e.getSource() == jPanel9 && panelClicked != jPanel9) {
                    jPanel9.setBackground(Palette.BUTTON_CLICK);
                    panelClicked.setBackground(Palette.BUTTON);
                    panelClicked = jPanel9;
                }
                if (e.getSource() == jPanel10 && panelClicked != jPanel10) {
                    jPanel10.setBackground(Palette.BUTTON_CLICK);
                    panelClicked.setBackground(Palette.BUTTON);
                    panelClicked = jPanel10;
                }
                if (e.getSource() == jPanel11 && panelClicked != jPanel11) {
                    jPanel11.setBackground(Palette.BUTTON_CLICK);
                    panelClicked.setBackground(Palette.BUTTON);
                    panelClicked = jPanel11;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == btn_perfil && panelClicked != btn_perfil) {
                    btn_perfil.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == jPanel5 && panelClicked != jPanel5) {
                    jPanel5.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == jPanel6 && panelClicked != jPanel6) {
                    jPanel6.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == jPanel7 && panelClicked != jPanel7) {
                    jPanel7.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == jPanel8 && panelClicked != jPanel8) {
                    jPanel8.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == jPanel9 && panelClicked != jPanel9) {
                    jPanel9.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == jPanel10 && panelClicked != jPanel10) {
                    jPanel10.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == jPanel11 && panelClicked != jPanel11) {
                    jPanel11.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == head_gerente) {
                    head_gerente.setBackground(Palette.HEAD_CLICK);
                }
                if (e.getSource() == head_empleado) {
                    head_empleado.setBackground(Palette.HEAD_CLICK);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == btn_perfil && panelClicked != btn_perfil) {
                    btn_perfil.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == jPanel5 && panelClicked != jPanel5) {
                    jPanel5.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == jPanel6 && panelClicked != jPanel6) {
                    jPanel6.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == jPanel7 && panelClicked != jPanel7) {
                    jPanel7.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == jPanel8 && panelClicked != jPanel8) {
                    jPanel8.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == jPanel9 && panelClicked != jPanel9) {
                    jPanel9.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == jPanel10 && panelClicked != jPanel10) {
                    jPanel10.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == jPanel11 && panelClicked != jPanel11) {
                    jPanel11.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == head_gerente) {
                    head_gerente.setBackground(Palette.HEAD);
                }
                if (e.getSource() == head_empleado) {
                    head_empleado.setBackground(Palette.HEAD);
                }
            }
        };
        btn_perfil.addMouseListener(m);
        jPanel5.addMouseListener(m);
        jPanel6.addMouseListener(m);
        jPanel7.addMouseListener(m);
        jPanel8.addMouseListener(m);
        jPanel9.addMouseListener(m);
        jPanel10.addMouseListener(m);
        jPanel11.addMouseListener(m);
        head_empleado.addMouseListener(m);
        head_gerente.addMouseListener(m);
    }

    private void pintarImagen(JLabel jlabel, String ruta) {
        this.imageIcon = new ImageIcon(ruta);
        this.icon = new ImageIcon(this.imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING));
        jLabel1.setIcon(icon);
        this.repaint();

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
        jPanel1 = new javax.swing.JPanel();
        menuGerente = new javax.swing.JPanel();
        btn_perfil = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        head_gerente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JPanel();
        menuEmpleado = new javax.swing.JPanel();
        head_empleado = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuGerente.setBackground(new java.awt.Color(255, 0, 102));
        menuGerente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_perfil.setBackground(new java.awt.Color(51, 51, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Empleados");

        javax.swing.GroupLayout btn_perfilLayout = new javax.swing.GroupLayout(btn_perfil);
        btn_perfil.setLayout(btn_perfilLayout);
        btn_perfilLayout.setHorizontalGroup(
            btn_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_perfilLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        btn_perfilLayout.setVerticalGroup(
            btn_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_perfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuGerente.add(btn_perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 270, 50));

        jPanel5.setBackground(new java.awt.Color(51, 0, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Departamentos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuGerente.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 270, 50));

        jPanel6.setBackground(new java.awt.Color(51, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Horarios");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuGerente.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 270, 50));

        jPanel7.setBackground(new java.awt.Color(204, 0, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("jLabel2");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        menuGerente.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 270, 50));

        head_gerente.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(40, 15));

        javax.swing.GroupLayout head_gerenteLayout = new javax.swing.GroupLayout(head_gerente);
        head_gerente.setLayout(head_gerenteLayout);
        head_gerenteLayout.setHorizontalGroup(
            head_gerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head_gerenteLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        head_gerenteLayout.setVerticalGroup(
            head_gerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head_gerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        menuGerente.add(head_gerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 110));

        jPanel1.add(menuGerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 630));

        background.setBackground(new java.awt.Color(0, 255, 102));

        menuEmpleado.setBackground(new java.awt.Color(255, 0, 102));
        menuEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("jLabel1");
        jLabel20.setPreferredSize(new java.awt.Dimension(40, 15));

        javax.swing.GroupLayout head_empleadoLayout = new javax.swing.GroupLayout(head_empleado);
        head_empleado.setLayout(head_empleadoLayout);
        head_empleadoLayout.setHorizontalGroup(
            head_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head_empleadoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        head_empleadoLayout.setVerticalGroup(
            head_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head_empleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        menuEmpleado.add(head_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 110));

        jPanel11.setBackground(new java.awt.Color(102, 255, 102));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuEmpleado.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        jPanel10.setBackground(new java.awt.Color(153, 255, 102));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Departamento");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuEmpleado.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        jPanel9.setBackground(new java.awt.Color(204, 255, 0));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Asistencia");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuEmpleado.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 0, 204));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Log out");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuEmpleado.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, -1));

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(menuEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(579, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 990, 630));

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel btn_perfil;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JPanel head_empleado;
    private javax.swing.JPanel head_gerente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel menuEmpleado;
    private javax.swing.JPanel menuGerente;
    // End of variables declaration//GEN-END:variables
}
