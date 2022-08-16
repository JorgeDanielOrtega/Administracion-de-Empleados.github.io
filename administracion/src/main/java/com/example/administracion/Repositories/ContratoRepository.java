package com.example.administracion.Repositories;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.example.administracion.Models.Contrato;
	


	@Repository
	public interface ContratoRepository extends CrudRepository<Contrato,Long>{
		
	}