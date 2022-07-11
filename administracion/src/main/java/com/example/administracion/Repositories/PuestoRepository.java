package com.example.administracion.Repositories;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.example.administracion.Models.Puesto;
	


	@Repository
	public interface PuestoRepository extends CrudRepository<Puesto,Long>{
		
	}