package com.example.administracion.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.administracion.Models.Horario;

@Repository
public interface HorarioRepository extends CrudRepository<Horario, Long> {
	public abstract Horario findByTipo(String tipo);
}