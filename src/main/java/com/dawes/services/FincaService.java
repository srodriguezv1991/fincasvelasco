package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dawes.model.FincaVO;
import com.dawes.repositories.FincaRepository;

@Service
@Transactional
public class FincaService {

	@Autowired
	private FincaRepository repo;

	//TODAS LAS FINCAS
	public List<FincaVO> listAll() {
		List<FincaVO> fincas = repo.findAll();
		return fincas;
	}

	
	//FINCA POR REFERENCIA
	public FincaVO findFinca(Long id) {
		Optional<FincaVO> finca = repo.findById(id);
		if (finca.isPresent()) {
			return finca.get();
		}
		return null;
	}
	
	//GUARDAR FINCA
	public FincaVO save(FincaVO finca) {
		return repo.save(finca);

	}

	
	//BORRAR FINCA
	public void delete(Long id) {
		repo.deleteById(id);
	}


}