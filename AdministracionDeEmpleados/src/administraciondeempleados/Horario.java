package administraciondeempleados;

import java.util.Date;

public class Horario {

    private String tipo;
    private Date diasLaborables;
    private Float horasLaborablesSemanales;

    public Horario(String tipo, Date diasLaborables, Float horasLaborablesSemanales) {
        this.tipo = tipo;
        this.diasLaborables = diasLaborables;
        this.horasLaborablesSemanales = horasLaborablesSemanales;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDiasLaborables() {
        return diasLaborables;
    }

    public void setDiasLaborables(Date diasLaborables) {
        this.diasLaborables = diasLaborables;
    }

    public Float getHorasLaborablesSemanales() {
        return horasLaborablesSemanales;
    }

    public void setHorasLaborablesSemanales(Float horasLaborablesSemanales) {
        this.horasLaborablesSemanales = horasLaborablesSemanales;
    }
    
    

}
