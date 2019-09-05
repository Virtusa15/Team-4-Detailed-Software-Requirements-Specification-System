package com.mvc.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;
 
public class RegisterDao {
 
 public String registerUser(RegisterBean registerBean)
 {
 String eid = registerBean.getEid();
 String ename = registerBean.getEname();
 String Designation = registerBean.getDesignation();
 String password = registerBean.getPassword();
 String location = registerBean.getLocation();
 
 
 Connection con = null;
 PreparedStatement preparedStatement = null;
 
 try
 {
 con = DBConnection.createConnection();
 String query = "insert into registration(eid,ename,Designation,password,location) values (?,?,?,?,?)";
 preparedStatement = con.prepareStatement(query); 
 preparedStatement.setString(1, eid);
 preparedStatement.setString(2, ename);
 preparedStatement.setString(3, Designation);
 preparedStatement.setString(4, password);
 preparedStatement.setString(5, location);
 
 
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