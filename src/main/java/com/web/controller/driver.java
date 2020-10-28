package com.web.controller;

import java.math.BigDecimal;

import com.web.dao.ReimbursementDao;
import com.web.model.Reimburse;

public class driver {
	static ReimbursementDao dao = new ReimbursementDao();
	public static void main(String[] args)
	{
		// dao.create(new Reimburse(new BigDecimal(1000), "test description", 1, 1));
	}

}
