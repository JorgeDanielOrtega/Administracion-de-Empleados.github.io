package administraciondeempleados;

import java.util.LinkedList;
import java.util.List;

public class Empresa {
    private String nombre = "";
    private int fundacionYear = 0;
    private String rubro = "";
    private String leyenda = "";
    private List<Departamento> departamentoList;
    private List<Horario> horarioList;

    public Empresa(String nombre, int fundacionYear, String rubro) {
        this.nombre = nombre;
        this.fundacionYear = fundacionYear;
        this.rubro = rubro;
        this.horarioList = new LinkedList<>();
        this.departamentoList = new LinkedList<>();
    }
    
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getFundacionYear() {
        return fundacionYear;
    }


    public String getRubro() {
        return rubro;
    }
    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", fundacionYear=" + fundacionYear + ", rubro=" + rubro + ", leyenda=" + leyenda + '}';
    }
    
    
    
    
    
}
