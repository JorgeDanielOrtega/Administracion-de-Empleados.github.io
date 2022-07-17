package com.example.administracion.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
public class AsistenciaController {

    @Autowired
    AsistenciaService asistenciaService;

    @GetMapping("/{id}")
    public ArrayList<Asistencia> getAsistenciasByIdTrabajador(@PathVariable("id") Long id) {
        return asistenciaService.getAsistenciasByIdTrabajador(id);
    }

    @PostMapping("/{id}") //TODO queda pendiente mandarle el id por el body desde el front end, o algo asi
    public Asistencia saveAsistencia(@PathVariable("id") Long id, @RequestBody Asistencia asistencia) {
        return asistenciaService.saveAsistencia(asistencia);
    }
}
