package com.example.administracion.Models;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Asistencias")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "hora")
    private Time hora;
    @Column(name = "estado")
    private String estado; // EstadoAsistencia
    @Column(name = "dia_semana")
    private String diaSemana;
    @Column(name = "id_empleado")
    private Long idEmpleado;

    // public Asistencia() {
    // fecha = Calendar.getInstance();
    // hora = Calendar.getInstance();
    // }

    // public Asistencia(EstadoAsistencia estado) {
    // this();
    // this.estado = estado;
    // }

    // public void asignarDatosFecha() {
    // asignarDia();
    // asignarFecha();
    // }

    // private String retornarDia(String dia) {
    // switch (dia) {
    // case "LU":
    // return "Lunes";

    // case "MA":
    // return "Martes";

    // case "MI":
    // return "Miercoles";

    // case "JU":
    // return "Jueves";

    // case "VI":
    // return "Viernes";

    // case "SA":
    // return "Sabado";

    // case "DO":
    // return "Domingo";

    // default:
    // System.out.println("se selecciono en default");
    // break;
    // }
    // return null;
    // }

    // private void asignarDia() {
    // int dia = fecha.get(Calendar.DAY_OF_WEEK) - 1;
    // for (DiasLaborales value : DiasLaborales.values()) {
    // if (value.ordinal() == dia) {
    // diaSemana = retornarDia(value.toString());
    // }
    // }
    // }

    // private void asignarFecha() {
    // int dia = fecha.get(Calendar.DATE);
    // int mes = fecha.get(Calendar.MONTH);
    // int anio = fecha.get(Calendar.YEAR);
    // int horaActual = this.hora.get(Calendar.HOUR_OF_DAY);
    // int minuto = this.hora.get(Calendar.MINUTE);
    // int segundo = this.hora.get(Calendar.SECOND);
    // fecha.set(anio, mes, dia, horaActual, minuto, segundo);
    // }

    // public String getFechaFormated() {
    // String result = "";
    // result = String.valueOf(fecha.get(Calendar.DATE)) + '-';
    // result += String.valueOf(fecha.get(Calendar.MONTH)) + '-';
    // result += String.valueOf(fecha.get(Calendar.YEAR));
    // return result;
    // }

    // public String getHoraFormated() {
    // String result = "";
    // result = String.valueOf(hora.get(Calendar.HOUR_OF_DAY)) + ':';
    // result += String.valueOf(hora.get(Calendar.MINUTE)) + ':';
    // result += String.valueOf(hora.get(Calendar.SECOND));
    // return result;
    // }

    // public void setFecha(Calendar fecha) {
    // this.fecha = fecha;
    // }

    // public void setHora(Calendar hora) {
    // this.hora = hora;
    // }

    // public Calendar getFecha() {
    // return fecha;
    // }

    // public Calendar getHora() {
    // return hora;
    // }

    public Time getHora() {
        return this.hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    // @Override //quitar mas tarde
    // public String toString() {
    // return "Asistencia{" + "fecha=" + fecha.get(Calendar.DATE) + ", hora=" +
    // hora.get(Calendar.SECOND) + ", estado=" + estado + ", diaSemana=" + diaSemana
    // + '}';
    // }
}
