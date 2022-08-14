package com.example.administracion.Services;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.administracion.Models.Empresa;
	import com.example.administracion.Repositories.EmpresaRepository;

	import java.util.ArrayList;
	import java.util.Optional;


@Service
	public class EmpresaService{
<<<<<<< HEAD
		@Autowired
		EmpresaRepository empresaRepository;

		public ArrayList<Empresa> obtenerEmpresas(){

			return (ArrayList<Empresa>) empresaRepository.findAll();
		}
		public Optional<Empresa> obtenerEmpresaId (Long id){

			return empresaRepository.findById(id);
=======

		@Autowired
		EmpresaRepository empresaRepository;

		public Empresa getEmpresaById() {
			return empresaRepository.findById(1l).get();
		}

		public Empresa actualizarEmpresa(Empresa empresa){
			Empresa empresaActual = empresaRepository.findById(1l).get();

			if(!empresaActual.getNombre().equals(empresa.getNombre())){
				empresaActual.setNombre(empresa.getNombre());
			}
			if(!empresaActual.getFundacionYear().equals(empresa.getFundacionYear())){
				empresaActual.setNombre(empresa.getNombre());
			}
			if(!empresaActual.getLeyenda().equals(empresa.getLeyenda())){
				empresaActual.setLeyenda(empresa.getLeyenda());
			}
			if(!empresaActual.getRubro().equals(empresa.getRubro())){
				empresaActual.setRubro(empresa.getRubro());
			}

			return empresaRepository.save(empresa);
>>>>>>> ffbccdb8b09493137b92efaa9ae21f08588a8f55
		}
	}