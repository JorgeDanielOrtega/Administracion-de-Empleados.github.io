package com.example.administracion.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.administracion.Models.Horario;
import com.example.administracion.Repositories.HorarioRepository;
import com.example.administracion.Repositories.HorariosDiasLaborablesRepository;

public class HorarioServiceTest {

    @Mock
    HorarioRepository horarioRepository;
    @Mock
    HorariosDiasLaborablesRepository horariosDiasLaborablesRepository;

    @InjectMocks
    HorarioService horarioService;

    Horario horario;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        horario = new Horario();
    }

    @Test
    public void getHorarioById() {
        when(horarioRepository.findById(anyLong())).thenReturn(Optional.of(horario));
        assertNotNull(horarioService.getHorarioById(anyLong()));
    }

    @Test
    public void getIdHorarioByTipo() {
        when(horarioRepository.findByTipo(anyString())).thenReturn(horario);

        assertSame(horarioService.getIdHorarioByTipo(anyString()), null);
    }

    @Test
    public void getNombresHorariosSinRepetir() {
        ArrayList<HashMap<String, Object>> nombresHorarioList = new ArrayList<>();

        when(horarioService.getNombresHorariosSinRepetir()).thenReturn(nombresHorarioList);

        assertNotNull(horarioService.getNombresHorariosSinRepetir());
    }

    @Test
    public void getFullHorarioById() {

        assertNotNull(horarioService.getFullHorarioById(anyLong()));
    }

}
