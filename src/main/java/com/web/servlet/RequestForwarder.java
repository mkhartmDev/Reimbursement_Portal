package com.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controller.ReimbursementController;
import com.web.controller.ReimbursementDataController;
import com.web.controller.SessionController;
import com.web.controller.UserController;

public class RequestForwarder {
	SessionController ses;

	
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
			
		case "/EmployeeReimburseM/landing.page":
			return "html/landing.html";
			
		case "/EmployeeReimburseM/post_re.page":
			return new ReimbursementController().addNew(req);
			
		case "/EmployeeReimburseM/user.page":
			return "html/user.html";
			
		default: 
			return "html/landing.html";
		}
	}
	
	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("fdfd");
		switch(req.getRequestURI()) {
		case "/EmployeeReimburseM/viewreimb.json":
			new ReimbursementDataController().findAllById(req, res);
			break;
		case "/EmployeeReimburseM/man_reimb.json":
			new ReimbursementDataController().findAlPending(req, res);
			break;
		case "/EmployeeReimburseM/deny.json":
			new ReimbursementDataController().DeleteReimb(req, res);
			break;
		case "/EmployeeReimburseM/approve.json":
			new ReimbursementDataController().ApproveReimb(req, res);
			break;
			
		}
		//	break;
	}
}
