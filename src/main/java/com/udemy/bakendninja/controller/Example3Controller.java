package com.udemy.bakendninja.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.bakendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	@GetMapping("/showform")
	public String showForm(Model model) {
//		LOGGER.info("INFO TRACE");
//		LOGGER.warn("WARNIG TRACE");
//		LOGGER.error("ERROR TRACE");
//		LOGGER.debug("DEBUG TRACE"); //Esta traza sale solo en Debug		
		model.addAttribute("person", new Person());
		//int i = 4/0;
		return FORM_VIEW;
	}
	
//	@PostMapping("/addperson")
//	public ModelAndView addPerson(@ModelAttribute("person") Person person_post) {
//		ModelAndView mav = new ModelAndView();
//		//LOGGER.info("METHOD: 'addPerson' --- PARAMS: '"+person_post+"'");
//		mav.addObject("person", person_post);
//		mav = new ModelAndView(RESULT_VIEW);
//		return mav;
//	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person_post, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		LOGGER.info("METHOD: 'addPerson' --- PARAMS: '"+person_post+"'");
		if(bindingResult.hasErrors()) {
			mav = new ModelAndView(FORM_VIEW);
		}else {
			mav.addObject("person", person_post);
			mav = new ModelAndView(RESULT_VIEW);
		}
		return mav;
	}

    //1ra forma de redirigir	
//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/example3/showform";
//	}
	
	 //2da forma de redirigir
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
			
}
