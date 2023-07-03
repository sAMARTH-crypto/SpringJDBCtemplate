package com.demo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.config.AppConfig;
import com.demo.dao.PersonDAO;
import com.demo.model.Person;

public class AppNamedParams {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		//personDAO.createPersonUsingNamedParams();
		
		Person person = new Person(9L, 25, "John", "Smith");
		personDAO.createPersonUsingBeanPropertySqlParams(person);

	}

}
