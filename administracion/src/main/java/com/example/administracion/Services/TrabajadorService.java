package com.example.administracion.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Persona;
import com.example.administracion.Models.Trabajador;
import com.example.administracion.Repositories.TrabajadorRepository;

@Service
public class TrabajadorService {

	@Autowired
	TrabajadorRepository trabajadorRepository;
	@Autowired
	PersonaService personaService;

	public ArrayList<Trabajador> getTrabajadores(Iterable<Long> ids) {
		return (ArrayList<Trabajador>) trabajadorRepository.findAllById(ids);
	}

	public Trabajador getTrabajadorById(Long id) {
		return (Trabajador) trabajadorRepository.findById(id).get();
	}

	public Map<String, Object> getDatosEmpleado(Persona persona, Trabajador trabajador) {
		Map<String, Object> myMap = new HashMap<>();

		myMap.put("id", trabajador.getId());
		myMap.put("nombres", persona.getNombre());
		myMap.put("apellidos", persona.getApellido());
		myMap.put("direccion", persona.getDireccion());
		myMap.put("estado_civil", persona.getEstadoCivil());
		myMap.put("cedula", persona.getCedula());
		myMap.put("ciudad", persona.getCiudad());
		myMap.put("telefono", persona.getTelefono());
		myMap.put("sexo", String.valueOf(persona.getSexo()));
		myMap.put("fecha_nacimiento", persona.getFechaNacimiento().toString());
		myMap.put("anio_entrada", persona.getAnioEntrada().toString());
		myMap.put("correo_personal", trabajador.getCorreoPersonal());
		myMap.put("correo_empresarial", trabajador.getCorreoEmpresarial());
		myMap.put("usuario", trabajador.getUsuario());
		myMap.put("contrasenia", trabajador.getPassword());
		myMap.put("id_departamento", trabajador.getIdDepartamento());
		myMap.put("id_rol", trabajador.getIdRol());
		myMap.put("id_horario", trabajador.getIdHorario());

		return myMap;
	}

	public Map<String, Object> getTrabajadorInfo(Long id) {
		Long idPersona = getTrabajadorById(id).getIdPersona();

		Persona persona = personaService.getPersonaById(idPersona);
		Trabajador trabajador = getTrabajadorById(id);
		return getDatosEmpleado(persona, trabajador);
	}

	private Map<String, Object> getDataEmpleadosByDepartamento(Persona persona, Trabajador trabajador){
		Map<String, Object> myMap = new HashMap<>();

		//TODO hacer los metodos para que muestren el nombre de los roles, horarios y puestos
		myMap.put("id", trabajador.getId());
		myMap.put("nombres", persona.getNombre());
		myMap.put("apellidos", persona.getApellido());
		myMap.put("id_rol", trabajador.getIdRol());
		myMap.put("id_horario", trabajador.getIdHorario());

		return myMap;
	}


	public ArrayList<Map<String, Object>> getTrabajadorByIdDepartamento(Long idDepartamento) {
		List<Long> ids = new LinkedList<>();
		ArrayList<Persona> personaList = new ArrayList<Persona>();
		ArrayList<Map<String, Object>> trabajadorArrayListInfo = new ArrayList<>();
		ArrayList<Trabajador> trabajadorList = trabajadorRepository.findAllByIdDepartamento(idDepartamento);

		trabajadorList.forEach(trabajador -> {
			Long idPersona = trabajador.getIdPersona();
			ids.add(idPersona);
		});
		personaList = personaService.getPersonas((Iterable<Long>) ids);

		for (int i = 0; i < trabajadorList.size(); i++) {
			trabajadorArrayListInfo.add(
					getDatosEmpleado(personaList.get(i), trabajadorList.get(i)));
		}

		return trabajadorArrayListInfo;
	}

}