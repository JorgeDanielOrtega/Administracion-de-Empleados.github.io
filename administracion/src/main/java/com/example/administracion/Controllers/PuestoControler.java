package com.example.administracion.Controllers;

import com.example.administracion.Models.Puesto;
import com.example.administracion.Repositories.PuestoRepository;
import com.example.administracion.Services.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/puesto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PuestoControler {
    @Autowired
    PuestoService puestoService;

    @GetMapping("/all")
    public ArrayList<Puesto> obtenerTodosPuestos(){
        return puestoService.getTodosPuestos();
    }
    @GetMapping("/nombres")
    public ArrayList<HashMap<String, Object>> obtenerNombers(){
        return puestoService.getAllNombrePuestosSinRepetir();

    }
}
