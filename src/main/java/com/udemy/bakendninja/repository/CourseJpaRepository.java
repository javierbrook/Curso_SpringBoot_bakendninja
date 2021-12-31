package com.udemy.bakendninja.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.bakendninja.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable>{
	
	//Podemos escribir métodos personalizados cuyos nombres tienen un formato que acepta JpaRepository de acuerdo a la tabla asociada (métodos que se agregan a los que vienen por defecto), ejemplos:
	
	public Course findByPrice(int price); //Genera la query -> select * from FROM mydb.course where price = ?price
	
	public Course findByPriceAndName(int price, String name); //Genera la query -> select * from FROM mydb.course where price = ?price and name ?name
	
	public List<Course> findByNameOrderByHours(String name);  //Genera la query -> select * from FROM mydb.course where name ?name order by hours
	
	public Course findByNameOrPrice(String name, int price);  //Genera la query -> select * from FROM mydb.course where name ?name or price = ?price
	
}
