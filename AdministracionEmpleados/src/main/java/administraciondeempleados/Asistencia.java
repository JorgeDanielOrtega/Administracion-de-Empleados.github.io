package administraciondeempleados;

import java.util.Calendar;

public class Asistencia {

    private Calendar fecha;
    private Calendar hora;
    private EstadoAsistencia estado;
    private String diaSemana;

    public Asistencia() {
        fecha = Calendar.getInstance();
        hora = Calendar.getInstance();
    }

    public Asistencia(EstadoAsistencia estado) {
        this();
        this.estado = estado;
    }

    public void asignarDatosFecha() {
        asignarDia();
        asignarFecha();
    }

    private void asignarDia() {
        int dia = fecha.get(Calendar.DAY_OF_WEEK) - 1;
        for (DiasLaborales value : DiasLaborales.values()) {
            if (value.ordinal() == dia) {
                diaSemana = retornarDia(value.toString());
            }
        }
    }

    private String retornarDia(String dia) {
        if (dia == "LU") {
            return "Lunes";
        } else if (dia == "MA") {
            return "Martes";
        } else if (dia == "MI") {
            return "Miercoles";
        } else if (dia == "JU") {
            return "Jueves";
        } else if (dia == "VI") {
            return "Viernes";
        } else if (dia == "SA") {
            return "Sabado";
        } else if (dia == "DO") {
            return "Domingo";
        } else {
            return "Default";
        }
    }

    private void asignarFecha() {
        int dia = fecha.get(Calendar.DATE);
        int mes = fecha.get(Calendar.MONTH);
        int anio = fecha.get(Calendar.YEAR);
        int horaActual = this.hora.get(Calendar.HOUR_OF_DAY);
        int minuto = this.hora.get(Calendar.MINUTE);
        int segundo = this.hora.get(Calendar.SECOND);
        fecha.set(anio, mes, dia, horaActual, minuto, segundo);
    }

    public String getFechaFormated() {
        String result = "";
        result = String.valueOf(fecha.get(Calendar.DATE)) + '-';
        result += String.valueOf(fecha.get(Calendar.MONTH)) + '-';
        result += String.valueOf(fecha.get(Calendar.YEAR));
        return result;
    }

    public String getHoraFormated() {
        String result = "";
        result = String.valueOf(hora.get(Calendar.HOUR_OF_DAY)) + ':';
        result += String.valueOf(hora.get(Calendar.MINUTE)) + ':';
        result += String.valueOf(hora.get(Calendar.SECOND));
        return result;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }

    @Override 
    public String toString() {
        return "Asistencia{" + "fecha=" + fecha.get(Calendar.DATE) + ", hora=" + hora.get(Calendar.SECOND) + ", estado=" + estado + ", diaSemana=" + diaSemana + '}';
    }

}
