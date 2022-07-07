package administraciondeempleados.gui;

import administraciondeempleados.Asistencia;
import administraciondeempleados.Empleado;
import administraciondeempleados.EstadoAsistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import prueb.DBConnect;

public class ModelTableAsistencia extends DefaultTableModel {

    private List<Asistencia> asistenciaList;
    private Empleado empleado;

    private DBConnect dBConnect;
    private Connection connection;
    private String sql;
    private PreparedStatement ps;
    private ResultSet result;

    public ModelTableAsistencia() {
        asistenciaList = new LinkedList();
        dBConnect = new DBConnect();
        addColumn("Fecha");
        addColumn("Hora");
        addColumn("Dia");
        addColumn("Estado");
    }

    private EstadoAsistencia retornarEstado(String estado) {
        switch (estado) {
            case "presente":
                return EstadoAsistencia.PRESENTE;
            case "retraso":
                return EstadoAsistencia.RETRASO;
            case "falta_justificada":
                return EstadoAsistencia.FALTA_JUSTIFICADA;
            default:
                System.out.println("se selecciono default en estado");
                break;
        }
        return null;
    }

    private void cargarAsistenciaList() {
        try {
            connection = dBConnect.conectar();
            sql = "SELECT * FROM Asistencias"; //agregar que seleccion todas las asistencias con el id del empleado
            ps = connection.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Date fecha = result.getDate("fecha");
                Date hora = result.getTime("hora");
                EstadoAsistencia estado = retornarEstado(result.getString("estado"));
                String diaSemana = result.getString("dia_semana");
                int dia = fecha.getDate();
                int mes = fecha.getMonth()+1;
                int anio = fecha.getYear()+1900;
                int horaMarcada = hora.getHours();
                int minutoMarcado = hora.getMinutes();
                int segundoMarcado = hora.getSeconds();

                Calendar fecha_horaMarcada = Calendar.getInstance();
                //Calendar horaRegistrada = Calendar.getInstance();
                fecha_horaMarcada.set(anio, mes, dia, horaMarcada, minutoMarcado, segundoMarcado);
                //horaRegistrada.set(anio, mes, dia, horaMarcada, minutoMarcado, segundoMarcado);
                Asistencia a = new Asistencia(estado);
                a.setDiaSemana(diaSemana);
                a.setFecha(fecha_horaMarcada);
                a.setHora(fecha_horaMarcada);
                empleado.getAsistenciaList().add(a);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se cargo la asistenciaList");
            System.out.println("hubo un error en asistencia " + e.getMessage());
        } finally {
            dBConnect.desconectar();
        }

    }

    public void llenarEmpleadoList() {
        asistenciaList.clear();
        empleado.getAsistenciaList().clear(); //por si acaso
        cargarAsistenciaList();
        asistenciaList.addAll(empleado.getAsistenciaList()); //nose si se copiaran directamente los objetos o se crean nuevos
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    private void limpiarTabla() {
        while (getRowCount() > 0) {
            removeRow(0);
        }
    }

    public void cargarModelo() {
        limpiarTabla();
        asistenciaList.forEach(asistencia -> {
            addRow(new String[]{
                asistencia.getFechaFormated(),
                asistencia.getHoraFormated(),
                asistencia.getDiaSemana(),
                asistencia.getEstado().toString()
            });
        });
    }
}
