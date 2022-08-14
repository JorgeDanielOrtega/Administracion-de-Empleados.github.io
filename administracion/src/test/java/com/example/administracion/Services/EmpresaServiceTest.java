package com.example.administracion.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.administracion.Models.Empresa;
import com.example.administracion.Repositories.EmpresaRepository;

public class EmpresaServiceTest {

    @Mock
    EmpresaRepository empresaRepository;

    @InjectMocks
    EmpresaService empresaService;
    Empresa empresa;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        empresa = new Empresa();
    }

    @Test
    public void getEmpresaById() {
        when(empresaRepository.findById(anyLong())).thenReturn(Optional.of(empresa));

        assertNotNull(empresaService.getEmpresaById());
    }

}
