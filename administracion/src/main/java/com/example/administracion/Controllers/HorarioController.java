package com.example.administracion.Controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.administracion.Services.HorarioService;

@RestController
@RequestMapping("/horario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HorarioController {
    @Autowired
    HorarioService horarioService;

    @GetMapping
    public ArrayList<HashMap<String, Object>> getNombresHorario() {
        return horarioService.getNombresHorariosSinRepetir();
    }
}
