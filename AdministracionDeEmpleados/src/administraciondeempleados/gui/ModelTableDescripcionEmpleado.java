package administraciondeempleados.gui;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import administraciondeempleados.Empleado;
import administraciondeempleados.Trabajador;

public class ModelTableDescripcionEmpleado extends DefaultTableModel{
    
    private List<Trabajador> trabajadorList;
    
    public ModelTableDescripcionEmpleado() {
//        empleadoList = new LinkedList<>();
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
        trabajadorList.add((Trabajador)empleado);
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
    public void cargarModelo(){
        for (Trabajador trabajador : trabajadorList) {
            Empleado empleado = (Empleado)trabajador;
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
    }
    
    public void eliminarEmpleado(int fila){
        if (fila >= 0){
            trabajadorList.remove(fila);
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
        trabajadorList.get(fila).setNombre(empleado.getNombre());
        trabajadorList.get(fila).setApellido(empleado.getApellido());
        trabajadorList.get(fila).setDireccion(empleado.getDireccion());
        trabajadorList.get(fila).setEstadoCivil(empleado.getEstadoCivil());
        trabajadorList.get(fila).setCedula(empleado.getCedula());
        trabajadorList.get(fila).setSexo(empleado.getSexo());
        trabajadorList.get(fila).setCiudad(empleado.getCiudad());
        trabajadorList.get(fila).setTelefono(empleado.getTelefono());
        trabajadorList.get(fila).setFechaNacimiento(empleado.getFechaNacimiento());
        trabajadorList.get(fila).setCorreoPersonal(empleado.getCorreoPersonal());
        trabajadorList.get(fila).setCorreoEmpresarial(empleado.getCorreoEmpresarial());
        trabajadorList.get(fila).setUsuario(empleado.getUsuario());
        trabajadorList.get(fila).setPassword(empleado.getPassword());
        trabajadorList.get(fila).setPagoPorTrasferencia(empleado.isPagoPorTrasferencia());
        trabajadorList.get(fila).setRol(empleado.getRol());
        trabajadorList.get(fila).setContrato(empleado.getContrato());
        ((Empleado)trabajadorList.get(fila)).setEntradaYear(empleado.getEntradaYear());
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

    public List<Trabajador> gettrabajadorList() {
        return trabajadorList;
    }

    public void settrabajadorList(List<Trabajador> trabajadorList) {
        this.trabajadorList = trabajadorList;
    }
    
    
    
    
}
