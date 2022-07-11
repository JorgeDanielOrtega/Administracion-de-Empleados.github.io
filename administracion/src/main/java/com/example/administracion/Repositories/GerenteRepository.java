package com.example.administracion.Repositories;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.example.administracion.Models.Gerente;
	


	@Repository
	public interface GerenteRepository extends CrudRepository<Gerente,Long>{
		
	}