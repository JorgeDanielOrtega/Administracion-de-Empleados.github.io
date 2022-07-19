package com.example.administracion.Services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Horario;
import com.example.administracion.Repositories.HorarioRepository;
import com.example.administracion.Repositories.HorariosDiasLaborablesRepository;

@Service
public class HorarioService {
	@Autowired
	HorarioRepository horarioRepository;
	@Autowired
	HorariosDiasLaborablesRepository horariosDiasLaborablesRepository;

	public Horario getHorarioById(Long id) {
		return horarioRepository.findById(id).get();
	}
	
	public Long getIdHorarioByTipo(String tipo){
		return horarioRepository.findByTipo(tipo).getId();
	}


	private List<String> asignarDiasLaborables(List<Long> idDiasLaborablesList) {
		List<String> diasLaborablesList = new LinkedList<>();

		for (Long long1 : idDiasLaborablesList) {
			switch (long1.toString()) {
				case "1":
					diasLaborablesList.add("lunes");
					break;
				case "2":
					diasLaborablesList.add("martes");
					break;
				case "3":
					diasLaborablesList.add("miercoles");
					break;
				case "4":
					diasLaborablesList.add("jueves");
					break;
				case "5":
					diasLaborablesList.add("viernes");
					break;
				case "6":
					diasLaborablesList.add("sabado");
					break;
				case "7":
					diasLaborablesList.add("domingo");
					break;
			}
		}
		return diasLaborablesList;
	}

	public Map<String, Object> getFullHorarioById(Long idHorario) {
		Map<String, Object> fullHorario = new HashMap<>();
		Horario horario = getHorarioById(idHorario);
		List<Long> idDias_laborablesList = new LinkedList<>();

		horariosDiasLaborablesRepository.findAllByIdHorario(idHorario).forEach(horarioDiasL -> {
			idDias_laborablesList.add(horarioDiasL.getIdDiasLaborables());
		});

		fullHorario.put("dias_laborables", asignarDiasLaborables(idDias_laborablesList));
		fullHorario.put("id", horario.getId());
		fullHorario.put("tipo", horario.getTipo());
		fullHorario.put("horas_semanales", horario.getHorasLaborablesSemanales());

		return fullHorario;
	}


}