package com.example.administracion.Repositories;

	import com.example.administracion.Models.Rol;
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.example.administracion.Models.Puesto;

	import java.util.Optional;


@Repository
	public interface PuestoRepository extends CrudRepository<Puesto,Long>{
	public abstract Optional<Puesto> findById(Long id);

}