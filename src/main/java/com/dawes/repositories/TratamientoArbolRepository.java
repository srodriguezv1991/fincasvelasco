package com.dawes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dawes.model.ArbolVO;
import com.dawes.model.TratamientoArbolVO;

@Repository
public interface TratamientoArbolRepository extends JpaRepository<TratamientoArbolVO, Long>{

	@Query("select c from TratamientoArbolVO c where arbol=:arbol")
	Optional<List<TratamientoArbolVO>> findAllByArbol(ArbolVO arbol);
}
