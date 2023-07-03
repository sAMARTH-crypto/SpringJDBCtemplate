package com.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MaxIdMapper implements RowMapper<Person> {
	
	public Person mapRow(ResultSet resultSet, int i) throws SQLException {

		Person person = new Person();
		person.setId(resultSet.getLong("maxid"));
		return person;
	}
}
