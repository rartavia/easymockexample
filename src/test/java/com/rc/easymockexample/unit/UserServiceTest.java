package com.rc.easymockexample.unit;

import static org.easymock.EasyMock.expect;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rc.easymockexample.dao.UserDao;
import com.rc.easymockexample.model.User;
import com.rc.easymockexample.service.UserExistException;
import com.rc.easymockexample.service.UserService;

/**
 * The <code>UserServiceTest</code> class that represents a unit test for the
 * {@link UserService} class.
 * 
 * @author rartavia
 */
public class UserServiceTest {

	private IMocksControl iMocksControl;
	private UserService userService;
	private UserDao userDaoMock;

	public UserServiceTest() {
		super();
	}

	/**
	 * Sets the requirements for the test.
	 * <p>
	 * Initializes the control and the mocks for the test, this step should be
	 * done before each test method.
	 */
	@Before
	public void setUp() {
		// Initializes the easymock control.
		iMocksControl = EasyMock.createControl();
		// Initializes the class to be tested.
		userService = new UserService();
		// Creates the mock for the DAO object.
		userDaoMock = iMocksControl.createMock(UserDao.class);
		// Injects the mock.
		userService.setUserDao(userDaoMock);
	}

	/**
	 * Resets the control after each test method.
	 */
	@After
	public void tearDown() {
		// Verify if all the behavior was executed as expected.
		iMocksControl.verify();
	}

	@Test
	public void nonRegistedUser() {
		boolean registedUser;
		String email = "somebody@somehost.com";

		expect(userDaoMock.get((String) EasyMock.anyObject())).andReturn(null);
		iMocksControl.replay();
		registedUser = userService.registedUser(email);

		Assert.assertFalse(registedUser);
	}

	@Test
	public void registedUser() {
		boolean registedUser;
		User user = new User();
		String email = "somebody@somehost.com";

		expect(userDaoMock.get((String) EasyMock.anyObject())).andReturn(user);
		iMocksControl.replay();
		registedUser = userService.registedUser(email);

		Assert.assertTrue(registedUser);
	}

	@Test(expected = UserExistException.class)
	public void signUpExitentUser() throws UserExistException {
		User user = new User();

		expect(userDaoMock.get((String) EasyMock.anyObject())).andReturn(
				new User());
		iMocksControl.replay();
		user = userService.signUp(user);
	}

	@Test
	public void signUp() throws UserExistException {
		User user = new User();

		expect(userDaoMock.get((String) EasyMock.anyObject())).andReturn(null);
		expect(userDaoMock.save(user)).andReturn(user);
		iMocksControl.replay();
		user = userService.signUp(user);

		Assert.assertNotNull(user);
	}
}
