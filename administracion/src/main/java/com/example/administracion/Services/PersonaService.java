package com.example.administracion.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Persona;
import com.example.administracion.Repositories.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
	PersonaRepository personaRepository;

	public ArrayList<Persona> getPersonas(Iterable<Long> ids) {
		return (ArrayList<Persona>) personaRepository.findAllById(ids);
	}

	public ArrayList<Persona> obtenerPersonas(){
		return (ArrayList<Persona>) personaRepository.findAll();
	}
	// public Persona getPersonaById(Long id) {
	// 	return personaRepository.findById(id).get();}


	public Optional<Persona> getPersonaById(Long id) {
		return personaRepository.findById(id);

	}
	public Persona guardarPersona(Persona persona){
		return personaRepository.save(persona);
	}
	public boolean eliminarPersonaPorId(Long id){
		try{
			this.personaRepository.deleteById(id);
			return true;
		}catch (Exception err){
			return false;
		}
	}
}