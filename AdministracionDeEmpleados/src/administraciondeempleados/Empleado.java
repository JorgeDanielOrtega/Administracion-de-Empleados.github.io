package administraciondeempleados;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Empleado extends Trabajador {

    private Date entradaYear;    
    private Horario horario;
    private String id;
    private List<Asistencia> asistenciaList;

    public Empleado(){
        this.asistenciaList = new LinkedList<>();
    }

    public Empleado(Date entradaYear, Horario horario, String correoPersonal, String usuario, String password, Puesto puesto, Rol rol, Departamento departamento, Contrato contrato, String nombre, String apellido, String direccion, String cedula, char sexo, String ciudad, String telefono, Date fechaNacimiento){
        super(correoPersonal, usuario, password, puesto, rol, departamento, contrato, nombre, apellido, direccion, cedula, sexo, ciudad, telefono, fechaNacimiento);
        this.entradaYear = entradaYear;
        this.horario = horario;
        this.asistenciaList = new LinkedList<>();
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Asistencia> getAsistenciaList() {
        return asistenciaList;
    }

    public void setAsistenciaList(List<Asistencia> asistenciaList) {
        this.asistenciaList = asistenciaList;
    }

    public Date getEntradaYear() {
        return entradaYear;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    
}
