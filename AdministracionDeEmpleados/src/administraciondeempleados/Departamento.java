package administraciondeempleados;

import java.util.List;

public class Departamento {

    private String nombre;
    private int numero;
    private int empleadosMaximos;
    private int vacaciones;
    private List<Trabajador> trabajadorList;

    public Departamento(String nombre, int numero, int empleadosMaximos) {
        this.nombre = nombre;
        this.numero = numero;
        this.empleadosMaximos = empleadosMaximos;
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
    
    

}
