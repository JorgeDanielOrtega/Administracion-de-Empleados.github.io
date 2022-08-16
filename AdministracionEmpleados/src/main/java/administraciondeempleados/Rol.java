package administraciondeempleados;

import java.util.LinkedList;
import java.util.List;

public class Rol {

    private String nombre;
    private Double salario;
    private Departamento departamento;
    
    private Puesto puesto;
    private List<Trabajador> trabajadorList;
    
    private int id_puesto;
    private int id_departamento;

    public Rol(){
        trabajadorList = new LinkedList();
    }
    
    public Rol(String nombre) { //Quitar mas tarde
        this();
        this.nombre = nombre;
    }
    
    public Rol( String nombre, double salario){
        this(nombre);
        this.salario = salario;
    }
    public Rol(String nombre, double salario, int id_puesto, int id_departamento){
        this(nombre, salario);
        this.id_puesto = id_puesto;
        this.id_departamento = id_departamento;
    }
     public Rol(double salario, String nombre, Puesto puesto){
        this(nombre, salario);
        this.puesto = puesto;
    }
     public Rol(double salario, String nombre, Puesto puesto, Departamento departamento){
        this(salario, nombre, puesto);
        this.departamento = departamento;
    }
    
//    public Rol(String nombre, Puesto puesto, Departamento departamento) { //quizas quitar lo de puesto
//        this(nombre);
//        this.puesto = puesto;
//        this.departamento = departamento;
//    }

    //TODO hacer metodo para calcular salario
    
   


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
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

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }
    

    @Override
    public String toString() {
        return nombre;
    }


}
