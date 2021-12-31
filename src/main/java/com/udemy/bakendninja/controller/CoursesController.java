package com.udemy.bakendninja.controller;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.java.Log;

import com.udemy.bakendninja.model.CourseModel;
import com.udemy.bakendninja.service.CoursesService;

@Log
@Controller
@RequestMapping("/courses")
public class CoursesController {
	
	public static final String COURSES_LIST = "coursesList";
	//public static final Log LOG = LogFactory.getLog(CoursesController.class);
	
	@Autowired
	private CoursesService coursesService;
		
	@GetMapping("/courseslist")
	public ModelAndView coursesList() {
		log.info("Call: "+ "CoursesController.coursesList()");
		ModelAndView mav = new ModelAndView(COURSES_LIST); 
		mav.addObject("courses", coursesService.listAllCourses());
		mav.addObject("course_post", new CourseModel()); //Objeto vacío para formulario
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course_post") CourseModel courseModel) {
		log.info("Call: "+ "CoursesController.addCourse()"+" -- Param: "+courseModel);
		coursesService.addCourse(courseModel);
		return "redirect:/courses/courseslist";
	}
	
}
