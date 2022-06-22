package administraciondeempleados;

import java.util.Date;

public class Gerente extends Trabajador{
    
    private Empresa empresa;
    
   //TODO agregar metodos al gerente para hacer la crud de empleados y eso, o dividirlo en una clase y todo

    public Gerente(String correoPersonal, String puesto, Rol rol, Departamento departamento, Horario horario, Empresa empresa) {
        super(correoPersonal, puesto, rol, departamento, horario);
        this.empresa = empresa;
    }
        
    public void modificarNombreEmpresa(String nombre){
        empresa.setNombre(nombre);
    }
    
    public void modificarRubro(String rubro){
        empresa.setRubro(rubro);
    }
    
    public Horario crearHorario(String tipo, Date diasLaborales, Float horasLaborablesSemanales){
        Horario horario = new Horario(tipo, diasLaborales, horasLaborablesSemanales);
        return horario;
    }
    
    public void modificarHorario(Horario horario, String tipo, Date diasLaborales, Float horasLaborablesSemanales){
        horario.setTipo(tipo);
        horario.setDiasLaborables(diasLaborales);
        horario.setHorasLaborablesSemanales(horasLaborablesSemanales);
    }
    
    public void eliminarHorario(Horario horario){
        horario = null;
    }
}
