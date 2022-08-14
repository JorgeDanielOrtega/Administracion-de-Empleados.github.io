package com.example.administracion.Repositories;

import com.example.administracion.Models.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.administracion.Models.Empresa;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
<<<<<<< HEAD
    public abstract Optional<Empresa> findById(Long id);}
=======
    public abstract Optional<Empresa> findById(Long id);

}
>>>>>>> ffbccdb8b09493137b92efaa9ae21f08588a8f55
