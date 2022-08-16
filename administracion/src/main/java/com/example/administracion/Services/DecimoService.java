package com.example.administracion.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Decimo;
import com.example.administracion.Models.Empleado;
import com.example.administracion.Models.Persona;
import com.example.administracion.Models.Trabajador;
import com.example.administracion.Repositories.DecimoRepository;

@Service
public class DecimoService {
	final int MESES = 12;
	final int DIAS_LABORALES = 360;
	final Double SUELDO_BASICO = 425.0;
	final Double PORCENTAJE_FONDO_RESERVA = 0.0833;

	@Autowired
	DecimoRepository decimoRepository;

	@Autowired
	AsistenciaService asistenciaService;

	@Autowired
	EmpleadoService empleadoService;

	@Autowired
	RolService rolService;

	@Autowired
	TrabajadorService trabajadorService;

	@Autowired
	PersonaService personaService;

	public ArrayList<Map<String, Object>> getDecimos() {
		ArrayList<Decimo> decimos = (ArrayList<Decimo>) decimoRepository.findAll();
		ArrayList<Map<String, Object>> decimosFormat = new ArrayList<>();
		for (Decimo decimo : decimos) {
			Map<String, Object> mapDecimo = new HashMap<String, Object>();
			mapDecimo.put("id", decimo.getId());
			mapDecimo.put("idEmpleado", decimo.getIdEmpleado());
			mapDecimo.put("decimoTercero", decimo.getDecimoTercero());
			mapDecimo.put("decimoCuarto", decimo.getDecimoCuarto());
			mapDecimo.put("fondoReserva", decimo.getFondoReserva());
			mapDecimo.put("NombresApellidos", getNombresApellidosTrabajadorById(decimo.getIdEmpleado()));
			decimosFormat.add(mapDecimo);
		}
		return decimosFormat;
	}

	private String getNombresApellidosTrabajadorById(Long idEmpleado) {
		Empleado empleado = empleadoService.getEmpleadoById(idEmpleado);
		Trabajador trabajador = trabajadorService.getTrabajadorById(empleado.getIdTrabajador()).get();
		Persona persona = personaService.getPersonaById(trabajador.getIdPersona()).get();
		return persona.getNombres() + " " + persona.getApellidos();
	}

	// public Decimo saveDecimo(Long idTrabajador) {
	// Trabajador trabajador = trabajadorService.getTrabajadorById(idTrabajador);
	// Rol rol = rolService.getRolById(trabajador.getIdRol());
	// Double salario = rol.getSalario();
	// Double decimoTercero = calcularDecimoTercero(salario);
	// Double decimoCuarto = calcularDecimoCuarto(idTrabajador);
	// Double fondoReserva = calcularFondoReserva(salario);
	// Decimo decimo = new Decimo();
	// decimo.setDecimoTercero(decimoTercero);
	// decimo.setDecimoCuarto(decimoCuarto);
	// decimo.setFondoReserva(fondoReserva);
	// return decimoRepository.save(decimo);
	// }
	public Decimo saveDecimo(Decimo decimo) {
		return decimoRepository.save(decimo);
	}

	public void deleteDecimoById(Long id){
		decimoRepository.deleteById(id);
	}

	// private Double calcularDecimoTercero(Double salario) {
	// 	return salario / MESES;
	// }

	// private Double calcularDecimoCuarto(Long idTrabajador) {
	// 	int totalAsistencias = asistenciaService.getAsistenciasByIdTrabajador(idTrabajador).size();
	// 	return (SUELDO_BASICO / DIAS_LABORALES) * totalAsistencias;
	// }

	// private Double calcularFondoReserva(Double salario) {
	// 	return salario * PORCENTAJE_FONDO_RESERVA;
	// }

}