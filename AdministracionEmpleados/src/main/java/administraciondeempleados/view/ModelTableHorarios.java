package administraciondeempleados.view;

import javax.swing.table.DefaultTableModel;
import administraciondeempleados.Gerente;
import java.util.List;
import administraciondeempleados.Horario;
import administraciondeempleados.Empresa;

public class ModelTableHorarios extends DefaultTableModel {

    private Gerente gerente;

    public ModelTableHorarios() {
        addColumn("Tipo");
        addColumn("Dias laborables");
        addColumn("Horas Semanales");
    }

    public void cargarModeloEmpleado(List<Horario> horarioList) {
        limpiarTabla();
        for (Horario horario : horarioList) {
            addRow(new Object[]{
                horario.getTipo(),
                horario.getDiasLaborablesList().toString(),
                String.valueOf(horario.getHorasLaborablesSemanales())
            });
        }
    }

    public void cargarModelo(Empresa empresa) {
        limpiarTabla();
        for (Horario horario : empresa.getHorarioList()) {
            addRow(new Object[]{
                horario.getTipo(),
                horario.getDiasLaborablesList().toString(),
                String.valueOf(horario.getHorasLaborablesSemanales())
            });
        }
    }

    public void limpiarTabla() {
        while (getRowCount() > 0) {
            removeRow(0);
        }
    }

    public void eliminarHorario(Horario horario, int indice) {
        gerente.eliminarHorario(horario);
        removeRow(indice);
    }

    public Horario seleccionarHorario(Horario horario) {
        return horario;
    }
}
