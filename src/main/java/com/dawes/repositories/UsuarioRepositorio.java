package com.dawes.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.dawes.model.UsuarioVO;


@Repository
public interface UsuarioRepositorio extends CrudRepository<UsuarioVO, Integer> {
	UserDetails findByUsername(String username);
}
