package com.rc.easymockexample.model;

/**
 * The <code>User</code> class represents a model that contains the user
 * information.
 * 
 * @author rartavia
 */
public class User {

	private Integer id;
	private String username;
	private String password;

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
