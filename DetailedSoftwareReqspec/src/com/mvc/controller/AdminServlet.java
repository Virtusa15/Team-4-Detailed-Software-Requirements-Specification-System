package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aid=request.getParameter("aid");
		String pass=request.getParameter("pass");
		if(aid.equals("Admin")&&pass.equals("Admin"))
		{
			 request.getRequestDispatcher("/Admin.html").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/Register.html").forward(request, response);
		}
		
	}

}
