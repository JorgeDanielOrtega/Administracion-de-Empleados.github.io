package com.example.administracion.Controllers;

import java.util.ArrayList;
import java.util.Optional;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.administracion.Models.Empresa;
import com.example.administracion.Repositories.EmpresaRepository;
import com.example.administracion.Services.EmpresaService;

import com.example.administracion.Services.EmpresaService;

@RestController()
@RequestMapping("/empresa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    EmpresaService empresaService;
    // @GetMapping()
    // public Empresa getEmpresaById() {
    // return empresaRepository.findById(1l).get();
    // }

    @GetMapping("/empresas")
    public ArrayList<Empresa> obtenerEmpresas() {
        return empresaService.obtenerEmpresas();
    }

    @GetMapping(path = "/{id}")
    public Optional<Empresa> obtenerEmpresaId(@PathVariable("id") Long id) {
        return empresaService.obtenerEmpresaId(id);
    }

    @GetMapping("")
    public Empresa getEmpresaById() {
        // return empresaService.getEmpresaById();
        return empresaService.getEmpresaById().get();
    }

    @PostMapping("/actualizar")
    public Empresa actualizarEmpresaDb(@RequestBody Empresa empresa) {
        return empresaService.actualizarEmpresa(empresa);
    }

    // @GetMapping("/id")
    // public Time getHoraEntredaEmpresa(){
    // return getEmpresaById().getHoraEntrada();
    // }


    @GetMapping("/id")
    public Time getHoraEntredaEmpresa(){
        return empresaService.getHoraEntredaEmpresa();
    }

}
