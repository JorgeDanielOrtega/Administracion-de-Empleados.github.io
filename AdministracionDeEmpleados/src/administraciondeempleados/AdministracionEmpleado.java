/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administraciondeempleados;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author SONY VAIO
 */
public class AdministracionEmpleado {
    
    private Gerente gerente;
    protected List<Departamento> depatamentoList;
    

    public AdministracionEmpleado(){
        depatamentoList = new LinkedList<>();
    }
    
    
//    public void crearEmpleado( String nombre, String apellido, String direccion, EstadoCivil estadoCivil, String numeroCedula,
//    char sexo, String ciudad, String telefono, /*, String fechaNacimiento, String cumpleanios*/
//    String correoPersonal, String correoEmpresarial, String vacaciones, String usuario, String contrasenia,
//    double horasExtra, boolean pagoPorTransferencia, Rol rol, Contrato contrato, Decimo decimo, Date anioEntrada ) {
//        Empleado empleadotemporalAgregarList = new Empleado (nombre, apellido, direccion, estadoCivil, numeroCedula, sexo,
//                ciudad, telefono, correoPersonal, correoEmpresarial, usuario, contrasenia, pagoPorTransferencia, rol, contrato
//        , anioEntrada);
//        gerente.getEmpresa().getHorarioList().get(0).getEmpleadoList().add(empleadotemporalAgregarList);
//    }

   // public void leerEmpleado(Trabajador indiceTrabajador);

    //public void modificarEmpleado();
    //public void eliminarEmpleado();
    
    public void agregarRol( String nombre, double salario){
        Rol rolTemporalAgregar = new Rol(nombre, salario);
            gerente.getEmpresa().getRolList().add(rolTemporalAgregar);
    }
    
    public Rol leerRol(String nombreRol){
        for(int index = 0; index < gerente.getEmpresa().getRolList().size(); index++){
            if(gerente.getEmpresa().getRolList().get(index).getNombre() == nombreRol){
               return  gerente.getEmpresa().getRolList().get(index);        
            }
        }
        return new Rol();
    }
    
    public void actualizarRol(String nombreRolActualizar, String nombre, double salario){
        boolean estaRol = false;
        for( int index = 0; index <gerente.getEmpresa().getRolList().size(); index++){
            if(gerente.getEmpresa().getRolList().get(index).getNombre() == nombreRolActualizar){
                estaRol = true;
                gerente.getEmpresa().getRolList().get(index).setNombre(nombre);
                gerente.getEmpresa().getRolList().get(index).setSalario(salario);
            }
        }
        if(!estaRol){
            System.out.println("No existe Rol");
        }
    }
    
    public void eliminarRol(String nombreRol){
        for(int index = 0; index < gerente.getEmpresa().getRolList().size(); index++){
            if(gerente.getEmpresa().getRolList().get(index).getNombre() == nombreRol){
                gerente.getEmpresa().getRolList().remove(index);        
            }
        }
    }
    
    public void crearDepartamento(String nombre, int numero, int maximoEmpleados, int vacaciones){
        Departamento departamentoTemporalAgregar = new Departamento(nombre, numero, maximoEmpleados, vacaciones);
        gerente.getEmpresa().getDepartamentoList().add(departamentoTemporalAgregar);
    }
    
    public Departamento leerDepartamento(String nombreDepartamento){
        
        for(int index = 0; index < gerente.getEmpresa().getDepartamentoList().size(); index++){
            if(gerente.getEmpresa().getDepartamentoList().get(index).getNombre() == nombreDepartamento){
               return  gerente.getEmpresa().getDepartamentoList().get(index); 
            }
        }
        return new Departamento();
    }
    
    public void actualizarDepartamento(String nombreDepartamento, String nombre, int numero, int maximoEmpleados, int vacaciones){
        
        for(int index = 0; index < gerente.getEmpresa().getDepartamentoList().size(); index++){
            if(gerente.getEmpresa().getDepartamentoList().get(index).getNombre() == nombreDepartamento){
                gerente.getEmpresa().getDepartamentoList().get(index).setNombre(nombre);
                gerente.getEmpresa().getDepartamentoList().get(index).setNumero(numero);
                gerente.getEmpresa().getDepartamentoList().get(index).setEmpleadosMaximos(maximoEmpleados);
                gerente.getEmpresa().getDepartamentoList().get(index).setVacaciones(vacaciones);            }
        }
    }
    
    public void eliminarDepartamento(String nombreDepartamento){
        for(int index = 0 ; index < gerente.getEmpresa().getDepartamentoList().size(); index++){
            if(gerente.getEmpresa().getDepartamentoList().get(index).getNombre() == nombreDepartamento){
                gerente.getEmpresa().getDepartamentoList().remove(index);    
            }
        }
    } 
    
    
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Departamento> getDepatamentoList() {
        return depatamentoList;
    }

    public void setDepatamentoList(List<Departamento> depatamentoList) {
        this.depatamentoList = depatamentoList;
    }
    
}
