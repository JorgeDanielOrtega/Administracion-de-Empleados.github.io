/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administraciondeempleados.gui;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import administraciondeempleados.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import prueb.DBConnect;

/**
 *
 * @author SONY VAIO
 */
public class ModelTableDescripcionDepartamento extends DefaultTableModel {

    private List<Departamento> departamentoList;
    private DBConnect dbConnect;
    private Connection connection;
    private String sql;
    private ResultSet result;
    private PreparedStatement ps;
    
    public ModelTableDescripcionDepartamento() {

        departamentoList = new LinkedList();
        dbConnect = new DBConnect();
        
        addColumn("Nombre");
        addColumn("Numero");
        addColumn("Numero Maximo Empleados");
        addColumn("Dias de Vacaciones");
    }

    public void cargarModelo() {
        for (Departamento departamento : departamentoList) {
            addRow(new Object[]{
                departamento.getNombre(),
                departamento.getNumero(),
                departamento.getEmpleadosMaximos(),
                departamento.getVacaciones()
            });
        }
    }
    
    public Departamento leerDepartamento(int fila){
        return departamentoList.get(fila);
    }
    
    public void agregarDepartamento(Departamento departamentoAgregar) {
        departamentoList.add(departamentoAgregar);
        addRow(new Object[]{
            departamentoAgregar.getNombre(),
            departamentoAgregar.getNumero(),
            departamentoAgregar.getEmpleadosMaximos(),
            departamentoAgregar.getVacaciones()
        });
    }

    public void eliminarDepartamento(int fila) {
        if (fila >= 0) {
            departamentoList.remove(fila);
            removeRow(fila);
            eliminarDepartamentoDB(departamentoList.get(fila));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar fila");
        }
    }

    public void editarDepartamento(int fila, Departamento departamentoModificar) {
        departamentoList.get(fila).setNombre(departamentoModificar.getNombre());
        departamentoList.get(fila).setNumero(departamentoModificar.getNumero());
        departamentoList.get(fila).setEmpleadosMaximos(departamentoModificar.getEmpleadosMaximos());
        departamentoList.get(fila).setVacaciones(departamentoModificar.getVacaciones());
        setValueAt(departamentoModificar.getNombre(), fila, 0);
        setValueAt(departamentoModificar.getNumero(), fila, 1);
        setValueAt(departamentoModificar.getEmpleadosMaximos(), fila, 2);
        setValueAt(departamentoModificar.getVacaciones(), fila, 3);
        actualizarDepartamentoDB(retornarID(departamentoList.get(fila).getNombre()), departamentoList.get(fila));
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }
    
    // DataBasse Methods
   private void crearDepartamentoDB(Departamento departamento, long id_empresa){
        try {
            connection = dbConnect.conectar();
            sql = "INSERT INTO \"departamentos\"(nombre, numero, maximo_empleados, vacaciones, id_empresa)"
                    + "VALUES ( '" + departamento.getNombre() + "', " + departamento.getNumero() + ", " +
                    departamento.getEmpleadosMaximos() + ", " +  departamento.getVacaciones() + ", " + id_empresa + " )";
            ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo subir el departamento");
            System.out.println("Erro al subir Departamento " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
   
    private void actualizarDepartamentoDB(long id, Departamento departamento){
        try {
            sql = " UPDATE\"departamentos\"SET nombre= '" + departamento.getNombre() + "', numero=" + departamento.getNumero()
                + ", maximo_empleados =" + departamento.getEmpleadosMaximos() + ", vacaciones=" + departamento.getVacaciones() +
                " WHERE id=" + id + ";";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se puedo acualizar el Departamento " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
        
    }
    
    private void eliminarDepartamentoDB(Departamento departamento){
        try {
            connection = dbConnect.conectar();
            long id = retornarID(departamento.getNombre());
            eliminarDepartamentoEmpleado(id);
            eliminarDepartamentoRol(id);
            sql = "DELETE FROM \"departamentos\" WHERE id= " + id;
            ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el Departamento");
            System.out.println("Error al eliminar Departamento " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }    
    
    private void eliminarDepartamentoEmpleado(long id){
        try {
            sql = "DELETE FROM \"empleados\"WHERE id_departamento = " + id + ';';
            ps = connection.prepareStatement(sql);     
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error al eliminar el id de departamento en DiaEmpleados " + e.getMessage());
        }
    }
    
    private void eliminarDepartamentoRol(long id){
        try {
            sql = "DELETE FROM \"roles\"WHERE id_departamento = " + id + ';';
            ps = connection.prepareStatement(sql);     
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error al eliminar el id de departamento en DiaRol " + e.getMessage());
        }
    }
    
    private long retornarID (String nombreDepartamento){
        long id = 0;
        try {
            String query = "SELECT id FROM\"departamentos\"WHERE nombre='" + nombreDepartamento + "'";
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
