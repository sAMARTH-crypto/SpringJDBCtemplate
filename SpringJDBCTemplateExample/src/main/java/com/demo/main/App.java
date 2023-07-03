package com.demo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.config.AppConfig;
import com.demo.dao.PersonDAO;
import com.demo.model.Person;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		/*Person personById = personDAO.getPersonById(1L);
		System.out.println(personById);
		/*System.out.println("List of person is:");

		for (Person p : personDAO.getAllPersons()) {
			System.out.println(p);
		}

		System.out.println("\nGet person with ID 1");

		;*/

		/*System.out.println("\nCreating person: ");
		Person person4 = new Person(4L, 36, "Sergey", "Emets");
		System.out.println(person4);
		personDAO.createPerson(person4);
		System.out.println("\nList of person is:");

		for (Person p : personDAO.getAllPersons()) {
			System.out.println(p);
		}*/

		/*System.out.println("\nDeleting person with ID 1");
		personDAO.deletePerson(personById);

		System.out.println("\nUpdate person with ID 4");

		Person pperson = personDAO.getPersonById(4L);
		pperson.setLastName("CHANGED");
		personDAO.updatePerson(pperson);

		System.out.println("\nList of person is:");
		for (Person p : personDAO.getAllPersons()) {
			System.out.println(p);
		}*/
		
		
		/*
		personDAO.createPersonUsingNamedParams();		
	    Person person = new Person(6L, 30, "John", "Smith");
	    personDAO.createPersonUsingBeanPropertySqlParams(person);
		*/

		context.close();
	}

}
