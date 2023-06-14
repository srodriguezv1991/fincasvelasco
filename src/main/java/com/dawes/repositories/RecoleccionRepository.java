package com.dawes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.model.RecoleccionVO;

@Repository
public interface RecoleccionRepository extends JpaRepository<RecoleccionVO, Long>{

}
