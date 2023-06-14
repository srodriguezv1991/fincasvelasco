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

import com.dawes.model.TratamientoVO;
import com.dawes.services.TratamientoService;


@Controller
@RequestMapping("/tratamiento")
public class TratamientoController {
	@Autowired
	TratamientoService tratamientoservice;
	
	//HOME TRATAMIENTOS
	@RequestMapping("/hometratamientos")
	public String viewHomeTratameintos(Model model) {
		List<TratamientoVO> tratamientos = tratamientoservice.listAll();
		model.addAttribute("tratamientos", tratamientos);
		return "Tratamiento/hometratamientos";
	}
	
	//CREAR TRATAMIENTO
	@RequestMapping("/creartratamiento")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("tratamiento", new TratamientoVO());
		return "Tratamiento/creartratamiento";
	}
	
	//GUARDAR TRATAMIENTO
	@RequestMapping("/guardartratamiento")
	public ModelAndView guardarTratamiento(@ModelAttribute("tratamiento") TratamientoVO tratamiento) {
		tratamientoservice.save(tratamiento);
		ModelAndView mav = new ModelAndView("Tratamiento/hometratamientos");
		List<TratamientoVO> tratamientos = tratamientoservice.listAll();
		mav.addObject("tratamientos", tratamientos);
		return mav;
	}
	@RequestMapping(value = "/modificartratamiento/guardartratamiento", method = RequestMethod.POST)
	public ModelAndView guardarMTratamiento(@ModelAttribute("tratamiento") TratamientoVO tratamiento) {
		tratamientoservice.save(tratamiento);
		ModelAndView mav = new ModelAndView("Tratamiento/hometratamientos");
		List<TratamientoVO> tratamientos = tratamientoservice.listAll();
		mav.addObject("tratamientos", tratamientos);
		return mav;
	}
	
	//MODIFICAR TRATAMIENTO
	@RequestMapping("/modificartratamiento/{id}")
	public ModelAndView showModificarTratamiento(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("Tratamiento/modificartratamiento");
		TratamientoVO tratamiento = tratamientoservice.findTratamiento(id);
		mav.addObject("tratamiento", tratamiento);
		return mav;
	}
	
	//BORRAR TRATAMIENTO
	@RequestMapping("/borrartratamiento/{id}")
	public String borrarTratamiento(@PathVariable(name = "id") Long id) {
		tratamientoservice.delete(id);
		return "redirect:/tratamiento/hometratamientos";
	}
}