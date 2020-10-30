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
		String ret_uri = "html/landing.html";
		String name = req.getParameter("uname");
		String pass = req.getParameter("pass");
		User u = us.LoginCheck(name, pass);
		if(u != null) 
		{
			if(u.getUserRoleId() == 1)
			{
			// not ideal to use roleid but deadline is tomorrow
			sesh = new SessionController();
				sesh.setSession(req, u);
				System.out.println(sesh.getSessionUser(req).getFirstName());
				ret_uri = "html/user.html";
			}
			else
			{
				sesh = new SessionController();
				sesh.setSession(req, u);
				System.out.println(sesh.getSessionUser(req).getFirstName());
				ret_uri = "html/manager.html";
			}
		} 
		return ret_uri;
	}

}
