package com.example.administracion.Controllers;

import java.util.ArrayList;

import com.example.administracion.Models.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.administracion.Models.Asistencia;
import com.example.administracion.Services.AsistenciaService;

@RestController
@RequestMapping("/asistencia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AsistenciaController {

    @Autowired
    AsistenciaService asistenciaService;

    @GetMapping("/all")
    public ArrayList<Asistencia> getAllAsistencias(){
        return asistenciaService.getAllAsistencias();
    }
    @GetMapping("/{id}")
    public ArrayList<Asistencia> getAsistenciasByIdTrabajador(@PathVariable("id") Long id) {
        return asistenciaService.getAsistenciasByIdTrabajador(id);
    }

    @PostMapping("/{id}") //TODO queda pendiente mandarle el id por el body desde el front end, o algo asi  
    public Asistencia saveAsistencia(@PathVariable("id") Long id, @RequestBody Asistencia asistencia) {
        return asistenciaService.saveAsistencia(asistencia);
    }
    @PostMapping(value = "/guardarAsistencia")
    public ResponseEntity<Asistencia> guardarAsistencia (@RequestBody Asistencia asistencia) {
        Asistencia obj = asistenciaService.saveAsistencia(asistencia);
        return new ResponseEntity<Asistencia>(obj, HttpStatus.OK);
    }
}
