package com.example.administracion.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Departamento;
import com.example.administracion.Repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	DepartamentoRepository departamentoRepository;
	@Autowired
	EntityManager entityManager;

	public Long getIdDepartamentoByNombre(String nombre) { return departamentoRepository.findByNombre(nombre).getId();
	}

	public Departamento getDepartamentoById(Long id) {
		return departamentoRepository.findById(id).get();
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

}