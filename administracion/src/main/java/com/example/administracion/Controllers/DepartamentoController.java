package com.example.administracion.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.administracion.Models.Departamento;
import com.example.administracion.Models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.administracion.Services.DepartamentoService;
import com.example.administracion.Services.TrabajadorService;

@RestController
@RequestMapping("/departamento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartamentoController {
    @Autowired
    TrabajadorService trabajadorService;
    @Autowired
    DepartamentoService departamentoService;

    // @GetMapping( path = "nombre/{idDepartamento}")
    // public ArrayList<Map<String, Object>>
    // getEmpleadosByDepartamento(@PathVariable("idDepartamento") Long
    // idDepartamento) {
    // return trabajadorService.getTrabajadorByIdDepartamento(idDepartamento);
    // }

    @GetMapping("")
    public ArrayList<HashMap<String, Object>> obtenetUsuariosPorNombre() {
        return departamentoService.getAllNombreDepartamentosSinRepetir();
    }

    @GetMapping("/all")
    public ArrayList<Departamento> obtenerTodosDepartamentos() {

        return departamentoService.getTodosDepartamentos();
    }

    @GetMapping(path = "/{id}")
    public Optional<Departamento> obtenerDepartementoId(@PathVariable("id") Long id) {
        return departamentoService.obtenerDepartamentoBarraBusqueda(id);
    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<Departamento> guardar(@RequestBody Departamento departamento) {
        Departamento obj = departamentoService.guardarDepartamento(departamento);
        return new ResponseEntity<Departamento>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/eliminar/{id}")
    public ResponseEntity<Departamento> eliminar(@PathVariable Long id) {
        Departamento departamento = departamentoService.getDepartamentoById(id);
        if (departamento != null) {
            departamentoService.eliminarDepartamento(id);
        } else {
            return new ResponseEntity<Departamento>(departamento, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
    }

}
