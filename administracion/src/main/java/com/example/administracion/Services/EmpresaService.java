package com.example.administracion.Services;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.administracion.Models.Empresa;
import com.example.administracion.Repositories.EmpresaRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpresaService {
	// <<<<<<< HEAD
	// @Autowired
	// EmpresaRepository empresaRepository;

	@Autowired
	EmpresaRepository empresaRepository;

	// public Empresa getEmpresaById() {
	// 	return empresaRepository.findById(1l).get();
	// }

	public ArrayList<Empresa> obtenerEmpresas() {

		return (ArrayList<Empresa>) empresaRepository.findAll();
	}

	public Optional<Empresa> obtenerEmpresaId(Long id) {

		return empresaRepository.findById(id);
	}

	public Empresa actualizarEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	

	public Optional<Empresa> getEmpresaById() {
		return empresaRepository.findById(1l);
	}

	public Time getHoraEntredaEmpresa() {
	return getEmpresaById().get().getHoraEntrada();
	}

	}
