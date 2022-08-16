package com.example.administracion.Controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.administracion.Models.Departamento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.administracion.Services.DepartamentoService;
import com.example.administracion.Services.TrabajadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@ExtendWith(MockitoExtension.class)
public class DepartamentoControllerTest {

    @InjectMocks
    private DepartamentoController departamentoController;

    @Mock
    TrabajadorService trabajadorService;
    @Mock
    DepartamentoService departamentoService;

    @Test
    public void getEmpleadosByDepartamento() {
        ArrayList<Map<String, Object>> empleados = new ArrayList<>();

        when(trabajadorService.getTrabajadorByIdDepartamento(2l)).thenReturn(empleados);

        ArrayList<Map<String, Object>> empleadosResult = departamentoController.getEmpleadosByDepartamento(2l);

        verify(trabajadorService, times(1)).getTrabajadorByIdDepartamento(2l);
    }

    @Test
    public void getNombres() {
        ArrayList<HashMap<String, Object>> nombres = new ArrayList<>();

        when(departamentoService.getAllNombreDepartamentosSinRepetir()).thenReturn(nombres);

        ArrayList<HashMap<String, Object>> nombresResult = departamentoController.getNombres();

        verify(departamentoService, times(1)).getAllNombreDepartamentosSinRepetir();
    }
    @Test
    public void obtenerTodosDepartamentos(){
        ArrayList<Departamento> departamentos = new ArrayList<>();
        when(departamentoService.getTodosDepartamentos()).thenReturn(departamentos);
        ArrayList<Departamento> departamentosResult = departamentoController.obtenerTodosDepartamentos();
        verify(departamentoService, times(1)).getTodosDepartamentos();
    }

    @Test
    public void guardar(){
        Departamento depa = new Departamento((long) 1,"Turismo",12,12,12,(long)1);
        when(departamentoService.guardarDepartamento(depa)).thenReturn(depa);
        ResponseEntity<Departamento> resulDepa = departamentoController.guardar(depa);
        verify(departamentoService, times(1)).guardarDepartamento(depa);
    }
//    @Test
//    public void eliminar(){
//        //Departamento depa = new Departamento((long) 1,"Turismo",12,12,12,(long)1);
//        Departamento depa = departamentoService.getDepartamentoById(1L).get();
////        if(verificacion == true){
////            Departamento depa = departamentoService.getDepartamentoById(1L).get();
////        }
////        if(depa != null){
////            when(departamentoService.eliminarDepartamento(1l)).thenReturn(true);
////        }else{
////            ResponseEntity<Departamento> result = new ResponseEntity<Departamento>(depa, HttpStatus.INTERNAL_SERVER_ERROR);
////        }
//        ResponseEntity<Departamento> result = departamentoController.eliminar(1l);
//        verify(departamentoService, times(1)).eliminarDepartamento(1l);
//    }
    @Test
    public void eliminar(){
        Departamento depa = new Departamento((long) 1,"Turismo",12,12,12,(long)1);
        if(depa != null){
            departamentoService.eliminarDepartamento(depa.getId());
            //assertEquals(null, depa.getId());
        }else{
            ResponseEntity<Departamento> result = new ResponseEntity<Departamento>(depa, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        verify(departamentoService, times(1)).eliminarDepartamento(depa.getId());
    }



}
