package com.web.model;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;

import com.web.controller.UserController;

public class ModelTest {
	
	private UserController uc;
	public User use = new User();
	HttpServletRequest req;
	public Reimburse re = new Reimburse();
	LocalDateTime l;
	byte[] m;
	
	@Before
	public void start()
	{
		uc = new UserController();
	}
	
	@Test
	public void ModelTest()
	{
		
		assertTrue(true);
	}

}
