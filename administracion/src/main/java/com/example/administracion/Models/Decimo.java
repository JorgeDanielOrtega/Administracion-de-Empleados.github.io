package com.example.administracion.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Decimos")
public class Decimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "decimo_cuarto")
    private Double decimoCuarto;
    @Column(name = "decimo_tercero")
    private Double decimoTercero;
    @Column(name = "fondo_reserva")
    private Double fondoReserva;
    @Column(name = "id_empleado")
    private Long idEmpleado;

    // private int parte;
    // private double porcentajeFondoReserva;

    // private Date fechaHoy;
    // private Trabajador trabajador;
    // private Empleado empleado;

    // public Decimo(double porcentajeFondoReserva, int parte){
    // this.porcentajeFondoReserva = porcentajeFondoReserva;
    // this.parte = parte;
    // fechaHoy = new Date();
    // }

    // public void calcularDecimoTercero(){
    // if(fechaHoy.getMonth() > empleado.getEntradaYear().getMonth() ||
    // fechaHoy.getYear() > empleado.getEntradaYear().getYear()){
    // this.decimoTercero = (float) (trabajador.getRol().getSalario() / 12);
    // }
    // }

    // public void calcularDecimoCuarto(){
    // int diaAnio = 360;
    // int sueldoBasico = 425;
    // if(fechaHoy.getMonth() > empleado.getEntradaYear().getMonth() ||
    // fechaHoy.getYear() > empleado.getEntradaYear().getYear()){
    // this.decimoCuarto = sueldoBasico / diaAnio;
    // }
    // }

    // public void calcularFondoDeReserva(){
    // if(fechaHoy.getYear() > (empleado.getEntradaYear().getYear())+1 &
    // fechaHoy.getMonth() >= empleado.getEntradaYear().getMonth() ){
    // if((fechaHoy.getMonth() == empleado.getEntradaYear().getMonth() &
    // fechaHoy.getDate() > empleado.getEntradaYear().getDate())
    // || (fechaHoy.getMonth() > empleado.getEntradaYear().getMonth())){
    // fondoReserva = (float) (empleado.getRol().getSalario() * 0.083);
    // }
    // }
    // }

    public double getDecimoCuarto() {
        return decimoCuarto;
    }

    public void setDecimoCuarto(double decimoCuarto) {
        this.decimoCuarto = decimoCuarto;
    }

    public double getDecimoTercero() {
        return decimoTercero;
    }

    public void setDecimoTercero(double decimoTercero) {
        this.decimoTercero = decimoTercero;
    }

    public double getFondoReserva() {
        return fondoReserva;
    }

    public void setFondoReserva(double fondoReserva) {
        this.fondoReserva = fondoReserva;
    }

    // public double getPorcentajeFondoReserva() {
    //     return porcentajeFondoReserva;
    // }

    // public void setPorcentajeFondoReserva(double porcentajeFondoReserva) {
    //     this.porcentajeFondoReserva = porcentajeFondoReserva;
    // }

    // public int getParte() {
    //     return parte;
    // }

    // public void setParte(int parte) {
    //     this.parte = parte;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
