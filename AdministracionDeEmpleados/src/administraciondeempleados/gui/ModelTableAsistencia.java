package administraciondeempleados.gui;

import administraciondeempleados.Asistencia;
import administraciondeempleados.Empleado;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ModelTableAsistencia extends DefaultTableModel {

    private List<Asistencia> asistenciaList;
    private Empleado empleado;

    public ModelTableAsistencia() {
        asistenciaList = new LinkedList();
        addColumn("Fecha");
        addColumn("Hora");
        addColumn("Dia");
        addColumn("Estado");
    }

    public void llenarEmpleadoList() {
        asistenciaList.clear();
        asistenciaList.addAll(empleado.getAsistenciaList()); //nose si se copiaran directamente los objetos o se crean nuevos
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    private void limpiarTabla() {
        while (getRowCount() > 0) {
            removeRow(0);
        }
    }
    
    public void cargarModelo(){
        limpiarTabla();
        asistenciaList.forEach(asistencia->{
            addRow(new String[]{
                asistencia.getFechaFormated(),
                asistencia.getHoraFormated(),
                asistencia.getDiaSemana(),
                asistencia.getEstado().toString()
            });
        });
    }
}
