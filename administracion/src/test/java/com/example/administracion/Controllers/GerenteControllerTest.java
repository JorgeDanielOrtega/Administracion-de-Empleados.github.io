package com.example.administracion.Controllers;

import com.example.administracion.Models.Gerente;
import com.example.administracion.Repositories.GerenteRepository;
import com.example.administracion.Services.EmpresaService;
import com.example.administracion.Services.GerenteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GerenteControllerTest {
    @InjectMocks
    private GerenteController gerenteController;
    @Mock
    private GerenteService gerenteService;

    @Test
    public void obtenerGerentes(){
        ArrayList<Gerente> gerentes = new ArrayList<>();
        when(gerenteService.obtenerGerentes()).thenReturn(gerentes);
        ArrayList<Gerente> gerenteList = gerenteController.obtenerGerentes();
        verify(gerenteService, times(1)).obtenerGerentes();
    }
    @Test
    public void guardarGerente(){
        Gerente g = new Gerente();
        when(gerenteService.guardarGerente(g)).thenReturn(g);
        ResponseEntity<Gerente> gerentList = gerenteController.guardarGerente(g);
        verify(gerenteService, times(1)).guardarGerente(g);
    }
}
