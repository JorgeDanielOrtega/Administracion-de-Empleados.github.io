
package com.example.administracion.Repositories;

import com.example.administracion.Models.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {
    public abstract LinkedList<Login> findAll();

}
