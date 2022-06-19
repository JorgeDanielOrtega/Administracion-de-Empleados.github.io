package administraciondeempleados;

import java.util.List;

public class Puesto {
    
    private String nombre;
    private List<Rol> rolList;
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    
     
}
