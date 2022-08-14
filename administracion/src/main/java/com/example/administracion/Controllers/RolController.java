package com.example.administracion.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import com.example.administracion.Models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.administracion.Services.RolService;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RolController {

    @Autowired
    RolService rolService;

    @GetMapping()
    public ArrayList<HashMap<String, Object>> getNombresRol() {
        return rolService.getAllNombreRolSinRepetir();
    }

    @GetMapping("/all")
    public ArrayList<Rol> obtenerTodosRoles() {
        return rolService.getTodosRoles();
    }

    @GetMapping(path = "/{id}")
    public Optional<Rol> obtenerIdPorId(@PathVariable("id") Long id) {
        return rolService.obtenerRolPorId(id);

    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<Rol> guardar(@RequestBody Rol rol){
        Rol obj = rolService.guardarRol(rol);
        return new ResponseEntity<Rol>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/eliminar/{id}")
    public ResponseEntity<Rol> eliminar(@PathVariable Long id){
        Rol rol = rolService.getRolById(id);
        if(rol != null){
            rolService.eliminarRolPorId(id);
        }else{
                return new ResponseEntity<Rol>(rol, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Rol>(rol, HttpStatus.OK);
    }

}
