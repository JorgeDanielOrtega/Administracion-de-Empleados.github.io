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

//public class Empleado extends Trabajador {

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(name = "id_trabajador")
    private Long idTrabajador;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public Long getIdTrabajador() {

        return idTrabajador;
    }

    public void setIdTrabajador(Long idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

}
