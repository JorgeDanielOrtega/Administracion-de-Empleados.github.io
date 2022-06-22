package administraciondeempleados;

<<<<<<< HEAD
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Empresa {

    private String nombre;
    private int fundacionYear;
    private String rubro;
    private List<Departamento> departamentoList;
    private List<Rol> rolList;
    private List<Horario> horarioList;
    private Calendar horaEntrada;

    public Empresa(String empresa, int fundacionYear, String rubro) {
        departamentoList = new LinkedList();
        rolList = new LinkedList();
        horarioList = new LinkedList();
        this.nombre = empresa;
        this.fundacionYear = fundacionYear;
        this.rubro = rubro;
        this.horaEntrada = Calendar.getInstance();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String empresa) {
        this.nombre = empresa;
=======
import java.util.List;

public class Empresa {
    private String empresa;
    private int fundacionYear;
    private String rubro;
    private List<Departamento> departamentoList;

    public Empresa(String empresa, int fundacionYear, String rubro) {
        this.empresa = empresa;
        this.fundacionYear = fundacionYear;
        this.rubro = rubro;
    }
    
    
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
>>>>>>> af846cae50b562cd12306e8d3f6d4756cfa6d3c4
    }

    public int getFundacionYear() {
        return fundacionYear;
    }

<<<<<<< HEAD
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

    public Calendar getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int hora, int minuto) {
        horaEntrada.set(Calendar.HOUR_OF_DAY, hora);
        horaEntrada.set(Calendar.MINUTE, minuto);
    }
    

=======

    public String getRubro() {
        return rubro;
    }
    public void setRubro(String rubro) {
        this.rubro = rubro;
    }
>>>>>>> af846cae50b562cd12306e8d3f6d4756cfa6d3c4
}
