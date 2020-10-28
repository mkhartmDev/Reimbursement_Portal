package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.web.model.User;

public class SessionController {
	
	public void setSession(HttpServletRequest req, User u) {
		HttpSession session = req.getSession();
		session.setAttribute("user", u);
	}
	
	public User getSessionUser(HttpServletRequest req) {
		return (User)req.getSession().getAttribute("user");
	}
	
	public void invalidate(HttpServletRequest req) {
		req.getSession().invalidate();
	}

}
