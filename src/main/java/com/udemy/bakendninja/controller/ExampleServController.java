package com.udemy.bakendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.bakendninja.service.ExampleService;

@Controller
@RequestMapping("/exampleService")
public class ExampleServController {
	
	public static final String INSERT_LISTADOS = "insertListados";
	
	@Autowired
	private ExampleService exampleServ;
	
	@GetMapping("/string")
	public String exampleString(Model model) {
		model.addAttribute("people", exampleServ.getPeople());
		return INSERT_LISTADOS;
	}
}
