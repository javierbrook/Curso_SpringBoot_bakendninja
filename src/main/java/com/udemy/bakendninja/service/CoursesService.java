package com.udemy.bakendninja.service;

import java.util.List;

import com.udemy.bakendninja.entity.Course;
import com.udemy.bakendninja.model.CourseModel;

public interface CoursesService {
	
	public List<Course> listAllCourses();
	public CourseModel addCourse(CourseModel courseModel);
	public int removeCourse(int id);
	public CourseModel updateCourse(CourseModel courseModel);	
}
