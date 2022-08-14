package com.example.administracion.Services;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.administracion.Models.Empresa;
	import com.example.administracion.Repositories.EmpresaRepository;

	import java.util.ArrayList;
	import java.util.Optional;


@Service
	public class EmpresaService{
		@Autowired
		EmpresaRepository empresaRepository;

		public ArrayList<Empresa> obtenerEmpresas(){

			return (ArrayList<Empresa>) empresaRepository.findAll();
		}
		public Optional<Empresa> obtenerEmpresaId (Long id){

			return empresaRepository.findById(id);
		}
	}