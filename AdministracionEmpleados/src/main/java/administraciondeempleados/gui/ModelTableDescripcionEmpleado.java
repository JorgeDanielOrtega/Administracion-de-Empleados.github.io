package administraciondeempleados.gui;

import administraciondeempleados.Contrato;
import administraciondeempleados.Decimo;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import administraciondeempleados.Empleado;
import administraciondeempleados.Gerente;
import administraciondeempleados.Horario;
import administraciondeempleados.Persona;
import administraciondeempleados.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import prueb.DBConnect;



public class ModelTableDescripcionEmpleado extends DefaultTableModel{
    
    private List<Trabajador> trabajadorList;
    private DBConnect dbConnect;
    private Connection connection;
    private String sql;
    private ResultSet result;
    private PreparedStatement ps;
    private long id_persona;
    private long id_trabajador;
    private long id_contrato;
    private long id_decimo;
    private long id_empleado;
    private long id_horario;
    //private long id_empleado;
    
    
    public ModelTableDescripcionEmpleado() {
//        empleadoList = new LinkedList<>();
        
        dbConnect = new DBConnect();
        addColumn("Nombre");
        addColumn("Apellido");
        addColumn("Cedula");
        addColumn("Telefono");
        addColumn("Fecha Nacimiento");
        addColumn("Usuario");
        addColumn("Rol");
        addColumn("Departamento");
        addColumn("Horario");
    }
    
