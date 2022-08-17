package com.example.administracion.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.administracion.Models.Persona;
import com.example.administracion.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.HashMap;

import com.example.administracion.Models.Contrato;
import com.example.administracion.Models.Empleado;
import com.example.administracion.Models.Persona;
import com.example.administracion.Models.Trabajador;
import com.example.administracion.Services.ContratoService;
import com.example.administracion.Services.PersonaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.administracion.Models.Empleado;
import com.example.administracion.Repositories.EmpleadoRepository;
import com.example.administracion.Services.EmpleadoService;
import com.example.administracion.Services.TrabajadorService;

@RestController
//@RequestMapping("/persona")
@RequestMapping("/empleados")
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


    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    ContratoService contratoService;

    @GetMapping()
    public List<Persona> personaList() {
        return (List<Persona>) personaService.listarPersonas();

    }
    @GetMapping("/all")
        public ArrayList<HashMap<String, Object>> getEmpleados(){
            return empleadoService.getTodosEmpleados();
    }

    @GetMapping("/table")
    public ArrayList<Empleado> obtenerEmpleadosTabla(){
        return empleadoService.obtenerEmpleadosTable();
    }
    @GetMapping("/personas")
    public ArrayList<Persona> obtenerPersonas(){
        return personaService.obtenerPersonas();
    }
    @GetMapping("/trabajadores")
    public ArrayList<Trabajador> obtenerTrabajador(){
        return trabajadorService.obtenerTodosTrabajadores();
    }
    @GetMapping("/contratos")
    public ArrayList<Contrato> obtenerContratos(){
        return contratoService.getAllContratos();
    }

    @PostMapping(value = "/guardarPersona")
    public ResponseEntity<Persona> guardarPersona (@RequestBody Persona persona){
        Persona obj = personaService.guardarPersona(persona);
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }
    @PostMapping(value = "/guardarTrabajador")
    public ResponseEntity<Trabajador> guardarTrabajador(@RequestBody Trabajador trabajador){
        Trabajador obj = trabajadorService.guardarTrabajador(trabajador);
        return new ResponseEntity<Trabajador>(obj, HttpStatus.OK);
    }

    @PostMapping(value = "/guardarEmpleado")
    public ResponseEntity<Empleado> guardarEmpleado (@RequestBody Empleado empleado){
        Empleado obj = empleadoService.guardarEmpleado(empleado);
        return new ResponseEntity<Empleado>(obj, HttpStatus.OK);
    }
    @PostMapping(value = "/guardarContrato")
    public ResponseEntity<Contrato> guardarContrato (@RequestBody Contrato contrato){
        Contrato obj = contratoService.guardarContrato(contrato);
        return new ResponseEntity<Contrato>(obj, HttpStatus.OK);
    }
    @GetMapping(value= "/eliminarPersona/{id}")
    public ResponseEntity<Persona> eliminarPersona(@PathVariable Long id){
        // Persona persona = personaService.getPersonaById(id);
        Persona persona = personaService.getPersonaById(id).get();
        if(persona != null){
            personaService.eliminarPersonaPorId(id);
        }else{
            return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }
    @GetMapping(value= "/eliminarTrabajador/{id}")
    public ResponseEntity<Trabajador> eliminarTrabajador(@PathVariable Long id){
        Trabajador trabajador = trabajadorService.getTrabajorById(id);
        if(trabajador != null){
            trabajadorService.eliminarTrabajadorPorId(id);
        }else{
            return new ResponseEntity<Trabajador>(trabajador, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Trabajador>(trabajador, HttpStatus.OK);
    }
    @GetMapping(value= "/eliminarEmpleado/{id}")
    public ResponseEntity<Empleado> eliminarEmpleado(@PathVariable Long id){
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if(empleado != null){
            empleadoService.eliminarEmpleadoPorId(id);
        }else{
            return new ResponseEntity<Empleado>(empleado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
    }
    @GetMapping(value= "/eliminarContrato/{id}")
    public ResponseEntity<Contrato> eliminarContrato(@PathVariable Long id){
        Contrato contrato = contratoService.getIdContrato(id);
        if(contrato != null){
            contratoService.eliminarContratoPorId(id);
        }else{
            return new ResponseEntity<Contrato>(contrato, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Contrato>(contrato, HttpStatus.OK);
    }

    @GetMapping("{idTrabajador}")
    public Empleado getEmpleadoByIdTrabajador(@PathVariable("idTrabajador") Long idTrabajador) {
        return empleadoRepository.findAllByIdTrabajador(idTrabajador);
    }
    @GetMapping("/ids")
    public ArrayList<Long> getIdEmpleados() {
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
