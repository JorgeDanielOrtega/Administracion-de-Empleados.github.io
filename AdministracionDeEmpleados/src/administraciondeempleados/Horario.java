package administraciondeempleados;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class Horario {

    private String tipo;
    private List<DiasLaborales> diasLaborablesList;
    private Float horasLaborablesSemanales;
    
    private List<Empleado> empleadoList;
    
    public Horario(String tipo) {
        diasLaborablesList = new LinkedList();
        this.tipo = tipo;
    }
    
    public Horario(String tipo, List<DiasLaborales> diasLaborables, Float horasLaborablesSemanales){
        this.tipo = tipo;
        this.diasLaborablesList = diasLaborables;
        this.horasLaborablesSemanales = horasLaborablesSemanales;
        this.empleadoList = new LinkedList<>();
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
         
    @Override
    public String toString() {
        return tipo + "\n" + diasLaborablesList + " / " + horasLaborablesSemanales + "Hs";
    }

}
