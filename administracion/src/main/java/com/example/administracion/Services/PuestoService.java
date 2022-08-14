package com.example.administracion.Services;

	import com.example.administracion.Models.Departamento;
	import com.example.administracion.Models.Rol;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.administracion.Models.Puesto;
	import com.example.administracion.Repositories.PuestoRepository;

	import java.util.ArrayList;
	import java.util.HashMap;


@Service
	public class PuestoService{
		@Autowired
		PuestoRepository puestoRepository;
		public Puesto getPuestoById(Long id) {
			return puestoRepository.findById(id).get();

		}
		public ArrayList<Puesto> getTodosPuestos(){
			return (ArrayList<Puesto>) puestoRepository.findAll();
		}

		public ArrayList<HashMap<String, Object>> getAllNombrePuestosSinRepetir() {

			ArrayList<HashMap<String, Object>> nombresPuestosList = new ArrayList<>();
			for (Puesto puesto : (ArrayList<Puesto>) puestoRepository.findAll()) {
				HashMap<String, Object> mapNombres = new HashMap();
				mapNombres.put("nombre", puesto.getNombre());
				nombresPuestosList.add(mapNombres);
			}
			return nombresPuestosList;
		}
	}