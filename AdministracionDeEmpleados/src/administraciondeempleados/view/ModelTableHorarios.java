package administraciondeempleados.view;
import javax.swing.table.DefaultTableModel;
import administraciondeempleados.Gerente;
import java.util.List;
import administraciondeempleados.Horario;
import administraciondeempleados.DiasLaborales;
import administraciondeempleados.Empresa;

public class ModelTableHorarios extends DefaultTableModel{

    private Gerente gerente;
    private Horario horario;
    
    public ModelTableHorarios() {
        addColumn("Tipo");
        addColumn("Dias laborables");
        addColumn("Horas Semanales");
    }
    public void limpiarTabla(){
        while (getRowCount() > 0) {            
            removeRow(0);
        }
    }
    public void  cargarModelo(Empresa empresa){
        limpiarTabla();
        for (Horario horario : empresa.getHorarioList()) {
            addRow(new Object[]{
            horario.getTipo(), 
            horario.getDiasLaborablesList().toString(), 
            String.valueOf(horario.getHorasLaborablesSemanales())
        });
        }
    }
    
    public void agregarHorario(String tipo, List<DiasLaborales> diasLaborablesList, Float horasSemanales){
        horario = gerente.crearHorario(tipo, diasLaborablesList, horasSemanales);
        addRow(new Object[]{
            horario.getTipo(), 
            horario.getDiasLaborablesList().toString(), 
            String.valueOf(horario.getHorasLaborablesSemanales())
        });
    }
    
    public void eliminarHorario(Horario horario, int indice){
        gerente.eliminarHorario(horario);
        removeRow(indice);
    }
    
}
