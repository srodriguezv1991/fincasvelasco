package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dawes.model.TratamientoVO;
import com.dawes.repositories.TratamientoRepository;

@Service
@Transactional
public class TratamientoService {

	@Autowired
	private TratamientoRepository repo;

	//TODOS LOS TRATAMIENTOS
	public List<TratamientoVO> listAll() {
		List<TratamientoVO> tratamientos = repo.findAll();
		return tratamientos;
	}

	
	//TRATAMIENTO POR REFERENCIA
	public TratamientoVO findTratamiento(Long id) {
		Optional<TratamientoVO> tratamiento = repo.findById(id);
		if (tratamiento.isPresent()) {
			return tratamiento.get();
		}
		return null;
	}
	
	//GUARDAR TRATAMIENTO
	public TratamientoVO save(TratamientoVO tratamiento) {
		return repo.save(tratamiento);

	}

	
	//BORRAR TRATAMIENTO
	public void delete(Long id) {
		repo.deleteById(id);
	}


}