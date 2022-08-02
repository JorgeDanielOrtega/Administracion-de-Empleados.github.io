package com.example.administracion.Services;

import java.util.ArrayList;
import java.util.List;

import com.example.administracion.Models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Persona;
import com.example.administracion.Repositories.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
	PersonaRepository personaRepository;

	public List<Persona> listarPersonas() {
		return (List<Persona>) personaRepository.findAll();
	}

	public ArrayList<Persona> getPersonas(Iterable<Long> ids) {
		return (ArrayList<Persona>) personaRepository.findAllById(ids);
	}

	public Persona getPersonaById(Long id) {
		return personaRepository.findById(id).get();
	}
//	public long guardarPersona(Persona p){
//
//	}
//	public void eliminar(Long id);
//}
}