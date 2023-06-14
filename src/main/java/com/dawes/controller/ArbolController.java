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

import com.dawes.model.ArbolVO;
import com.dawes.model.TratamientoArbolVO;
import com.dawes.services.ArbolService;
import com.dawes.services.FincaService;
import com.dawes.services.TratamientoArbolService;
import com.dawes.services.VariedadService;

@Controller
@RequestMapping("/arbol")
public class ArbolController {

	@Autowired
	ArbolService arbolservice;
	@Autowired
	FincaService fincaservice;
	@Autowired
	VariedadService variedadservice;
	@Autowired
	TratamientoArbolService tratamientoarbolservice;

	// HOME ARBOL
	@RequestMapping("/homearboles")
	public String viewHomeFincas(Model model) {
		List<ArbolVO> arboles = arbolservice.listAll();
		model.addAttribute("arboles", arboles);
		return "Arbol/homearboles";
	}

	// CREAR ARBOL
	@RequestMapping("/creararbol")
	public String forminsertar(Model model) {
		model.addAttribute("arbol", new ArbolVO());
		model.addAttribute("finca", fincaservice.listAll());
		model.addAttribute("variedad", variedadservice.listAll());
		return "Arbol/creararbol";
	}

	// GUARDAR ARBOL
	@RequestMapping("/guardararbol")
	public ModelAndView guardarArbol(@ModelAttribute("arbol") ArbolVO arbol) {
		arbolservice.save(arbol);
		ModelAndView mav = new ModelAndView("Arbol/homearboles");
		List<ArbolVO> arboles = arbolservice.listAll();
		mav.addObject("arboles", arboles);
		return mav;
	}

	@RequestMapping(value = "/modificararbol/guardararbol", method = RequestMethod.POST)
	public ModelAndView guardarMArbol(@ModelAttribute("arbol") ArbolVO arbol) {
		arbolservice.save(arbol);
		ModelAndView mav = new ModelAndView("Arbol/homearboles");
		List<ArbolVO> arboles = arbolservice.listAll();
		mav.addObject("arboles", arboles);
		return mav;
	}

	// MODIFICAR ARBOL
	@RequestMapping("/modificararbol/{id}")
	public ModelAndView showModificarArbol(Model model, @PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("Arbol/modificararbol");
		ArbolVO arbol = arbolservice.findArbol(id);
		model.addAttribute("finca", fincaservice.listAll());
		model.addAttribute("variedad", variedadservice.listAll());
		mav.addObject("arbol", arbol);
		return mav;
	}

	// BORRAR ARBOL
	@RequestMapping("/borrararbol/{id}")
	public String borrarArbol(@PathVariable(name = "id") Long id) {
		List<TratamientoArbolVO> tratamientosarboles = tratamientoarbolservice.listAll();
		for (TratamientoArbolVO ta : tratamientosarboles) {
			if (ta.getTratamiento().getIdtratamiento() == id)
				tratamientoarbolservice.delete((long) ta.getIdtratamientoarbol());
		}
		arbolservice.delete(id);
		return "redirect:/arbol/homearboles";
	}

}
