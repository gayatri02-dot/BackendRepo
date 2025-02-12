package com.Bean;

import java.io.Serializable;

public class CustLoginBean implements Serializable {
	String username;
	String password;
	
	public CustLoginBean() {
		super();
	}

	public CustLoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "LoginBean [username=" + username + ", password=" + password + "]";
	}
	
	
	
}

