package com.example.administracion.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Rol;
import com.example.administracion.Repositories.RolRepository;

@Service
public class RolService {
	@Autowired
	RolRepository rolRepository;

	public Optional<Rol> getRolById(Long id) {
		return rolRepository.findById(id);
	}

	public Long getIdRolByNombre(String nombre) {
		return rolRepository.findByNombre(nombre).getId();
	}

	public ArrayList<HashMap<String, Object>> getAllNombreRolSinRepetir() {
		ArrayList<HashMap<String, Object>> nombresRolList = new ArrayList<>();

		for (Rol rol : (ArrayList<Rol>) rolRepository.findAll()) {
			HashMap<String, Object> mapNombre = new HashMap();
			mapNombre.put("nombre", rol.getNombre());
			nombresRolList.add(mapNombre);
		}

		return nombresRolList;
	}

}