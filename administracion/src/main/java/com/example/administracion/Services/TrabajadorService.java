package com.example.administracion.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Horario;
import com.example.administracion.Models.Persona;
import com.example.administracion.Models.Trabajador;
import com.example.administracion.Repositories.TrabajadorRepository;

@Service
public class TrabajadorService {

	@Autowired
	TrabajadorRepository trabajadorRepository;
	@Autowired
	DepartamentoService departamentoService;
	@Autowired
	PersonaService personaService;
	@Autowired
	RolService rolService;
	@Autowired
	HorarioService horarioService;
	@Autowired
	EntityManager entityManager;

	// TODO refactorizarlo los hasmap, y cambiarlos por list, utilizando las queries
	public ArrayList<Trabajador> getTrabajadores(Iterable<Long> ids) {
		return (ArrayList<Trabajador>) trabajadorRepository.findAllById(ids);
	}

	public Map<String, Object> getDatosEmpleado(Persona persona, Trabajador trabajador) {

		try {
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new HashMap<String, Object>();
	}

	public Long getIdHorarioByIdTrabajador(Long idTrabajador) {
		return getTrabajadorById(idTrabajador).get().getIdHorario();
	}

	public Map<String, Object> getTrabajadorInfo(Long id) {
		try {
			Long idPersona = getTrabajadorById(id).get().getIdPersona();

			Persona persona = personaService.getPersonaById(idPersona).get();
			Trabajador trabajador = getTrabajadorById(id).get();
			return getDatosEmpleado(persona, trabajador);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new HashMap<>();
	}

	public Optional<Trabajador> getTrabajadorById(Long id) {
		return trabajadorRepository.findById(id);
	}

	private Map<String, Object> getDataEmpleadosByDepartamento(Persona persona, Trabajador trabajador) {
		Map<String, Object> myMap = new HashMap<>();

		// TODO hacer el campo puestos, quizas
		Long idRol = trabajador.getIdRol();
		Long idHorario = trabajador.getIdHorario();

		myMap.put("id", trabajador.getId());
		myMap.put("nombres", persona.getNombre());
		myMap.put("apellidos", persona.getApellido());
		myMap.put("Rol", rolService.getRolById(idRol).get().getNombre());
		myMap.put("Horario", getHorarioOfTrabajador(idHorario).get().getTipo());

		return myMap;
	}

	public ArrayList<Map<String, Object>> getTrabajadorForBusqueda() {
		try {
			List<Long> ids = new LinkedList<>();
			ArrayList<Persona> personaList = new ArrayList<Persona>();
			ArrayList<Map<String, Object>> trabajadorArrayListInfo = new ArrayList<>();
			ArrayList<Trabajador> trabajadorList = new ArrayList<>();

			for (Trabajador trabajador : (ArrayList<Trabajador>) trabajadorRepository.findAll()) {
				if (trabajador.getIdDepartamento() != null && trabajador.getIdHorario() != null
						&& trabajador.getIdRol() != null) {

					trabajadorList.add(trabajador);
				}
			}

			// todo añadir para recuperar los departamentos
			trabajadorList.forEach(trabajador -> {
				Long idPersona = trabajador.getIdPersona();
				ids.add(idPersona);
			});
			personaList = personaService.getPersonas((Iterable<Long>) ids);

			for (int i = 0; i < trabajadorList.size(); i++) {
				trabajadorArrayListInfo.add(
						getDataEmpleadosForBusqueda(personaList.get(i), trabajadorList.get(i)));
			}
			return trabajadorArrayListInfo;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ArrayList<>();
	}

	private Map<String, Object> getDataEmpleadosForBusqueda(Persona persona, Trabajador trabajador) {
		Map<String, Object> myMap = new HashMap<>();

		// TODO hacer el campo puestos, quizas
		Long idRol = trabajador.getIdRol();
		Long idHorario = trabajador.getIdHorario();
		Long idDepartamento = trabajador.getIdDepartamento();

		myMap.put("id", trabajador.getId());
		myMap.put("nombres", persona.getNombre());
		myMap.put("apellidos", persona.getApellido());
		myMap.put("departamento", departamentoService.getDepartamentoById(idDepartamento).get().getNombre());
		myMap.put("rol", rolService.getRolById(idRol).get().getNombre());
		myMap.put("horario", getHorarioOfTrabajador(idHorario).get().getTipo());

		return myMap;
	}

	public ArrayList<Map<String, Object>> getTrabajadoresByFields(String departamento, String rol, String horario,
			Long id,
			String nombreApellido) {

		try {
			Map<String, Object> fieldsMap = new HashMap<>();

			if (departamento != null) {
				fieldsMap.put("t.idDepartamento", departamentoService.getIdDepartamentoByNombre(departamento));
			}
			if (rol != null) {
				fieldsMap.put("t.idRol", rolService.getIdRolByNombre(rol));
			}
			if (horario != null) {
				fieldsMap.put("t.idHorario", horarioService.getIdHorarioByTipo(horario));
			}
			if (nombreApellido != null) {
				fieldsMap.put("t.idPersona", getIdPersonaByNombresApellidos(nombreApellido));
			}
			if (id != null) {
				fieldsMap.put("t.id", id.toString());
			}
			Query query = entityManager.createQuery(generarQuery(fieldsMap));

			return getDataEmpleadosForBusqueda(query.getResultList());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return new ArrayList<>();
	}

	private ArrayList<HashMap<String, Object>> getDataEmpleadosForBusqueda(List<Trabajador> trabajadorList) {
		ArrayList<HashMap<String, Object>> mapList = new ArrayList<>();

		Long idTrabajador;
		Long idRol;
		Long idHorario;
		Long idDepartamento;
		Persona persona;

		// TODO hacer el campo puestos, quizas
		for (Trabajador trabajador : trabajadorList) {

			HashMap<String, Object> myMap = new HashMap<>();

			idTrabajador = trabajador.getId();
			idRol = trabajador.getIdRol();
			idHorario = trabajador.getIdHorario();
			idDepartamento = trabajador.getIdDepartamento();
			persona = personaService.getPersonaById(trabajador.getIdPersona()).get();

			myMap.put("id", idTrabajador);
			myMap.put("nombres", persona.getNombre());
			myMap.put("apellidos", persona.getApellido());
			myMap.put("departamento", departamentoService.getDepartamentoById(idDepartamento).get().getNombre());
			myMap.put("rol", rolService.getRolById(idRol).get().getNombre());
			myMap.put("horario", getHorarioOfTrabajador(idHorario).get().getTipo());

			mapList.add(myMap);
		}

		return mapList;
	}

	public Optional<Horario> getHorarioOfTrabajador(Long idHorario) {
		return horarioService.getHorarioById(idHorario);
	}

	public ArrayList<Map<String, Object>> getTrabajadorByIdDepartamento(Long idDepartamento) {
		// TODO encontrar la manera de retornar el nombre del departamento

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
					getDataEmpleadosByDepartamento(personaList.get(i), trabajadorList.get(i)));
		}
		return trabajadorArrayListInfo;
	}

	public String getIdPersonaByNombresApellidos(String nombresApellidos) {
		try {
			String sql = "SELECT p.id FROM Persona p WHERE p.nombres LIKE '%" + nombresApellidos
					+ "%' OR p.apellidos LIKE '%" + nombresApellidos + "%'";

			Query query = entityManager.createQuery(sql);

			return formatearidPersonaList(query.getResultList().toArray());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "1";
	}

	private String formatearidPersonaList(Object[] idsPersona) {
		String result = "(";
		int size = idsPersona.length;
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				result += idsPersona[i] + ")";
				return result;
			}
			result += idsPersona[i] + ",";
		}
		return "";
	}

	private String generarQuery(Map<String, Object> fieldsMap) {
		Object[] keys = fieldsMap.keySet().toArray();
		int size = fieldsMap.size();
		String query = "SELECT t FROM Trabajador t WHERE ";
		for (int i = 0; i < size; i++) {
			String key = keys[i].toString();

			if (key.equals("t.idPersona")) {
				query += key + " IN " + fieldsMap.get(key);
			} else if (i == size - 1) {
				query += key + "=" + fieldsMap.get(key).toString();
			} else {
				query += key + "=" + fieldsMap.get(key).toString() + " AND ";
			}
		}
		return query;
	}

}