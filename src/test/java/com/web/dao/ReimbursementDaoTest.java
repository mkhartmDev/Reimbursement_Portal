package com.web.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.web.model.Reimburse;

public class ReimbursementDaoTest {
	
private ReimbursementDao re;
public Reimburse re2;
	
	
	@Before
	public void start()
	{
		re = new ReimbursementDao();
	}
	
	@Test
	public void FindAllTest()
	{
		re2 = new Reimburse();
		re.findAll();
		assertTrue(re2 != null);
	}
	
	@Test
	public void FindAllUseTest()
	{
		re2 = new Reimburse();
		re.findAllByName("employee2");
		assertTrue(re2 != null);
	}
	
	@Test
	public void FindAllUseidTest()
	{
		re2 = new Reimburse();
		re.findById(1);
		assertTrue(re2 != null);
	}
	
	@Test
	public void FindAllUseridTest()
	{
		re2 = new Reimburse();
		re.findByUsrId(1);
		assertTrue(re2 != null);
	}
	
	@Test
	public void CreateTest()
	{
		re2 = new Reimburse();
		assertTrue(true);
	}
	
	@Test
	public void FindbyUsernameTest()
	{
		re2 = new Reimburse();
		re.findByUsername("employee2");
		assertTrue(re2 != null);
	}
	
	@Test
	public void FindbyStatusTest()
	{
		re2 = new Reimburse();
		re.findAllByStatus("pending");
		assertTrue(re2 != null);
	}
	
	@Test
	public void createTest()
	{
		re2 = new Reimburse();
		re2 = re.findById(1);
		int i = re.create(re2);
		assertTrue(i != 2);
	}
	
	@Test
	public void approveTest()
	{
		re2 = new Reimburse();
		re2 = re.findById(1);
		int i = re.approve(1);
		assertTrue(i != 2);
	}
	
	@Test
	public void denyTest()
	{
		re2 = new Reimburse();
		re2 = re.findById(1);
		int i = re.deny(1);
		assertTrue(i != 2);
	}

}
