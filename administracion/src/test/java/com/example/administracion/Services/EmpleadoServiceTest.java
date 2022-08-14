package com.example.administracion.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.administracion.Repositories.EmpleadoRepository;

public class EmpleadoServiceTest {

    @Mock
    EmpleadoRepository empleadoRepository;
    @Mock
    TrabajadorService trabajadorService;
    @Mock
    PersonaService personaService;

    @InjectMocks
    EmpleadoService empleadoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test

    public void getIdsTrabajador() {
        assertNotNull(empleadoService.getIdsTrabajador());

    }

}
