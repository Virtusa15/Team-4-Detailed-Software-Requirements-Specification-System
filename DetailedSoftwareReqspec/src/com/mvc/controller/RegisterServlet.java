package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;
 
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

public RegisterServlet() {
 }
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 String eid = request.getParameter("eid");
 String ename = request.getParameter("ename");
 String Designation = request.getParameter("Designation");
 String password = request.getParameter("password");
 String location = request.getParameter("location");
 
 
 RegisterBean registerBean = new RegisterBean();
 registerBean.setEid(eid);
 registerBean.setEname(ename);
 registerBean.setDesignation(Designation);
 registerBean.setPassword(password);
 registerBean.setLocation(location);
 
 
 RegisterDao registerDao = new RegisterDao();
 
 String userRegistered = registerDao.registerUser(registerBean);
 
 if(userRegistered.equals("SUCCESS"))   {
 request.getRequestDispatcher("/Home.jsp").forward(request, response);
 }
 else 
 {
 request.setAttribute("errMessage", userRegistered);
 request.getRequestDispatcher("/Register.jsp").forward(request, response);
 }
 }
}
