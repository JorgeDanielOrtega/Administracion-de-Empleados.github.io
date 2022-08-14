package com.example.administracion.Controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.administracion.Models.Decimo;
import com.example.administracion.Services.DecimoService;

@RestController
@RequestMapping("/decimo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DecimoController {

    @Autowired
    DecimoService decimoService;

    @GetMapping()
    public ArrayList<Map<String, Object>> getDecimos() {
        return decimoService.getDecimos();
    }

    @PostMapping()
    public Decimo saveDecimo(@RequestBody Decimo decimo) {
        return decimoService.saveDecimo(decimo);
    }

}
