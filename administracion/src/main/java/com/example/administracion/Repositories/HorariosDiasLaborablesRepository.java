package com.example.administracion.Repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.administracion.Models.HorariosDias_laborables;

@Repository
public interface HorariosDiasLaborablesRepository extends CrudRepository<HorariosDias_laborables,Long>{
    public abstract ArrayList<HorariosDias_laborables> findAllByIdHorario(Long idHorario);
}
