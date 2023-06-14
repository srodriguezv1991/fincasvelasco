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

import com.dawes.model.VariedadVO;
import com.dawes.services.VariedadService;


@Controller
@RequestMapping("/variedad")
public class VariedadController {
	
	@Autowired
	VariedadService variedadservice;
	
	//HOME VARIEDADES
	@RequestMapping("/homevariedades")
	public String viewHomeVariedades(Model model) {
		List<VariedadVO> variedades = variedadservice.listAll();
		model.addAttribute("variedades", variedades);
		return "Variedad/homevariedades";
	}
	
	//CREAR VARIEDAD
	@RequestMapping("/crearvariedad")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("variedad", new VariedadVO());
		return "Variedad/crearvariedad";
	}
	
	//GUARDAR VARIEDAD
		@RequestMapping("/guardarvariedad")
		public ModelAndView guardarVariedad(@ModelAttribute("variedad") VariedadVO variedad) {
			variedadservice.save(variedad);
			ModelAndView mav = new ModelAndView("Variedad/homevariedades");
			List<VariedadVO> variedades = variedadservice.listAll();
			mav.addObject("variedades", variedades);
			return mav;
		}
		@RequestMapping(value = "/modificarvariedad/guardarvariedad", method = RequestMethod.POST)
		public ModelAndView guardarMVariedad(@ModelAttribute("variedad") VariedadVO variedad) {
			variedadservice.save(variedad);
			ModelAndView mav = new ModelAndView("Variedad/homevariedades");
			List<VariedadVO> variedades = variedadservice.listAll();
			mav.addObject("variedades", variedades);
			return mav;
		}
	
		//MODIFICAR VARIEDAD
		@RequestMapping("/modificarvariedad/{id}")
		public ModelAndView showModificarVariedad(@PathVariable(name = "id") Long id) {
			ModelAndView mav = new ModelAndView("Variedad/modificarvariedad");
			VariedadVO variedad = variedadservice.findVariedad(id);
			mav.addObject("variedad", variedad);
			return mav;
		}
		
		//BORRAR VARIEDAD
		@RequestMapping("/borrarvariedad/{id}")
		public String borrarVariedad(@PathVariable(name = "id") Long id) {
			variedadservice.delete(id);
			return "redirect:/variedad/homevariedades";
		}
}