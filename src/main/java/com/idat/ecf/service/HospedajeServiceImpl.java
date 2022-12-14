package com.idat.ecf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ecf.dto.HospedajeDTO;
import com.idat.ecf.model.Hospedaje;
import com.idat.ecf.repository.HospedajeRepository;
@Service
public class HospedajeServiceImpl implements HospedajeService {

	@Autowired
	private HospedajeRepository repository;

	@Override
	public List<HospedajeDTO> listar() {
		List<HospedajeDTO> listadto = new ArrayList<>();
		List<Hospedaje> lista = repository.findAll();
		HospedajeDTO dto = null;
		for (Hospedaje turista : lista) {
			dto = new HospedajeDTO();
			dto.setNombre(turista.getNombre());
			dto.setIdHospedaje(turista.getIdHospedaje());
			listadto.add(dto);
		}
		return listadto;
	}

	@Override
	public HospedajeDTO obtenerporId(Integer id) {
		HospedajeDTO dto = null;
		Hospedaje turista = repository.findById(id).orElse(null);
		dto = new HospedajeDTO();
		dto.setNombre(turista.getNombre());
		dto.setIdHospedaje(turista.getIdHospedaje());
		return dto;
	}

	@Override
	public void guardar(HospedajeDTO a) {	
		Hospedaje doc = new  Hospedaje();
		doc.setNombre(a.getNombre());
		repository.save(doc);
		
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void actualizar(HospedajeDTO alumno) {
        Hospedaje doc = new Hospedaje();
        doc.setNombre(alumno.getNombre());
        repository.saveAndFlush(doc);
		
	}
}
