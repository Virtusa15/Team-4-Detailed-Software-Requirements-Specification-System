package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.mvc.bean.UpdateBean;
import com.mvc.dao.UpdateDao;
 
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

public UpdateServlet() {
 }
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 String eid = request.getParameter("eid");
 String question = request.getParameter("question");
 String Design = request.getParameter("Design");
 
 
 
 
 UpdateBean registerBean = new UpdateBean();
 registerBean.setEid(eid);
 registerBean.setQuestion(question);
 registerBean.setDesign(Design);

 
 
 UpdateDao registerDao = new UpdateDao();
 
 String userRegistered = registerDao.registerUser(registerBean);
 
 if(userRegistered.equals("SUCCESS"))   {
 request.getRequestDispatcher("/upres.html").forward(request, response);
 }
 else 
 {
 request.setAttribute("errMessage", userRegistered);
 request.getRequestDispatcher("/Register.jsp").forward(request, response);
 }
 }
}