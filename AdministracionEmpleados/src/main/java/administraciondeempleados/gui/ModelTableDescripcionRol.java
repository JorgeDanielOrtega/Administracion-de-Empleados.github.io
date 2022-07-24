/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administraciondeempleados.gui;

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
    private DBConnect dbConnnect;
    private Connection connection;
    private String sql;
    private ResultSet result;
    private PreparedStatement ps;
    
    public ModelTableDescripcionRol() {
        rolList = new LinkedList();
        dbConnnect = new DBConnect();
        
        addColumn("Nombre");
        addColumn("Salario");
        addColumn("Puesto");
    }
    
    public void agregarRol(Rol rol){
        rolList.add(rol);
        crearRolDB(rol, 1, 1); //Cambiar
        addRow(new Object[]{
            rol.getNombre(),
            rol.getSalario(),
            rol.getPuesto()
        });
    }
    
    public void cargarModelo(){
        for(Rol rol : rolList){
            addRow(new Object[]{
            rol.getNombre(),
            rol.getSalario(),
            rol.getPuesto().getNombre()
        });
        }
    }
    
    public Rol leerRol(int fila){
        return rolList.get(fila);
    }
    
    public void eliminarRol(int fila){
        if(fila >= 0){
            rolList.remove(fila);
            removeRow(fila);
            eliminarRolDB(rolList.get(fila));
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }
    
    public void editarRol(int fila, Rol rol){
        rolList.get(fila).setNombre(rol.getNombre());
        rolList.get(fila).setSalario(rol.getSalario());
        rolList.get(fila).setPuesto(rol.getPuesto());
        setValueAt(rol.getNombre(), fila, 0);
        setValueAt(rol.getSalario(), fila, 1);
        setValueAt(rol.getPuesto().getNombre(), fila, 2);
        retornarID(rolList.get(fila).getNombre());
        actualizarRolDB(fila, rol);
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }
    
    //DATABASE METHODS
    private void crearRolDB(Rol rol, long id_puesto, long id_departamento){
        try{
            connection = dbConnnect.conectar();
            sql = "INSERT INTO \"roles\"(nombre, salario, id_puesto, id_departamento)"
                    + "VALUES ( '" + rol.getNombre() +"', " + rol.getSalario() + ", " + id_puesto + id_departamento + " )";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear Rol");
            System.out.println("Error al crear deparatemento de DB");
        }finally{
            dbConnnect.desconectar();
        }
    }
    
    private void actualizarRolDB(long id, Rol rol){
        try{
            sql = "UPDATE\"roles\"SET nombre= '" + rol.getNombre() + "', salario= " + rol.getSalario() + 
                    "WHERE id= " + id + ";";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("No se pudo actualizar el Rol");
        }finally{
            dbConnnect.desconectar();
        }
    }
    private void eliminarRolDB(Rol rol){
        try{
            connection = dbConnnect.conectar();
            long id = retornarID(rol.getNombre());
            eliminarRolEmpleado(id);
            sql = "DELETE FROM \"roles\"WHERE id =" + id;
            ps = connection.prepareStatement(sql);
            ps.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , "Error al eliminar Rol de la BD");
            System.out.println("Error al eliminar Rol de la BD");
        }finally{
            dbConnnect.desconectar();
        }
    }
    
    private void eliminarRolEmpleado(long id){
        try{
            sql = "DELETE FROM \"empleados\"WHERE id_rol = " + id + ';';
            ps = connection.prepareStatement(sql);
            ps.execute();
        }catch(Exception e){
            System.out.println("Error al eliminar id_rol de empleado");
        }
    }

    private long retornarID (String nombreDepartamento){
        long id = 0;
        try{
            String query = "SELECT id FROM\"roles\"WHERE nombre='" + nombreDepartamento + "'";
            ps = connection.prepareStatement(query);
            result = ps.executeQuery();
            while(result.next()){
                id = result.getLong("id");
            }
            System.out.println(id);
            return id;
        }catch(Exception e){
            System.out.println("No se pudo encontrar el id");
        }
        return 0;
    }
}
