package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.mvc.bean.QuestionBean;
import com.mvc.dao.QuestionDao;
 
public class QuestionServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
public QuestionServlet() {
 }
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 String empid = request.getParameter("empid");
 String Design = request.getParameter("Design");
 String question = request.getParameter("question");
 
 
 QuestionBean registerBean = new QuestionBean();
 registerBean.setEmpid(empid);
 registerBean.setDesign(Design);
 registerBean.setQuestion(question);
 
 QuestionDao registerDao = new QuestionDao();
 String userRegistered = registerDao.registerUser(registerBean);
 
 if(userRegistered.equals("SUCCESS"))
 {
 request.getRequestDispatcher("/resp.html").forward(request, response);
 }
 else 
 {
 request.setAttribute("errMessage", userRegistered);
 request.getRequestDispatcher("/Register.html").forward(request, response);
 }
 }
}
