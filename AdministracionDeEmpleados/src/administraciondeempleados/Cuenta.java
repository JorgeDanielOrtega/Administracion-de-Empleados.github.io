package administraciondeempleados;

public class Cuenta {
    
    private Trabajador trabajador;
    
    private String correoEmpresarial;
    private String contraseña;

    public Cuenta(String correoEmpresarial, String contraseña) {
        this.correoEmpresarial = correoEmpresarial;
        this.contraseña = contraseña;
    }

    public Cuenta(String correoEmpresarial, String contraseña, Trabajador trabajador) {
        this.correoEmpresarial = correoEmpresarial;
        this.contraseña = contraseña;
        this.trabajador = trabajador;
    }

    public String getCorreoEmpresarial() {
        return correoEmpresarial;
    }

    public void setCorreoEmpresarial(String correoEmpresarial) {
        this.correoEmpresarial = correoEmpresarial;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "trabajador=" + trabajador + ", correoEmpresarial=" + correoEmpresarial + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
      
}
