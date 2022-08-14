package com.example.administracion.Models;

// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.util.LinkedList;
// import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Departamentos")

public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "maximo_empleados")
    private Integer empleadosMaximos;
    @Column(name = "vacaciones")
    private Integer vacaciones;
    @Column(name = "id_empresa")
    private Long idEmpresa;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getEmpleadosMaximos() {
        return empleadosMaximos;
    }

    public void setEmpleadosMaximos(int empleadosMaximos) {
        this.empleadosMaximos = empleadosMaximos;
    }

    public int getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(int vacaciones) {
        this.vacaciones = vacaciones;
    }

    // public List<Trabajador> getTrabajadorList() {
    // return trabajadorList;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
