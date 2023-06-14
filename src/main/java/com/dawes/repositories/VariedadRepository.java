package com.dawes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.model.VariedadVO;

@Repository
public interface VariedadRepository extends JpaRepository<VariedadVO, Long>{

}
