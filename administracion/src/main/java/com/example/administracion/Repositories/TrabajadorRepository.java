package com.example.administracion.Repositories;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.administracion.Models.Trabajador;

@Repository
public interface TrabajadorRepository extends CrudRepository<Trabajador, Long> {

    public abstract ArrayList<Trabajador> findAllByIdDepartamento(Long idDepartamento);

    // public abstract LinkedList<Trabajador> findAll();
    // public abstract ArrayList<Trabajador> findAll();

}