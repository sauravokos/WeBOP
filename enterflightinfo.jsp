<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="AddFlightServlet">
<input type="text" name="flightId">
<input type = "text" name="source">
<input type = "text" name="destination">
<input type = "text" name="duration">
<input type = "text" name="totalSeats">
<input type = "text" name="distance">
<input type = "text" name="depTime">
<input type = "text" name="arrTime">
<input type = "text" name="price">
<input type ="submit" value="add flight">
</form>

</body>
</html>