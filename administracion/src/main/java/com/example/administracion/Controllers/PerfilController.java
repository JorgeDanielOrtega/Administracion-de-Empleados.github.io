package com.example.administracion.Controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.administracion.Services.EmpleadoService;
import com.example.administracion.Services.PersonaService;
import com.example.administracion.Services.TrabajadorService;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    TrabajadorService trabajadorService;
    @Autowired
    PersonaService personaService;

    @GetMapping("/{id}")
    public Map<String, Object> getEmpleado(@PathVariable("id") Long id){
        //TODO investigar como mandar un mensaje si no se encuentra el empleado
        return  trabajadorService.getTrabajadorInfo(id);
    }

}
