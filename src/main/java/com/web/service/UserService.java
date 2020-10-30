package com.web.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.web.model.User;
import com.web.dao.DaoContract;
import com.web.dao.UserDao;

public class UserService {
	private UserDao mdao = new UserDao();
	private static final Logger log = Logger.getLogger(UserService.class);

	public UserService(UserDao mdao) {
		super();
		this.mdao = mdao;
	}

	public UserService() {
		this(new UserDao());
	}
	
	public User findByName(String name) {
		return mdao.findByUsername(name);
	}
	public User LoginCheck(String name, String pass) {
		return mdao.LoginCheck(name, pass);
	}
	
	public List<User> findAll(){
		return mdao.findAll();
	}
	
	public int save(User t) {
		log.info("New User Created: " + toString());
		return mdao.create(t);
	}

}
