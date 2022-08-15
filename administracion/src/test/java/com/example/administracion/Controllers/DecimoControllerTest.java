package com.example.administracion.Controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.administracion.Models.Decimo;
import com.example.administracion.Repositories.DecimoRepository;
import com.example.administracion.Services.DecimoService;

public class DecimoControllerTest {

    @InjectMocks
    DecimoController decimoController;

    @Mock
    DecimoService decimoService;

    @Mock
    DecimoRepository decimoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getDecimos() {
        when(decimoService.getDecimos()).thenReturn(new ArrayList<Map<String, Object>>());

        ArrayList<Map<String, Object>> decimos = decimoController.getDecimos();

        verify(decimoService, times(1)).getDecimos();
    }

    @Test
    public void saveDecimo() {

        Decimo decimo = new Decimo();

        when(decimoRepository.save(decimo)).thenReturn(decimo);

    }

}
