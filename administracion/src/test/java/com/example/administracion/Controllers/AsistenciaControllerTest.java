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

import com.example.administracion.Models.Asistencia;
import com.example.administracion.Services.AsistenciaService;

@ExtendWith(MockitoExtension.class)
public class AsistenciaControllerTest {

    @InjectMocks
    private AsistenciaController asistenciaController;

    @Mock
    AsistenciaService asistenciaService;

    @Test
    public void getAsistenciasByIdTrabajador() {
        ArrayList<Asistencia> asistencias = new ArrayList<>();

        when(asistenciaService.getAsistenciasByIdTrabajador(2l)).thenReturn(asistencias);

        ArrayList<Asistencia> asistenciasResult = asistenciaController.getAsistenciasByIdTrabajador(2l);

        verify(asistenciaService, times(1)).getAsistenciasByIdTrabajador(2l);
    }


}
