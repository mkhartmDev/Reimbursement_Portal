package com.web.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.web.model.User;

public class UserDaoTest {
	
	private UserDao use;
	private User user = new User();
	
	
	@Before
	public void start()
	{
		use = new UserDao();
	}
	
	@Test
	public void FindAllTest()
	{
		use.findAll();
		assertTrue(true);
	}
	
	@Test
	public void LoginTest()
	{
		use.LoginCheck("employee1", "password1");
		assertTrue(true);
	}
	
	@Test
	public void UsernameTest()
	{
		user = use.findByUsername("employee1");
		assertTrue(user != null);
	}
	

}
