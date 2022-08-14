package com.example.administracion.Controllers;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.administracion.Models.Empresa;
import com.example.administracion.Services.EmpresaService;

@RestController()
@RequestMapping("/empresa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping()
    public Empresa getEmpresaById() {
        return empresaService.getEmpresaById().get();
    }

    @GetMapping("/id")
    public Time getHoraEntredaEmpresa(){
        return empresaService.getHoraEntredaEmpresa();
    }

}
