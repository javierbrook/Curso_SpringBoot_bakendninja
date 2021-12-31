package com.udemy.bakendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.bakendninja.model.Person;
import com.udemy.bakendninja.service.ExampleService;

@Service
public class ExampleServiceImpl implements ExampleService{

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getPeople() {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Tony", 43));
		people.add(new Person("Pedro", 3));
		people.add(new Person("Ana", 12));
		people.add(new Person("Rita", 51));
		LOG.info("HELLO FROM SERVICE");
		return people;
	}

}
