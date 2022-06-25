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

/**
 *
 * @author SONY VAIO
 */
public class ModelTableDescripcionRol extends DefaultTableModel{

    private List<Rol> rolList;
    
    public ModelTableDescripcionRol() {
        rolList = new LinkedList<>();
        addColumn("Nombre");
        addColumn("Salario");
        addColumn("Puesto");
    }
    
    public void agregarRol(Rol rol){
        rolList.add(rol);
        addRow(new Object[]{
            rol.getNombre(),
            rol.getSalario(),
            rol.getPuesto().getNombre()
        });
    }
    
    public Rol leerRool(int fila){
        return rolList.get(fila);
    }
    
    public void eliminarRol(int fila){
        if(fila >= 0){
            rolList.remove(fila);
            removeRow(fila);
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
    }
}
