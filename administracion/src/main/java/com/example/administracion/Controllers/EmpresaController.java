package com.example.administracion.Controllers;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Optional;

import com.example.administracion.Models.Departamento;
import com.example.administracion.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.administracion.Models.Empresa;
import com.example.administracion.Repositories.EmpresaRepository;

import javax.swing.text.html.Option;


@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    EmpresaService empresaService;
//    @GetMapping()
//    public Empresa getEmpresaById() {
//        return empresaRepository.findById(1l).get();
//    }

    @GetMapping("")
    public ArrayList<Empresa> obtenerEmpresas(){
        return empresaService.obtenerEmpresas();
    }
    @GetMapping(path = "/{id}")
    public Optional<Empresa> obtenerEmpresaId(@PathVariable("id") Long id){
        return empresaService.obtenerEmpresaId(id);
    }


//    @GetMapping("/id")
//    public Time getHoraEntredaEmpresa(){
//        return getEmpresaById().getHoraEntrada();
//    }

}
