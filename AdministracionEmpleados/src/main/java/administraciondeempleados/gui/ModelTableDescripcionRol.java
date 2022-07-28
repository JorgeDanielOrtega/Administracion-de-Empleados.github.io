/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administraciondeempleados.gui;

import administraciondeempleados.Puesto;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import administraciondeempleados.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import prueb.DBConnect;

/**
 *
 * @author SONY VAIO
 */
public class ModelTableDescripcionRol extends DefaultTableModel{

    private List<Rol> rolList;
    private DBConnect dbConnect;
    private Connection connection;
    private String sql;
    private ResultSet result;
    private PreparedStatement ps;
    private long id_puesto;
    
    public ModelTableDescripcionRol() {
        rolList = new LinkedList();
        dbConnect = new DBConnect();
        
        addColumn("Nombre");
        addColumn("Salario");
        addColumn("Puesto");
    }
    
    public void agregarRol(Rol rol, String nombreDepartamento){
        rolList.add(rol);
        crearPuestoDB(rol.getPuesto());
        long idDepartamento = encontrarID( "departamentos","nombre",nombreDepartamento);
        crearRolDB(rol, id_puesto, idDepartamento); 
        addRow(new Object[]{
            rol.getNombre(),
            rol.getSalario(),
            rol.getPuesto().getNombre()
        });
    }
    
    public void cargarModelo(){
        try{
            connection = dbConnect.conectar();
//            sql = "SELECT * FROM \"roles\"";
//            ps = connection.prepareStatement(sql);
//            result = ps.executeQuery();
//            //Rol rolMolde = new Rol();
//            while(result.next()){
//                String nombre = result.getString("nombre");
//                float salario = result.getFloat("salario");
//                int id_puesto = result.getInt("id_puesto");
//                int id_departamento = result.getInt("id_departamento");
//                Rol rolMolde = new Rol(nombre, salario, id_puesto, id_departamento);
//                rolList.add(rolMolde);
//            }
            for (Rol rol : rolList) {
                addRow(new Object[]{
                rol.getNombre(),
                rol.getSalario(),
                rol.getId_puesto(),
                rol.getId_departamento()
            });
        }
        }catch(Exception e){
            System.out.println("Hubo un error al cargar Roles" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al cargar Roles");
        }finally{
            dbConnect.desconectar();
        } 
    }
    
    public Rol leerRol(int fila){
        return rolList.get(fila);
    }
    
    public void eliminarRol(int fila){ 
        Rol rol = rolList.get(fila);
        if(fila >= 0){
            rolList.remove(fila);
            removeRow(fila);
            long idRol = encontrarID( "roles", "nombre",rol.getNombre());
            long idTrabajador = encontrarID("trabajador", "id_rol", String.valueOf(idRol));
            actualizarLlaveForanea("trabajador", "id_rol",  idTrabajador);            
            eliminarRolDB(idRol);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }
    
    public void editarRol(int fila, Rol rol,  String nombreDepartamento){
        long idRol = encontrarID( "roles", "nombre",rolList.get(fila).getNombre());
        rolList.get(fila).setNombre(rol.getNombre());
        rolList.get(fila).setSalario(rol.getSalario());
        rolList.get(fila).setPuesto(rol.getPuesto());
        setValueAt(rol.getNombre(), fila, 0);
        setValueAt(rol.getSalario(), fila, 1);
        setValueAt(rol.getPuesto().getNombre(), fila, 2);
        long idDepartamento = encontrarID( "departamentos","nombre",nombreDepartamento);
        actualizarRolDB(rolList.get(fila), idRol, idDepartamento);
    }

    //DATABASE METHODS
    
    //CREAR 
    
    private void crearRolDB(Rol rol, long id_puesto, long id_departamento){
        try{
            connection = dbConnect.conectar();
            sql = "INSERT INTO \"roles\" (nombre, salario, id_puesto, id_departamento)"
                    + " VALUES ( '" + rol.getNombre() +"', " + rol.getSalario() + ", " + id_puesto + ", "
                    + id_departamento + " )";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Rol creado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear Rol");
            System.out.println("Error al crear rol   de DB");
        }finally{
            dbConnect.desconectar();
        }
    }
    
    private void crearPuestoDB(Puesto puesto){
        try{
            connection = dbConnect.conectar();
            sql = "INSERT INTO \"puestos\" (nombre) VALUES ('" + puesto.getNombre() + "')";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            while (result.next()){
                id_puesto = result.getLong("id");
           }
            JOptionPane.showMessageDialog(null, "Puesto Creeado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Puesto no Creado");
        }finally{
            dbConnect.desconectar();
        }
    }
    
    //ELIMINAR
    
    private void eliminarRolDB(long idRol){
        try{
            connection = dbConnect.conectar();
            sql = "DELETE FROM \"roles\" WHERE id = " + idRol;
            ps = connection.prepareStatement(sql);
            ps.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , "Error al eliminar Rol de la BD");
            System.out.println("Error al eliminar Rol de la BD" + e);
        }finally{
            dbConnect.desconectar();
        }
    }
    
    private void actualizarLlaveForanea(String nombreTabla, String nombreColumna, long idComprobacion){
        try{
            connection = dbConnect.conectar();
            sql = "UPDATE \"" + nombreTabla  + "\" SET " + nombreColumna +" = null WHERE id = " + idComprobacion;
            ps = connection.prepareStatement(sql);
            ps.execute();
        }catch(Exception e){
            System.out.println("Error al eliminar id_rol de empleado" + e);
        }finally{
            dbConnect.desconectar();
        }
    }
    
    //ACTUALIZAR
    
    private void actualizarRolDB(Rol rol, long idRol, long idDepartamento){
        try{
            connection = dbConnect.conectar();
            sql = "UPDATE \"roles\" SET nombre= '" + rol.getNombre() + "', salario= " + rol.getSalario() + 
                    ", id_departamento= " + idDepartamento +" WHERE id= " + idRol + ";";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Rol actualizado de " + idRol );
        }catch(Exception e){
            System.out.println("No se pudo actualizar el Rol" + e);
        }finally{
            dbConnect.desconectar();
        }
    }

    //ENCONTRAR ID
    
    private long encontrarID(String tablaExaminar, String columnaAnalizar, String valor ){
        long id = 0;
        try{
            connection = dbConnect.conectar();
            sql = "SELECT id FROM \""+ tablaExaminar + "\" WHERE " + columnaAnalizar + " = '" + valor + "'";
            ps = connection.prepareStatement(sql);
            result =ps.executeQuery();
            while(result.next()){
                id = result.getLong("id");
            }
            System.out.println("Id de " + tablaExaminar + " id = " + id);
            return id;
        }catch(Exception e){
            System.out.println("Error al encontrar id de departamentos en ROL");
            JOptionPane.showMessageDialog(null, "No se puedo encontrar el id de empleado en Rol");
        }finally{
            dbConnect.desconectar();
        }
        return id;
    }
    
    //GETTERS AND SETTERS
    
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }
    
}
