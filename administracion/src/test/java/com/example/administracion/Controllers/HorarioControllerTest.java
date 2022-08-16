package com.example.administracion.Controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.administracion.Services.HorarioService;

@ExtendWith(MockitoExtension.class)
public class HorarioControllerTest {

    @InjectMocks
    private HorarioController horarioController;

    @Mock
    HorarioService horarioService;

    @Test
    public void getNombresHorario() {
        ArrayList<HashMap<String, Object>> horarios = new ArrayList<>();

        when(horarioService.getNombresHorariosSinRepetir()).thenReturn(horarios);

        ArrayList<HashMap<String, Object>> horariosResult = horarioController.getNombresHorario();

        verify(horarioService, times(1)).getNombresHorariosSinRepetir();
    }

    
}