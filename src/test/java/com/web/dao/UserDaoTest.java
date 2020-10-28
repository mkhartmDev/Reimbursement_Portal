package com.web.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
	
	private UserDao use;
	
	
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
	

}
