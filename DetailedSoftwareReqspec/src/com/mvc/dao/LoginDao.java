package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;

public class LoginDao {
	public String registerUser(LoginBean loginbean)
	 {
	 String lid = loginbean.getLid();
	 String pass = loginbean.getPass();
	 Connection con = null;
	 PreparedStatement preparedStatement = null;
	 try
	 {
	 con = DBConnection.createConnection();
	 String query = "select * from registration where eid=? and password=?";
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, lid);
	 preparedStatement.setString(2, pass);
	 int i= preparedStatement.executeUpdate();
	 
	 if (i!=0) {
	 return "SUCCESS"; 
	 }
	 else
	 {
		 return "failed";
	 }
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }

	 return "hi";
}
}