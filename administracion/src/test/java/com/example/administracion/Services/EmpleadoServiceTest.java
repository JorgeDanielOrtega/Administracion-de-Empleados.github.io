package com.example.administracion.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.example.administracion.Models.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.administracion.Repositories.EmpleadoRepository;

import java.util.ArrayList;
import java.util.LinkedList;

public class EmpleadoServiceTest {

    @Mock
    EmpleadoRepository empleadoRepository;
    @Mock
    TrabajadorService trabajadorService;
    @Mock
    PersonaService personaService;

    @InjectMocks
    EmpleadoService empleadoService;

    private Empleado empleado;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        empleado = new Empleado();
    }
    @Test
    public void eliminarEmpleadoPorId(){
        assertNotNull(empleadoService.eliminarEmpleadoPorId(empleado.getId()));
    }
    @Test
    public void obtenerEmpleadosTable(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        when(empleadoRepository.findAll()).thenReturn(empleados);
        assertNotNull(empleadoService.obtenerEmpleadosTable());
    }
    @Test
    public void guardarEmpleado(){
        when(empleadoRepository.save(empleado)).thenReturn(empleado);
        assertNotNull(empleadoService.guardarEmpleado(empleado));
    }
    @Test
    public void getIdsTrabajador() {
        assertNotNull(empleadoService.getIdsTrabajador());

    }

}
