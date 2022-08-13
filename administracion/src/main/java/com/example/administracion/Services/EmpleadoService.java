package com.example.administracion.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Empleado;
import com.example.administracion.Repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	EmpleadoRepository empleadoRepository;
	@Autowired
	TrabajadorService trabajadorService;
	@Autowired
	PersonaService personaService;

	public Iterable<Long> getIdTrabajador() {
		ArrayList<Long> idTrabajadorList = new ArrayList<>();
		for (Empleado empleado : empleadoRepository.findAll()) {
			idTrabajadorList.add(empleado.getIdTrabajador());
		}
		return (Iterable<Long>) idTrabajadorList;
	}

	public Empleado getEmpleadoById(Long id){
		return empleadoRepository.findById(id).get();
	}

	
}