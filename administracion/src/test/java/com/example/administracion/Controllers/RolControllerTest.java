package com.example.administracion.Controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.administracion.Models.Puesto;
import com.example.administracion.Models.Rol;
import com.example.administracion.Services.PuestoService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.administracion.Services.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class RolControllerTest {

    @InjectMocks
    private RolController rolController;

    @Mock
    private RolService rolService;
    @Mock
    private PuestoService puestoService;

    @Test
    public void obtenerTodosRoles(){
        ArrayList<Rol> roles = new ArrayList<>();
        when(rolService.getTodosRoles()).thenReturn(roles);
        ArrayList<Rol> rolResult = rolController.obtenerTodosRoles();
        verify(rolService, times(1)).getTodosRoles();
    }
    @Test
    public void guardar(){
        Rol rol = new Rol();
        when(rolService.guardarRol(rol)).thenReturn(rol);
        ResponseEntity<Rol> resultR = rolController.guardar(rol);
        verify(rolService, times(1)).guardarRol(rol);
    }
    @Test
    public void eliminar(){
        Rol r = new Rol();
        if(r != null){
            rolService.eliminarRolPorId(r.getId());
        }else{
            ResponseEntity<Rol> result = new ResponseEntity<Rol>(r, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        verify(rolService, times(1)).eliminarRolPorId(r.getId());
    }
    @Test
    public void getNombresRol() {
        ArrayList<HashMap<String, Object>> roles = new ArrayList<>();
        HashMap rol = new HashMap<>();
        rol.put("nombre", "gerente");
        roles.add(rol);

        when(rolService.getAllNombreRolSinRepetir()).thenReturn(roles);

        ArrayList<HashMap<String, Object>> rolesResult = rolController.getNombresRol();

        verify(rolService, times(1)).getAllNombreRolSinRepetir();
    }

}