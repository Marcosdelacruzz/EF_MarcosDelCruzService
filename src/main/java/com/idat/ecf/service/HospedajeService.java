package com.idat.ecf.service;

import java.util.List;

import com.idat.ecf.dto.HospedajeDTO;


public interface HospedajeService {

	
	List<HospedajeDTO> listar();
	HospedajeDTO obtenerporId(Integer id);
	void guardar(HospedajeDTO a);
	void eliminar(Integer id);
	void actualizar(HospedajeDTO alumno);
}
