package com.example.administracion.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.administracion.Models.Horario;
import com.example.administracion.Models.Persona;
import com.example.administracion.Models.Trabajador;
import com.example.administracion.Repositories.TrabajadorRepository;

public class TrabajadorServiceTest {

    @Mock
    TrabajadorRepository trabajadorRepository;
    @Mock
    DepartamentoService departamentoService;
    @Mock
    PersonaService personaService;
    @Mock
    RolService rolService;
    @Mock
    HorarioService horarioService;
    @Mock
    EntityManager entityManager;

    @InjectMocks
    TrabajadorService trabajadorService;

    Trabajador trabajador;
    Persona persona;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        trabajador = new Trabajador();
        trabajador.setCorreoEmpresarial("correoEmpresarial");
        trabajador.setCorreoPersonal("correoPersonal");
        trabajador.setUsuario("usuario");
        trabajador.setPassword("password");
        trabajador.setIdDepartamento(1l);
        trabajador.setIdRol(1l);
        trabajador.setIdHorario(1l);
        trabajador.setId(1l);

        persona = new Persona();
        persona.setNombre("a");
        persona.setApellido("a");
        persona.setDireccion("a");
        persona.setEstadoCivil("a");
        persona.setCedula("a");
        persona.setCiudad("a");
        persona.setTelefono("a");
        persona.setSexo('M');
        persona.setAnioEntrada(new Date(2000, 10, 21));
        persona.setFechaNacimiento(new Date(2000, 10, 21));

    }

    @Test
    public void getTrabajadores() {
        assertNotNull(trabajadorService.getTrabajadores(anyIterable()));
    }

    @Test
    public void getDatosEmpleado() {
        assertNotNull(trabajadorService.getDatosEmpleado(persona, trabajador));
    }

    @Test
    public void getIdHorarioByIdTrabajador() {
        when(trabajadorService.getTrabajadorById(3l)).thenReturn(Optional.of(trabajador));
        assertNotNull(trabajadorService.getIdHorarioByIdTrabajador(3l));
    }

    @Test
    public void getTrabajadorInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        // when(trabajadorService.getTrabajadorInfo(3l)).thenReturn(map);
        assertNotNull(trabajadorService.getTrabajadorInfo(3l));
    }

    @Test
    public void getTrabajadorById() {
        when(trabajadorRepository.findById(3l)).thenReturn(Optional.of(trabajador));
        assertNotNull(trabajadorService.getTrabajadorById(3l));
    }

    @Test
    public void getTrabajadorForBusqueda() {
        when(trabajadorRepository.findAll()).thenReturn(any(Iterable.class));

        assertNotNull(trabajadorService.getTrabajadorForBusqueda());

    }

    @Test
    public void getTrabajadoresByFields() {
        assertNotNull(trabajadorService.getTrabajadoresByFields(null, null, null, null, null));
    }

    @Test
    public void getHorarioOfTrabajador() {
        Horario horario = new Horario();
        when(horarioService.getHorarioById(anyLong())).thenReturn(Optional.of(horario));
        assertNotNull(trabajadorService.getHorarioOfTrabajador(anyLong()));
    }

    @Test
    public void getTrabajadorByIdDepartamento() {
        when(trabajadorRepository.findAllByIdDepartamento(anyLong())).thenReturn(new ArrayList<Trabajador>());
        assertNotNull(trabajadorService.getTrabajadorByIdDepartamento(anyLong()));
    }

    @Test
    public void getIdPersonaByNombresApellidos() {
        when(entityManager.createQuery(anyString())).thenReturn(any(Query.class));
        assertNotNull(trabajadorService.getIdPersonaByNombresApellidos("jo"));
    }

}
