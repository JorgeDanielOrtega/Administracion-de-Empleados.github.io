package com.example.administracion.Models;

// import java.util.LinkedList;
// import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "salario")
    private Double salario;
    @Column(name = "id_departamento")
    private Long idDepartamento;
    @Column(name = "id_puesto")
    private Long idPuesto;

    // private Departamento departamento;
    // private Puesto puesto;

    // private List<Trabajador> trabajadorList;

    // public Rol(){
    // trabajadorList = new LinkedList();
    // }

    // public Rol(String nombre) { //Quitar mas tarde
    // this();
    // this.nombre = nombre;
    // }

    // public Rol( String nombre, double salario){
    // this(nombre);
    // this.salario = salario;
    // }

    // public Rol(double salario, String nombre, Puesto puesto){
    // this(nombre, salario);
    // this.puesto = puesto;
    // }
    // public Rol(double salario, String nombre, Puesto puesto, Departamento
    // departamento){
    // this(salario, nombre, puesto);
    // this.departamento = departamento;
    // }
    // public Rol(String nombre, Puesto puesto, Departamento departamento) {
    // //quizas quitar lo de puesto
    // this(nombre);
    // this.puesto = puesto;
    // this.departamento = departamento;
    // }

    // TODO hacer metodo para calcular salario

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    // public Puesto getPuesto() {
    // return puesto;
    // }

    // public void setPuesto(Puesto puesto) {
    // this.puesto = puesto;
    // }

    // public Departamento getDepartamento() {
    // return departamento;
    // }

    // public void setDepartamento(Departamento departamento) {
    // this.departamento = departamento;
    // }

    // public List<Trabajador> getTrabajadorList() {
    // return trabajadorList;
    // }

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

    public Long getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Long idPuesto) {
        this.idPuesto = idPuesto;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
