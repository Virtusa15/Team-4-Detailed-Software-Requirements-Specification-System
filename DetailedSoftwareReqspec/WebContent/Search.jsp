<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <%@page import="java.sql.*,com.mvc.*"
%>
<%@page import="com.mvc.util.DBConnection"%>
</head>
<body>
<div id="container">
<div class="jumbotron text-center">
<h2>View Page</h2>
</div>
 <table class="table table-dark">
 <thead class="text-success">
<tr> 
<td>question</td>
<td>answer</td>
</tr>
</thead>
<%
try
{
String qid=request.getParameter("qid");
String query="select question,answer from raise1 where question=?";
Connection con=DBConnection.createConnection();
PreparedStatement stmt=con.prepareStatement(query);
stmt.setString(1, qid);
ResultSet rs= stmt.executeQuery();
while(rs.next())
{
%>
<tbody>
    <tr>   
    <td><%=rs.getString("question")%></td>
    <td><%=rs.getString("answer")%></td>
    </tr>
 <%
 
}
%>
 </tbody>
    </table>
    </div>
    <%
    rs.close();
    stmt.close();
    con.close();
}
catch(Exception e)
{
    e.printStackTrace();
}
%>
</body>
</html>