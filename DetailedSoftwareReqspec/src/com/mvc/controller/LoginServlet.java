package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String lid=request.getParameter("lid");
	String pass=request.getParameter("pass");
	LoginBean LoginBean = new LoginBean();
	 LoginBean.setLid(lid);
	 LoginBean.setPass(pass);
	 LoginDao LoginDao = new LoginDao();
	 String userRegistered = LoginDao.registerUser(LoginBean);
	 if(userRegistered.equals("SUCCESS")) 
	 {
	 request.getRequestDispatcher("/viewemp.jsp").forward(request, response);
	 }
	 else   
	 {
	 request.setAttribute("errMessage", userRegistered);
	 request.getRequestDispatcher("/Register.html").forward(request, response);
	 } 
	}

}
