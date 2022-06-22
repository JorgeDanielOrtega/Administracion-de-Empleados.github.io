package administraciondeempleados;

public abstract class Trabajador extends Persona{

    private String correoPersonal;
    private String correoEmpresarial;
    private Cuenta cuenta;
    private String puesto;
    private Rol rol;
    private Departamento departamento;
    private Horario horario;

    public Trabajador(String correoPersonal, String puesto, Rol rol, Departamento departamento, Horario horario) {
        this.correoPersonal = correoPersonal;
        this.puesto = puesto;
        this.rol = rol;
        this.departamento = departamento;
        this.horario = horario;
    }
    
    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getCorreoEmpresarial() {
        return correoEmpresarial;
    }

    public void setCorreoEmpresarial(String correoEmpresarial) {
        this.correoEmpresarial = correoEmpresarial;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    
    
    
    

}
