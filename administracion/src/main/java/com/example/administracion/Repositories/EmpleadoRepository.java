package com.example.administracion.Repositories;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.example.administracion.Models.Empleado;
	


	@Repository
	public interface EmpleadoRepository extends CrudRepository<Empleado,Long>{
		
	}