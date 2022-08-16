package administraciondeempleados;

public class Cuenta {
    
    private Rol rol;  
    private String correoEmpresarial;
    private String contraseña;

    public Cuenta(String correoEmpresarial, String contraseña) {
        this.correoEmpresarial = correoEmpresarial;
        this.contraseña = contraseña;
    }

    public Cuenta(String correoEmpresarial, String contraseña, Rol rol) {
        this.correoEmpresarial = correoEmpresarial;
        this.contraseña = contraseña;
        this.rol = rol;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @Override
    public String toString() {
        return "Cuenta{" + "Rol=" + rol + ", correoEmpresarial=" + correoEmpresarial + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
      
}
