package com.example.administracion.Controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.administracion.Services.DepartamentoService;
import com.example.administracion.Services.TrabajadorService;

@ExtendWith(MockitoExtension.class)
public class BusquedaControllerTest {

    @InjectMocks
    private BusquedaController busquedaController;

    @Mock
    TrabajadorService trabajadorService;
    @Mock
    DepartamentoService departamentoService;

    @Test
    public void getTrabajadores() {
        ArrayList<Map<String, Object>> trabajadores = new ArrayList<>();

        when(trabajadorService.getTrabajadorForBusqueda()).thenReturn(trabajadores);

        ArrayList<Map<String, Object>> trabajadoresResult = busquedaController.getTrabajadores();

        verify(trabajadorService, times(1)).getTrabajadorForBusqueda();
    }

    @Test
    public void getTrabajadorPrueba() {
        ArrayList<Map<String, Object>> trabajadores = new ArrayList<>();

        when(trabajadorService.getTrabajadoresByFields(null, null, null, null, null)).thenReturn(trabajadores);

        ArrayList<Map<String, Object>> trabajadoresResult = busquedaController.getTrabajadorPrueba(null, null, null,
                null, null);

        verify(trabajadorService, times(1)).getTrabajadoresByFields(null, null, null, null, null);
    }

}
