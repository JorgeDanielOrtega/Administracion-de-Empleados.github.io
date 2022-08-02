package com.example.administracion.Models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Real Model
@Table(name = "Contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tiene_contrato")
    private Boolean tieneContrato; // quizas cambiar a integer
    @Column(name = "tiempo_contrato")
    private Double tiempoContrato;
    @Column(name = "fecha_limite")
    private Date fechaLimite;
    @Column(name = "id_empleado")
    private Long idEmpleado;

    // public Contrato(Boolean tieneContrato) {
    // this.tieneContrato = tieneContrato;
    // }

    // public Contrato(Boolean tieneContrato, Date fechaLimite) {
    // this(tieneContrato);
    // this.fechaLimite = fechaLimite;
    // }

    // public Contrato(Boolean tieneContrato, Double tiempoContrato, Date
    // fechaLimite) {
    // this(tieneContrato, fechaLimite);
    // this.tiempoContrato = tiempoContrato;
    // }

    // TODO hacer metodo para el calculo del metodo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getTieneContrato() {
        return tieneContrato;
    }

    public void setTieneContrato(Boolean tieneContrato) {
        this.tieneContrato = tieneContrato;
    }

    public Double getTiempoContrato() {
        return tiempoContrato;
    }

    public void setTiempoContrato(Double tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "" + tieneContrato + "  " + tiempoContrato + '}';
    }

}
