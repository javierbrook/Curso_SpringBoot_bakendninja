package com.udemy.bakendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exampleDatosSimples")
public class InsertDatosSimples {
	
	public static final String INSERT_DATOS_SIMPLES = "insertDatosSimples";
	
	//1ra Forma
	@GetMapping("/string")
	public String exampleString(Model model) {
		model.addAttribute("name", "Pedro");
		return INSERT_DATOS_SIMPLES;
	}
	
	//2da Forma
	@GetMapping("/mav")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(INSERT_DATOS_SIMPLES);
		mav.addObject("name", "Tony");
		return mav;
	}
	
}
