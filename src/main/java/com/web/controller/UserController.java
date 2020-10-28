package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.web.model.User;
import com.web.service.UserService;

public class UserController {
	SessionController sesh = new SessionController();
	
	private UserService us;

	public UserController(UserService us) {
		super();
		this.us = us;
	}

	public UserController() {
		this(new UserService());
	}
	
	public String login(HttpServletRequest req) {
		String name = req.getParameter("uname");
		String pass = req.getParameter("pass");
		User u = us.LoginCheck(name, pass);
		if(u != null) {
			sesh = new SessionController();
			sesh.setSession(req, u);
			return "html/user.html";
		} else {
			return "html/landing.html";
		}
	}

}