    public void cargarModelo(){
        try{
            connection = dbConnect.conectar();          
            for (Trabajador trabajador : trabajadorList){
                System.out.println("Trabajador == " + trabajador);
                if(trabajador instanceof Empleado){
                    Empleado empleado = (Empleado)trabajador;
                    addRow(new Object[]{
                    empleado.getNombre(),
                    empleado.getApellido(),
                    empleado.getCedula(),
                    empleado.getTelefono(),
                    empleado.getFechaNacimiento().getYear()+1900 + "-" + (empleado.getFechaNacimiento().getMonth()+1) + "-" + empleado.getFechaNacimiento().getDate(),
                    empleado.getUsuario(),
                    empleado.getRol(),
                    empleado.getDepartamento(), 
                    empleado.getHorario()
                    });
                }
            }
        }catch(Exception e){
            System.out.println("Hubo un error al cargar Departamentos" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al carfar Departamentos");
        }finally{
            dbConnect.desconectar();
        }
    }
    
    public void agregarEmpleado(Empleado empleado){
        trabajadorList.add((Trabajador)empleado);
        
        addRow(new Object[]{
            empleado.getNombre(),
            empleado.getApellido(),
            empleado.getCedula(),
            empleado.getTelefono(),
            empleado.getFechaNacimiento().getYear()+1900 + "-" + (empleado.getFechaNacimiento().getMonth()+1) + "-" + empleado.getFechaNacimiento().getDate(),
            empleado.getUsuario(),
            empleado.getRol(),
            empleado.getDepartamento(),
            empleado.getHorario()
        });
        try{
            connection = dbConnect.conectar();
            String fechaNacimiento = "" + String.valueOf( empleado.getFechaNacimiento().getYear() + 1900) + "/" + String.valueOf( empleado.getFechaNacimiento().getMonth() + 1) + "/" + String.valueOf(empleado.getFechaNacimiento().getDate());
            String fechaEntrada =  "" + String.valueOf(empleado.getEntradaYear().getYear() + 1900) + "/" + String.valueOf(empleado.getEntradaYear().getMonth() + 1) + "/" + String.valueOf(empleado.getEntradaYear().getDate());
            crearPersonaDB(empleado, fechaNacimiento, fechaEntrada);
            long idRol = retornarID("roles","nombre", empleado.getRol().getNombre());
            long idHorario = retornarIDHorario(empleado.getHorario());
            //crearHorario(empleado.getHorario());
            long idPuesto = retornarID("puestos", "nombre", empleado.getRol().getPuesto().getNombre());
            long idDepartamento = retornarID("departamentos", "nombre", empleado.getDepartamento().getNombre());
            crearTrabajadorDB(empleado, id_persona, idHorario, idRol, idDepartamento);
            crearEmpleadoDB();
            crearContratoDB(empleado.getContrato(), id_empleado);
            cambiarContratoIDTrabajador();            
        }catch(Exception e){
            System.out.println("No se pudo CREAR EMPLEADO PRICIPAL" + e.getMessage());
            JOptionPane.showMessageDialog( null, "NO SE PUDO CREAR EMPLEADO PRICIPAL");
        }finally{
            dbConnect.desconectar();
        }
        
    }
    
            
    public void eliminarEmpleado(int fila){
        Trabajador trabajador = trabajadorList.get(fila);
//        System.out.println(trabajador.getNombre() + "-" + trabajador.getApellido() + "-" + trabajador.getRol());        
        if (fila >= 0){
            trabajadorList.remove(fila);
            removeRow(fila);
            
            //ID
            long idPersona = retornarID("persona","cedula", trabajador.getCedula());
            long idTrabajador = retornarID("trabajador","id_persona", String.valueOf(idPersona));
            long idEmpleado = retornarID("empleados", "id_trabajador", String.valueOf(idTrabajador));
            long idContrato = retornarID("contratos", "id_empleado", String.valueOf(idEmpleado));
            long idAsistencia = retornarID("asistencias", "id_trabajador", String.valueOf(idTrabajador));
            long idGerente = retornarID("gerentes", "id_trabajador", String.valueOf(idTrabajador));
            long idDecimos = retornarID("decimos", "id_empleado", String.valueOf(idEmpleado));
            JOptionPane.showMessageDialog( null, "IDE DE DECIMOS ES "+ idDecimos);
    //PERSONA
            eliminarConexionLlaveForanea("trabajador", "id_persona", idTrabajador );
            eliminarRegistro("persona", idPersona);
            //TRABAJADOR
            eliminarConexionLlaveForanea("empleados","id_trabajador", idEmpleado);
            eliminarConexionLlaveForanea("asistencias", "id_trabajador", idAsistencia);
            eliminarConexionLlaveForanea("gerentes", "id_trabajador", idGerente);
            eliminarRegistro("trabajador", idTrabajador);
            //EMPLEADO
            eliminarConexionLlaveForanea("decimos", "id_empleado", idDecimos);
            eliminarConexionLlaveForanea("contratos", "id_empleado", idContrato);
            eliminarRegistro("empleados", idEmpleado);
            //CONTRATO
            eliminarConexionLlaveForanea("trabajador", "id_contrato", idTrabajador);
            eliminarRegistro("contratos", idContrato);
            //DECIMOS
            eliminarRegistro("decimos", idDecimos);
        }else{
            JOptionPane.showMessageDialog( null, "Selecionar Fila");
        }
    }
    
    private long retornarID (String nombreTabla, String columnaTabla, String campoComparar){
        long id = 0;
        try {
            connection = dbConnect.conectar();
            String query = "SELECT id FROM\""+ nombreTabla   +"\"WHERE " + columnaTabla +"= '" + campoComparar + "'";
            ps = connection.prepareStatement(query);
            result = ps.executeQuery();
            while(result.next()){
                id = result.getLong("id");
            }
            System.out.println("Foreign Key de " + nombreTabla + " es " + id);
            return id;
        } catch (Exception e) {
            System.out.println("No se pudo encontrar el id" + e.getMessage());
            JOptionPane.showMessageDialog( null, "Selecionar Fila");
        }
        return 0;
    }
    
    private void eliminarConexionLlaveForanea(String nombreTabla, String nombreColumna, long idComprobacion){
        try{
            connection = dbConnect.conectar();
            sql = "UPDATE \"" + nombreTabla  + "\" SET " + nombreColumna +" = null WHERE id = " + idComprobacion;
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Eliminacion de llave foranea en " + nombreTabla + " el id = " + idComprobacion);
        }catch(Exception e){
            System.out.println("No se pudo eliminar la llave foranea en " + nombreTabla + e.getMessage());
            JOptionPane.showMessageDialog( null, "No se pudo eliminar la llave fonarea en " + nombreTabla);
        }finally{
            dbConnect.desconectar();
        }
    }       
    
    private void eliminarRegistro(String nombreTabla, long idEliminar){
        try{
            connection = dbConnect.conectar();
            sql = "DELETE FROM \"" + nombreTabla + "\" WHERE id = " + idEliminar ;
            ps = connection.prepareStatement(sql);
            ps.execute();
            System.out.println("Elimnacion del registro en " + nombreTabla);
        }catch(Exception e){
            System.out.println("No se pudo eliminar la registro en " + nombreTabla + e.getMessage());
            JOptionPane.showMessageDialog( null, "No se pudo eliminar la REGISTRO de " + nombreTabla);
        }finally{
            dbConnect.desconectar();
        }
    }
    
    public void editarEmpleado(int fila, Empleado empleado){
        boolean instanciaGerente = (trabajadorList.get(fila) instanceof Gerente) ? false : true;
        if(instanciaGerente){
            
            trabajadorList.get(fila).setNombre(empleado.getNombre());
            trabajadorList.get(fila).setApellido(empleado.getApellido());
            trabajadorList.get(fila).setDireccion(empleado.getDireccion());
            trabajadorList.get(fila).setEstadoCivil(empleado.getEstadoCivil());
            trabajadorList.get(fila).setCedula(empleado.getCedula());
            trabajadorList.get(fila).setSexo(empleado.getSexo());
            trabajadorList.get(fila).setCiudad(empleado.getCiudad());
            trabajadorList.get(fila).setTelefono(empleado.getTelefono());
            trabajadorList.get(fila).setFechaNacimiento(empleado.getFechaNacimiento());
            trabajadorList.get(fila).setCorreoPersonal(empleado.getCorreoPersonal());
            trabajadorList.get(fila).setCorreoEmpresarial(empleado.getCorreoEmpresarial());
            trabajadorList.get(fila).setUsuario(empleado.getUsuario());
            trabajadorList.get(fila).setPassword(empleado.getPassword());
            trabajadorList.get(fila).setPagoPorTrasferencia(empleado.isPagoPorTrasferencia());
            trabajadorList.get(fila).setRol(empleado.getRol());
            trabajadorList.get(fila).setContrato(empleado.getContrato());
            ((Empleado)trabajadorList.get(fila)).setEntradaYear(empleado.getEntradaYear());
            trabajadorList.get(fila).setDepartamento(empleado.getDepartamento());

            setValueAt(empleado.getNombre(), fila, 0);
            setValueAt(empleado.getApellido(), fila, 1);
            setValueAt(empleado.getCedula(), fila,2 );
            setValueAt(empleado.getTelefono(), fila, 3);
            setValueAt(empleado.getFechaNacimiento().getYear()+1900 + "-" + (empleado.getFechaNacimiento().getMonth()+1) + "-" + empleado.getFechaNacimiento().getDate(), fila, 4);
            setValueAt(empleado.getUsuario(), fila, 5);
            setValueAt(empleado.getRol(), fila, 6);
            setValueAt(empleado.getDepartamento(), fila, 7);
            setValueAt(empleado.getHorario(), fila, 8);
            System.out.println("Empleado == " + empleado);
            try{
                connection = dbConnect.conectar();
                String fechaNacimiento = "" + String.valueOf( empleado.getFechaNacimiento().getYear() + 1900) + "/" + String.valueOf( empleado.getFechaNacimiento().getMonth() + 1) + "/" + String.valueOf(empleado.getFechaNacimiento().getDate());
                String fechaEntrada =  "" + String.valueOf(empleado.getEntradaYear().getYear() + 1900) + "/" + String.valueOf(empleado.getEntradaYear().getMonth() + 1) + "/" + String.valueOf(empleado.getEntradaYear().getDate());
                long idPersona = retornarID("persona", "cedula", empleado.getCedula());
                long idTrabajador = retornarID("trabajador", "id_persona", String.valueOf(idPersona));
                long idEmpleado = retornarID("empleados", "id_trabajador", String.valueOf(idTrabajador));
                long idDecimos = retornarID("decimos", "id_empleado", String.valueOf(idEmpleado));
                long idDepartamento = retornarID("departamentos", "nombre", empleado.getDepartamento().getNombre());
                long idRol = retornarID("roles","nombre", empleado.getRol().getNombre());
                long idHorario = retornarIDHorario(empleado.getHorario());
                //crearHorario(empleado.getHorario());
                //long idPuesto = retornarID("puestos", "nombre", empleado.getRol().getPuesto().getNombre());
                long idContrato = retornarID("contratos", "id_empleado", String.valueOf(idEmpleado));
                actualizarPersonaDB(empleado, fechaNacimiento, fechaEntrada, idPersona);

                actualizarDecimoDB(idDecimos, empleado.getDecimo());
                actualizarTrabajadorDB(empleado, idTrabajador, idPersona, idHorario, idRol, idDepartamento, idContrato);
                actualizarContratoDB(idRol, empleado.getContrato());
                cambiarContratoIDTrabajador();            
            }catch(Exception e){
                System.out.println("No se pudo  MODIFICAR EMPLEADO " + e.getMessage());
            }finally{
                dbConnect.desconectar();
            }
        }else{
            System.out.println("No es una instancia de empleado");
        }
    }
    //ACTUALIZARR

    
    public List<Trabajador> gettrabajadorList() {
        return trabajadorList;
    }

    public void settrabajadorList(List<Trabajador> trabajadorList) {
        this.trabajadorList = trabajadorList;
    }
    
    //Database Methods 
    private void actualizarPersonaDB(Trabajador persona, String fechaNacimiento, String fechaEntrada, long idPersona){
        try{
            connection = dbConnect.conectar();
            sql = "UPDATE \"persona\" SET nombres = '" + persona.getNombre() + "', apellidos = '" + persona.getApellido()
                    + "', direccion = '" + persona.getDireccion() + "', estado_civil = '" + persona.getEstadoCivil() + "', cedula = '"
                    + persona.getCedula() + "', ciudad = '" + persona.getCiudad() + "', telefono = '" + persona.getTelefono()
                    + "', sexo = '" + persona.getSexo() + "', fecha_nacimiento = '" + fechaNacimiento + "', anio_entrada = '"
                    + fechaEntrada + "' WHERE id = " + idPersona ;
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "Se actualizo Persona en DB");
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo modificar persona en DB");
           System.out.println("No se puedo modificar persona en BD " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }

    private void actualizarTrabajadorDB(Empleado trabajador, long idTrabajador, long idPersona, long idHorario, long idRol, long idDepartamento, long idContrato){
        int pagoTransferencia = (trabajador.isPagoPorTrasferencia() == true) ? 1 : 0;
        try{
           connection = dbConnect.conectar();
           sql = "UPDATE \"trabajador\" SET correo_personal= '" + trabajador.getCorreoPersonal() + "', correo_empresarial= '"
                   + trabajador.getCorreoEmpresarial() + "', usuario= '" + trabajador.getUsuario() + "', contrasenia= '"
                   + trabajador.getPassword() + "', pago_por_transferencia= " + pagoTransferencia + ", id_persona = " + idPersona
                   + ", id_horario = " + idHorario + ",id_rol = "+ idRol +",id_departamento=" + idDepartamento + ",vacaciones="
                   + " " + trabajador.getVacaciones() + ", id_contrato = " + idContrato + 
                   " WHERE id= " + idTrabajador + ";";
           ps = connection.prepareStatement(sql);
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "Se actualizo Trabajador de DB");
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo actualizar trabajador en DB");
           System.out.println("No se puedo actualizar trabajador en BD " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
    
    private void actualizarContratoDB(Contrato contrato, long idEmpleado, long idContrato){
        int tieneContrato = (contrato.getTieneContrato() == true) ? 1 : 0; 
        String contratoTiempo = String.valueOf(contrato.getFechaLimite().getYear() + 1900) + "/" + String.valueOf(contrato.getFechaLimite().getMonth() + 1) + "/" + String.valueOf(contrato.getFechaLimite().getDate());
        try{
           connection = dbConnect.conectar();
           sql = "UPDATE \"contratos\" SET tiene_contrato = " + tieneContrato + ", tiempo_contrato= " + contratoTiempo 
                   + ", fecha_limite = " + contratoTiempo + ", id_empleado = " + idEmpleado
                  + " WHERE id= " + idContrato + ";";
           ps = connection.prepareStatement(sql);
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "Se actualizo Contrato de DB");
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo actualizar en DB");
           System.out.println("No se puedo actualizar el contrato en BD " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
    
    private void actualizarPersonaDB(long id, Persona persona){
        try{
           connection = dbConnect.conectar();
           sql = "UPDATE\"persona\"SET nombres= '" + persona.getNombre() + "', apellidos= '" + persona.getApellido() + "', direccion= '" + persona.getDireccion() +
                  "', estado_civil= '" + persona.getEstadoCivil() + "', cedula= '" + persona.getCedula() + "', ciudad= '" + persona.getCiudad() + "', telefono= '" +
                    persona.getTelefono() + "', sexo= '" + persona.getSexo() + "', fecha_nacimiento= '" + persona.getFechaNacimiento() + "', anio_entrada= '" +
                    persona.getBirthday() + "WHERE id=" + id + ";";
           ps = connection.prepareStatement(sql);
           ps.executeUpdate();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo actualizar persona en DB");
            System.out.println("No se puedo actualizar el persona en BD " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
    
    private void actualizarContratoDB(long id, Contrato contrato){
        int tieneContrato = (contrato.getTieneContrato()== true) ? 1 : 0;
        String contratoTiempo = String.valueOf(contrato.getFechaLimite().getYear() + 1900) + "/" + String.valueOf(contrato.getFechaLimite().getMonth() + 1) + "/" + String.valueOf(contrato.getFechaLimite().getDate());        try{
           connection = dbConnect.conectar();
           sql = "UPDATE\"contratos\"SET tiene_contrato= " + tieneContrato + ", tiempo_contrato= " +
                   contrato.getTiempoContrato() + ", fecha_limite= '" + contratoTiempo + 
                   "' WHERE id=" + id + ";";
           ps = connection.prepareStatement(sql);
           ps.executeUpdate();
           System.out.println("Se actualizo contrato " + contratoTiempo);
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo actualizar contrato en DB");
           System.out.println("No se puedo actualizar el contrato en BD " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
 
    private void actualizarDecimoDB(long idDecimo, Decimo decimo){
        try{
            connection = dbConnect.conectar();
            sql = "UPDATE\"decimos\"SET decimo_tercero= " + decimo.getDecimoTercero() + ", decimo_cuarto= " +
                   decimo.getDecimoCuarto() + ", fondo_reserva= " + decimo.getFondoReserva() +  
                   " WHERE id=" + idDecimo + ";";
           ps = connection.prepareStatement(sql);
           ps.executeUpdate();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo actualizar decimo en DB");
           System.out.println("No se puedo actualizar el decimo en BD " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
    
    private void crearPersonaDB(Trabajador persona, String fechaNacimiento, String fechaEntrada){
        
        try{
            connection = dbConnect.conectar();
            sql = "INSERT INTO \"persona\" (nombres, apellidos, direccion, estado_civil, cedula, ciudad,"
                    + "telefono, sexo, fecha_nacimiento, anio_entrada)" + " VALUES ('" + persona.getNombre()
                    + "', '" + persona.getApellido() + "', '" + persona.getDireccion() + "', '" + persona.getEstadoCivil() + "', '" + persona.getCedula() + "', '" +
                    persona.getCiudad() + "', '" + persona.getTelefono() + "', '" + persona.getSexo() + "', '" + fechaNacimiento + "', '" +
                    fechaEntrada + "')";
           ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.executeUpdate();
           result = ps.getGeneratedKeys();
           while (result.next()){
                id_persona = result.getLong("id");
           }
           JOptionPane.showMessageDialog(null, "CREADO PERSONA");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear persona en DB");
            System.out.println("No se puedo crear el persona en BD " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }

    private void crearTrabajadorDB(Trabajador trabajador, long id_persona, long id_horario, long id_rol, long id_departamento){
        int pagoTransferencia = (trabajador.isPagoPorTrasferencia() == true) ? 1 : 0;
        id_contrato = 2;
        try{
            sql = "INSERT INTO \"trabajador\" (correo_personal, correo_empresarial, usuario, contrasenia, pago_por_transferencia, id_persona, id_horario, id_rol,"
                    + " id_departamento, vacaciones, id_contrato)" + " VALUES('" + trabajador.getCorreoPersonal() + "', '" + trabajador.getCorreoEmpresarial() + "', '" + trabajador.getUsuario() + "', '" +
                    trabajador.getPassword() + "', " + pagoTransferencia + ", " + id_persona + ", " + id_horario + ", " + 
                    id_rol + ", " + id_departamento + ", " + trabajador.getVacaciones() + ", " + id_contrato + ")";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            while (result.next()){
                id_trabajador = result.getLong("id");
            }
            JOptionPane.showMessageDialog(null, "CREADO TRABAJADOR");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear Trabajador en DB");
            System.out.println("No se puedo crear el trabajador en BD " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
    private void crearHorario(Horario horario){
        try{
            connection = dbConnect.conectar();
            sql = "INSERT INTO \"horarios\" (tipo, horas_semanales)"
                    + " VALUES ('" + horario.getTipo() + "', " + horario.getHorasLaborablesSemanales() + " )"; 
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            while(result.next()){
                id_horario = result.getLong("id");
            }
            JOptionPane.showMessageDialog(null, "CREADO HORARIO");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear horario");
            System.out.println("Error al crear horario");
        }finally{
            dbConnect.desconectar();
        }
    }
    
    private void crearEmpleadoDB(){
        try{
            connection = dbConnect.conectar();
            sql = "INSERT INTO \"empleados\" (id_trabajador) VALUES (" + id_trabajador + ")"; 
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            while (result.next()){
                id_empleado = result.getLong("id");
           }
            JOptionPane.showMessageDialog(null, "CREADO EMPLEADO");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear empleado");
            System.out.println("Error al crear empleado");
        }finally{
            dbConnect.desconectar();
        }
    }
    
    private void crearDecimoDB(Decimo decimo){
        try{
            sql = "INSERT INTO \"decimos\"(decimo_tercero, decimo_cuarto, fondo_reserva, id_empleado)" +
                    "VALUES(" + decimo.getDecimoTercero() + ", " + decimo.getDecimoCuarto() + ", " + decimo.getFondoReserva() + ")";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            while (result.next()){
                id_decimo = result.getLong(1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear Decimo en DB");
            System.out.println("No se puedo crear el decimo en BD " + e.getMessage());
        }
    }
    
    private void crearContratoDB(Contrato contrato, long id_empleado){
        int tieneContrato = (contrato.getTieneContrato()== true) ? 1 : 0;
        String contratoTiempo = String.valueOf(contrato.getFechaLimite().getYear() + 1900) + "/" + String.valueOf(contrato.getFechaLimite().getMonth() + 1) + "/" + String.valueOf(contrato.getFechaLimite().getDate());
        try{
            connection = dbConnect.conectar();
            sql = "INSERT INTO \"contratos\" (tiene_contrato, tiempo_contrato, fecha_limite, id_empleado )"
                + "VALUES (" +  tieneContrato + ", " + contrato.getTiempoContrato() + ", '" + contratoTiempo + 
                    "', " + id_empleado + ")";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            while (result.next()){
                id_contrato = result.getLong("id");
            }
            JOptionPane.showMessageDialog(null, "CONTRATO CONTRUIDO CON ID " + id_contrato);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear Contrato en DB");
            System.out.println("No se puedo crear el contrato en BD " + e.getMessage());
        }
    }
    
    //RETORNAR 
    
    private void cambiarContratoIDTrabajador(){
       try {
            connection = dbConnect.conectar();
            sql = "UPDATE \"trabajador\" SET id_contrato =" + id_contrato + " WHERE id= " + id_trabajador ; 
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se cambiar el ID TRAJADOR" + e.getMessage());
            JOptionPane.showMessageDialog( null, "No se pudo cambiar el ID TRABAJADOR");
        }finally{
           dbConnect.desconectar();
       }
   }
    
   private long retornarIDHorario (Horario horario){
        long id = 0;
        try {
            connection = dbConnect.conectar();
            String query = "SELECT id FROM \"horarios\" WHERE tipo = '" + horario.getTipo() + "' and horas_semanales = " + horario.getHorasLaborablesSemanales();
            ps = connection.prepareStatement(query);
            result = ps.executeQuery();
            while(result.next()){
                id = result.getLong("id");
            }
            System.out.println(id);
            return id;
        } catch (Exception e) {
            System.out.println("No se pudo encontrar el id" + e.getMessage());
            JOptionPane.showMessageDialog( null, "Selecionar Fila");
        }
        return 0;
    }
}
