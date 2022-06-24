package administraciondeempleados;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.LinkedList;

import java.util.List;

public class Departamento {

    private String añoCreacion;
    private String nombre;
    private int numero;
    private int empleadosMaximos;
    private int vacaciones;
    private List<Trabajador> trabajadorList;

    public Departamento(String nombre, int numero, int empleadosMaximos, int vacaciones) {

        trabajadorList = new LinkedList();
        this.nombre = nombre;
        this.numero = numero;
        this.empleadosMaximos = empleadosMaximos;
        this.vacaciones = vacaciones;
        guardarFecha();
    }

    
    private void actualizarVacaciones(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy");
        if(añoCreacion.equals(String.valueOf(Integer.parseInt(formato.format(LocalDateTime.now())) - 1))){
            for (int i = 0; i <= trabajadorList.size(); i++){
               trabajadorList.get(i).setVacaciones(vacaciones);
            }          
        }
    }
    
    private void guardarFecha(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy");
        this.añoCreacion = formato.format(LocalDateTime.now());
    }


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

    public List<Trabajador> getTrabajadorList() {
        return trabajadorList;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
