package com.rc.easymockexample.dao;

import java.util.HashSet;
import java.util.Set;

import com.rc.easymockexample.model.User;

/**
 * The <code>UserDao</code> class contains data access methods for the user
 * entity.
 * 
 * @author rartavia
 */
public class UserDao {

	public UserDao() {
		super();
	}

	public User save(User user) {
		return user;
	}

	public User get(Integer id) {
		return new User();
	}

	public User get(String email) {
		return new User();
	}

	public Set<User> getUsers() {
		User user = new User();
		Set<User> users = new HashSet<User>(0);
		users.add(user);
		return users;
	}
}
