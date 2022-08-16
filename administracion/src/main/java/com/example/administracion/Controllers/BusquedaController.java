package com.example.administracion.Controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.administracion.Repositories.TrabajadorRepository;

import com.example.administracion.Services.DepartamentoService;
import com.example.administracion.Services.TrabajadorService;

@RestController
@RequestMapping("/busqueda")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BusquedaController {

    @Autowired
    TrabajadorService trabajadorService;
    @Autowired
    DepartamentoService departamentoService;

    public ArrayList<Map<String, Object>> getTrabajadores() { // Todo cambiar nombre despues
        return trabajadorService.getTrabajadorForBusqueda();
        
    }

    @GetMapping("/by")
    public ArrayList<Map<String, Object>> getTrabajadorPrueba(
            @RequestParam(value = "departamento", required = false) String departamento,
            @RequestParam(value = "rol", required = false) String rol,
            @RequestParam(value = "horario", required = false) String horario,
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "nombreApellido", required = false) String nombreApellido) {
        return trabajadorService.getTrabajadoresByFields(departamento, rol, horario, id, nombreApellido);
    }
}
