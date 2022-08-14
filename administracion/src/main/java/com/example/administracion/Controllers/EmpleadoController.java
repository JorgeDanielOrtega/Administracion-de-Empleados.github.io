package com.example.administracion.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.administracion.Models.Persona;
import com.example.administracion.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.administracion.Services.EmpleadoService;
import com.example.administracion.Services.TrabajadorService;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpleadoController {

    @Autowired
    private PersonaService personaService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private TrabajadorService trabajadorService;

//    @GetMapping() //To know what operation shall execute when recive method get
//    public ArrayList<Long> getEmpleados() {
//        return (ArrayList<Long>) empleadoService.getIdTrabajador();
//    }
    @GetMapping()
    public List<Persona> personaList() {
        return (List<Persona>) personaService.listarPersonas();
    }
    @GetMapping
    public ArrayList<Long> getEmpleados() {
        return (ArrayList<Long>) empleadoService.getIdsTrabajador();
    }

//    We could use PostMapping to save information
//    @GetMapping("/listar")
//    public String listar(Model model){
//        List<Persona> personas = personaService.listarPersonas();
//        model.addAttribute("personas", personas);
//        return "index";
//    }
}
