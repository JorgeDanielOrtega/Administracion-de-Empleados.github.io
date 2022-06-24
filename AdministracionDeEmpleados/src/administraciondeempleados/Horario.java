package administraciondeempleados;


import java.util.LinkedList;
import java.util.List;

public class Horario {

    private String tipo;

    private List<String> diasLaborablesList;
    private Float horasLaborablesSemanales;

    public Horario(String tipo) {
        diasLaborablesList = new LinkedList();
        this.tipo = tipo;
    }

    public List<String> getDiasLaborablesList() {
        return diasLaborablesList;
    }

    public String getTipo() {
        return tipo;
    }

    public Float getHorasLaborablesSemanales() {
        return horasLaborablesSemanales;
    }
    

    @Override
    public String toString() {
        return tipo;
    }




}
