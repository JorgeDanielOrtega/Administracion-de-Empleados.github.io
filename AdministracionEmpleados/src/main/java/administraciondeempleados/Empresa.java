package administraciondeempleados;

import com.google.protobuf.ByteString;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import prueb.DBConnect;

public class Empresa {

    //atributos sql
    private DBConnect dbConnect;
    private Connection connection;
    private String sql;
    private PreparedStatement ps;
    private ResultSet result;

    //atributos
    private String nombre;
    private String leyenda;
    private int fundacionYear = 0;
    private String rubro;

    //relaciones
    private List<Departamento> departamentoList;
    private List<Rol> rolList;
    private List<Horario> horarioList;
    private Calendar horaEntrada;
    private List<Gerente> gerenteList;

    // implementar el metodo en el dialog datos empresa, para que los datos se envien directamente a la bd
    public Empresa() {
        horarioList = new LinkedList();
        rolList = new LinkedList();
        departamentoList = new LinkedList();
        gerenteList = new LinkedList();
        dbConnect = new DBConnect();
        this.horaEntrada = Calendar.getInstance();//quitar mas tarde

    }

    public Empresa(String nombre, int fundacionYear, String rubro) {
        this();
        this.nombre = nombre;
        this.fundacionYear = fundacionYear;
        this.rubro = rubro;
        //this.horaEntrada = Calendar.getInstance();
    }

    public Empresa(String nombre, int fundacionYear, String leyenda, String rubro) {
        this(nombre, fundacionYear, rubro);
        this.leyenda = leyenda;
    }

    public void cargarListas() {
        cargarDepartamentoList();
        cargarRolList();
        cargarHorarioList();
        cargarTrabajadoresList();
        cargarGerenteList();
    }
    
    private void cargarGerenteList(){
        //TODO
    }

