package com.example.administracion.Services;

import com.example.administracion.Models.Contrato;
import com.example.administracion.Repositories.ContratoRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ContratoServiceTest {
    @Mock
    private ContratoRepository contratoRepository;
    @InjectMocks
    private ContratoService contratoService;
    private Contrato contrato;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        contrato = new Contrato();
    }
    @Test
    public void getAllContratos(){
        ArrayList<Contrato> contratos = new ArrayList<>();
        contratos.add(contrato);
        when(contratoRepository.findAll()).thenReturn(contratos);
        assertNotNull(contratoService.getAllContratos());
    }
    @Test
    public void guardarContrato(){
        Contrato c1 = new Contrato(1l);
        Contrato esperado = new Contrato( 1l);
        when(contratoRepository.save(c1)).thenReturn(c1);
        Contrato resultado = contratoService.guardarContrato(c1);
        Assertions.assertEquals(c1.getId(), resultado.getId());
    }
    @Test
    public void eliminarContratoPorId(){
        assertNotNull(contratoService.eliminarContratoPorId(1l));
    }
}
