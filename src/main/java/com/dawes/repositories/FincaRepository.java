package com.dawes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.model.FincaVO;

@Repository
public interface FincaRepository extends JpaRepository<FincaVO, Long> {

}
