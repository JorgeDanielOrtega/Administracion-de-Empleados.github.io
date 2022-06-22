package administraciondeempleados;

<<<<<<< HEAD
import java.util.LinkedList;
import java.util.List;
=======
import java.util.Date;
>>>>>>> af846cae50b562cd12306e8d3f6d4756cfa6d3c4

public class Horario {

    private String tipo;
<<<<<<< HEAD
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

=======
    private Date diasLaborables;
    private Float horasLaborablesSemanales;

>>>>>>> af846cae50b562cd12306e8d3f6d4756cfa6d3c4
}
