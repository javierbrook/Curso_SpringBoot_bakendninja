package com.udemy.bakendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.bakendninja.model.Person;

@Controller
@RequestMapping("/exampleDatosComplejos")
public class InsertDatosComplejos {
	
	public static final String INSERT_DATOS_COMPLEJOS = "insertDatosComplejos";
	
	//1ra Forma
	@GetMapping("/string")
	public String exampleString(Model model) {
		model.addAttribute("person", new Person("Pedro", 23));
		return INSERT_DATOS_COMPLEJOS;
	}
	
	//2da Forma
	@GetMapping("/mav")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(INSERT_DATOS_COMPLEJOS);
		mav.addObject("person", new Person("Tony", 43));
		return mav;
	}
	
}
