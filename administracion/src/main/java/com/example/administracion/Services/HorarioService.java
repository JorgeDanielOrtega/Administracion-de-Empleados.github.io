package com.example.administracion.Services;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.administracion.Models.Horario;
	import com.example.administracion.Repositories.HorarioRepository;


	@Service
	public class HorarioService{
		@Autowired
		HorarioRepository horarioRepository;
		public Horario getHorarioById(Long id){
			return horarioRepository.findById(id).get();
		}
	}