package com.dawes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dawes.model.RolVO;
import com.dawes.model.UsuarioVO;
import com.dawes.repositories.UsuarioRepositorio;

@Service
public class UsuarioService implements UserDetailsService {
	@Autowired
	UsuarioRepositorio ur;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return ur.findByUsername(username);
	}
	public void save(UsuarioVO usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		usuario.setRol(RolVO.USER);
		ur.save(usuario);
	}

}
