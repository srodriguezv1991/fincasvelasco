package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dawes.model.ArbolVO;
import com.dawes.repositories.ArbolRepository;

@Service
@Transactional
public class ArbolService {

	@Autowired
	private ArbolRepository repo;

	//TODOS LOS ARBOLES
	public List<ArbolVO> listAll() {
		List<ArbolVO> arboles = repo.findAll();
		return arboles;
	}

	
	//ARBOL POR REFERENCIA
	public ArbolVO findArbol(Long id) {
		Optional<ArbolVO> arbol = repo.findById(id);
		if (arbol.isPresent()) {
			return arbol.get();
		}
		return null;
	}
	
	//GUARDAR ARBOL
	public ArbolVO save(ArbolVO arbol) {
		return repo.save(arbol);

	}

	
	//BORRAR ARBOL
	public void delete(Long id) {
		repo.deleteById(id);
	}


}