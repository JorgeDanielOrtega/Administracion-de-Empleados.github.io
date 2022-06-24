package administraciondeempleados;

import java.util.Date;
import java.util.List;

public class Gerente extends Trabajador{
    
    private Empresa empresa;

    public Gerente(Empresa empresa, String correoPersonal, String usuario, String password, Puesto puesto, Rol rol, Departamento departamento, Contrato contrato, String nombre, String apellido, String direccion, String cedula, char sexo, String ciudad, String telefono, Date fechaNacimiento) {
        super(correoPersonal, usuario, password, puesto, rol, departamento, contrato, nombre, apellido, direccion, cedula, sexo, ciudad, telefono, fechaNacimiento);
        this.empresa = empresa;
    }
    
    //CRUD EMPRESA, crear empresa se controla desde la interfaz
            
    public Empresa crearEmpresa(String nombre, int fundacionYear, String rubro, String leyenda){
        Empresa empresa = new Empresa(nombre, fundacionYear, rubro);
        empresa.setLeyenda(leyenda);
        this.empresa = empresa;
        return empresa;
    }
    
    public void modificarNombreEmpresa(String nombre){
        this.empresa.setNombre(nombre);
    }
    
    public void modificarRubro(String rubro){
        this.empresa.setRubro(rubro);
    }
    
    public void modificarLeyenda(String leyenda){
        this.empresa.setLeyenda(leyenda);
    }

    public void modificarAñoFundacion(int añoFundacion){
        this.empresa.setFundacionYear(añoFundacion);
    }
    
    //CRUD HORARIO
    
    public Horario crearHorario(String tipo, List<DiasLaborales> diasLaborales, Float horasLaborablesSemanales){
        Horario horario = new Horario(tipo, diasLaborales, horasLaborablesSemanales);
        empresa.getHorarioList().add(horario);
        return horario;
    }
    
    public void modificarTipoHorario(Horario horario, String tipo){
        empresa.getHorarioList().get(empresa.getHorarioList().indexOf(horario)).setTipo(tipo);
    }
    
    public void modificarDiasLaboralesHorario(Horario horario, List<DiasLaborales> diasLaborales){
        empresa.getHorarioList().get(empresa.getHorarioList().indexOf(horario)).setDiasLaborablesList(diasLaborales);
    }
    
    public void agregarDiaLaborables(Horario horario, DiasLaborales dia){
        empresa.getHorarioList().get(empresa.getHorarioList().indexOf(horario)).agregarDia(dia);
    }
    
    public void eliminarDiaLaborables(Horario horario, DiasLaborales dia){
        empresa.getHorarioList().get(empresa.getHorarioList().indexOf(horario)).eliminarDia(dia);
    }
    
    public void modificarHorasLaboralesHorario(Horario horario, Float horasLaborablesSemanales){
        empresa.getHorarioList().get(empresa.getHorarioList().indexOf(horario)).setHorasLaborablesSemanales(horasLaborablesSemanales);
    }
    
    public void eliminarHorario(Horario horario){
        this.empresa.getHorarioList().remove(horario);
    }
    
    //Getters and Setters

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
      
    @Override
    public String toString() {
        return "Gerente{" + "empresa=" + empresa + '}';
    }

}
