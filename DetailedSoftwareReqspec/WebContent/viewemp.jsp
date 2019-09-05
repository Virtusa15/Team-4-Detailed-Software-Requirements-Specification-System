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
</head>

<body>
<form action="design.html">
<div id="container">
<div class="jumbotron text-center">
<h2>View Page</h2>
</div>
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

	String qid=request.getParameter("lid");
	String query="select * from raise1 where empid=?";
	Connection con=DBConnection.createConnection();
	PreparedStatement stmt=con.prepareStatement(query);
	stmt.setString(1, qid);
	ResultSet rs= stmt.executeQuery();
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
  <button type="submit" class="btn btn-primary center-block">Employee Module</button>
  </form>
</body>

</html>