package administraciondeempleados.gui;

import administraciondeempleados.Contrato;
import administraciondeempleados.Decimo;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import administraciondeempleados.Empleado;
import administraciondeempleados.Persona;
import administraciondeempleados.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import prueb.DBConnect;



public class ModelTableDescripcionEmpleado extends DefaultTableModel{
    
    private List<Trabajador> trabajadorList;
    private DBConnect dbConnect;
    private Connection connection;
    private String sql;
    private ResultSet result;
    private PreparedStatement ps;
    private long id_persona;
    private long id_contrato;
    private long id_decimo;
    private long id_trabajador;
    //private long id_empleado;
    
    
    public ModelTableDescripcionEmpleado() {
//        empleadoList = new LinkedList<>();

        dbConnect = new DBConnect();
        addColumn("Nombre");
        addColumn("Apellido");
        addColumn("Direccion");
        addColumn("EstadoCivil");
        addColumn("Cedula");
        addColumn("Genero");
        addColumn("Ciudad");
        addColumn("Telefono");
        addColumn("Fecha Nacimiento");
        addColumn("Correo personal");
        addColumn("Correo empresarial");
        addColumn("Usuario");
        addColumn("Contraseña");
        addColumn("Pago por transferencia");
        addColumn("Rol");
        addColumn("Contrato");
        addColumn("Año de entrada");
        addColumn("Departamento");
        addColumn("Horario");
    }
    
    public void agregarEmpleado(Empleado empleado){
        trabajadorList.add((Trabajador)empleado);
        addRow(new Object[]{
            empleado.getNombre(),
            empleado.getApellido(),
            empleado.getDireccion(),
            empleado.getEstadoCivil(),
            empleado.getCedula(),
            empleado.getSexo(),
            empleado.getCiudad(),
            empleado.getTelefono(),
            empleado.getFechaNacimiento().getYear()+1900 + "-" + (empleado.getFechaNacimiento().getMonth()+1) + "-" + empleado.getFechaNacimiento().getDate(),
            empleado.getCorreoPersonal(),
            empleado.getCorreoEmpresarial(),
            empleado.getUsuario(),
            empleado.getPassword(),
            empleado.isPagoPorTrasferencia(),
            empleado.getRol(),
            empleado.getContrato(),
            empleado.getEntradaYear().getYear()+1900 + "-" + (empleado.getEntradaYear().getMonth()+1) + "-" + empleado.getEntradaYear().getDate(),
            empleado.getDepartamento(),
            empleado.getHorario()
        });
//        Persona persona = new Persona(empleado.getNombre(), empleado.getApellido(), empleado.getDireccion(), empleado.getEstadoCivil(),
//        empleado.getCedula(), empleado.getSexo(), empleado.getCiudad(), empleado.getTelefono(), empleado.getFechaNacimiento());
        crearContratoDB(empleado.getContrato(), id_contrato);
        
    }
    public void cargarModelo(){
        for (Trabajador trabajador : trabajadorList) {
            Empleado empleado = (Empleado)trabajador;
            addRow(new Object[]{
            empleado.getNombre(),
            empleado.getApellido(),
            empleado.getDireccion(),
            empleado.getEstadoCivil(),
            empleado.getCedula(),
            empleado.getSexo(),
            empleado.getCiudad(),
            empleado.getTelefono(),
            empleado.getFechaNacimiento().getYear()+1900 + "-" + (empleado.getFechaNacimiento().getMonth()+1) + "-" + empleado.getFechaNacimiento().getDate(),
            empleado.getCorreoPersonal(),
            empleado.getCorreoEmpresarial(),
            empleado.getUsuario(),
            empleado.getPassword(),
            empleado.isPagoPorTrasferencia(),
            empleado.getRol(),
            empleado.getContrato(),
            empleado.getEntradaYear().getYear()+1900 + "-" + (empleado.getEntradaYear().getMonth()+1) + "-" + empleado.getEntradaYear().getDate(),
            empleado.getDepartamento(),
            empleado.getHorario()
            });
        }
    }
    
