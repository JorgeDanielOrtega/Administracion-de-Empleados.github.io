package com.example.administracion.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.administracion.Models.Asistencia;
import com.example.administracion.Repositories.AsistenciaRepository;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AsistenciaServiceTest {

    @Mock
    AsistenciaRepository asistenciaRepository;

    @InjectMocks
    AsistenciaService asistenciaService;

    private Asistencia asistencia;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        asistencia = new Asistencia();
    }

    @Test
    public void getAllAsistencias(){
        ArrayList<Asistencia> asistencias = new ArrayList<>();
        asistencias.add(asistencia);
        when(asistenciaRepository.findAll()).thenReturn(asistencias);
        assertNotNull(asistenciaService.getAllAsistencias());
    }
    @Test
    public void getAsistenciasByIdTrabajador() {
        ArrayList<Asistencia> asistencias = new ArrayList<>();
        asistencias.add(asistencia);
        when(asistenciaRepository.findAllByIdTrabajador(1l)).thenReturn(asistencias);
        assertNotNull(asistenciaService.getAsistenciasByIdTrabajador(1l));
    }

    @Test
    public void saveAsistencia() {
        
        when(asistenciaRepository.save(asistencia)).thenReturn(asistencia);
        assertNotNull(asistenciaService.saveAsistencia(asistencia));
    }

}
