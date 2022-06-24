package administraciondeempleados;

import java.util.Date;

public abstract class Persona {

    private String nombre;
    private String apellido;
    private String direccion;
    private String cedula;
    private char sexo;
    private String ciudad;
    private String telefono;
    private Date fechaNacimiento;
    private Date birthday;

    public Persona(String nombre, String apellido, String direccion, String cedula, char sexo, String ciudad, String telefono, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cedula = cedula;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        calculcarCumpleaños();
    }
    
    private void calculcarCumpleaños(){
        Date actual = new Date();
        this.birthday = new Date((actual.getYear() - 1900), this.fechaNacimiento.getMonth(), this.fechaNacimiento.getDay());
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + '}';
    } 
    
}
