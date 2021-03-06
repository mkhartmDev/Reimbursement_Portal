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
	
	 public List<Reimburse> findAllById(int id){
		 return dao.findByUsrId(id);
		 
	 }
	 
	 public List<Reimburse> findAllByStatus(String s)
	 {
		 return dao.findAllByStatus(s);
	 }
	 
	 public int delete(int i) {
			return dao.delete(i);
		}
	 
	 public int deny(int i) {
			return dao.deny(i);
		}
	 
	 public int approve(int i) {
			return dao.approve(i);
		}
	

}
