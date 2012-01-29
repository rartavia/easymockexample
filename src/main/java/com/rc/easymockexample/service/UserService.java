package com.rc.easymockexample.service;

import com.rc.easymockexample.dao.UserDao;
import com.rc.easymockexample.model.User;

/**
 * The <code>UserService</code> class contains methods with business logic
 * related to the user entity.
 * 
 * @author rartavia
 * 
 */
public class UserService {

	private UserDao userDao;

	public UserService() {
		super();
	}

	/**
	 * Verifies if the user already exists, given an email.
	 * 
	 * @param email
	 *            the email to be checked
	 * @return <ul>
	 *         <li><code>true</code> if the user already exists</li>
	 *         <li><code>false</code> otherwise</li>
	 *         </ul>
	 */
	public boolean registedUser(String email) {
		boolean registeredUser = false;
		User user = userDao.get(email);
		if (user != null) {
			registeredUser = true;
		}
		return registeredUser;
	}

	/**
	 * Verifies if the user already exists and creates a new record when the
	 * user is new.
	 * 
	 * @param user
	 *            a <code>User</code> model
	 * @return the user
	 * @throws UserExistException
	 *             if the user already exists
	 */
	public User signUp(User user) throws UserExistException {
		boolean registedUser = registedUser(user.getUsername());
		if (registedUser) {
			throw new UserExistException();
		}
		userDao.save(user);
		return user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
