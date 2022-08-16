package com.example.administracion.Controllers;

import com.example.administracion.Models.Puesto;
import com.example.administracion.Services.PuestoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PuestoControllerTest {
    @InjectMocks
    private PuestoControler puestoControler;
    @Mock
    private PuestoService puestoService;

    @Test
    public void obtenerTodosPuestos(){
        ArrayList<Puesto> puestos = new ArrayList<>();
        when(puestoService.getTodosPuestos()).thenReturn(puestos);
        ArrayList<Puesto> puestoResult = puestoControler.obtenerTodosPuestos();
        verify(puestoService, times(1)).getTodosPuestos();
    }




}
