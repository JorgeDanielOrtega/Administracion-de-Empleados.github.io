package administraciondeempleados;

public abstract class Trabajador extends Persona {

    private String correoPersonal;
    private String correoEmpresarial;
    private String usuario;
    private String password;
    private Puesto puesto;
    private Rol rol;
    private Departamento departamento;
    private Contrato contrato;

    
    public Contrato getContrato() {
        return contrato;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public String getCorreoEmpresarial() {
        return correoEmpresarial;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public Rol getRol() {
        return rol;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public void setCorreoEmpresarial(String correoEmpresarial) {
        this.correoEmpresarial = correoEmpresarial;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    
    
    

}
