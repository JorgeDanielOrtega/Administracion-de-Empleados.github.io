package administraciondeempleados;

import java.util.LinkedList;
import java.util.List;

public class Empresa {

    private String nombre;
    private int fundacionYear;
    private String rubro;
    private List<Departamento> departamentoList;
    private List<Rol> rolList;
    private List<Horario> horarioList;

    public Empresa(String empresa, int fundacionYear, String rubro) {
        departamentoList = new LinkedList();
        rolList = new LinkedList();
        horarioList = new LinkedList();
        this.nombre = empresa;
        this.fundacionYear = fundacionYear;
        this.rubro = rubro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String empresa) {
        this.nombre = empresa;
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

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

}
