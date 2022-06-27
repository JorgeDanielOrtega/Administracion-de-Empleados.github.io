package administraciondeempleados.gui;

import administraciondeempleados.view.Horarios;
import administraciondeempleados.Contrato;
import administraciondeempleados.Departamento;
import administraciondeempleados.Empleado;
import administraciondeempleados.Empresa;
import administraciondeempleados.Gerente;
import administraciondeempleados.Puesto;
import administraciondeempleados.Rol;
import administraciondeempleados.Empresa;
import administraciondeempleados.EstadoCivil;
import administraciondeempleados.Horario;
import administraciondeempleados.gui.DiaDatosEmpresa;
import administraciondeempleados.gui.DiaLogin;
import assets.colors.Palette;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends javax.swing.JFrame {

    private final int WIDTH_BACKGROUND = 990;
    private final int HEIGHT_BACKGROUND = 630;
    private ImageIcon imageIcon;
    private Icon icon;
    private JPanel buttonClicked;
    private JPanel headClicked;
    Calendar horaActual;
    private List<Empleado> empleadoList;
    private Empresa empresa;
    private DiaDatosEmpresa diaDatosEmpresa;
    private Gerente gerente;
    private DiaLogin diaLogin;
    private Departamento departamento;
    private Empleado empleado;
    private Empleado empleado2;
    private Empleado empleado3;
    private Empleado empleado4;
    private Rol rolContable;
    private Rol rolAyudante;
    private Horario horarioMatutino;
    private Horario horarioVespertino;
    private Horario horarioNocturno;
    private JFrame parent;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        parent = this;
        if (empresa == null) {
            diaDatosEmpresa = new DiaDatosEmpresa(this, true, empresa);
            this.empresa = diaDatosEmpresa.getEmpresa();
        }
        departamento = new Departamento("Finanzas", 1, 25);
        empresa.getDepartamentoList().add(departamento);
        empresa.setHoraEntrada(7, 30);
        pintarImagen(jLabel1, "src/assets/icons/user3.png");
        jLabel1.setText("Gerente");
        setLocationRelativeTo(null);
        buttonClicked = new JPanel();
        headClicked = new JPanel();
        this.horaActual = Calendar.getInstance();
        menuGerente.setVisible(true);
        menuEmpleado.setVisible(true);
        rolContable = new Rol("Contable");
        rolAyudante = new Rol("ayudante");
        horarioMatutino = new Horario("matutino", 45f);
        horarioVespertino = new Horario("vespertino",30f);
        horarioNocturno = new Horario("nocturno",15f);
        empresa.getHorarioList().add(horarioMatutino);
        empresa.getHorarioList().add(horarioVespertino);
        empresa.getHorarioList().add(horarioNocturno);
        empresa.getRolList().add(rolContable);
        empresa.getRolList().add(rolAyudante);
        gerente = new Gerente(empresa, "Gerente", "admin", "admin", new Puesto("Gerente"), new Rol("Gerente"), new Departamento("Administracion", 1, 1), new Contrato(true), "Gerente", "Gerente", "Gerente", "9999999999", '/', "Ciudad", "9999999999", new Date(2022, 6, 26));
        empleado = new Empleado(new Date(22, 2, 2), horarioMatutino, "jorge.d.ortega@unl.edu.ec", "daniel", "1234", new Puesto("administracion"), rolContable, departamento, new Contrato(true), "Jorge daniel", "ortega alburqueque", "Av. agustin aguirre", "1234567", 'm', "loja", "12345", new Date(22, 22, 22));
        empleado2  = new Empleado(new Date(22, 2, 2), horarioMatutino, "dfdfdf.d.ortega@unl.edu.ec", "jose", "1234", new Puesto("administracion"), rolContable, departamento, new Contrato(true), "Lenucio", "ortega ", "Av. agustin aguirre", "1234567", 'm', "loja", "12345", new Date(22, 22, 22));
        empleado3  = new Empleado(new Date(22, 2, 2), horarioVespertino, "hola@unl.edu.ec", "daniel", "1234", new Puesto("empleado"), rolAyudante, departamento, new Contrato(true), "jose ", "ortega gonzalez", "Av. agustin aguirre", "1234567", 'm', "loja", "12345", new Date(22, 22, 22));
        empleado4  = new Empleado(new Date(22, 2, 2), horarioNocturno, "empreas@.edu.ec", "daniel", "1234", new Puesto("empleado"), rolAyudante, departamento, new Contrato(true), "lucia bermeo", "VAlles", "Av. agustin aguirre", "1234567", 'f', "loja", "12345", new Date(22, 22, 22));
        cargarComponentes();
        mouseEvents();
        empresa.getDepartamentoList().add(gerente.getDepartamento());
        empresa.getDepartamentoList().get(0).getTrabajadorList().add(gerente);
    }

    private void cargarComponentes() {
        if (!true) {
            menuEmpleado.setVisible(true);
            menuEmpleado.setBackground(Palette.MENU);
            menuGerente.setVisible(false);
            jLabel1.setText("Empleado");
        } else {

            menuGerente.setVisible(true);
            menuGerente.setBackground(Palette.MENU);
            menuEmpleado.setVisible(false);
        }
        head.setBackground(Palette.HEAD);
        btn_empleados.setBackground(Palette.BUTTON);
        btn_departamentos.setBackground(Palette.BUTTON);
        btn_horarios.setBackground(Palette.BUTTON);

        btn_logOut.setBackground(Palette.BUTTON);
        btn_asistencia.setBackground(Palette.BUTTON);
        btn_departamentoEmpleado.setBackground(Palette.BUTTON);
        btn_buscar.setBackground(Palette.BUTTON);

        background.setBackground(Palette.BACKGROUND);

        departamento.getTrabajadorList().add(empleado);
        departamento.getTrabajadorList().add(empleado2);
        departamento.getTrabajadorList().add(empleado3);
        departamento.getTrabajadorList().add(empleado4);
    }

    public void mouseEvents() {
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getSource() == head && buttonClicked != head) {
                    head.setBackground(Palette.HEAD_CLICK);
                    headClicked.setBackground(Palette.HEAD);
                    headClicked = head;
                    buttonClicked.setBackground(Palette.BUTTON);
                    buttonClicked = new JPanel();
                    Perfil p = new Perfil(empleado);
                    p.setSize(WIDTH_BACKGROUND, HEIGHT_BACKGROUND);
                    p.setLocation(0, 0);
                    background.removeAll();
                    background.add(p);
                    background.revalidate();
                    background.repaint();
                }
                if (e.getSource() == btn_buscar && buttonClicked != btn_buscar) {
                    btn_buscar.setBackground(Palette.BUTTON_CLICK);
                    buttonClicked.setBackground(Palette.BUTTON);
                    buttonClicked = btn_buscar;
                    Busqueda bus = new Busqueda(empresa);
                    bus.setSize(WIDTH_BACKGROUND, HEIGHT_BACKGROUND);
                    bus.setLocation(0, 0);
                    background.removeAll();
                    background.add(bus);
                    background.revalidate();
                    background.repaint();
                }

                if (e.getSource() == btn_empleados && buttonClicked != btn_empleados) {
                    btn_empleados.setBackground(Palette.BUTTON_CLICK);
                    buttonClicked.setBackground(Palette.BUTTON);
                    buttonClicked = btn_empleados;
                    DiaEmpleado diaEmpleado = new DiaEmpleado(null, true, empresa.getDepartamentoList(), empresa.getRolList());
                    diaEmpleado.setVisible(true);
                }
                if (e.getSource() == btn_departamentos && buttonClicked != btn_departamentos) {
                    btn_departamentos.setBackground(Palette.BUTTON_CLICK);
                    buttonClicked.setBackground(Palette.BUTTON);
                    buttonClicked = btn_departamentos;
                    DiaDepartamento diaDepartamento = new DiaDepartamento(null, true, empresa.getDepartamentoList());
                    diaDepartamento.setVisible(true);
                }
                if (e.getSource() == btn_horarios && buttonClicked != btn_horarios) {
                    btn_horarios.setBackground(Palette.BUTTON_CLICK);
                    buttonClicked.setBackground(Palette.BUTTON);
                    buttonClicked = btn_horarios;
                    Horarios horarios = new Horarios(gerente);
                    //horarios.setGerente(gerente);
                    horarios.setVisible(true);
                }
                if (e.getSource() == btn_logOut && buttonClicked != btn_logOut) {
                    btn_logOut.setBackground(Palette.BUTTON_CLICK);
                    buttonClicked.setBackground(Palette.BUTTON);
                    buttonClicked = btn_logOut;
                    diaLogin = new DiaLogin(null, true, empresa);
                    diaLogin.setVisible(true);
                }
                if (e.getSource() == btn_asistencia && buttonClicked != btn_asistencia) {
                    btn_asistencia.setBackground(Palette.BUTTON_CLICK);
                    buttonClicked.setBackground(Palette.BUTTON);
                    buttonClicked = btn_asistencia;
                    AsignacionAsistencia asistencia = new AsignacionAsistencia(null, true,empleado.getAsistenciaList(), horaActual);
                    asistencia.setVisible(true);
//                    Calendar horaEntrada = empresa.getHoraEntrada();
//                    //si hay tiempo ponerle un metodo para que compruebe pasado una hora (8 si ha marcado asistencia o no, si no hay nada guardado en su asistenciaList, asignarFaltaIjustificada automaticamente
//                    if (horaActual.get(Calendar.HOUR_OF_DAY) == horaActual.get(Calendar.HOUR_OF_DAY)) {
//                        AsignacionAsistencia asignacionAsistencia
//                                = new AsignacionAsistencia(this, true, empleado.getAsistenciaList(), empresa.getHoraEntrada());
//                        asignacionAsistencia.setVisible(true);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "no se puede marcar asistencia todavia"); //mas tarde cambiar el mensaje
//                    }
                }
                if (e.getSource() == btn_departamentoEmpleado && buttonClicked != btn_departamentoEmpleado) {
                    btn_departamentoEmpleado.setBackground(Palette.BUTTON_CLICK);
                    buttonClicked.setBackground(Palette.BUTTON);
                    buttonClicked = btn_departamentoEmpleado;

                    DepartamentoGUi depa = new DepartamentoGUi(empresa.getDepartamentoList().get(0)); //error porque falta agregarle a la crud de empleado que ingrese un departamento
                    depa.setSize(WIDTH_BACKGROUND, HEIGHT_BACKGROUND);
                    depa.setLocation(0, 0);
                    background.removeAll();
                    background.add(depa);
                    background.revalidate();
                    background.repaint();
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == head && buttonClicked != head) {
                    head.setBackground(Palette.HEAD_CLICK);
                }
                if (e.getSource() == btn_buscar && buttonClicked != btn_buscar) {
                    btn_buscar.setBackground(Palette.BUTTON_CLICK);
                }

                if (e.getSource() == btn_empleados && buttonClicked != btn_empleados) {
                    btn_empleados.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == btn_departamentos && buttonClicked != btn_departamentos) {
                    btn_departamentos.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == btn_horarios && buttonClicked != btn_horarios) {
                    btn_horarios.setBackground(Palette.BUTTON_CLICK);
                }

                if (e.getSource() == btn_logOut && buttonClicked != btn_logOut) {
                    btn_logOut.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == btn_asistencia && buttonClicked != btn_asistencia) {
                    btn_asistencia.setBackground(Palette.BUTTON_CLICK);
                }
                if (e.getSource() == btn_departamentoEmpleado && buttonClicked != btn_departamentoEmpleado) {
                    btn_departamentoEmpleado.setBackground(Palette.BUTTON_CLICK);
                }

                if (e.getSource() == head) {
                    head.setBackground(Palette.HEAD_CLICK);
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == head && buttonClicked != head) {
                    head.setBackground(Palette.HEAD);
                }

                if (e.getSource() == btn_buscar && buttonClicked != btn_buscar) {
                    btn_buscar.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == btn_empleados && buttonClicked != btn_empleados) {
                    btn_empleados.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == btn_departamentos && buttonClicked != btn_departamentos) {
                    btn_departamentos.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == btn_horarios && buttonClicked != btn_horarios) {
                    btn_horarios.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == btn_logOut && buttonClicked != btn_logOut) {
                    btn_logOut.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == btn_asistencia && buttonClicked != btn_asistencia) {
                    btn_asistencia.setBackground(Palette.BUTTON);
                }
                if (e.getSource() == btn_departamentoEmpleado && buttonClicked != btn_departamentoEmpleado) {
                    btn_departamentoEmpleado.setBackground(Palette.BUTTON);
                }

                if (e.getSource() == head) {
                    head.setBackground(Palette.HEAD);
                }
            }
        };
        btn_empleados.addMouseListener(m);
        btn_departamentos.addMouseListener(m);
        btn_horarios.addMouseListener(m);
        btn_logOut.addMouseListener(m);
        btn_asistencia.addMouseListener(m);
        btn_departamentoEmpleado.addMouseListener(m);
        head.addMouseListener(m);
        btn_buscar.addMouseListener(m);
    }

    private void pintarImagen(JLabel jlabel, String ruta) {
        this.imageIcon = new ImageIcon(ruta);
        this.icon = new ImageIcon(this.imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING));
        jLabel1.setIcon(icon);
        this.repaint();

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
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
        head = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuGerente = new javax.swing.JPanel();
        btn_empleados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_departamentos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_horarios = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        menuEmpleado = new javax.swing.JPanel();
        btn_departamentoEmpleado = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_asistencia = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_logOut = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        background = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(40, 15));

        javax.swing.GroupLayout headLayout = new javax.swing.GroupLayout(head);
        head.setLayout(headLayout);
        headLayout.setHorizontalGroup(
            headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        headLayout.setVerticalGroup(
            headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 110));

        menuGerente.setBackground(new java.awt.Color(255, 0, 102));
        menuGerente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_empleados.setBackground(new java.awt.Color(51, 51, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Empleados");

        javax.swing.GroupLayout btn_empleadosLayout = new javax.swing.GroupLayout(btn_empleados);
        btn_empleados.setLayout(btn_empleadosLayout);
        btn_empleadosLayout.setHorizontalGroup(
            btn_empleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_empleadosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        btn_empleadosLayout.setVerticalGroup(
            btn_empleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_empleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuGerente.add(btn_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 270, 50));

        btn_departamentos.setBackground(new java.awt.Color(51, 0, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Departamentos");

        javax.swing.GroupLayout btn_departamentosLayout = new javax.swing.GroupLayout(btn_departamentos);
        btn_departamentos.setLayout(btn_departamentosLayout);
        btn_departamentosLayout.setHorizontalGroup(
            btn_departamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_departamentosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        btn_departamentosLayout.setVerticalGroup(
            btn_departamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_departamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuGerente.add(btn_departamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 270, 50));

        btn_horarios.setBackground(new java.awt.Color(51, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Horarios");

        javax.swing.GroupLayout btn_horariosLayout = new javax.swing.GroupLayout(btn_horarios);
        btn_horarios.setLayout(btn_horariosLayout);
        btn_horariosLayout.setHorizontalGroup(
            btn_horariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_horariosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        btn_horariosLayout.setVerticalGroup(
            btn_horariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_horariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuGerente.add(btn_horarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 270, 50));

        btn_buscar.setBackground(new java.awt.Color(204, 0, 0));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Buscar");

        javax.swing.GroupLayout btn_buscarLayout = new javax.swing.GroupLayout(btn_buscar);
        btn_buscar.setLayout(btn_buscarLayout);
        btn_buscarLayout.setHorizontalGroup(
            btn_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_buscarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        btn_buscarLayout.setVerticalGroup(
            btn_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        menuGerente.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 270, 50));

        jPanel1.add(menuGerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 630));

        menuEmpleado.setBackground(new java.awt.Color(255, 0, 102));
        menuEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_departamentoEmpleado.setBackground(new java.awt.Color(153, 255, 102));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Departamento");

        javax.swing.GroupLayout btn_departamentoEmpleadoLayout = new javax.swing.GroupLayout(btn_departamentoEmpleado);
        btn_departamentoEmpleado.setLayout(btn_departamentoEmpleadoLayout);
        btn_departamentoEmpleadoLayout.setHorizontalGroup(
            btn_departamentoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_departamentoEmpleadoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        btn_departamentoEmpleadoLayout.setVerticalGroup(
            btn_departamentoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_departamentoEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuEmpleado.add(btn_departamentoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        btn_asistencia.setBackground(new java.awt.Color(204, 255, 0));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Asistencia");

        javax.swing.GroupLayout btn_asistenciaLayout = new javax.swing.GroupLayout(btn_asistencia);
        btn_asistencia.setLayout(btn_asistenciaLayout);
        btn_asistenciaLayout.setHorizontalGroup(
            btn_asistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_asistenciaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        btn_asistenciaLayout.setVerticalGroup(
            btn_asistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_asistenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuEmpleado.add(btn_asistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));

        btn_logOut.setBackground(new java.awt.Color(255, 0, 204));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Log out");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_logOutLayout = new javax.swing.GroupLayout(btn_logOut);
        btn_logOut.setLayout(btn_logOutLayout);
        btn_logOutLayout.setHorizontalGroup(
            btn_logOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_logOutLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        btn_logOutLayout.setVerticalGroup(
            btn_logOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_logOutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuEmpleado.add(btn_logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));

        jPanel1.add(menuEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 630));

        background.setBackground(new java.awt.Color(0, 255, 102));

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
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

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        diaLogin = new DiaLogin(this, true, empresa);
        diaLogin.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

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
    private javax.swing.JPanel btn_asistencia;
    private javax.swing.JPanel btn_buscar;
    private javax.swing.JPanel btn_departamentoEmpleado;
    private javax.swing.JPanel btn_departamentos;
    private javax.swing.JPanel btn_empleados;
    private javax.swing.JPanel btn_horarios;
    private javax.swing.JPanel btn_logOut;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JPanel head;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menuEmpleado;
    private javax.swing.JPanel menuGerente;
    // End of variables declaration//GEN-END:variables
}
