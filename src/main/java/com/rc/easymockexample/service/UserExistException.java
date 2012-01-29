package com.rc.easymockexample.service;

/**
 * The <code>UserExistException</code> class represents indicates when a user
 * was not found.
 * 
 * @author rartavia
 */
public class UserExistException extends Exception {

	private static final long serialVersionUID = 6689884870315681825L;

	public UserExistException() {
		super();
	}

	public UserExistException(String message) {
		super(message);
	}

	public UserExistException(Throwable cause) {
		super(cause);
	}

	public UserExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
