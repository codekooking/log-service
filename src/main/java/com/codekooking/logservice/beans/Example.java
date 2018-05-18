package com.codekooking.logservice.beans;

public class Example {
	
	private String name;
	
	private String email;

	public Example() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Example(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Example [name=" + name + ", email=" + email + "]";
	}
}
