package administraciondeempleados;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Empleado extends Trabajador {

    private Date entradaYear;
    private Horario horario;
    private String id;
    private List<Asistencia> asistenciaList;

    public Empleado() {
        this.asistenciaList = new LinkedList();
    }

    public Empleado(String id) {
        this.id = id;
    }
    

    public Date getEntradaYear() {
        return entradaYear;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Asistencia> getAsistenciaList() {
        return asistenciaList;
    }
    
    
    
    
}
