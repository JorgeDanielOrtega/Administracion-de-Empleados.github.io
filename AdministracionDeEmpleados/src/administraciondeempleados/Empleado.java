package administraciondeempleados;

import java.util.Date;

public class Empleado extends Trabajador {

    private Date entradaYear;
    private Horario horario;
    private String id;

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
    
    
}
