package com.mvc.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.QuestionBean;
import com.mvc.util.DBConnection;
 
public class QuestionDao {
 
 public String registerUser(QuestionBean registerBean)
 {
 String empid = registerBean.getEmpid();
 String Design = registerBean.getDesign();
 String question = registerBean.getQuestion();
 
 Connection con = null;
 PreparedStatement preparedStatement = null;
 
 try
 {
 con = DBConnection.createConnection();
 String query = "insert into raise1(empid,Design,question,createdat) values (?,?,?,current_timestamp)";
 preparedStatement = con.prepareStatement(query); 
 preparedStatement.setString(1, empid);
 preparedStatement.setString(2, Design);
 preparedStatement.setString(3, question);
 
 int i= preparedStatement.executeUpdate();
 
 if (i!=0) 
 return "SUCCESS"; 
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 
 return "Oops.. Something went wrong there..!"; 
 }
}