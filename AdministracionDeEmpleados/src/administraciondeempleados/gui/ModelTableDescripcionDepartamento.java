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

/**
 *
 * @author SONY VAIO
 */
public class ModelTableDescripcionDepartamento extends DefaultTableModel{

    private List<Departamento> departamentoList;

    public ModelTableDescripcionDepartamento() {
        departamentoList = new LinkedList<>();
        addColumn("Nombre");
        addColumn("Numero");
        addColumn("Numero Maximo Empleados");
        addColumn("Dias de Vacaciones");
        
    }
    
    public void agregarDepartamento(Departamento departamentoAgregar){
        departamentoList.add(departamentoAgregar);
        addRow(new Object[]{
            departamentoAgregar.getNombre(),
            departamentoAgregar.getNumero(),
            departamentoAgregar.getEmpleadosMaximos(),
            departamentoAgregar.getVacaciones()
    });
    }
    public void eliminarDepartamento(int fila){
        if(fila >=0){
            departamentoList.remove(fila);
            removeRow(fila);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccionar fila");
        }
    }
    
    public void editarDepartamento(int fila, Departamento departamentoModificar){
       departamentoList.get(fila).setNombre(departamentoModificar.getNombre());
       departamentoList.get(fila).setNumero(departamentoModificar.getNumero());
       departamentoList.get(fila).setEmpleadosMaximos(departamentoModificar.getEmpleadosMaximos());
       departamentoList.get(fila).setVacaciones(departamentoModificar.getVacaciones());
       setValueAt(departamentoModificar.getNombre(), fila, 0);
       setValueAt(departamentoModificar.getNumero(), fila, 1);
       setValueAt(departamentoModificar.getEmpleadosMaximos(), fila, 2);
       setValueAt(departamentoModificar.getVacaciones(), fila, 3);
    }
    
    
}
