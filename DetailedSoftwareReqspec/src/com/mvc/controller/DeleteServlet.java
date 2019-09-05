package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.mvc.bean.QuestionBean;
import com.mvc.dao.DeleteDao;
 
public class DeleteServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
public DeleteServlet() {
 }
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //String answer = request.getParameter("did");
 QuestionBean registerBean = new QuestionBean();
 DeleteDao registerDao = new DeleteDao();
 String userRegistered = registerDao.registerUser(registerBean);
 
 if(userRegistered.equals("SUCCESS"))
 {
 request.getRequestDispatcher("/resdel.html").forward(request, response);
 }
 else 
 {
 request.setAttribute("errMessage", userRegistered);
 request.getRequestDispatcher("/Register.html").forward(request, response);
 }
 }
}
