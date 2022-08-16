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

    public void llenarEmpleadoList() {
        trabajadorList.clear();
        for (Departamento departamento : empresa.getDepartamentoList()) {
            trabajadorList.addAll(departamento.getTrabajadorList());
        }
        trabajadoresFilteredList.addAll(trabajadorList);
    }

    public void cargarModelo() {
        limpiarTabla();
        for (Trabajador trabajador : trabajadorList) {
            if (trabajador instanceof Empleado) {
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
    }

    public void cargarEmpleadosFiltrados() {
        limpiarTabla();
        for (Trabajador trabajador : trabajadoresFilteredList) {
            if (trabajador instanceof Empleado) {
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
        trabajadoresFilteredList.clear();
        trabajadoresFilteredList.addAll(trabajadorList);
    }

    private void limpiarTabla() {
        while (getRowCount() > 0) {
            removeRow(0);
        }
    }

    public void filtrarEmpleados(String value, String component) {
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
                trabajadoresFilteredList = trabajadoresFilteredList.stream().filter(trabajador -> {
                    if (trabajador instanceof Empleado) {
                        Empleado e = (Empleado) trabajador;
                        return e.getHorario().getTipo().equals(value);
                    }
                    return false;
                }).collect(Collectors.toList());
            }
            case "Id" -> {
                trabajadoresFilteredList = trabajadoresFilteredList.stream().filter(trabajador -> {
                    if (trabajador instanceof Empleado) {
                        Empleado e = (Empleado) trabajador;
                        return e.getId().equals(value);
                    }
                    return false;
                }).collect(Collectors.toList());
            }
            case "Fullname" -> {
                trabajadoresFilteredList = trabajadoresFilteredList.stream().filter(
                        trabajador -> trabajador.getNombre().toLowerCase().contains(value)
                        || trabajador.getApellido().toLowerCase().contains(value)).collect(Collectors.toList());
            }
        }
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Trabajador> getTrabajadoresFilteredList() {
        return trabajadoresFilteredList;
    }
}
