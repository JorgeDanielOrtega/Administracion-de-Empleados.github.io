package administraciondeempleados;

import java.util.List;

public class Rol {

    private String nombre;
    private Double salario;
    private Puesto puesto;
    private Departamento departamento;
    private List<Trabajador> trabajadorList;

<<<<<<< HEAD
    public Rol(String nombre) { //Quitar mas tarde
        this.nombre = nombre;
    }

    public Rol(String nombre, Puesto puesto, Departamento departamento) {
        this(nombre);
        this.puesto = puesto;
        this.departamento = departamento;
    }

    //TODO hacer metodo para calcular salario
=======
    public Rol(String nombre, Puesto puesto, Departamento departamento) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.departamento = departamento;
    }
    
    
    
    //TODO hacer metodo para calcular salario

>>>>>>> af846cae50b562cd12306e8d3f6d4756cfa6d3c4
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Trabajador> getTrabajadorList() {
        return trabajadorList;
    }
<<<<<<< HEAD

    @Override
    public String toString() {
        return nombre;
    }
=======
    
    
>>>>>>> af846cae50b562cd12306e8d3f6d4756cfa6d3c4

}
