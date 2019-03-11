package com.ajeanne.servlet;

public class User {
	private String email;
	private String name;
	private String passwd;
	
	public User(String email, String name, String pwd) {
		this.email = email;
		this.name = name;
		this.passwd = pwd;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
