package com.web.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.web.dao.ReimbursementDao;
import com.web.model.Reimburse;
import com.web.model.User;
import com.web.service.ReimbursementService;
import com.web.service.UserService;

public class ReimbursementController {
	private ReimbursementService rs;
	SessionController ses;
	static ReimbursementDao dao;

	public ReimbursementController(ReimbursementService us) {
		super();
		this.rs = rs;
	}

	public ReimbursementController() {
		this(new ReimbursementService());
	}
	
	public List<Reimburse> findAll() {
		return rs.findAll();
	}
	
	public List<Reimburse> findAllByName(String name) {
		return rs.findAllByName(name);
	}
	
	public String addNew(HttpServletRequest req)
	{
		ses = new SessionController();
		dao = new ReimbursementDao();
		String test = req.getParameter("amount");
		System.out.println(test);
		double amount = Double.parseDouble(test);
		BigDecimal amount2 = BigDecimal.valueOf(amount);
		
		String desc = req.getParameter("description");
		int userint = ses.getSessionUser(req).getUserId();
		int reqd = Integer.parseInt(req.getParameter("r_type"));
		int insert = dao.create(new Reimburse(amount2, desc, userint, reqd));
		
		if(insert == 1)
			return "html/user.html";
		else
			return "html/add_new_reimb.html";
		
	}


}
