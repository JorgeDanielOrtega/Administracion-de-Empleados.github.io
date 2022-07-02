package administraciondeempleados;

import java.util.Date;
import administraciondeempleados.gui.ModelTableDescripcionDepartamento;
import administraciondeempleados.gui.ModelTableDescripcionRol;
import administraciondeempleados.gui.ModelTableDescripcionDepartamento;
import administraciondeempleados.view.ModelTableHorarios;

public class AdministracionDeEmpleados {

    public static void main(String[] args) {
        Empleado empleado =new Empleado("Jhair", "Agila", "10 de agosto", EstadoCivil.SOLTERO, "101111",
       'm', "Loja", "098756711", new Date(1,1,1),"jhairagil@gmail.com", "jhair.agil@unl.edu.ec", "Jhair", "10111", true,
        new Rol(), new Contrato(Boolean.TRUE), new Date(2022-1900, 2, 4), new Departamento("Tech", 1, 10),
        new Horario("matutuino", 24f));
        ModelTableDescripcionDepartamento d1 = new ModelTableDescripcionDepartamento();
        ModelTableDescripcionRol r1 = new ModelTableDescripcionRol();
        ModelTableDescripcionDepartamento m1 = new ModelTableDescripcionDepartamento();
        ModelTableHorarios h1 = new ModelTableHorarios();
    }
}