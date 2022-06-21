package administraciondeempleados.gui;

import administraciondeempleados.Departamento;
import administraciondeempleados.Empleado;
import administraciondeempleados.Empresa;
import administraciondeempleados.Trabajador;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

public class ModelTableBusqueda extends DefaultTableModel {

    private Empresa empresa;
    private List<Trabajador> trabajadorList;
    private List<Object> componentActiveList;
    List<Trabajador> trabajadoresFilteredList;

    public ModelTableBusqueda() {
        trabajadorList = new LinkedList();
        trabajadoresFilteredList = new LinkedList();
        addColumn("Id");
        addColumn("Nombres y Apellidos");
        addColumn("Departamento");
        addColumn("Rol");
        addColumn("Horario");
        
    }
    
    //limpiar en el btn limpiar busqueda el o en cualquier btn la lista de trabajadores filtrados

    public void llenarEmpleadoList() { //quizas problemas a la hora de conectar todo
        trabajadorList.clear();
        for (Departamento departamento : empresa.getDepartamentoList()) {
            trabajadorList.addAll(departamento.getTrabajadorList()); //quizas
        }
    }

    public void cargarModelo() {
        //trabajadoresFilteredList.addAll(trabajadorList); //quizas
        limpiarTabla();
        for (Trabajador trabajador : trabajadorList) {
            Empleado empleado = (Empleado) trabajador;
            addRow(new String[]{
                empleado.getId(),
                empleado.getNombre() + " " + empleado.getApellido(),
                empleado.getDepartamento().getNombre(),
                empleado.getRol().getNombre(),
                empleado.getHorario().getTipo()
            });
        }
    }

    public void limpiarTabla() {
        while (getRowCount() > 0) {
            removeRow(0);
        }
    }

    public void cargarEmpleadosFiltrados() {
        limpiarTabla();
        for (Trabajador trabajador : trabajadoresFilteredList) {
            Empleado empleado = (Empleado) trabajador;
            addRow(new String[]{
                empleado.getId(),
                empleado.getNombre() + " " + empleado.getApellido(),
                empleado.getDepartamento().getNombre(),
                empleado.getRol().getNombre(),
                empleado.getHorario().getTipo()
            });
        }
        trabajadoresFilteredList.clear();
        //trabajadoresFilteredList.addAll(trabajadorList);
    }

    public void filtrarEmpleados(String value, String component) {                
        trabajadoresFilteredList.addAll(trabajadorList);
        switch (component) {
            case "Departamento" -> {
                trabajadoresFilteredList = trabajadoresFilteredList.stream().
                        filter(trabajador -> trabajador.getDepartamento().getNombre().equals(value)).
                        collect(Collectors.toList());
            }
            case "Rol" -> {
                trabajadoresFilteredList = trabajadoresFilteredList.stream().
                        filter(trabajador -> trabajador.getRol().getNombre().equals(value)).
                        collect(Collectors.toList());
            }
            case "Horario" -> {
                trabajadoresFilteredList = trabajadoresFilteredList.stream().
                        filter(trabajador -> {
                            Empleado e = (Empleado) trabajador;
                            return e.getHorario().getTipo().equals(value);
                        }).collect(Collectors.toList());
            }
            case "Id" -> {
                trabajadoresFilteredList = trabajadoresFilteredList.stream().
                        filter(trabajador -> {
                            Empleado e = (Empleado) trabajador;
                            return e.getId().equals(value);
                        }).collect(Collectors.toList());
            }
            case "Fullname" -> {
                trabajadoresFilteredList = trabajadoresFilteredList.stream().
                        filter(trabajador
                                -> trabajador.getNombre().contains(value) || trabajador.getApellido().contains(value)
                        ).collect(Collectors.toList());
            }
        }
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        trabajadorList.forEach(action -> {

        });
    }

    public void setComponentActiveList(List<Object> componentActiveList) {
        this.componentActiveList = componentActiveList;
    }

    public List<Trabajador> getTrabajadoresFilteredList() {
        return trabajadoresFilteredList;
    }

}
