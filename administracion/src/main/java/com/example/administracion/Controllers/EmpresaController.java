package com.example.administracion.Controllers;

import java.sql.Time;
import java.util.Optional;

import com.example.administracion.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.administracion.Models.Empresa;
import com.example.administracion.Repositories.EmpresaRepository;

@RestController()
@RequestMapping("/empresa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping()
    public Empresa getEmpresaById() {
        return empresaService.getEmpresaById();
    }

    @PostMapping("actualizar")
    public Empresa actualizarEmpresaDb(@RequestBody Empresa empresa){
        return empresaService.actualizarEmpresa(empresa);
    }

    @GetMapping("/id")
    public Time getHoraEntredaEmpresa(){
        return getEmpresaById().getHoraEntrada();
    }

}
