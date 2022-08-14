package com.example.administracion.Repositories;

import com.example.administracion.Models.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.administracion.Models.Rol;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {
	public abstract Rol findByNombre(String nombre);
	//public abstract ArrayList<Rol> encontrarPorDepartamento(String nombreDepartamento);
	public abstract Optional<Rol> findById(Long id);
	//public abstract Rol findById(Long id);

}