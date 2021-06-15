package com.example.demo.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationForm {

	  private String username;
	  private String password;
	  private String fullname;
	  private String street;
	  private String city;
	  
	  public User toUser(PasswordEncoder passwordEncoder) {
	    return new User(
	        username, passwordEncoder.encode(password), 
	        fullname, street, city);
	  }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	  
	  
}
