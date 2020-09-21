package com.entity;

public class Token {
	private int id;
	private String token;
	private String email;
	
	public Token() {
		
	}
	
	public Token(int id, String token, String email) {
		super();
		this.id = id;
		this.token = token;
		this.email = email;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
