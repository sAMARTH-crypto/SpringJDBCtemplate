package com.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.demo.model.MaxIdMapper;
import com.demo.model.Person;
import com.demo.model.PersonMapper;

@Component
public class PersonDAOImpl implements PersonDAO {

	JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_PERSON = "select * from people where id = ?";
	private final String SQL_DELETE_PERSON = "delete from people where id = ?";
	private final String SQL_UPDATE_PERSON = "update people set first_name = ?, last_name = ?, age  = ? where id = ?";
	private final String SQL_GET_ALL = "select * from people";
	private final String SQL_INSERT_PERSON = "insert into people(id, first_name, last_name, age) values(?,?,?,?)";
	private final String SQL_MAX_ID = "select max(id) as maxid from people";

	@Autowired
	public PersonDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		if(dataSource != null)
			System.out.println("DB connected!");
	}

	public Person getPersonById(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] { id }, new PersonMapper());
		
	}

	public List<Person> getAllPersons() {
		return jdbcTemplate.query(SQL_GET_ALL, new PersonMapper());
	}
	
	public Person getMaxId() {
		return jdbcTemplate.queryForObject(SQL_MAX_ID, new MaxIdMapper());
	}

	public boolean deletePerson(Person person) {
		return jdbcTemplate.update(SQL_DELETE_PERSON, person.getId()) > 0;
	}

	public boolean updatePerson(Person person) {
		return jdbcTemplate.update(SQL_UPDATE_PERSON, person.getFirstName(), person.getLastName(), person.getAge(),
				person.getId()) > 0;
	}

	public boolean createPerson(Person person) {
		return jdbcTemplate.update(SQL_INSERT_PERSON, person.getId(), person.getFirstName(), person.getLastName(),
				person.getAge()) > 0;
	}
	
	public void createPersonUsingNamedParams() {
		
		if(jdbcTemplate.getDataSource() != null)
			System.out.println("Insdie DB connection...");
		
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
		
		String sql = "INSERT INTO people (id, first_name, last_name, age) VALUES (:id, :fname, :lname, :age)";
		 
		Map<String, String> params = new HashMap<>();
		
		params.put("id", Long.toString(getMaxId().getId() + 1));
		params.put("fname", "Tom");
		params.put("lname", "Hanks");
		params.put("age", "45");
		 
		int num = template.update(sql, params);
		System.out.println("Inserted! " + num);
	}
	
	public void createPersonUsingBeanPropertySqlParams(Person person) {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
		 
	    String sql = "INSERT INTO people (id, first_name, last_name, age) VALUES (:id, :firstName, :lastName, :age)";
	 
	    BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(person);
	 
	    int num = template.update(sql, paramSource);
	    System.out.println("Inserted with BEAN! " + num);
	}

}
