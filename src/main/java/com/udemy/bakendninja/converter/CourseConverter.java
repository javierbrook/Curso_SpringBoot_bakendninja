package com.udemy.bakendninja.converter;

import org.springframework.stereotype.Component;

import com.udemy.bakendninja.entity.Course;
import com.udemy.bakendninja.model.CourseModel;

@Component
public class CourseConverter {
	
	//Entity -> Model
	public CourseModel entityToModel(Course course) {
		CourseModel courseModel = new CourseModel();
		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getPrice());
		courseModel.setHours(course.getHours());
		return courseModel;
	}
	
	//Model -> Entity
    public Course modelToEntity(CourseModel courseModel) {
    	Course course = new Course();
    	course.setName(courseModel.getName());
    	course.setDescription(courseModel.getDescription());
    	course.setPrice(courseModel.getPrice());
    	course.setHours(courseModel.getHours());
    	return course;
    }
	
}
