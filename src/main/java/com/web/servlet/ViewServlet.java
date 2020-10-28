package com.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "views", urlPatterns = {"*.page"})
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.toString());
		request.getRequestDispatcher(new RequestForwarder().routes(request)).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.toString());
		request.getRequestDispatcher(new RequestForwarder().routes(request)).forward(request, response);
		System.out.println("test");
	}

}
