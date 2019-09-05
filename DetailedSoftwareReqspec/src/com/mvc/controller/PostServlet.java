package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.PostBean;
import com.mvc.dao.PostDao;
 
public class PostServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
public PostServlet() {
 }
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 String empid = request.getParameter("pid");
 String question = request.getParameter("qpid");
 
 PostBean registerBean = new PostBean();
 
 registerBean.setPid(empid);
 registerBean.setQpid(question);
 
 PostDao registerDao = new PostDao();
 
 String userRegistered = registerDao.registerUser(registerBean);
 
 if(userRegistered.equals("SUCCESS"))
 {
 request.getRequestDispatcher("/respo.html").forward(request, response);
 }
 else 
 {
 request.setAttribute("errMessage", userRegistered);
 request.getRequestDispatcher("/Register.jsp").forward(request, response);
 }
 }
}
