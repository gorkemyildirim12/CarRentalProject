package com.carRental.entity;

import java.util.Date;




public class Person {
	protected long personid;
	protected String name;
	protected String surname;
	protected Date birthDate;
	protected String idNumber;
	protected String email;
	protected String password;
	
	public long getPersonid() {
		return personid;
	}
	public void setPersonid(long personid) {
		this.personid = personid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Person(long personid, String name, String surname, Date birthDate, String idNumber, String email,
			String password) {
		this.personid = personid;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.idNumber = idNumber;
		this.email = email;
		this.password = password;
	}
	
	
	

}
