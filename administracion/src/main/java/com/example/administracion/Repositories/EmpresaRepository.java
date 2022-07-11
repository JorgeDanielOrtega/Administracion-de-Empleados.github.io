package com.example.administracion.Repositories;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.example.administracion.Models.Empresa;
	


	@Repository
	public interface EmpresaRepository extends CrudRepository<Empresa,Long>{
		
	}