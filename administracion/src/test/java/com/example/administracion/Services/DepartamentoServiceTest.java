package com.example.administracion.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import com.example.administracion.Models.Contrato;
import org.junit.jupiter.api.Assertions;
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
    public void eliminarDepartamento(){
        assertNotNull(departamentoService.eliminarDepartamento(1l));
    }
    @Test
    public void guardarDepartamento(){
        Departamento depa = new Departamento((long) 1,"Turismo",12,12,12,(long)1);
        Departamento depa2 = new Departamento((long) 1,"Turismo",12,12,12,(long)1);
        when(departamentoRepository.save(depa)).thenReturn(depa);
        Departamento resultado = departamentoService.guardarDepartamento(depa);
        Assertions.assertEquals(depa.getId(), resultado.getId());
        Assertions.assertEquals(depa.getNombre(), resultado.getNombre());
    }

    @Test
    public void getTodosDepartamentos(){
        ArrayList<Departamento> departamentos = new ArrayList<>();
        departamentos.add(departamento);
        when(departamentoRepository.findAll()).thenReturn(departamentos);
        assertNotNull(departamentoService.getTodosDepartamentos());
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
