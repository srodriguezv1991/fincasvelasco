package com.dawes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.model.ArbolVO;

@Repository
public interface ArbolRepository extends JpaRepository<ArbolVO, Long> {

}
