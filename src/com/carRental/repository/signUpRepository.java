package com.carRental.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.carRental.entity.Person;

public class signUpRepository extends BaseRepository{
	public boolean insert(Person person) throws Exception{
		connect();
		String sql = "insert into sign_up_info(name , surname , birthDate , idNumber , email , password) "
				+ "values(? , ? , ? , ? , ? , ? )";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, person.getName());
		statement.setString(2, person.getSurname());
		statement.setDate(3, (Date) person.getBirthDate());
		statement.setString(4, person.getIdNumber());
		statement.setString(5, person.getEmail());
		statement.setString(6, person.getPassword());
		
		int affected = statement.executeUpdate();
		disconnect();
		return affected > 0;
	}
	
	public boolean authentication(String email , String password) throws Exception{
		boolean authenticated = false;
		connect();
		String query = "select email , password from sign_up_info where email = ? and password = ? ";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, password);
		ResultSet resultset = statement.executeQuery(); 
		if(resultset.next()) {
			authenticated = true;
		}
		
		disconnect();
		return authenticated;
	}
}
