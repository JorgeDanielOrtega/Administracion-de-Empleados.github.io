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

import com.example.administracion.Models.Asistencia;
import com.example.administracion.Services.AsistenciaService;
import com.example.administracion.Services.HorarioService;
import com.example.administracion.Services.TrabajadorService;

@ExtendWith(MockitoExtension.class)
public class PerfilControllerTest {

    @InjectMocks
    private PerfilController perfilController;


    @Mock
    TrabajadorService trabajadorService;

    @Mock
    AsistenciaService asistenciaService;
    @Mock
    HorarioService horarioService;

    @Test
    public void getTrabajador() {
        Map<String, Object> trabajador = new HashMap<String, Object>();

        when(trabajadorService.getTrabajadorInfo(2l)).thenReturn(trabajador);

        Map<String, Object> trabajadorResult = perfilController.getTrabajador(2l);

        verify(trabajadorService, times(1)).getTrabajadorInfo(2l);
    }

    @Test
    public void getAsistenciaByIdTrabajador() {
        ArrayList<Asistencia> asistencias = new ArrayList<>();

        when(asistenciaService.getAsistenciasByIdTrabajador(2l)).thenReturn(asistencias);

        ArrayList<Asistencia> asistenciasResult = perfilController.getAsistenciaByIdTrabajador(2l);

        verify(asistenciaService, times(1)).getAsistenciasByIdTrabajador(2l);
    }

    @Test
    public void getHorarioPorIdTrabajador() {
        Map<String, Object> horario = new HashMap<String, Object>();

        when(horarioService.getFullHorarioById(0l)).thenReturn(horario);

        Map<String, Object> horarioResult = perfilController.getHorarioPorIdTrabajador(0l);

        verify(horarioService, times(1)).getFullHorarioById(0l);
    }

}