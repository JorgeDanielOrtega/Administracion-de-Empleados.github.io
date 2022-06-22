/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administraciondeempleados.gui;

import administraciondeempleados.Departamento;
import administraciondeempleados.Empleado;
import administraciondeempleados.Trabajador;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario iTC
 */
public class ModelTableDepartamento extends DefaultTableModel {

    private List<Empleado> empleadoList;
    private Departamento departamento;

    public ModelTableDepartamento() {
        empleadoList = new LinkedList();
        addColumn("Nombres y Apellidos");
        addColumn("Rol");
        addColumn("Puesto");
    }

    private void llenarEmpleadoList() {
        empleadoList.clear();
        departamento.getTrabajadorList().forEach(trabajador -> {
            empleadoList.add((Empleado) trabajador);
        });
    }

    private void limpiarTabla() {
        while (getRowCount() > 0) {
            removeRow(0);
        }
    }

    public void cargar() { //metodo de prueba
        limpiarTabla();
        llenarEmpleadoList();
        for (Empleado e : empleadoList) {
            addRow(new String[]{
                e.getNombre() + " " + e.getApellido(),
                e.getRol().getNombre(),
                e.getPuesto().getNombre()
            });
        }
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
