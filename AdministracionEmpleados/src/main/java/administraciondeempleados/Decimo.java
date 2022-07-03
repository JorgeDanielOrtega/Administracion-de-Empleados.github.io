package administraciondeempleados;

import java.util.Date;

public class Decimo {
    private double porcentajeFondoReserva;
    private int parte;
    private float decimoCuarto;
    private float decimoTercero;
    private float fondoReserva;
    
    private Date fechaHoy;
    
    private Trabajador trabajador;
    private Empleado empleado;
    
    public Decimo(double porcentajeFondoReserva, int parte){
        this.porcentajeFondoReserva = porcentajeFondoReserva;
        this.parte = parte;
        fechaHoy  = new Date();
    }
    
    public void calcularDecimoTercero(){
        if(fechaHoy.getMonth() > empleado.getEntradaYear().getMonth() || fechaHoy.getYear() > empleado.getEntradaYear().getYear()){
            this.decimoTercero = (float) (trabajador.getRol().getSalario() / 12);
        }
    }
    
    public void calcularDecimoCuarto(){
        int diaAnio = 360;
        int sueldoBasico = 425;
        if(fechaHoy.getMonth() > empleado.getEntradaYear().getMonth() || fechaHoy.getYear() > empleado.getEntradaYear().getYear()){
            this.decimoCuarto = sueldoBasico / diaAnio;
        }
    }
    
    public void calcularFondoDeReserva(){
        if(fechaHoy.getYear() > (empleado.getEntradaYear().getYear())+1 & fechaHoy.getMonth() >= empleado.getEntradaYear().getMonth() ){
            if((fechaHoy.getMonth() == empleado.getEntradaYear().getMonth() & fechaHoy.getDate() > empleado.getEntradaYear().getDate())
                    || (fechaHoy.getMonth() > empleado.getEntradaYear().getMonth())){
                    fondoReserva = (float) (empleado.getRol().getSalario() * 0.083);
            }
        }
   }

    public float getDecimoCuarto() {
        return decimoCuarto;
    }

    public void setDecimoCuarto(float decimoCuarto) {
        this.decimoCuarto = decimoCuarto;
    }

    public float getDecimoTercero() {
        return decimoTercero;
    }

    public void setDecimoTercero(float decimoTercero) {
        this.decimoTercero = decimoTercero;
    }

    public float getFondoReserva() {
        return fondoReserva;
    }

    public void setFondoReserva(float fondoReserva) {
        this.fondoReserva = fondoReserva;
    }
    
    public double getPorcentajeFondoReserva() {
        return porcentajeFondoReserva;
    }

    public void setPorcentajeFondoReserva(double porcentajeFondoReserva) {
        this.porcentajeFondoReserva = porcentajeFondoReserva;
    }

    public int getParte() {
        return parte;
    }

    public void setParte(int parte) {
        this.parte = parte;
    }
    
    
}
