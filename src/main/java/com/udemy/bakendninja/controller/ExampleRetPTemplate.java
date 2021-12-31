package com.udemy.bakendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exampleRetT")
public class ExampleRetPTemplate {
	
	public static final String FORMAS_RET_TEMP_VIEW = "formasDeRetPlantilla";
	
	//1ra Forma
	@GetMapping("/exampleString")
	public String exampleString() {
		return FORMAS_RET_TEMP_VIEW;
	}
	
	//2da Forma
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		return new ModelAndView(FORMAS_RET_TEMP_VIEW);
	}
	
}
