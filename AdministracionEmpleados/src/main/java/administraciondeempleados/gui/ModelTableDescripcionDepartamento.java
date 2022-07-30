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
    private int validacionCarga;
    
    public ModelTableDescripcionDepartamento() {

        departamentoList = new LinkedList();
        dbConnect = new DBConnect();
        addColumn("Nombre");
        addColumn("Numero");
        addColumn("Numero Maximo Empleados");
        addColumn("Dias de Vacaciones");
    }

    public void cargarModelo() {
            try{
                connection = dbConnect.conectar();
                for (Departamento departamento : departamentoList) {
                    addRow(new Object[]{
                    departamento.getNombre(),
                    departamento.getNumero(),
                    departamento.getEmpleadosMaximos(),
                    departamento.getVacaciones()
                });
                this.validacionCarga = 1;
                }
            }catch(Exception e){
                System.out.println("Hubo un error al cargar Departamentos" + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al carfar Departamentos");
            }finally{
                dbConnect.desconectar();
            }                
    }
    
    public Departamento leerDepartamento(int fila){
        return departamentoList.get(fila);
    }
    
    public void agregarDepartamento(Departamento departamentoAgregar, String nombreEmpresa) {
        long idEmpresa = retornarID("empresa", "nombre", nombreEmpresa);
        crearDepartamentoDB(departamentoAgregar, idEmpresa); //MODIFICAR EL ID DE EMPLERA PARA HACER ESCALABLE
        departamentoList.add(departamentoAgregar);
        addRow(new Object[]{
            departamentoAgregar.getNombre(),
            departamentoAgregar.getNumero(),
            departamentoAgregar.getEmpleadosMaximos(),
            departamentoAgregar.getVacaciones()
        });
    }

    public void eliminarDepartamento(int fila) {
        Departamento departamento = departamentoList.get(fila);
        if (fila >= 0) {
            departamentoList.remove(fila);
            removeRow(fila);
            long idDepartemento = retornarID("departamentos", "nombre", departamento.getNombre());
            eliminarConexionLlaveForanea("roles", "id_departamento", idDepartemento);
            eliminarConexionLlaveForanea("trabajador", "id_departamento", idDepartemento);
            eliminarDepartamentoDB(idDepartemento);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar fila");
        }
    }

        private long retornarID (String nombreTabla, String columnaTabla, String campoComparar){
        long id = 0;
        try {
            connection = dbConnect.conectar();
            String query = "SELECT id FROM\""+ nombreTabla   +"\"WHERE " + columnaTabla +"='" + campoComparar + "'";
            ps = connection.prepareStatement(query);
            result = ps.executeQuery();
            while(result.next()){
                id = result.getLong("id");
            }
            JOptionPane.showConfirmDialog(null, "El id de empresa es " + id);
            System.out.println(id);
            return id;
        } catch (Exception e) {
            System.out.println("No se pudo encontrar el id" + e.getMessage());
            JOptionPane.showMessageDialog( null, "No se pudo encontar ID");
        }
        return 0;
    }
    
    private void eliminarConexionLlaveForanea(String nombreTabla, String nombreColumna, long idComprobacion){
        try{
            connection = dbConnect.conectar();
            sql = "UPDATE \"" + nombreTabla  + "\" SET " + nombreColumna +" = null WHERE "+ nombreColumna + "= " + idComprobacion;
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("No se pudo eliminar la llave foranea en " + nombreTabla + e.getMessage());
            JOptionPane.showMessageDialog( null, "No se pudo eliminar la llave fonarea en " + nombreTabla);
        }finally{
            dbConnect.desconectar();
        }
    }
    public void editarDepartamento(int fila, Departamento departamentoModificar, String nombreEmpresa) {
        departamentoList.get(fila).setNombre(departamentoModificar.getNombre());
        departamentoList.get(fila).setNumero(departamentoModificar.getNumero());
        departamentoList.get(fila).setEmpleadosMaximos(departamentoModificar.getEmpleadosMaximos());
        departamentoList.get(fila).setVacaciones(departamentoModificar.getVacaciones());
        setValueAt(departamentoModificar.getNombre(), fila, 0);
        setValueAt(departamentoModificar.getNumero(), fila, 1);
        setValueAt(departamentoModificar.getEmpleadosMaximos(), fila, 2);
        setValueAt(departamentoModificar.getVacaciones(), fila, 3);
        long idDepartemento = retornarID("departamentos", "nombre", departamentoList.get(fila).getNombre());
        actualizarDepartamentoDB(departamentoList.get(fila),idDepartemento);
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }
    
    // DataBasse Methods
   private void crearDepartamentoDB(Departamento departamento, long id_empresa){
        try {
            connection = dbConnect.conectar();
            sql = "INSERT INTO \"departamentos\"( nombre, numero, maximo_empleados, vacaciones, id_empresa)"
                    + " VALUES ( '" + departamento.getNombre() + "', " + departamento.getNumero() + ", " +
                    departamento.getEmpleadosMaximos() + ", " +  departamento.getVacaciones() + ", " + id_empresa + " )";
            ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo subir el departamento");
            System.out.println("Error al subir Departamento " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }
   
    private void actualizarDepartamentoDB(Departamento departamento, long idDepartamento ){
        try {
            sql = " UPDATE \"departamentos\" SET nombre= '" + departamento.getNombre() + "', numero= " + departamento.getNumero()
                + ", maximo_empleados= " + departamento.getEmpleadosMaximos() + ", vacaciones= " + departamento.getVacaciones() +
                " WHERE id=" + idDepartamento + ";";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se puedo acualizar el Departamento " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
        
    }
    
    private void eliminarDepartamentoDB(long idDepartamento){
        try {
            connection = dbConnect.conectar();
            sql = "DELETE FROM \"departamentos\" WHERE id= " + idDepartamento + ";";
            ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el Departamento");
            System.out.println("Error al eliminar Departamento " + e.getMessage());
        }finally{
            dbConnect.desconectar();
        }
    }   
    
}
