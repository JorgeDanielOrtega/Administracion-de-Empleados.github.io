package com.example.administracion.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	DepartamentoRepository departamentoRepository;

	public Long getIdDepartamentoByNombre(String nombre) {
		return departamentoRepository.findByNombre(nombre).getId();
	}

}