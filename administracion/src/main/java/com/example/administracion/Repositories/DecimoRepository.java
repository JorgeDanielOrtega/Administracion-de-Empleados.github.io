package com.example.administracion.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.administracion.Models.Decimo;

@Repository
public interface DecimoRepository extends CrudRepository<Decimo, Long> {

}