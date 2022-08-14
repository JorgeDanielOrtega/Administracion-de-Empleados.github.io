package com.example.administracion.Controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.administracion.Services.DepartamentoService;
import com.example.administracion.Services.TrabajadorService;

@ExtendWith(MockitoExtension.class)
public class DepartamentoControllerTest {

    @InjectMocks
    private DepartamentoController departamentoController;

    @Mock
    TrabajadorService trabajadorService;
    @Mock
    DepartamentoService departamentoService;

    @Test
    public void getEmpleadosByDepartamento() {
        ArrayList<Map<String, Object>> empleados = new ArrayList<>();

        when(trabajadorService.getTrabajadorByIdDepartamento(2l)).thenReturn(empleados);

        ArrayList<Map<String, Object>> empleadosResult = departamentoController.getEmpleadosByDepartamento(2l);

        verify(trabajadorService, times(1)).getTrabajadorByIdDepartamento(2l);
    }

    @Test
    public void getNombres() {
        ArrayList<HashMap<String, Object>> nombres = new ArrayList<>();

        when(departamentoService.getAllNombreDepartamentosSinRepetir()).thenReturn(nombres);

        ArrayList<HashMap<String, Object>> nombresResult = departamentoController.getNombres();

        verify(departamentoService, times(1)).getAllNombreDepartamentosSinRepetir();
    }


}
