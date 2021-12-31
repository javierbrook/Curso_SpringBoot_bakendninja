package com.udemy.bakendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.bakendninja.component.ExampleComponent;

@Controller
@RequestMapping("/exampleComponent")
public class ExampleComponentController {

	@Autowired
	@Qualifier("exampleComponent")
	ExampleComponent examplComp;
	
	@GetMapping("/usesComp")
	public String usesComp() {
		examplComp.sayHello();
		return "500";
	}
}
