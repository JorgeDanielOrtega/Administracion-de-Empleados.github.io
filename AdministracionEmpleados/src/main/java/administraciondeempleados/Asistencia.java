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
        asignarFecha();
        asignarDia();
    }

    public Asistencia(EstadoAsistencia estado) {
        this();
        this.estado = estado;
    }

    private void asignarDia() {
        int dia = fecha.get(Calendar.DAY_OF_WEEK) - 1;
        for (DiasLaborales value : DiasLaborales.values()) {
            if (value.ordinal() == dia) {
                diaSemana = value.toString();
            }
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

    public String getDiaSemana() {
        return diaSemana;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }
    

    @Override //quitar mas tarde
    public String toString() {
        return "Asistencia{" + "fecha=" + fecha.get(Calendar.DATE) + ", hora=" + hora.get(Calendar.SECOND) + ", estado=" + estado + ", diaSemana=" + diaSemana + '}';
    }

}
