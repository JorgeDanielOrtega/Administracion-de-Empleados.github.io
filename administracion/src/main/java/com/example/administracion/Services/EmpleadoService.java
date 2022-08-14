package com.example.administracion.Services;

import java.security.spec.ECPoint;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
=======
import java.util.HashMap;
>>>>>>> 4ac830cbb47f6afbf61aa0c6aea44fb50a053bc6

import com.example.administracion.Models.*;
import com.example.administracion.Repositories.TrabajadorRepository;
import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Repositories.EmpleadoRepository;

@Service
public class EmpleadoService{
	@Autowired
	EmpleadoRepository empleadoRepository;
	@Autowired
	TrabajadorService trabajadorService;
	@Autowired
	PersonaService personaService;
	@Autowired
	TrabajadorRepository trabajadorRepository;
	@Autowired
	DepartamentoService departamentoService;
	@Autowired
	RolService rolService;
	@Autowired
	PuestoService puestoService;
	@Autowired
	HorarioService horarioService;

	public Empleado getEmpleadoById(long id){
		return empleadoRepository.findById(id).get();
	}
	public boolean eliminarEmpleadoPorId(Long id){
		try{
			this.empleadoRepository.deleteById(id);
			return true;
		}catch(Exception err){
			return false;
		}
	}

	public Iterable<Long> getIdsTrabajador() {
		ArrayList<Long> idTrabajadorList = new ArrayList<>();
		for (Empleado empleado : empleadoRepository.findAll()) {
			idTrabajadorList.add(empleado.getIdTrabajador());
		}
		return (Iterable<Long>) idTrabajadorList;
	}
	public ArrayList<Empleado> obtenerEmpleadosTable(){
		return (ArrayList<Empleado>) empleadoRepository.findAll();
	}
	public Horario getHorarioOfTrabajador(Long idHorario) {
		// return horarioService.getHorarioById(idHorario);
		return horarioService.getHorarioById(idHorario).get();
	}

	public ArrayList<HashMap<String, Object>> getTodosEmpleados(){
		ArrayList<HashMap<String, Object>> mapList = new ArrayList<>();

		ArrayList<Trabajador> trabajadorList = (ArrayList<Trabajador>)trabajadorRepository.findAll();
		ArrayList<Empleado> empleadoList = (ArrayList<Empleado>)empleadoRepository.findAll();
		Long idRol = null;
		Long idHorario = null;
		Long idDepartamento =null;
		Long idEmpleado = null;
		Persona persona;
		Long idPuesto = null;
		for(Empleado empleado : empleadoList){
			for(Trabajador trabajador : trabajadorList){
				if (empleado.getIdTrabajador() == trabajador.getId()){
					HashMap<String, Object> myMap = new HashMap<>();
					idEmpleado = empleado.getId();
					idRol = trabajador.getIdRol();
					idHorario = trabajador.getIdHorario();
					idDepartamento = trabajador.getIdDepartamento();
					// persona = personaService.getPersonaById(trabajador.getIdPersona());
					persona = personaService.getPersonaById(trabajador.getIdPersona()).get();
					// Rol rol = rolService.getRolById(idRol);
					Rol rol = rolService.getRolById(idRol).get();
					idPuesto = rol.getIdPuesto();
					if (idRol != null && idDepartamento != null && idHorario != null) {
						myMap.put("id", idEmpleado);
						myMap.put("nombres", persona.getNombres());
						myMap.put("apellidos", persona.getApellidos());
						myMap.put("usuario", trabajador.getUsuario());
						myMap.put("cedula", persona.getCedula());
						myMap.put("telefono", persona.getCedula());
						// myMap.put("departamento", departamentoService.getDepartamentoById(idDepartamento).getNombre());
						myMap.put("departamento", departamentoService.getDepartamentoById(idDepartamento).get().getNombre());
						// myMap.put("rol", rolService.getRolById(idRol).getNombre());
						myMap.put("rol", rolService.getRolById(idRol).get().getNombre());
						myMap.put("puesto", puestoService.getPuestoById(idPuesto).getNombre());
						myMap.put("horario", getHorarioOfTrabajador(idHorario).getTipo());
						mapList.add(myMap);
					}
				}
			}
		}
		return mapList;
	}
	public Empleado guardarEmpleado(Empleado empleado){
		return empleadoRepository.save(empleado);
	}
	public Empleado getEmpleadoById(Long id){
		return empleadoRepository.findById(id).get();
	}

}