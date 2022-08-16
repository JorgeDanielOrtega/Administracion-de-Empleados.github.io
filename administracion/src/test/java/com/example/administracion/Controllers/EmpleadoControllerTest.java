package com.example.administracion.Controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.administracion.Models.*;
import com.example.administracion.Services.ContratoService;
import com.example.administracion.Services.PersonaService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.administracion.Services.EmpleadoService;
import com.example.administracion.Services.TrabajadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class EmpleadoControllerTest {

    @InjectMocks
    private EmpleadoController empleadoController;

    @Mock
    private EmpleadoService empleadoService;
    @Mock
    private TrabajadorService trabajadorService;
    @Mock
    private PersonaService personaService;
    @Mock
    private ContratoService contratoService;

    @Test
    public void getEmpleados() {
        ArrayList<Long> ids = new ArrayList<>();

        when(empleadoService.getIdsTrabajador()).thenReturn(ids);

        ArrayList<Long> empleadoResult = empleadoController.getIdEmpleados();

        verify(empleadoService, times(1)).getIdsTrabajador();
    }

    //    @Test
//    public void personaList(){
//        List<Persona> personas = new List<Persona>;
//        when(personaService.listarPersonas()).thenReturn(personas);
//        List<Persona> personasResult = empleadoController.personaList();
//        verify(personaService, times(1)).listarPersonas();
//    }
    @Test
    public void obtenerEmpleadosTabla() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        when(empleadoService.obtenerEmpleadosTable()).thenReturn(empleados);
        ArrayList<Empleado> empleadosResult = empleadoController.obtenerEmpleadosTabla();
        verify(empleadoService, times(1)).obtenerEmpleadosTable();
    }

    @Test
    public void obtenerPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();
        when(personaService.obtenerPersonas()).thenReturn(personas);
        ArrayList<Persona> personasResult = empleadoController.obtenerPersonas();
        verify(personaService, times(1)).obtenerPersonas();
    }

    @Test
    public void obtenerTrabajador() {
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        when(trabajadorService.obtenerTodosTrabajadores()).thenReturn(trabajadores);
        ArrayList<Trabajador> trabajadorResul = empleadoController.obtenerTrabajador();
        verify(trabajadorService, times(1)).obtenerTodosTrabajadores();
    }

    @Test
    public void obtenerContratos() {
        ArrayList<Contrato> contratos = new ArrayList<>();
        when(contratoService.getAllContratos()).thenReturn(contratos);
        ArrayList<Contrato> contratosResult = empleadoController.obtenerContratos();
        verify(contratoService, times(1)).getAllContratos();
    }

    @Test
    public void guardarPersona() {
        Persona p = new Persona(1l);
        when(personaService.guardarPersona(p)).thenReturn(p);
        ResponseEntity<Persona> resultP = empleadoController.guardarPersona(p);
        verify(personaService, times(1)).guardarPersona(p);
    }

    @Test
    public void guardarTrabajador() {
        Trabajador t = new Trabajador();
        when(trabajadorService.guardarTrabajador(t)).thenReturn(t);
        ResponseEntity<Trabajador> resultT = empleadoController.guardarTrabajador(t);
        verify(trabajadorService, times(1)).guardarTrabajador(t);
    }
    @Test
    public void guardarEmpleado(){
        Empleado e = new Empleado();
        when(empleadoService.guardarEmpleado(e)).thenReturn(e);
        ResponseEntity<Empleado> resultE = empleadoController.guardarEmpleado(e);
        verify(empleadoService, times(1)).guardarEmpleado(e);
    }
    @Test
    public void guardarContrato(){
        Contrato c = new Contrato();
        when(contratoService.guardarContrato(c)).thenReturn(c);
        ResponseEntity<Contrato> resultC = empleadoController.guardarContrato(c);
        verify(contratoService, times(1)).guardarContrato(c);
    }
    @Test
    public void eliminarPersona(){
        Persona p = new Persona(1l);
        if(p != null){
            personaService.eliminarPersonaPorId(p.getId());
        }else{
            ResponseEntity<Persona> result = new ResponseEntity<Persona>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        verify(personaService, times(1)).eliminarPersonaPorId(p.getId());

    }
    @Test
    public void eliminarTrabajador(){
        Trabajador t = new Trabajador();
        if( t != null){
            trabajadorService.eliminarTrabajadorPorId(t.getId());
        }else{
            ResponseEntity<Trabajador> result = new ResponseEntity<Trabajador>(t, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        verify(trabajadorService, times(1)).eliminarTrabajadorPorId(t.getId());
    }
    @Test
    public void eliminarEmpleado(){
        Empleado e = new Empleado();
        if (e != null){
            empleadoService.eliminarEmpleadoPorId(e.getId());
        }else{
            ResponseEntity<Empleado> result = new ResponseEntity<Empleado>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        verify(empleadoService, times(1)).eliminarEmpleadoPorId(e.getId());

    }
    @Test
    public void eliminarContrato(){
        Contrato c = new Contrato();
        if(c != null){
            contratoService.eliminarContratoPorId(c.getId());
        }else{
            ResponseEntity<Contrato> result = new ResponseEntity<Contrato>(c, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        verify(contratoService, times(1)).eliminarContratoPorId(c.getId());

    }
    @Test
    public void getEmpleadoByIdTrabajador(){

    }
    @Test
    public void getIdEmpleados(){

    }
}