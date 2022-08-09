package com.example.administracion.Services;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.administracion.Models.Empresa;
	import com.example.administracion.Repositories.EmpresaRepository;


	@Service
	public class EmpresaService{

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
		}
	}