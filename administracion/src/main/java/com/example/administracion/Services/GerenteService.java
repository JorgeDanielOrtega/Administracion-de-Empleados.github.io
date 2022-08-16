package com.example.administracion.Services;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.administracion.Models.Gerente;
	import com.example.administracion.Repositories.GerenteRepository;

	import java.util.ArrayList;


@Service
	public class GerenteService{
		@Autowired
		GerenteRepository gerenteRepository;
		public Gerente guardarGerente (Gerente gerente){
			return gerenteRepository.save(gerente);
		}
		public ArrayList<Gerente> obtenerGerentes(){

			return (ArrayList<Gerente>) gerenteRepository.findAll();
		}
	}