    public void eliminarEmpleado(int fila){
        if (fila >= 0){
            trabajadorList.remove(fila);
            removeRow(fila);
            //eliminar(fila);
        }else{
            JOptionPane.showMessageDialog( null, "Selecionar Fila");
        }
//        for(int index = 0; index<empleadoList.size(); index++){
//            if(empleadoList.get(index).getUsuario().equals(usuarioEmpleado));
//                empleadoList.remove(index);
//            }
    }
    
    public void editarEmpleado(int fila, Empleado empleado){
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
        setValueAt(empleado.getDireccion(), fila,2 );
        setValueAt(empleado.getEstadoCivil(), fila,3 );
        setValueAt(empleado.getCedula(), fila,4 );
        setValueAt(empleado.getSexo(), fila,5 );
        setValueAt(empleado.getCiudad(), fila, 6);
        setValueAt(empleado.getTelefono(), fila, 7);
        setValueAt(empleado.getFechaNacimiento().getYear()+1900 + "-" + (empleado.getFechaNacimiento().getMonth()+1) + "-" + empleado.getFechaNacimiento().getDate(), fila, 8);
        setValueAt(empleado.getCorreoPersonal(), fila, 9);
        setValueAt(empleado.getCorreoEmpresarial(), fila, 10);
        setValueAt(empleado.getUsuario(), fila, 11);
        setValueAt(empleado.getPassword(), fila,12 );
        setValueAt(empleado.isPagoPorTrasferencia(), fila,13);
        setValueAt(empleado.getRol(), fila, 14);
        setValueAt(empleado.getContrato(), fila, 15);
        setValueAt(empleado.getEntradaYear().getYear()+1900 + "-" + (empleado.getEntradaYear().getMonth()+1) + "-" + empleado.getEntradaYear().getDate(), fila,16 );
        setValueAt(empleado.getDepartamento(), fila, 17);
        setValueAt(empleado.getHorario(), fila, 18);
    }

    public List<Trabajador> gettrabajadorList() {
        return trabajadorList;
    }

