package com.web.controller;

import java.util.List;

import com.web.dao.ReimbursementDao;
import com.web.model.Reimburse;

public class driver {
	static ReimbursementDao dao = new ReimbursementDao();
	public static void main(String[] args)
	{
		List<Reimburse> list = dao.findByUsrId(1);
		System.out.println(list.get(0).getAmount());
	}

}
