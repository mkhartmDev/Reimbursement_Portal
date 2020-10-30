package com.web.controller;

import java.util.List;

import com.web.dao.ReimbursementDao;
import com.web.model.Reimburse;
import com.web.service.ReimbursementService;

public class driver {
	static ReimbursementDao dao = new ReimbursementDao();
	static ReimbursementService serv= new ReimbursementService();
	public static void main(String[] args)
	{
		List<Reimburse> list = serv.findAllById(1);
		System.out.println(list);
	}

}
