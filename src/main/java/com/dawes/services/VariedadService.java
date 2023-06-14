package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dawes.model.VariedadVO;
import com.dawes.repositories.VariedadRepository;

@Service
@Transactional
public class VariedadService {

	@Autowired
	private VariedadRepository repo;

	//TODAS LAS VARIEDADES
	public List<VariedadVO> listAll() {
		List<VariedadVO> variedades = repo.findAll();
		return variedades;
	}

	
	//VARIEDAD POR REFERENCIA
	public VariedadVO findVariedad(Long id) {
		Optional<VariedadVO> variedad = repo.findById(id);
		if (variedad.isPresent()) {
			return variedad.get();
		}
		return null;
	}
	
	//GUARDAR VARIEDAD
	public VariedadVO save(VariedadVO variedad) {
		return repo.save(variedad);

	}

	
	//BORRAR VARIEDAD
	public void delete(Long id) {
		repo.deleteById(id);
	}


}