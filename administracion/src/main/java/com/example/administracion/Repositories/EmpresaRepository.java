package com.example.administracion.Repositories;

import com.example.administracion.Models.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.administracion.Models.Empresa;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
    public abstract Optional<Empresa> findById(Long id);}