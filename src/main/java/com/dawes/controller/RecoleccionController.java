package com.dawes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dawes.model.RecoleccionVO;
import com.dawes.services.FincaService;
import com.dawes.services.RecoleccionService;
import com.dawes.services.VariedadService;



@Controller
@RequestMapping("/recoleccion")
public class RecoleccionController {
	@Autowired
	RecoleccionService recoleccionservice;
	@Autowired
	FincaService fincaservice;
	@Autowired
	VariedadService variedadservice;
	
	//HOME RECOLECCIONES
	@RequestMapping("/homerecolecciones")
	public String viewHomeRecoleccion(Model model) {
		List<RecoleccionVO> recolecciones = recoleccionservice.listAll();
		model.addAttribute("recolecciones", recolecciones);

		return "Recoleccion/homerecolecciones";
	}

	//CREAR RECOLECCION
	@RequestMapping("/crearrecoleccion")
	public String showCrearTratamiento(Model model) {
		RecoleccionVO r = new RecoleccionVO();
		model.addAttribute("recoleccion", r);
		model.addAttribute("finca", fincaservice.listAll());
	    model.addAttribute("variedad", variedadservice.listAll());
		return "Recoleccion/crearrecoleccion";
	}

	//GUARDAR RECOLECCION
	@RequestMapping(value = "/guardarrecoleccion", method = RequestMethod.POST)
	public ModelAndView guardarRecoleccion(@ModelAttribute("recoleccion") RecoleccionVO recoleccion) {
		recoleccionservice.save(recoleccion);
		ModelAndView mav = new ModelAndView("Recoleccion/homerecolecciones");
		List<RecoleccionVO> recolecciones = recoleccionservice.listAll();
		mav.addObject("recolecciones", recolecciones);
		return mav;
	}

	@RequestMapping(value = "/modificarrecoleccion/guardarrecoleccion", method = RequestMethod.POST)
	public ModelAndView guardarmoificaRecoleccion(@ModelAttribute("recoleccion") RecoleccionVO recoleccion) {
		recoleccionservice.save(recoleccion);
		ModelAndView mav = new ModelAndView("Recoleccion/homerecolecciones");
		List<RecoleccionVO> recolecciones = recoleccionservice.listAll();
		mav.addObject("recolecciones", recolecciones);
		return mav;
		}
	
	//MODIFICAR RECOLECCION
	@RequestMapping("/modificarrecoleccion/{id}")
	public ModelAndView showModificarrecoleccion(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("Recoleccion/modificarrecoleccion");
		RecoleccionVO recoleccion = recoleccionservice.findRecoleccion(id);
		mav.addObject("recoleccion", recoleccion);
		return mav;
	}

	//BORRAR RECOLECCION
	@RequestMapping("/borrarrecoleccion/{id}")
	public String borrarFinca(@PathVariable(name = "id") Long id) {
		recoleccionservice.delete(id);
		return "redirect:/recoleccion/homerecolecciones";
	}

}
