package com.udemy.bakendninja.service.impl;

import java.util.List;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.bakendninja.converter.CourseConverter;
import com.udemy.bakendninja.entity.Course;
import com.udemy.bakendninja.model.CourseModel;
import com.udemy.bakendninja.repository.CourseJpaRepository;
import com.udemy.bakendninja.service.CoursesService;
import lombok.extern.java.Log;

@Log
@Service
public class CoursesServiceImpl implements CoursesService{

//	public static final Log LOG = LogFactory.getLog(CoursesServiceImpl.class);
	
	@Autowired
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	private CourseConverter courseConverter;
	
	@Override
	public List<Course> listAllCourses() {
		log.info("Call: "+ "CoursesServiceImpl.listAllCourses()");
		return courseJpaRepository.findAll();
	}

	@Override
	public CourseModel addCourse(CourseModel courseModel) {
		log.info("Call: "+ "CoursesServiceImpl.addCourse()");
		return courseConverter.entityToModel(courseJpaRepository.save(courseConverter.modelToEntity(courseModel)));
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public CourseModel updateCourse(CourseModel courseModel) {
		return courseConverter.entityToModel(courseJpaRepository.save(courseConverter.modelToEntity(courseModel)));
	}

	
}
