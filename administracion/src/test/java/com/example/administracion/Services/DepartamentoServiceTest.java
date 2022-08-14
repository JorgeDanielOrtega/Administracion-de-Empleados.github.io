package com.example.administracion.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.administracion.Models.Departamento;
import com.example.administracion.Repositories.DepartamentoRepository;

public class DepartamentoServiceTest {

    @Mock
    DepartamentoRepository departamentoRepository;

    @InjectMocks
    DepartamentoService departamentoService;

    private Departamento departamento;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        departamento = new Departamento();
    }

    @Test
    public void getIdDepartamentoByNombre() {
        when(departamentoRepository.findByNombre(anyString())).thenReturn(departamento);
        assertSame(departamentoService.getIdDepartamentoByNombre(anyString()), null);
    }

    @Test
    public void getDepartamentoById() {
        when(departamentoRepository.findById(anyLong())).thenReturn(Optional.of(departamento));
        assertNotNull(departamentoService.getDepartamentoById(anyLong()));
    }

    @Test
    public void getAllNombreDepartamentosSinRepetir() {
        ArrayList<HashMap<String, Object>> nombresDepartamentoList = new ArrayList<>();
        when(departamentoService.getAllNombreDepartamentosSinRepetir()).thenReturn(nombresDepartamentoList);
        assertNotNull(departamentoService.getAllNombreDepartamentosSinRepetir());
    }

}
