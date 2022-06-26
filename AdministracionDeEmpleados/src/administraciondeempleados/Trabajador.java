package administraciondeempleados;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.xml.validation.Validator;


public abstract class Trabajador extends Persona{


    private String correoPersonal;
    private String correoEmpresarial;
    private int vacaciones;
    private String usuario;
    private String password;
    private double horasExtra;
    private boolean pagoPorTrasferencia;

    private Departamento departamento;
    
    private Puesto puesto;
    private Rol rol;
    private Contrato contrato;
    private Decimo decimo;
    private List<Asistencia> asistencia;

    public Trabajador(String nombre, String apellido, String direccion, EstadoCivil estadoCivil, String numeroCedula,
            char sexo, String ciudad, String telefono, Date fechaNacimiento){
        super(nombre, apellido, direccion, estadoCivil, numeroCedula, sexo, ciudad, telefono, fechaNacimiento);
    }
    
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

    
    public Trabajador(String nombre, String apellido, String direccion, EstadoCivil estadoCivil, String numeroCedula,
            char sexo, String ciudad, String telefono, Date fechaNacimiento, String correoPersonal,
            String correoEmpresarial, String usuario, String contrasenia, boolean pagoPorTransferencia,
            Rol rol, Contrato contrato) {
        this(nombre, apellido, direccion, estadoCivil, numeroCedula, sexo, ciudad, telefono, fechaNacimiento);
        this.correoPersonal = correoPersonal;
        this.correoEmpresarial = correoEmpresarial;
        this.usuario = usuario;
        this.password = contrasenia;
        this.pagoPorTrasferencia = pagoPorTransferencia;
        this.rol = rol;
        this.contrato = contrato;
    }
    public Trabajador(String nombre, String apellido, String direccion, EstadoCivil estadoCivil, String numeroCedula,
            char sexo, String ciudad, String telefono, Date fechaNacimiento,
            String correoPersonal, String correoEmpresarial, int vacaciones, String usuario, String contrasenia,
            double horasExtra, boolean pagoPorTransferencia, Rol rol, Contrato contrato, Decimo decimo) {
        this(nombre, apellido, direccion, estadoCivil, numeroCedula, sexo, ciudad, telefono, fechaNacimiento,
        correoPersonal, correoEmpresarial, usuario, contrasenia, pagoPorTransferencia, rol, contrato);
        this.vacaciones = vacaciones;
        this.horasExtra = horasExtra; //AQUI PERMITIR QUE INGRESE MODIFICAR
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

    public double getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(double horasExtra) {
        this.horasExtra = horasExtra;
    }

    public boolean isPagoPorTrasferencia() {
        return pagoPorTrasferencia;
    }

    public void setPagoPorTrasferencia(boolean pagoPorTrasferencia) {
        this.pagoPorTrasferencia = pagoPorTrasferencia;
    }

    public Decimo getDecimo() {
        return decimo;
    }

    public void setDecimo(Decimo decimo) {
        this.decimo = decimo;
    }

    public List<Asistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<Asistencia> asistencia) {
        this.asistencia = asistencia;
    }
    
    @Override
    public String toString() {
        return "Trabajador{" + "correoPersonal=" + correoPersonal + ", correoEmpresarial=" + correoEmpresarial + ", usuario=" + usuario + ", password=" + password + ", puesto=" + puesto + ", rol=" + rol + ", departamento=" + departamento + ", contrato=" + contrato + '}';
    }
    
    

}
