package com.example.administracion.Services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.administracion.Models.Asistencia;
import com.example.administracion.Models.Rol;
import com.example.administracion.Repositories.AsistenciaRepository;
import com.example.administracion.Repositories.RolRepository;

public class RolServiceTest {

    @Mock
    RolRepository rolRepository;

    @InjectMocks
    RolService rolService;

    private Rol rol;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        rol = new Rol();
    }

    @Test
    public void getRolById() {
        when(rolRepository.findById(any(Long.class))).thenReturn( Optional.of(rol));
        assertNotNull(rolService.getRolById(1l));
    }

    @Test
    public void getIdRolByNombre() {
        when(rolRepository.findByNombre(anyString())).thenReturn(rol);
        assertSame(rolService.getIdRolByNombre(anyString()), null);
    }

    
    @Test
    public void getAllNombreRolSinRepetir() {
        ArrayList<HashMap<String, Object>> nombresRolList = new ArrayList<>();
        when(rolService.getAllNombreRolSinRepetir()).thenReturn(nombresRolList);
        assertNotNull(rolService.getAllNombreRolSinRepetir());
    }

}
