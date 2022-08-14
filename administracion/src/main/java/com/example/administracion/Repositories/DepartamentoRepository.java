package com.example.administracion.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.administracion.Models.Departamento;

import java.util.Optional;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {
	public abstract Departamento findByNombre(String nombre);
	public abstract Optional<Departamento> findById(Long id);

}