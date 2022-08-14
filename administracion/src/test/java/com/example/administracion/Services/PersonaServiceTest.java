package com.example.administracion.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.administracion.Models.Persona;
import com.example.administracion.Repositories.PersonaRepository;

public class PersonaServiceTest {

    @Mock
    PersonaRepository personaRepository;

    @InjectMocks
    PersonaService personaService;

    private Persona persona;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        persona = new Persona();
    }

    @Test
    public void getPersonas() {
        when(personaRepository.findAllById(anyIterable())).thenReturn(new ArrayList<Persona>());
        assertNotNull(personaService.getPersonas(anyIterable()));
    }

    @Test
    public void getPersonaById() {
        when(personaRepository.findById(anyLong())).thenReturn(Optional.of(persona));
        assertNotNull(personaService.getPersonaById(anyLong()));
    }

}