    public void settrabajadorList(List<Trabajador> trabajadorList) {
        this.trabajadorList = trabajadorList;
    }
    
    
    //Database Methods 
    private void crearEmpleadoDB(Empleado empleado, long id_rol, long id_departamento, long id_horario){
        try{
            connection = dbConnect.conectar();
            crearPersonaDB(empleado);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear empleado");
            System.out.println("Error al crear empleado");
        }finally{
            dbConnect.desconectar();
        }
    }
    private void eliminarmpleadoDB(Empleado empleado){
        try {
            connection = dbConnect.conectar();
            long id = retornarID(empleado.getId()); ///TAL VEZ PROBLEMAS
            eliminarPersonaTrabajador(id);
            sql = "DELETE FROM \"persona\" WHERE id= " + id; //SE OBVIA POR CREACION EN CADENA == MISMO ID
            ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el Departamento");
            System.out.println("Error al eliminar Departamento " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
    private void eliminarEmpleadoAsitencia(long id){
        try{
            sql = "DELETE FROM \"asistencia\"WHERE id_empleado = " + id + ";";
            ps = connection.prepareStatement(sql);
            ps.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se puede eliminar el empleado de asistencia");
            System.out.println("Error al eliminar Empleado de asistenica " + e.getMessage());
        }
    }
    private void eliminarEmpleadoDecimos(long id){
        try{
            sql = "DELETE FROM \"decimos\"WHERE id_empleado = " + id + ";";
            ps = connection.prepareStatement(sql);
            ps.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se puede eliminar el empleado de asistencia");
            System.out.println("Error al eliminar Empleado de asistenica " + e.getMessage());
        }
    }
    
    
    private void crearPersonaDB(Persona persona){
        
        try{
            sql = "INSERT INTO \"persona\"(nombres, apellidos, direccion, estado_civil, cedula, ciudad,"
                    + "telefono, sexo, fecha_nacimiento, anio_entrada)" + "VALUES ('" + persona.getNombre()
                    + "', '" + persona.getApellido() + "', '" + persona.getDireccion() + "', '" + persona.getEstadoCivil() + "', '" + persona.getCedula() + "', '" +
                    persona.getCiudad() + "', '" + persona.getTelefono() + "', '" + persona.getSexo() + "', '" + persona.getFechaNacimiento() + "', anio_entrada= '" +
                    persona.getBirthday() + "')";
           ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.executeUpdate();
           result = ps.getGeneratedKeys();
           result.next();
           id_persona = result.getLong(1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear persona en DB");
            System.out.println("No se puedo crear el persona en BD " + e.getMessage());
        }
    }
    
    private void actualizarPersonaDB(long id, Persona persona){
        try{
            sql = "UPDATE\"persona\"SET nombres= '" + persona.getNombre() + "', apellidos= '" + persona.getApellido() + "', direccion= '" + persona.getDireccion() +
                  "', estado_civil= '" + persona.getEstadoCivil() + "', cedula= '" + persona.getCedula() + "', ciudad= '" + persona.getCiudad() + "', telefono= '" +
                    persona.getTelefono() + "', sexo= '" + persona.getSexo() + "', fecha_nacimiento= '" + persona.getFechaNacimiento() + "', anio_entrada= '" +
                    persona.getBirthday() + "WHERE id=" + id + ";";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo actualizar persona en DB");
            System.out.println("No se puedo actualizar el persona en BD " + e.getMessage());
        }
    }
    
    private void eliminarPersonaDB(Persona persona){
        try {
            connection = dbConnect.conectar();
            long id = retornarID(persona.getCedula());
            eliminarPersonaTrabajador(id);
            sql = "DELETE FROM \"persona\" WHERE id= " + id; //SE OBVIA POR CREACION EN CADENA == MISMO ID
            ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el Departamento");
            System.out.println("Error al eliminar Departamento " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
    
    private void eliminarPersonaTrabajador(long id){
        try{
            sql = "DELETE FROM \"trabajador\"WHERE id_persona = " + id + ";";
            ps = connection.prepareStatement(sql);
            ps.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se puede eliminar el Departamento");
            System.out.println("Error al eliminar Departamento " + e.getMessage());
        }
    }
        
    private void crearContratoDB(Contrato contrato, long id_empleado){
        try{
            sql = "INSERT INTO \"contratos\"(tiene_contrato, tiempo_contrato, fecha_limite, id_empleado )"
                + "VALUES (" +  contrato.getTieneContrato() + ", " + contrato.getTiempoContrato() + ", '" + contrato.getFechaLimite() + 
                    ", " + id_empleado + "')";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            result.next();
            id_contrato = result.getLong(1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear Contrato en DB");
            System.out.println("No se puedo crear el contrato en BD " + e.getMessage());
        }
    }
    private void actualizarContratoDB(long id, Contrato contrato){
        try{
           sql = "UPDATE\"contratos\"SET tiene_contrato= " + contrato.getTieneContrato() + ", tiempo_contrato= " +
                   contrato.getTiempoContrato() + ", fecha_limite= '" + contrato.getFechaLimite() + 
                   " WHERE id=" + id + ";";
           ps = connection.prepareStatement(sql);
           ps.executeUpdate();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo crear persona en DB");
           System.out.println("No se puedo crear el contrato en BD " + e.getMessage());
        }
    }
    
    private void eliminarContratoDB(long id, Contrato contrato){
        try {
            connection = dbConnect.conectar();
            //long id = retornarID(contrato.get);
            eliminarContratoTrabajador(id);
            sql = "DELETE FROM \"contratos\" WHERE id= " + id;
            ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el Contrato");
            System.out.println("Error al eliminar Contrato " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
    private void eliminarContratoTrabajador(long id){
        try{
           sql = "DELETE FROM \"trabajador\"WHERE id_contrato= " + id +";"; 
           ps = connection.prepareStatement(sql);
           ps.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se puede eliminar Contrato Trabajador");
            System.out.println("Error al eliminar Contrato de trabajador" + e.getMessage());
        }
    }
    private void crearDecimoDB(Decimo decimo){
        try{
            sql = "INSERT INTO \"decimos\"(decimo_tercero, decimo_cuarto, fondo_reserva, id_empleado)" +
                    "VALUES(" + decimo.getDecimoTercero() + ", " + decimo.getDecimoCuarto() + ", " + decimo.getFondoReserva() + ")";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            result.next();
            id_decimo = result.getLong(1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear Decimo en DB");
            System.out.println("No se puedo crear el decimo en BD " + e.getMessage());
        }
    }
    private void actualizarDecimoDB(long id, Decimo decimo){
        
        try{
           sql = "UPDATE\"decimos\"SET decimo_tercero= " + decimo.getDecimoTercero() + ", decimo_cuarto= " +
                   decimo.getDecimoCuarto() + ", fondo_reserva= " + decimo.getFondoReserva() +  
                   " WHERE id=" + id + ";";
           ps = connection.prepareStatement(sql);
           ps.executeUpdate();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo crear persona en DB");
           System.out.println("No se puedo crear el contrato en BD " + e.getMessage());
        }
        
    }
    
    
    private void crearTrabajadorDB(Trabajador trabajador, long id_horario, long id_rol, long id_departamento){
        try{
            sql = "INSERT INTO \"trabajador\"(correo_personal, usuario, contrasenia, pago_por_transferencia, id_persona, id_horario, id_rol,"
                    + " id_departamento, vacaciones)" + "VALUES('" + trabajador.getCorreoPersonal() + "','" + trabajador.getUsuario() + "','" +
                    trabajador.getPassword() + "'," + trabajador.isPagoPorTrasferencia() + "," + id_persona + ", " + id_horario + ", " + 
                    id_rol + ", " + id_departamento + ")";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            result.next();
            id_trabajador = result.getLong(1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear Trabajador en DB");
            System.out.println("No se puedo crear el trabajador en BD " + e.getMessage());
        }
    }
    
    private void actualizarTrabajadorDB(long id, Trabajador trabajador){
        try{
           sql = "UPDATE\"trabajador\"SET correo_personal= '" + trabajador.getCorreoPersonal() + "', usuario= '" +
                   trabajador.getUsuario() + "', contrasenia= '" + trabajador.getPassword() + "', pago_por_transferencia= " +
                   trabajador.isPagoPorTrasferencia() + "vacaciones= " + trabajador.getVacaciones() +
                   " WHERE id=" + id + ";";
           ps = connection.prepareStatement(sql);
           ps.executeUpdate();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo crear persona en DB");
           System.out.println("No se puedo crear el contrato en BD " + e.getMessage());
        }
    }
    
    private void eliminarTrabajadorDB(long id, Trabajador trabajador){
        try {
            connection = dbConnect.conectar();
           // long id = retornarID(contrato.get);
            eliminarTrabajadorEmpleado(id);
            sql = "DELETE FROM \"trabajador\" WHERE id= " + id;
            ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el Contrato");
            System.out.println("Error al eliminar Contrato " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
    
    private void eliminarTrabajadorEmpleado (long id){
        try{
            sql = "DELETE FROM\"empleados\"WHERE id_trabajador=" + id + ";";
            ps = connection.prepareStatement(sql);
            ps.execute();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo eliminar tranajador en DB");
           System.out.println("No se puedo eliminar trabajador de BD " + e.getMessage());
        }
    }
    
    private long retornarID (String numeroCedula){
        long id = 0;
        try {
            String query = "SELECT id FROM\"empleado\"WHERE cedula='" + numeroCedula + "'";
            ps = connection.prepareStatement(query);
            result = ps.executeQuery();
            while(result.next()){
                id = result.getLong("id");
            }
            System.out.println(id);
            return id;
        } catch (Exception e) {
            System.out.println("No se pudo encontrar el id" + e.getMessage());
        }
        return 0;
    }
}
