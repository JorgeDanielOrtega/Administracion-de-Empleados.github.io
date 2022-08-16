package com.example.administracion.Services;

import com.example.administracion.Models.Gerente;
import com.example.administracion.Repositories.GerenteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


public class GerenteServiceTest {
    @Mock
    GerenteRepository gerenteRepository;
    @InjectMocks
    GerenteService gerenteService;
    private Gerente gerente;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        gerente = new Gerente();
    }

    @Test
    public void guardarGerente(){
        when(gerenteRepository.save(gerente)).thenReturn(gerente);
        assertNotNull(gerenteService.guardarGerente(gerente));
    }
    @Test
    public void obtenerGerentes(){
        ArrayList<Gerente> gerentes = new ArrayList<>();
        gerentes.add(gerente);
        when(gerenteRepository.findAll()).thenReturn(gerentes);
        assertNotNull(gerenteService.obtenerGerentes());
    }
}
