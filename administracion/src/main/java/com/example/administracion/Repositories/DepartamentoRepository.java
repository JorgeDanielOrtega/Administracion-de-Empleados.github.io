package com.example.administracion.Repositories;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.example.administracion.Models.Departamento;
	


	@Repository
	public interface DepartamentoRepository extends CrudRepository<Departamento,Long>{
		
	}