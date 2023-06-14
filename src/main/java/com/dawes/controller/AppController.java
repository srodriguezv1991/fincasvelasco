package com.dawes.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dawes.model.UsuarioVO;
import com.dawes.services.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;




@Controller
public class AppController {
	
	UsuarioService usuarioservice;
	
	
	@RequestMapping("/index")
	public String principal() {
		return "index";
	}
	@RequestMapping("/admin")
	public String administrador() {
		return "Admin/admin";
	}
	@RequestMapping("/")
	public String user() {
		return "index";
	}
	
	@RequestMapping("/403")
	public String p403() {
		return "Error/403";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "Logs/login";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "Logs/logout";
	}
	
	@RequestMapping("/salir")
	public String salir(HttpServletRequest request) {
		request.getSession(true).invalidate();
		return "index";
	}
}
