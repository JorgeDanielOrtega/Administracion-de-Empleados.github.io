package com.example.administracion.Models;

// import java.util.Date;
// import java.util.List;
//import administraciondeempleados.AdministracionEmpleado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//public class Gerente extends Trabajador{
@Entity
@Table(name = "Gerentes")
public class Gerente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_trabajador")
    private Long idTrabajador;

    // private Empresa empresa;
    // private AdministracionEmpleado adminstracionEmpleado;


    // CRUD EMPRESA

    // public Empresa crearEmpresa(String nombre, int fundacionYear, String rubro,
    // String leyenda){
    // Empresa empresa = new Empresa(nombre, fundacionYear, rubro);
    // empresa.setLeyenda(leyenda);
    // this.empresa = empresa;
    // return empresa;
    // }

    // public void modificarNombreEmpresa(String nombre){
    // this.empresa.setNombre(nombre);
    // }

    // public void modificarRubro(String rubro){
    // this.empresa.setRubro(rubro);
    // }

    // public void modificarLeyenda(String leyenda){
    // this.empresa.setLeyenda(leyenda);
    // }

    // public void modificarAñoFundacion(int añoFundacion){
    // this.empresa.setFundacionYear(añoFundacion);
    // }

    // CRUD HORARIO

    // public Horario crearHorario(String tipo, List<DiasLaborales> diasLaborales,
    // Float horasLaborablesSemanales){
    // Horario horario = new Horario(tipo, diasLaborales, horasLaborablesSemanales);
    // empresa.getHorarioList().add(horario);
    // return horario;
    // }

    // public void insertarHorario(Horario horario){
    // empresa.getHorarioList().add(horario);
    // }

    // public void modificarTipoHorario(Horario horario, String tipo){
    // empresa.getHorarioList().get(empresa.getHorarioList().indexOf(horario)).setTipo(tipo);
    // }

    // public void modificarDiasLaboralesHorario(Horario horario,
    // List<DiasLaborales> diasLaborales){
    // empresa.getHorarioList().get(empresa.getHorarioList().indexOf(horario)).setDiasLaborablesList(diasLaborales);
    // }

    // public void agregarDiaLaborables(Horario horario, DiasLaborales dia){
    // empresa.getHorarioList().get(empresa.getHorarioList().indexOf(horario)).agregarDia(dia);
    // }

    // public void eliminarDiaLaborables(Horario horario, DiasLaborales dia){
    // empresa.getHorarioList().get(empresa.getHorarioList().indexOf(horario)).eliminarDia(dia);
    // }

    // public void modificarHorasLaboralesHorario(Horario horario, Float
    // horasLaborablesSemanales){
    // empresa.getHorarioList().get(empresa.getHorarioList().indexOf(horario)).setHorasLaborablesSemanales(horasLaborablesSemanales);
    // }

    // public void eliminarHorario(Horario horario){
    // this.empresa.getHorarioList().remove(horario);
    // }

    // Getters and Setters

    // public Empresa getEmpresa() {
    // return empresa;
    // }

    // public void setEmpresa(Empresa empresa) {
    // this.empresa = empresa;
    // }

    // public AdministracionEmpleado getAdminstracionEmpleado() {
    // return adminstracionEmpleado;
    // }

    // public void setAdminstracionEmpleado(AdministracionEmpleado
    // adminstracionEmpleado) {
    // this.adminstracionEmpleado = adminstracionEmpleado;
    // }

    // @Override
    // public String toString() {
    // return "Gerente{" + "empresa=" + empresa + '}';
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Long idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

}
