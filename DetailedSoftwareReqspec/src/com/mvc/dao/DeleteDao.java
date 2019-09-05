package com.mvc.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.QuestionBean;
import com.mvc.util.DBConnection;
 
public class DeleteDao {
 
 public String registerUser(QuestionBean registerBean)
 {
	 Connection con = null;
 
PreparedStatement stmt = null ;
 String a="unanswered";
 
 try
 {
 con = DBConnection.createConnection();
 String query = "delete from raise1 where createdat<=sysdate and answer=?";
 stmt = con.prepareStatement(query); 
 stmt.setString(1,a);
 
int i=stmt.executeUpdate();

if(i!=0) {
 
 return "SUCCESS"; 
}
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 
 return "Oops.. Something went wrong there..!"; 
 }
}