package com.dawes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.model.TratamientoVO;

@Repository
public interface TratamientoRepository extends JpaRepository<TratamientoVO, Long>{

}
