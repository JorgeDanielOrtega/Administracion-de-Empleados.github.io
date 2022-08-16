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
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class AsistenciaControllerTest {

    @InjectMocks
    private AsistenciaController asistenciaController;

    @Mock
    AsistenciaService asistenciaService;


    @Test
    public void getAllAsistencias(){
        ArrayList<Asistencia> asistencias = new ArrayList<>();
        when(asistenciaService.getAllAsistencias()).thenReturn(asistencias);
        ArrayList<Asistencia> asistenciasResult = asistenciaController.getAllAsistencias();
        verify(asistenciaService, times(1)).getAllAsistencias();
    }
    @Test
    public void getAsistenciasByIdTrabajador() {
        ArrayList<Asistencia> asistencias = new ArrayList<>();

        when(asistenciaService.getAsistenciasByIdTrabajador(2l)).thenReturn(asistencias);

        ArrayList<Asistencia> asistenciasResult = asistenciaController.getAsistenciasByIdTrabajador(2l);

        verify(asistenciaService, times(1)).getAsistenciasByIdTrabajador(2l);
    }
    @Test
    public void saveAsistencia(){
        Asistencia asistencia = new Asistencia(1l);
        when(asistenciaService.saveAsistencia(asistencia)).thenReturn(asistencia);
        Asistencia resultAsistencia = asistenciaController.saveAsistencia(1l, asistencia);
        verify(asistenciaService, times(1)).saveAsistencia(asistencia);
    }
    @Test
    public void guardarAsistencia(){
        Asistencia asistencia = new Asistencia(1l);
        when(asistenciaService.saveAsistencia(asistencia)).thenReturn(asistencia);
        ResponseEntity<Asistencia> resultAsist = asistenciaController.guardarAsistencia(asistencia);
        verify(asistenciaService, times(1)).saveAsistencia(asistencia);
    }
}
