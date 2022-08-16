package administraciondeempleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
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
    private String fundacionYear;
    private String rubro;

    //relaciones
    private List<Departamento> departamentoList;
    private List<Rol> rolList;
    private List<Horario> horarioList;
    private Calendar horaEntrada;
    private List<Gerente> gerenteList;
    private List<Trabajador> trabajadorList;

    // implementar el metodo en el dialog datos empresa, para que los datos se envien directamente a la bd
    public Empresa() {
        horarioList = new LinkedList();
        rolList = new LinkedList();
        departamentoList = new LinkedList();
        gerenteList = new LinkedList();
        trabajadorList = new LinkedList();
        dbConnect = new DBConnect();
        this.horaEntrada = Calendar.getInstance();//quitar mas tarde

    }

    public Empresa(String nombre, String fundacionYear, String rubro) {
        this();
        this.nombre = nombre;
        this.fundacionYear = fundacionYear;
        this.rubro = rubro;
        //this.horaEntrada = Calendar.getInstance();
    }

    public Empresa(String nombre, String fundacionYear, String leyenda, String rubro) {
        this(nombre, fundacionYear, rubro);
        this.leyenda = leyenda;
    }

    public void cargarListas() {
        cargarDepartamentoList();
        //System.out.println(this.departamentoList);
        cargarRolList();
        //System.out.println(this.rolList);
        cargarHorarioList();
        //System.out.println(this.horarioList);
        cargarTrabajadoresList();
        //System.out.println(this.trabajadorList);
        cargarGerenteList();
        System.out.println(this.gerenteList);
        cargarEmpresa();
        //System.out.println(this);
    }
    
    public void cargarEmpresa(){
        try{
            connection = dbConnect.conectar();
            sql = "SELECT * FROM empresa";
            ps = connection.prepareStatement(sql);
            result = ps.executeQuery();
            while(result.next()){
                this.nombre = result.getString("nombre");
                this.leyenda = result.getString("leyenda");
                this.fundacionYear = result.getString("anio_fundacion");
                this.rubro = result.getString("rubro");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo cargar los datos de la empresa ");
            System.err.println("error datos empresa" + e.getMessage());
        } finally {
            dbConnect.desconectar();
        }
    }
    
    private void cargarGerenteList(){
        try {
            connection = dbConnect.conectar();           
            sql = "SELECT * FROM (SELECT * FROM \"trabajador\" t inner join "
                    + " \"persona\" p on t.id_persona = p.id) as pato WHERE id_rol notnull";
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
                long idDepartamento = result.getLong("id_departamento");
                long idRol = result.getLong("id_rol");
                
                Empresa empresa = retornarEmpresa(id);
                Contrato contrato = retornarContrato(id);
                Departamento depa = retornarDepartamento(idDepartamento);
                Rol rol = retornarRol(idRol);
                Gerente g = new Gerente(empresa, correoPersonal, contrasenia, rol.getPuesto(), rol, depa, contrato, nombres, apellidos, direccion, cedula, sexo, ciudad, telefono, fecha_nacimiento);
                g.setId(String.valueOf(id));
                depa.getTrabajadorList().add(g);
                rol.getTrabajadorList().add(g);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el gerenteList");
            System.err.println("error gerente List" + e.getMessage());
        } finally {
            dbConnect.desconectar();
        }
    }
    
    private Empresa retornarEmpresa(long idGerente){
        try{
            String consulta = "SELECT * FROM \"empresa\" WHERE id_gerente = " + idGerente;
            PreparedStatement pst = connection.prepareStatement(consulta);
            ResultSet resS = pst.executeQuery();
            while(resS.next()){
                String nombre = resS.getString("nombre");
                String leyenda = resS.getString("leyenda");
                String fundacionYear = resS.getString("anio_fundacion");
                String rubro = resS.getString("rubro"); 
                Empresa empresa = new Empresa(nombre, fundacionYear, leyenda, rubro);
                return empresa;
            }
        }catch (Exception e){
            System.out.println("Error al retornar la empresa");
        }
        return new Empresa();
    }
    
    private Horario retornarHorario(long idHorario) {
        try {
            String consulta = "SELECT tipo FROM \"horarios\"  WHERE id = " + idHorario;
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
            String consulta = "SELECT nombre FROM \"roles\" WHERE id = " + idRol;
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
            String consulta = "SELECT * FROM \"contratos\" WHERE id_empleado = " + idEmpleado;
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
    
    private Departamento retornarDepartamento(long idDepartamento) {
        try {
            String consulta = "SELECT nombre FROM \"departamentos\" WHERE id = " + idDepartamento;
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

    private void cargarTrabajadoresList() {
        try {
            connection = dbConnect.conectar();
            //sql = "SELECT * FROM \"trabajador\"";
            sql = "select * from (select * from \"trabajador\" t inner join "
                    + " \"persona\" p on t.id_persona = p.id) as todo where "
                    + "fecha_nacimiento notnull and anio_entrada notnull and id_horario notnull "
                    + "and id_rol notnull and id_departamento notnull;";
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
                Empleado e = new Empleado(nombres, apellidos, direccion, retornarEstadoCivil(estadoCivil),
                        cedula, sexo, ciudad, telefono, fecha_nacimiento, correoPersonal, correoEmpresarial,
                        usuario, contrasenia, pagoTransferencia, rol, contrato, anio_entrada, depa, horario);
                e.setId(String.valueOf(id));
                depa.getTrabajadorList().add(e);
                horario.getEmpleadoList().add(e);
                rol.getTrabajadorList().add(e);
                this.trabajadorList.add(e);
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
            sql = "SELECT * FROM \"departamentos\"";
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
            JOptionPane.showMessageDialog(null, "No se pudo cargar el departamentoList (Empresa)");
            System.err.println("hubo un error depaaaa xd" + e.getMessage());
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
              sql = "SELECT r.salario, r.nombre AS nombre_rol, p.nombre AS nombre_puesto, "
                    + "d.nombre AS departamento FROM \"roles\" r "
                    + "INNER JOIN \"puestos\" p "
                    + "On r.id_puesto = p.id "
                    + "INNER JOIN \"departamentos\" d "
                    + "On d.id = r.id_departamento";
            ps = connection.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                String nombreDepa = result.getString("departamento");
                double salario = result.getDouble("salario");
                String nombrePuesto = result.getString("nombre_puesto");
                String nombreRol = result.getString("nombre_rol");
                rolList.add(new Rol(salario, nombreRol, new Puesto(nombrePuesto),
                        retornarDepartamento(nombreDepa)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el rolList");
            System.err.println("Hubo un error rol" + e.getMessage());
        } finally {
            dbConnect.desconectar();
        }
    }

    private List<DiasLaborales> retornarDiasLaborablesList(long id) {
        try {
            connection = dbConnect.conectar();
            List<DiasLaborales> diasLaborablesList = new LinkedList();
            sql = "SELECT dia FROM \"dias_laborables\" WHERE id IN  \n" +
                    "(SELECT hd.id_dias_laborables FROM \"horarios\" h INNER JOIN\n" +
                    "\"horarios_dias_laborables\" hd ON "+ id + "= hd.id_horarios);";
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
        return new LinkedList<DiasLaborales>();
    }

    private void cargarHorarioList() {
        try {
            connection = dbConnect.conectar();
            sql = "SELECT * FROM \"horarios\"";
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

    public String getFundacionYear() {
        return fundacionYear;
    }

    public void setFundacionYear(String fundacionYear) {
        this.fundacionYear = fundacionYear;
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

    public List<Trabajador> getTrabajadorList() {
        return trabajadorList;
    }

    public void setTrabajadorList(List<Trabajador> trabajadorList) {
        this.trabajadorList = trabajadorList;
    }

    
    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", fundacionYear=" + fundacionYear + ", rubro=" + rubro + ", leyenda=" + leyenda + '}';
    }

}
