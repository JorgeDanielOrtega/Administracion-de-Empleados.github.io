package com.example.administracion.Services;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Departamento;
import com.example.administracion.Repositories.DepartamentoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DepartamentoService {

	@Autowired
	DepartamentoRepository departamentoRepository;
	@Autowired
	EntityManager entityManager;


	public Long getIdDepartamentoByNombre(String nombre) { return departamentoRepository.findByNombre(nombre).getId();
	}
	public ArrayList<Departamento> getTodosDepartamentos(){
		return (ArrayList<Departamento>) departamentoRepository.findAll();
	}
	// public Departamento getDepartamentoById(Long id) {
	// 	return departamentoRepository.findById(id).get();
	// }
	public Optional<Departamento> obtenerDepartamentoBarraBusqueda(Long id){
		return  departamentoRepository.findById(id);
	}
	public boolean eliminarDepartamento (Long id){
		try{
			departamentoRepository.deleteById(id);
			return true;
		}catch(Exception err){
			return false;
		}
	}
	public ArrayList<HashMap<String, Object>> getAllNombreDepartamentosSinRepetir() {

		ArrayList<HashMap<String, Object>> nombresDepartamentoList = new ArrayList<>();
		for (Departamento departamento : (ArrayList<Departamento>) departamentoRepository.findAll()) {
			HashMap<String, Object> mapNombres = new HashMap();
			mapNombres.put("nombre", departamento.getNombre());
			nombresDepartamentoList.add(mapNombres);
		}
		return nombresDepartamentoList;
	}

	public Departamento guardarDepartamento (Departamento departamento){
		return departamentoRepository.save(departamento);
	}

	public Optional<Departamento> getDepartamentoById(Long id) {
		return departamentoRepository.findById(id);
	}

	// public ArrayList<HashMap<String, Object>> getAllNombreDepartamentosSinRepetir() {

	// 	ArrayList<HashMap<String, Object>> nombresDepartamentoList = new ArrayList<>();
	// 	for (Departamento departamento : (ArrayList<Departamento>) departamentoRepository.findAll()) {
	// 		HashMap<String, Object> mapNombres = new HashMap();
	// 		mapNombres.put("nombre", departamento.getNombre());
	// 		nombresDepartamentoList.add(mapNombres);
	// 	}

	// 	return nombresDepartamentoList;
	// }

}