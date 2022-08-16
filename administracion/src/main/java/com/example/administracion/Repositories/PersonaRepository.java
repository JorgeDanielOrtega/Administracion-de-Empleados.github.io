package com.example.administracion.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.administracion.Models.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

}