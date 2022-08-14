package com.example.administracion.Services;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.administracion.Models.Contrato;
	import com.example.administracion.Repositories.ContratoRepository;

	import java.util.ArrayList;


@Service
	public class ContratoService{
	@Autowired
	ContratoRepository contratoRepository;
	public Contrato getIdContrato (Long id){
		return contratoRepository.findById(id).get();
	}
	public boolean eliminarContratoPorId(Long id){
		try{
			contratoRepository.deleteById(id);
			return true;
		}catch (Exception err){
			return false;
		}
	}
	public ArrayList<Contrato> getAllContratos(){
			return (ArrayList<Contrato>) contratoRepository.findAll();
		}

		public Contrato guardarContrato (Contrato contrato){
			return contratoRepository.save(contrato);
		}
	}