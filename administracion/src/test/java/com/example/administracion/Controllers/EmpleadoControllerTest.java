package com.example.administracion.Controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.administracion.Services.EmpleadoService;
import com.example.administracion.Services.TrabajadorService;


@ExtendWith(MockitoExtension.class)
public class EmpleadoControllerTest {

    @InjectMocks
    private EmpleadoController empleadoController;

    @Mock
    private EmpleadoService empleadoService;
    @Mock
    private TrabajadorService trabajadorService;

    @Test
    public void getEmpleados() {
        ArrayList<Long> ids = new ArrayList<>();    

        when(empleadoService.getIdTrabajador()).thenReturn(ids);

        ArrayList<Long> empleadoResult = empleadoController.getEmpleados();

        verify(empleadoService, times(1)).getIdTrabajador();
    }
}