package administraciondeempleados;

import java.util.Date;

public class Empleado extends Trabajador {

    private Date entradaYear;

    public Empleado(Date entradaYear, String correoPersonal, String puesto, Rol rol, Departamento departamento, Horario horario) {
        super(correoPersonal, puesto, rol, departamento, horario);
        this.entradaYear = entradaYear;
    }

    public Date getEntradaYear() {
        return entradaYear;
    }

}
