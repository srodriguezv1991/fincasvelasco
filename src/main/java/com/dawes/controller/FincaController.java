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
import com.dawes.model.FincaVO;
import com.dawes.services.ArbolService;
import com.dawes.services.FincaService;

@Controller
@RequestMapping("/finca")
public class FincaController {

	@Autowired
	ArbolService arbolservice;
	@Autowired
	FincaService fincaservice;

	// HOME FINCAS
	@RequestMapping("/homefincas")
	public String viewHomeFincas(Model model) {
		List<FincaVO> fincas = fincaservice.listAll();
		model.addAttribute("fincas", fincas);
		return "Finca/homefincas";
	}

	// CREAR FINCA
	@RequestMapping("/crearfinca")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("finca", new FincaVO());
		return "Finca/crearfinca";
	}

	// GUARDAR FINCA
	@RequestMapping("/guardarfinca")
	public ModelAndView guardarFinca(@ModelAttribute("finca") FincaVO finca) {
		fincaservice.save(finca);
		ModelAndView mav = new ModelAndView("Finca/homefincas");
		List<FincaVO> fincas = fincaservice.listAll();
		mav.addObject("fincas", fincas);
		return mav;
	}

	@RequestMapping(value = "/modificarfinca/guardarfinca", method = RequestMethod.POST)
	public ModelAndView guardarMFinca(@ModelAttribute("finca") FincaVO finca) {
		fincaservice.save(finca);
		ModelAndView mav = new ModelAndView("Finca/homefincas");
		List<FincaVO> fincas = fincaservice.listAll();
		mav.addObject("fincas", fincas);
		return mav;
	}

	// MODIFICAR FINCA
	@RequestMapping("/modificarfinca/{id}")
	public ModelAndView showModificarFinca(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("Finca/modificarfinca");
		FincaVO finca = fincaservice.findFinca(id);
		mav.addObject("finca", finca);
		return mav;
	}

	// BORRAR FINCA
	@RequestMapping("/borrarfinca/{id}")
	public String borrarFinca(@PathVariable(name = "id") Long id) {
		List<ArbolVO> arboles = arbolservice.listAll();
		for (ArbolVO arbolVO : arboles) {
			if (arbolVO.getFinca().getIdfinca() == id)
			arbolservice.delete((long) arbolVO.getIdarbol());
		}
		fincaservice.delete(id);
		return "redirect:/finca/homefincas";
	}

	// MAPA
	@RequestMapping("/mapafinca/{id}")
	public String viewHomeMapa(Model model, @PathVariable(name = "id") Long id) {
		int[][] matriz = { { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 },
				{ -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 } };
		FincaVO finca= fincaservice.findFinca(id);
		List<ArbolVO> arboles = arbolservice.listAll();
		for (ArbolVO arbolVO : arboles) {
			if (arbolVO.getFinca().getIdfinca() == id)
			matriz[arbolVO.getFila() - 1][arbolVO.getColumna() - 1] = arbolVO.getIdarbol();
		}
		model.addAttribute("matriz", matriz);
		model.addAttribute("finca", finca);
		return "mapa";
	}
}
