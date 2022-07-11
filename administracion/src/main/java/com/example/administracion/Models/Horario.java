package com.example.administracion.Models;

// import java.util.LinkedList;
// import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// import java.util.Date;

@Entity
@Table(name = "Horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "horas_semanales")
    private Float horasLaborablesSemanales;

    // private List<DiasLaborales> diasLaborablesList;
    // private List<Empleado> empleadoList;

    // public Horario() {
    // empleadoList = new LinkedList();
    // diasLaborablesList = new LinkedList();

    // }

    // public Horario(String tipo) {
    // this();
    // this.tipo = tipo;
    // }
    // public Horario(String tipo, Float horasLaborablesSemanales){
    // this(tipo);
    // this.horasLaborablesSemanales = horasLaborablesSemanales;
    // }

    // public Horario(String tipo, List<DiasLaborales> diasLaborables, Float
    // horasLaborablesSemanales){
    // this(tipo, horasLaborablesSemanales);
    // this.diasLaborablesList = diasLaborables;
    // }

    // //metodos de actualizacion de dias
    // public void agregarDia(DiasLaborales dia){
    // this.diasLaborablesList.add(dia);
    // }

    // public void eliminarDia(DiasLaborales dia){
    // this.diasLaborablesList.remove(dia);
    // }

    // getters and setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // public List<DiasLaborales> getDiasLaborablesList() {
    // return diasLaborablesList;
    // }

    // public void setDiasLaborablesList(List<DiasLaborales> diasLaborablesList) {
    // this.diasLaborablesList = diasLaborablesList;
    // }

    public Float getHorasLaborablesSemanales() {
        return horasLaborablesSemanales;
    }

    public void setHorasLaborablesSemanales(Float horasLaborablesSemanales) {
        this.horasLaborablesSemanales = horasLaborablesSemanales;
    }

    // public List<Empleado> getEmpleadoList() {
    // return empleadoList;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
