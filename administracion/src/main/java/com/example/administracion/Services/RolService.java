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

	public Optional<Rol> obtenerRolPorId(Long id) {
		return rolRepository.findById(id);
	}

	public ArrayList<Rol> getTodosRoles() {
		return (ArrayList<Rol>) rolRepository.findAll();
	}

	public Optional<Rol> getRolById(Long id) {
		return rolRepository.findById(id);
	}

	public Long getIdRolByNombre(String nombre) {
		return rolRepository.findByNombre(nombre).getId();
	}

	// public ArrayList<HashMap<String, Object>> getAllNombreRolSinRepetir() {
	// 	ArrayList<HashMap<String, Object>> nombresRolList = new ArrayList<>();
	// }

	public ArrayList<HashMap<String, Object>> getAllNombreRolSinRepetir() {
		ArrayList<HashMap<String, Object>> nombresRolList = new ArrayList<>();

		for (Rol rol : (ArrayList<Rol>) rolRepository.findAll()) {
			HashMap<String, Object> mapNombre = new HashMap();
			mapNombre.put("nombre", rol.getNombre());
			nombresRolList.add(mapNombre);
		}

		return nombresRolList;
	}

	public Rol guardarRol(Rol rol) {
		return rolRepository.save(rol);
	}

	public boolean eliminarRolPorId(Long id) {
		try {
			this.rolRepository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}

}