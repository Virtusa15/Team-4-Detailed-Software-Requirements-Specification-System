<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"                                                    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.mvc.util.DBConnection"%>
<html>
<head>
<title>View Example</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<%@page import="java.sql.*,com.mvc.*"
%>
<style>
body{
  background: url(images/multi.jpg) no-repeat;
  background-size: 100%;
}
</style>
</head>

<body>
<br/>
<br/>
<br/>
<br/>

<div id="container">
<div align="center">
<h1>View Page</h1>
</div>
</div>
<br/>
<br/>
<br/>
<br/>
<br/>

 <table class="table table-dark">
 <thead class="text-success">
<tr>
<td>empid</td>  
<td>question</td>
<td>answer</td>
<td>Created at</td>
<td>Action</td>
</tr>
</thead>
<%
try
{

String query="select empid,question,answer,createdat from raise1";
Connection con=DBConnection.createConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{
%>
<tbody>
    <tr>
    <td><%=rs.getString("empid")%></td>    
    <td><%=rs.getString("question")%></td>
    <td><%=rs.getString("answer")%></td>
    <td><%=rs.getDate("createdat")%></td>
    <td><a href="post.html">reply</a> </td>
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