    private Departamento retornarDepartamento(long idDepartamento) {
        try {
            String consulta = "SELECT nombre FROM Departamentos WHERE id = " + idDepartamento;
            PreparedStatement pst = connection.prepareStatement(consulta);
            ResultSet resultS = pst.executeQuery();
            while (resultS.next()) {
                String nombreDepa = resultS.getString("nombre");
                for (Departamento departamento : departamentoList) {
                    if (departamento.getNombre().equals(nombreDepa)) {
                        return departamento;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("hubo un error al retornar departamento con id" + e.getMessage());
        }
        return null;
    }

    private Horario retornarHorario(long idHorario) {
        try {
            String consulta = "SELECT tipo FROM Horarios  WHERE id = " + idHorario;
            PreparedStatement pst = connection.prepareStatement(consulta);
            ResultSet resultS = pst.executeQuery();
            while (resultS.next()) {
                String tipo = resultS.getString("tipo");
                for (Horario horario : horarioList) {
                    if (horario.getTipo().equals(tipo)) {
                        return horario;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("hubo un error al retornar horario con id" + e.getMessage());
        }
        return null;
    }

    private Rol retornarRol(long idRol) {
        try {
            String consulta = "SELECT nombre FROM Roles WHERE id = " + idRol;
            PreparedStatement pst = connection.prepareStatement(consulta);
            ResultSet resultS = pst.executeQuery();
            while (resultS.next()) {
                String nombreRol = resultS.getString("nombre");
                for (Rol rol : rolList) {
                    if (rol.getNombre().equals(nombreRol)) {
                        return rol;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("hubo un error al retornar rol con id" + e.getMessage());
        }
        return null;
    }

    private Contrato retornarContrato(long idEmpleado) {
        try {
            String consulta = "SELECT * FROM Contratos WHERE id_empleado = " + idEmpleado;
            PreparedStatement pst = connection.prepareStatement(consulta);
            ResultSet resultS = pst.executeQuery();
            while (resultS.next()) {
                boolean tieneContrato = resultS.getInt("tiene_contrato") == 1;
                double tiempoContrato = resultS.getDouble("tiempo_contrato");
                Date fechaLimite = resultS.getDate("fecha_limite");
                return new Contrato(tieneContrato, tiempoContrato, fechaLimite);
            }
        } catch (Exception e) {
            System.out.println("hubo un error al retornar contrato con id" + e.getMessage());
        }
        return null;
    }

    private EstadoCivil retornarEstadoCivil(String estado) {
        switch (estado) {
            case "CASADO":
                return EstadoCivil.CASADO;
            case "SOLTERO":
                return EstadoCivil.SOLTERO;
            case "UNION_LIBRE":
                return EstadoCivil.UNION_LIBRE;
            case "DIVORCIADO":
                return EstadoCivil.DIVORCIADO;

            default:
                System.out.println("se selecciono en default");
                break;
        }
        return null;
    }

    private void cargarTrabajadoresList() {
        try {
            connection = dbConnect.conectar();
            sql = "SELECT * FROM Empleados WHERE  fecha_nacimiento != '0000-00-00' AND anio_entrada != '0000-00-00'";
            ps = connection.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                long id = result.getLong("id");
                String cedula = result.getString("cedula");
                String nombres = result.getString("nombres");
                String apellidos = result.getString("apellidos");
                String direccion = result.getString("direccion");
                String estadoCivil = result.getString("estado_civil");
                char sexo = result.getString("sexo").charAt(0); //quizas
                String ciudad = result.getString("ciudad");
                String telefono = result.getString("telefono");
                Date fecha_nacimiento = result.getDate("fecha_nacimiento");
                Date anio_entrada = result.getDate("anio_entrada");
                String correoEmpresarial = result.getString("correo_empresarial");
                String correoPersonal = result.getString("correo_personal");
                String usuario = result.getString("usuario");
                String contrasenia = result.getString("contrasenia");
                boolean pagoTransferencia = result.getInt("pago_por_transferencia") == 1;
                //boolean gerente = result.getInt("gerente") == 1;
                long idHorario = result.getLong("id_horario");
                long idDepartamento = result.getLong("id_departamento");
                long idRol = result.getLong("id_rol");
                Contrato contrato = retornarContrato(id);

                Departamento depa = retornarDepartamento(idDepartamento);
                Horario horario = retornarHorario(idHorario);
                Rol rol = retornarRol(idRol);
                Empleado e = new Empleado(nombres, apellidos, direccion, retornarEstadoCivil(estadoCivil), cedula, sexo, ciudad, telefono, fecha_nacimiento, correoPersonal, correoEmpresarial, usuario, contrasenia, pagoTransferencia, rol, contrato, anio_entrada, depa, horario);
                e.setId(String.valueOf(id));
                depa.getTrabajadorList().add(e);
                horario.getEmpleadoList().add(e);
                rol.getTrabajadorList().add(e);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el trabajadorList");
            System.err.println("hubo un error trabajador" + e.getMessage());
        } finally {
            dbConnect.desconectar();
        }
    }

    private void cargarDepartamentoList() {
        try {
            connection = dbConnect.conectar();
            sql = "SELECT * FROM Departamentos";
            ps = connection.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                String nombreDepa = result.getString("nombre");
                int numero = result.getInt("numero");
               int maxEmpleados = result.getInt("maximo_empleados");
                int vacaciones = result.getInt("vacaciones");
                departamentoList.add(new Departamento(nombreDepa, numero, maxEmpleados, vacaciones));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el departamentoList");
            System.err.println("hubo un error depaaaa" + e.getMessage());
        } finally {
            dbConnect.desconectar();
        }
    }

    private Departamento retornarDepartamento(String nombreDepartamento) {
        for (Departamento departamento : departamentoList) {
            if (departamento.getNombre().equals(nombreDepartamento)) {
                return departamento;
            }
        }
        return null;
    }

    private void cargarRolList() {
        try {
            connection = dbConnect.conectar();
            sql = "SELECT r.salario, r.nombre AS 'Rol', p.nombre AS 'Puesto', "
                    + "d.nombre AS 'Departamento' FROM Roles r, Puestos p, Departamentos d";
            ps = connection.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                String nombreDepa = result.getString("Departamento");
                double salario = result.getDouble("salario");
                String nombrePuesto = result.getString("Puesto");
                String nombreRol = result.getString("Rol");
                rolList.add(new Rol(salario, nombreRol, new Puesto(nombrePuesto),
                        retornarDepartamento(nombreDepa)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el rolList");
            System.err.println("hubo un error rol" + e.getMessage());
        } finally {
            dbConnect.desconectar();
        }
    }

    private List<DiasLaborales> retornarDiasLaborablesList(long id) {
        try {
            //quizas haya problemas con los objetos, dado que se utiliza en dos metodos, y puede haber perdida de consultas
            connection = dbConnect.conectar();
            List<DiasLaborales> diasLaborablesList = new LinkedList();
            sql = "SELECT dia FROM Dias_Laborables WHERE id IN  "
                    + "(SELECT hd.id_dias_Laborables FROM Horarios h INNER JOIN"
                    + " Horarios_Dias_Laborables hd ON " + id + " = hd.id_horarios)";
            ps = connection.prepareStatement(sql);
            ResultSet resultS = ps.executeQuery();
            while (resultS.next()) {
                String dia = resultS.getString("dia");
                switch (dia) {
                    case "lunes":
                        diasLaborablesList.add(DiasLaborales.LU);
                        break;
                    case "martes":
                        diasLaborablesList.add(DiasLaborales.MA);
                        break;
                    case "miercoles":
                        diasLaborablesList.add(DiasLaborales.MI);
                        break;
                    case "jueves":
                        diasLaborablesList.add(DiasLaborales.JU);
                        break;
                    case "viernes":
                        diasLaborablesList.add(DiasLaborales.VI);
                        break;
                    case "sabado":
                        diasLaborablesList.add(DiasLaborales.SA);
                        break;
                    case "domingo":
                        diasLaborablesList.add(DiasLaborales.DO);
                        break;
                    default:
                        System.out.println("se selecciono en default");
                        break;
                }
            }
            return diasLaborablesList;
        } catch (Exception e) {
            System.err.println("hubo un error dias" + e.getMessage());
        }
        return null;
    }

    private void cargarHorarioList() {
        try {
            connection = dbConnect.conectar();
            sql = "SELECT * FROM Horarios ";
            ps = connection.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                String tipo = result.getString("tipo");
                long id = result.getLong("id");
                float horasSemanales = result.getFloat("horas_semanales");
                horarioList.add(new Horario(tipo, retornarDiasLaborablesList(id), horasSemanales));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el horariolist");
            System.err.println("hubo un error horario" + e.getMessage());
        } finally {
            dbConnect.desconectar();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String empresa) {
        this.nombre = empresa;
    }

    public int getFundacionYear() {
        return fundacionYear;
    }

    public void setFundacionYear(int fundacionYear) {
        if (this.fundacionYear == 0) {
            this.fundacionYear = fundacionYear;
        }
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public Calendar getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int hora, int minuto) {
        horaEntrada.set(Calendar.HOUR_OF_DAY, hora);
        horaEntrada.set(Calendar.MINUTE, minuto);
    }

    public List<Gerente> getGerenteList() {
        return gerenteList;
    }

    public void setGerenteList(List<Gerente> gerenteList) {
        this.gerenteList = gerenteList;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", fundacionYear=" + fundacionYear + ", rubro=" + rubro + ", leyenda=" + leyenda + '}';
    }

}
