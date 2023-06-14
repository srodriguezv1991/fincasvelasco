package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dawes.model.ArbolVO;
import com.dawes.model.TratamientoArbolVO;
import com.dawes.repositories.TratamientoArbolRepository;

@Service
@Transactional
public class TratamientoArbolService {

	@Autowired
	private TratamientoArbolRepository repo;

	//TODOS LOS TRATAMIENTOS APLICADOS
	public List<TratamientoArbolVO> listAll() {
		List<TratamientoArbolVO> tratamientoarboles = repo.findAll();
		return tratamientoarboles;
	}

	
	//TRATAMIENTOS POR ARBOL
	public TratamientoArbolVO findtratamientoArbol(Long id) {
		Optional<TratamientoArbolVO> tratamientoarbol = repo.findById(id);
		if (tratamientoarbol.isPresent()) {
			return tratamientoarbol.get();
		}
		return null;
	}
	
	//GUARDAR TRATAMIENTO ARBOL
	public TratamientoArbolVO save(TratamientoArbolVO tratamientoarbol) {
		return repo.save(tratamientoarbol);

	}

	
	//BORRAR TRATAMIENTO ARBOL
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	//TRATAMIENTOS POR ARBOL
	public Optional<List<TratamientoArbolVO>> findAllByArbol(ArbolVO arbol) {
		return repo.findAllByArbol(arbol);
	}


}