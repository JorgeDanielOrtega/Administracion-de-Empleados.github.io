package administraciondeempleados;

import java.util.LinkedList;
import java.util.List;


public class Horario {

    private String tipo;
    private Float horasLaborablesSemanales;
    
    private List<DiasLaborales> diasLaborablesList;
    private List<Empleado> empleadoList;
    
    public Horario() {
        empleadoList = new LinkedList();
        diasLaborablesList = new LinkedList();

    }
    
    public Horario(String tipo) {
        this();
        this.tipo = tipo;
    }
    public Horario(String tipo, Float horasLaborablesSemanales){
        this(tipo);
        this.horasLaborablesSemanales = horasLaborablesSemanales;
    }
    
    public Horario(String tipo, List<DiasLaborales> diasLaborables, Float horasLaborablesSemanales){
        this(tipo, horasLaborablesSemanales);
        this.diasLaborablesList = diasLaborables;
    }
    
    //metodos de actualizacion de dias
    public void agregarDia(DiasLaborales dia){
        this.diasLaborablesList.add(dia);
    }
        
    public void eliminarDia(DiasLaborales dia){
        this.diasLaborablesList.remove(dia);
    }

    
    //getters and setters
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public List<DiasLaborales> getDiasLaborablesList() {
        return diasLaborablesList;
    }

    public void setDiasLaborablesList(List<DiasLaborales> diasLaborablesList) {
        this.diasLaborablesList = diasLaborablesList;
    }

    public Float getHorasLaborablesSemanales() {
        return horasLaborablesSemanales;
    }

    public void setHorasLaborablesSemanales(Float horasLaborablesSemanales) {
        this.horasLaborablesSemanales = horasLaborablesSemanales;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }
         
    @Override
    public String toString() {
        return tipo;
    }

}
