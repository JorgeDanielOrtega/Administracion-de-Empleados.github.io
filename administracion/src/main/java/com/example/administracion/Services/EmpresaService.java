package com.example.administracion.Services;

import java.sql.Time;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Empresa;
import com.example.administracion.Repositories.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	EmpresaRepository empresaRepository;

	public Optional<Empresa> getEmpresaById() {
		return empresaRepository.findById(1l);
	}

	public Time getHoraEntredaEmpresa() {
		return getEmpresaById().get().getHoraEntrada();
	}
}