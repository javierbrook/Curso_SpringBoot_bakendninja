package com.udemy.bakendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.bakendninja.model.Person;

@Controller
@RequestMapping("/exampleListados")
public class InsertListados {
	
	public static final String INSERT_LISTADOS = "insertListados";
	
	//1ra Forma
	@GetMapping("/string")
	public String exampleString(Model model) {
		model.addAttribute("people", getPeople());
		return INSERT_LISTADOS;
	}
	
	//2da Forma
	@GetMapping("/mav")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(INSERT_LISTADOS);
		mav.addObject("people", getPeople());
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Tony", 43));
		people.add(new Person("Pedro", 3));
		people.add(new Person("Ana", 12));
		people.add(new Person("Rita", 51));
		return people;
	}
	
}
