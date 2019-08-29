<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 String name = session.getAttribute("name").toString();
 out.println("<h2> Welcome "+name+" !</h2>");
 out.println("<h3> here are you functionalities </h3>");
 
%>
<form action="enterflightinfo.jsp">
<p> Add a flight 
<input type="submit" value="add a flight"> </p>
</form>
</body>
</html>