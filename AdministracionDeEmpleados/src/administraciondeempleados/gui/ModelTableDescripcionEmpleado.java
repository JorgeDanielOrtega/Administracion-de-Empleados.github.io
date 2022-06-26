/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administraciondeempleados.gui;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import administraciondeempleados.Departamento;
import administraciondeempleados.Empleado;

/**
 *
 * @author SONY VAIO
 */
public class ModelTableDescripcionEmpleado extends DefaultTableModel{
    
    private List<Empleado> empleadoList;
    
    public ModelTableDescripcionEmpleado() {
        empleadoList = new LinkedList<>();
        addColumn("Nombre");
        addColumn("Apellido");
        addColumn("Direccion");
        addColumn("EstadoCivil");
        addColumn("Cedula");
        addColumn("Genero");
        addColumn("Ciudad");
        addColumn("Telefono");
        addColumn("Fecha Nacimiento");
        addColumn("Correo personal");
        addColumn("Correo empresarial");
        addColumn("Usuario");
        addColumn("Contraseña");
        addColumn("Pago por transferencia");
        addColumn("Rol");
        addColumn("Contrato");
        addColumn("Año de entrada");
        
    }
    
    public void agregarEmpleado(Empleado empleado){
        empleadoList.add(empleado);
        addRow(new Object[]{
            empleado.getNombre(),
            empleado.getApellido(),
            empleado.getDireccion(),
            empleado.getEstadoCivil(),
            empleado.getCedula(),
            empleado.getSexo(),
            empleado.getCiudad(),
            empleado.getTelefono(),
            empleado.getFechaNacimiento().getYear()+1900 + "-" + (empleado.getFechaNacimiento().getMonth()+1) + "-" + empleado.getFechaNacimiento().getDate(),
            empleado.getCorreoPersonal(),
            empleado.getCorreoEmpresarial(),
            empleado.getUsuario(),
            empleado.getPassword(),
            empleado.isPagoPorTrasferencia(),
            empleado.getRol(),
            empleado.getContrato(),
            empleado.getEntradaYear().getYear()+1900 + "-" + (empleado.getEntradaYear().getMonth()+1) + "-" + empleado.getEntradaYear().getDate()
        });
    }
    
    public void eliminarEmpleado(int fila){
        if (fila >= 0){
            empleadoList.remove(fila);
            removeRow(fila);
        }else{
            JOptionPane.showMessageDialog( null, "Selecionar Fila");
        }
//        for(int index = 0; index<empleadoList.size(); index++){
//            if(empleadoList.get(index).getUsuario().equals(usuarioEmpleado));
//                empleadoList.remove(index);
//            }
    }
    
    public void editarEmpleado(int fila, Empleado empleado){
        empleadoList.get(fila).setNombre(empleado.getNombre());
        empleadoList.get(fila).setApellido(empleado.getApellido());
        empleadoList.get(fila).setDireccion(empleado.getDireccion());
        empleadoList.get(fila).setEstadoCivil(empleado.getEstadoCivil());
        empleadoList.get(fila).setCedula(empleado.getCedula());
        empleadoList.get(fila).setSexo(empleado.getSexo());
        empleadoList.get(fila).setCiudad(empleado.getCiudad());
        empleadoList.get(fila).setTelefono(empleado.getTelefono());
        empleadoList.get(fila).setFechaNacimiento(empleado.getFechaNacimiento());
        empleadoList.get(fila).setCorreoPersonal(empleado.getCorreoPersonal());
        empleadoList.get(fila).setCorreoEmpresarial(empleado.getCorreoEmpresarial());
        empleadoList.get(fila).setUsuario(empleado.getUsuario());
        empleadoList.get(fila).setPassword(empleado.getPassword());
        empleadoList.get(fila).setPagoPorTrasferencia(empleado.isPagoPorTrasferencia());
        empleadoList.get(fila).setRol(empleado.getRol());
        empleadoList.get(fila).setContrato(empleado.getContrato());
        empleadoList.get(fila).setEntradaYear(empleado.getEntradaYear());
        setValueAt(empleado.getNombre(), fila, 0);
        setValueAt(empleado.getApellido(), fila, 1);
        setValueAt(empleado.getDireccion(), fila,2 );
        setValueAt(empleado.getEstadoCivil(), fila,3 );
        setValueAt(empleado.getCedula(), fila,4 );
        setValueAt(empleado.getSexo(), fila,5 );
        setValueAt(empleado.getCiudad(), fila, 6);
        setValueAt(empleado.getTelefono(), fila, 7);
        setValueAt(empleado.getFechaNacimiento().getYear()+1900 + "-" + (empleado.getFechaNacimiento().getMonth()+1) + "-" + empleado.getFechaNacimiento().getDate(), fila, 8);
        setValueAt(empleado.getCorreoPersonal(), fila, 9);
        setValueAt(empleado.getCorreoEmpresarial(), fila, 10);
        setValueAt(empleado.getUsuario(), fila, 11);
        setValueAt(empleado.getPassword(), fila,12 );
        setValueAt(empleado.isPagoPorTrasferencia(), fila,13);
        setValueAt(empleado.getRol(), fila, 14);
        setValueAt(empleado.getContrato(), fila, 15);
        setValueAt(empleado.getEntradaYear().getYear()+1900 + "-" + (empleado.getEntradaYear().getMonth()+1) + "-" + empleado.getEntradaYear().getDate(), fila,16 );
    }
    
    
    
}
