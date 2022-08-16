package com.example.administracion.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.administracion.Models.Decimo;
import com.example.administracion.Models.Empresa;
import com.example.administracion.Repositories.DecimoRepository;

public class DecimoServiceTest {

    @Mock
    DecimoRepository decimoRepository;

    @InjectMocks
    DecimoService decimoService;
    Empresa empresa;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        empresa = new Empresa();
    }

    @Test
    public void getDecimos() {
        assertNotNull(decimoService.getDecimos());
    }

    @Test
    public void saveDecimo() {
        when(decimoRepository.save(new Decimo())).thenReturn(new Decimo());
    }

}
