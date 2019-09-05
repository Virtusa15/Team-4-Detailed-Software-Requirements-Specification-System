package com.mvc.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.UpdateBean;
import com.mvc.util.DBConnection;
 
public class UpdateDao {
 
 public String registerUser(UpdateBean registerBean)
 {
 String eid = registerBean.getEid();
 String question = registerBean.getQuestion();
 
 
 Connection con = null;
 PreparedStatement preparedStatement = null;
 
 try
 {
 con = DBConnection.createConnection();
 String query = "update raise1 set question=? where empid=?";
 preparedStatement = con.prepareStatement(query); 
 preparedStatement.setString(2, eid);
 preparedStatement.setString(1, question);
 
 
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