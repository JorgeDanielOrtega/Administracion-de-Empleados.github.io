package com.example.administracion.Controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.administracion.Services.RolService;


@ExtendWith(MockitoExtension.class)
public class RolControllerTest {

    @InjectMocks
    private RolController rolController;

    @Mock
    private RolService rolService;

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