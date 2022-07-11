package com.example.administracion.Models;

// import java.util.Date;
// import java.util.LinkedList;
// import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//public class Empleado extends Trabajador {

@Entity
@Table(name = "Empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_trabajador")
    private Long idTrabajador;
    // private Date entradaYear;
    // private Horario horario;
    // private List<Asistencia> asistenciaList;

    // public Empleado(){
    // //this.asistenciaList = new LinkedList<>();
    // }
    // public Empleado(String nombre, String apellido, String direccion, EstadoCivil
    // estadoCivil,
    // String numeroCedula, char sexo, String ciudad, String telefono, Date
    // fechaNacimiento,
    // String correoPersonal, String correoEmpresarial, String usuario, String
    // contrasenia,
    // boolean pagoPorTransferencia, Rol rol, Contrato contrato, Date anioEntrada,
    // Departamento departamento,
    // Horario horario) {
    // super(nombre, apellido, direccion, estadoCivil, numeroCedula, sexo, ciudad,
    // telefono, fechaNacimiento, correoPersonal,
    // correoEmpresarial, usuario, contrasenia, pagoPorTransferencia, rol, contrato,
    // departamento);
    // asistenciaList = new LinkedList();
    // this.entradaYear = anioEntrada;
    // this.horario = horario;
    // }

    // //eliminar este contructor o cambiar el cumpleanios por anio entrada
    // public Empleado(Date entradaYear, Horario horario, String correoPersonal,
    // String usuario, String password, Puesto puesto, Rol rol, Departamento
    // departamento, Contrato contrato, String nombre, String apellido, String
    // direccion, String cedula, char sexo, String ciudad, String telefono, Date
    // fechaNacimiento) {
    // super(correoPersonal, usuario, password, puesto, rol, departamento, contrato,
    // nombre, apellido, direccion, cedula, sexo, ciudad, telefono,
    // fechaNacimiento);
    // this.entradaYear = entradaYear;
    // this.horario = horario;
    // this.asistenciaList = new LinkedList();
    // }

    // public Horario getHorario() {
    // return horario;
    // }

    // public void setHorario(Horario horario) {
    // this.horario = horario;
    // }

    // public List<Asistencia> getAsistenciaList() {
    // return asistenciaList;
    // }

    // public void setAsistenciaList(List<Asistencia> asistenciaList) {
    // this.asistenciaList = asistenciaList;
    // }

    // public Date getEntradaYear() {
    // return entradaYear;
    // }

    // public void setEntradaYear(Date entradaYear) {
    // this.entradaYear = entradaYear;
    // }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // @Override
    // public String toString() {
    // return "Empleado{" + "entradaYear=" + entradaYear + ", horario=" + horario +
    // ", id=" + id + ", asistenciaList="
    // + asistenciaList + "nombre: " + super.getNombre() + " rol: " + super.getRol()
    // + " puesto: "
    // + super.getRol().getPuesto().getNombre() + '}';
    // }

    public Long getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Long idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

}
