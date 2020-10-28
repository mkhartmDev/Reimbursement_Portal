package com.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controller.ReimbursementController;
import com.web.controller.UserController;

public class RequestForwarder {

	
	public String routes(HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		
		switch (req.getRequestURI()){
		case "/EmployeeReimburseM/login.page":
			String matt = new UserController().login(req);
			return new UserController().login(req);
			
		case "/EmployeeReimburseM/pastreimb.page":
			return "html/past_reimb.html";
			
		case "/EmployeeReimburseM/addreimb.page":
			return "html/add_new_reimb.html";
			
		case "/EmployeeReimburseM/post_re.page":
			return new ReimbursementController().addNew(req);
		default: 
			System.out.println("dsdasd");
			return "html/landing.html";
		}
	}
	
	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//switch(req.getRequestURI()) {
		//	break;
	}
}
