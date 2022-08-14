package com.example.administracion.Services;

	import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.administracion.Models.Asistencia;
	import com.example.administracion.Repositories.AsistenciaRepository;


	@Service
	public class AsistenciaService{

		@Autowired
		AsistenciaRepository asistenciaRepository;

		public ArrayList<Asistencia> getAllAsistencias(){
			return (ArrayList<Asistencia>) asistenciaRepository.findAll();
		}
		public ArrayList<Asistencia> getAsistenciasByIdTrabajador(Long idTrabajador){
			return asistenciaRepository.findAllByIdTrabajador(idTrabajador);
		}

		public Asistencia saveAsistencia(Asistencia asistencia){
			return asistenciaRepository.save(asistencia);
		}
		
	}