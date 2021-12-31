package com.udemy.bakendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class RecibePetGet2 {
	
	//localhost:8080/example2/request1/Pedro
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name) {
		ModelAndView mav = new ModelAndView("recibePetGet");
		mav.addObject("nm_in_model", name);
		return mav;
	}

}
