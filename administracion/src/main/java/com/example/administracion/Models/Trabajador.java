package com.example.administracion.Models;

// import java.util.Date;
// import java.util.LinkedList;
// import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// import javax.xml.validation.Validator;

//public abstract class Trabajador extends Persona{
@Entity
@Table(name = "Trabajador")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "correo_personal")
    private String correoPersonal;
    @Column(name = "correo_empresarial")
    private String correoe;
    @Column(name = "vacaciones")
    private Integer vacaciones;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contrasenia")
    private String password;
    @Column(name = "pago_por_transferencia")
    private Integer formaPago;// quizas cambiar a integer o short
    @Column(name = "id_departamento")
    private Long idDepartamento;
    @Column(name = "id_persona")
    private Long idPersona;
    @Column(name = "id_rol")
    private Long idRol;
    @Column(name = "id_horario")
    private Long idHorario;

    @Column(name = "id_contrato")
    private Long idContrato;

    // private Decimo decimo;
    // private List<Asistencia> asistencia;


    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public String getCorreoe() {
        return correoe;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(int vacaciones) {
        this.vacaciones = vacaciones;
    }

    public Integer isPagoPorTrasferencia() {
        return formaPago;
    }

    public void setFormaPago(Integer formaPago) {
        this.formaPago = formaPago;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public Long getIdContrato(){return idContrato;}

    public void setIdContrato (Long contrato){ this.idContrato = contrato;}
}
