<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="RegistrationServletController">
	firstname: <input type="text" name="firstname"/>
	lastname: <input type="text" name="lastname"/>
	password: <input type="password" name="password">
	phoneno:  <input type="text" name="phone"/>
	email : <input type="email" name="email"/>
	<input type="submit" value="submit"/>
</form>

</body>
</html>