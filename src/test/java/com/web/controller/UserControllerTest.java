package com.web.controller;

import static org.junit.Assert.assertTrue;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.ReimbursementDao;
import com.web.model.Reimburse;
import com.web.model.User;

public class UserControllerTest {
	
	private UserController uc;
	public User use = new User();
	HttpServletRequest req;
	
	@Before
	public void start()
	{
		uc = new UserController();
	}
	
	@Test
	public void FindAllTest()
	{
		//String test = uc.login(req);
		assertTrue(true);
	}

}
