package com.banking.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int id;
	
	@Column(name = "name")
	@NotEmpty(message="Enter user name.")
private String name;
	@Column(name = "email")
	@NotEmpty(message="Enter valid email")
private String email;
	@Column(name = "password")
	@NotEmpty(message="Enter password")
private String password;
	@Column(name = "phone")
	@NotEmpty(message="Enter phone number")
private String phone;
	@Column(name = "location")
	@NotEmpty(message="Enter location")
private String location;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

}
