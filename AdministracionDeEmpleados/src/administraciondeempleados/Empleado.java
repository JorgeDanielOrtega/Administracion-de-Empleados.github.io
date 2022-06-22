package administraciondeempleados;

import java.util.Date;
<<<<<<< HEAD
import java.util.LinkedList;
import java.util.List;
=======
>>>>>>> af846cae50b562cd12306e8d3f6d4756cfa6d3c4

public class Empleado extends Trabajador {

    private Date entradaYear;
<<<<<<< HEAD
    private Horario horario;
    private String id;
    private List<Asistencia> asistenciaList;

    public Empleado() {
        this.asistenciaList = new LinkedList();
    }

    public Empleado(String id) {
        this.id = id;
    }
    
=======
>>>>>>> af846cae50b562cd12306e8d3f6d4756cfa6d3c4

    public Date getEntradaYear() {
        return entradaYear;
    }

<<<<<<< HEAD
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
    
    
    
    
=======
>>>>>>> af846cae50b562cd12306e8d3f6d4756cfa6d3c4
}
