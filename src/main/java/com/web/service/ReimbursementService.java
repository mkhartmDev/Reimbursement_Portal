package com.web.service;

import java.util.List;

import com.web.dao.ReimbursementDao;
import com.web.dao.UserDao;
import com.web.model.Reimburse;
import com.web.model.User;

public class ReimbursementService {
	private ReimbursementDao dao = new ReimbursementDao();

	public ReimbursementService(UserDao mdao) {
		super();
		this.dao = dao;
	}

	public ReimbursementService() {
		this(new UserDao());
	}
	
	public List<Reimburse> findAllByName(String name) {
		return dao.findAllByName(name);
	}
	
	public List<Reimburse> findAll() {
		return dao.findAll();
	}
	
	

}
