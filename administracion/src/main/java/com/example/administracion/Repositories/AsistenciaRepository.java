package com.example.administracion.Repositories;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.example.administracion.Models.Asistencia;
	


	@Repository
	public interface AsistenciaRepository extends CrudRepository<Asistencia,Long>{
		
	}