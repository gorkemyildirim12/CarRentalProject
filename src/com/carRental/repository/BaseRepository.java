package com.carRental.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseRepository {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/carrentalproject?useSSL=false";
	private String user = "root";
	private String password = "Godoro";
	
	protected Connection connection;
	
	public BaseRepository() {
		try {
			Class.forName(driver).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void connect() throws Exception{
		connection = DriverManager.getConnection(url , user , password);
	}
	protected void disconnect() throws Exception{
		connection.close();
	}

}
