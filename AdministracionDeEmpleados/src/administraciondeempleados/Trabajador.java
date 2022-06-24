package administraciondeempleados;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.xml.validation.Validator;


public abstract class Trabajador extends Persona{


    private String correoPersonal;
    private String correoEmpresarial;
    private String usuario;
    private String password;
    private Puesto puesto;
    private Rol rol;
    private Departamento departamento;
    private Contrato contrato;
    private List<Asistencia> asistencia;
    private int vacaciones;

    public Trabajador(String correoPersonal, String usuario, String password, Puesto puesto, Rol rol, Departamento departamento, Contrato contrato, String nombre, String apellido, String direccion, String cedula, char sexo, String ciudad, String telefono, Date fechaNacimiento) {
        super(nombre, apellido, direccion, cedula, sexo, ciudad, telefono, fechaNacimiento);
        this.correoPersonal = correoPersonal;
        generarCorreoEmpresarial(nombre, apellido);
        this.usuario = correoEmpresarial;
        this.password = password;
        this.puesto = puesto;
        this.rol = rol;
        this.departamento = departamento;
        this.contrato = contrato;
        this.vacaciones = departamento.getVacaciones();
        this.asistencia = new LinkedList<>();
    }
    
    public void pedirVacaciones(int numeroVacaciones){
        if(numeroVacaciones <= vacaciones){
            vacaciones -= numeroVacaciones;
            //futuro JOption o mensaje en interfaz
            System.out.println("Está de vacaciones; vacaciones restantes: " + vacaciones);
        }else{
            //futuro JOption o mensaje en interfaz
            System.out.println("Dias insuficientes, solo puede pedir " + vacaciones + " dias");
        }
    }
    
    private void generarCorreoEmpresarial(String nombre, String apellido){
        this.correoEmpresarial = nombre.replaceAll("\\s+", "") + "." + apellido.replaceAll("\\s+", "") + "@superEmpresa.comXD";
    }
    
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

    public int getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(int vacaciones) {
        this.vacaciones = vacaciones;
    }
    
    @Override
    public String toString() {
        return "Trabajador{" + "correoPersonal=" + correoPersonal + ", correoEmpresarial=" + correoEmpresarial + ", usuario=" + usuario + ", password=" + password + ", puesto=" + puesto + ", rol=" + rol + ", departamento=" + departamento + ", contrato=" + contrato + '}';
    }
    
    

}
