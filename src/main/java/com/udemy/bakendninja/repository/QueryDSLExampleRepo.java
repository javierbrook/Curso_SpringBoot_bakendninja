package com.udemy.bakendninja.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.bakendninja.entity.Course;
import com.udemy.bakendninja.entity.QCourse;

@Repository
public class QueryDSLExampleRepo {

	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	
	//Método que permite encontrar un curso que si exit=true, devuelve el curso con descripción finalizada en 'OP' y id=23, y sino, con descripción finalizada en 'OP' y con nombre finalizado en 'OP' 
	public Course find(boolean exist) {
		
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		BooleanBuilder predicateBuider = new BooleanBuilder(qCourse.description.endsWith("OP")); //Variable para añadir todo lo que va en la clausula 'where'
		 
		if(exist){
			predicateBuider.and(qCourse.id.eq(23));
		}else {
			predicateBuider.and(qCourse.name.endsWith("OP"));
		}
		
		return query.select(qCourse).from(qCourse).where(predicateBuider).fetchOne();
	}
}
