package com.example.administracion.Controllers;

import java.sql.Time;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Optional;

import com.example.administracion.Models.Departamento;
import com.example.administracion.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
=======
import java.util.Optional;

import com.example.administracion.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> ffbccdb8b09493137b92efaa9ae21f08588a8f55
import org.springframework.web.bind.annotation.*;

import com.example.administracion.Models.Empresa;
import com.example.administracion.Repositories.EmpresaRepository;

import javax.swing.text.html.Option;


@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpresaController {

    @Autowired
<<<<<<< HEAD
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
=======
    EmpresaService empresaService;

    @GetMapping()
    public Empresa getEmpresaById() {
        return empresaService.getEmpresaById();
    }

    @PostMapping("actualizar")
    public Empresa actualizarEmpresaDb(@RequestBody Empresa empresa){
        return empresaService.actualizarEmpresa(empresa);
>>>>>>> ffbccdb8b09493137b92efaa9ae21f08588a8f55
    }


//    @GetMapping("/id")
//    public Time getHoraEntredaEmpresa(){
//        return getEmpresaById().getHoraEntrada();
//    }

}
