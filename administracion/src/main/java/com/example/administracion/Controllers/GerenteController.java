package com.example.administracion.Controllers;

import com.example.administracion.Models.Gerente;
import com.example.administracion.Services.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/gerente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GerenteController {
    @Autowired
    GerenteService gerenteService;

    @GetMapping("/all")
    public ArrayList<Gerente> obtenerGerentes(){
        return gerenteService.obtenerGerentes();
    }
    @PostMapping(value = "/guardarGerente")
    public ResponseEntity<Gerente> guardarGerente (@RequestBody Gerente gerente){
        Gerente obj = gerenteService.guardarGerente(gerente);
        return new ResponseEntity<Gerente>(obj, HttpStatus.OK);
    }
}
