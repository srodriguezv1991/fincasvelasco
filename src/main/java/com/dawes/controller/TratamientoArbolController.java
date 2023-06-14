package com.dawes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawes.model.TratamientoArbolVO;
import com.dawes.services.ArbolService;
import com.dawes.services.FincaService;
import com.dawes.services.TratamientoArbolService;
import com.dawes.services.TratamientoService;
import com.dawes.services.VariedadService;

@Controller
@RequestMapping("/tratamientoarbol")
public class TratamientoArbolController {

	@Autowired
	ArbolService arbolservice;
	@Autowired
	FincaService fincaservice;
	@Autowired
	VariedadService variedadservice;
	@Autowired
	TratamientoService tratamientoservice;
	@Autowired
	TratamientoArbolService tratamientoarbolservice;
	
	
	// HOME TRATAMIENTOARBOL
	@RequestMapping("/hometratamientosarboles")
	public String viewHomeTratamientoArboles(Model model) {
		List<TratamientoArbolVO> tratamientosarboles = tratamientoarbolservice.listAll();
		model.addAttribute("tratamientosarboles", tratamientosarboles);
		return "TratamientoArbol/hometratamientosarboles";
	}

	// CREAR TRATAMIENTOARBOL
	@RequestMapping("/creartratamientoarbol")
	public String forminsertar(Model model) {
		model.addAttribute("tratamientoarbol", new TratamientoArbolVO());
		model.addAttribute("arbol", arbolservice.listAll());
		model.addAttribute("tratamiento", tratamientoservice.listAll());
		return "TratamientoArbol/creartratamientoarbol";
	}

	// GUARDAR TRATAMIENTOARBOL
	@RequestMapping("/guardartratamientoarbol")
	public ModelAndView guardarTratamientoArbol(@ModelAttribute("tratamientoarbol") TratamientoArbolVO tratamientoarbol) {
		tratamientoarbolservice.save(tratamientoarbol);
		ModelAndView mav = new ModelAndView("TratamientoArbol/hometratamientosarboles");
		List<TratamientoArbolVO> tratamientosarboles = tratamientoarbolservice.listAll();
		mav.addObject("tratamientosarboles", tratamientosarboles);
		return mav;
	}

	// BORRAR TRATAMIENTOARBOL
	@RequestMapping("/borrartratamientoarbol/{id}")
	public String borrarTratamientoArbol(@PathVariable(name = "id") Long id) {
		tratamientoarbolservice.delete(id);
		return "redirect:/TratamientoArbol/hometratamientosarboles";
	}
}
