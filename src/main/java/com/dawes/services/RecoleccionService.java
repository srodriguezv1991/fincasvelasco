package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dawes.model.RecoleccionVO;
import com.dawes.repositories.RecoleccionRepository;

@Service
@Transactional
public class RecoleccionService {

	@Autowired
	private RecoleccionRepository repo;

	//TODAS LAS RECOLECCIONES
	public List<RecoleccionVO> listAll() {
		List<RecoleccionVO> recolecciones = repo.findAll();
		return recolecciones;
	}

	
	//RECOLECCION POR REFERENCIA
	public RecoleccionVO findRecoleccion(Long id) {
		Optional<RecoleccionVO> recoleccion = repo.findById(id);
		if (recoleccion.isPresent()) {
			return recoleccion.get();
		}
		return null;
	}
	
	//GUARDAR RECOLECCION
	public RecoleccionVO save(RecoleccionVO finca) {
		return repo.save(finca);

	}

	
	//BORRAR RECOLECION
	public void delete(Long id) {
		repo.deleteById(id);
	}


}