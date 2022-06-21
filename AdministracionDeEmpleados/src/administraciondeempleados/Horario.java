package administraciondeempleados;

import java.util.Date;

public class Horario {

    private String tipo;
    private Date diasLaborables;
    private Float horasLaborablesSemanales;

    public Horario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
    
    

}
