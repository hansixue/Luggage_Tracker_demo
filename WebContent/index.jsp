<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome!</h1>

<h3>input the first number</h3>
	<form action="LuggageControllerServlet" method="get">
		<input type="hidden" name="command" value="LIST50">
		<input type="text" name="startNumber"/>
		<input type="submit" value="List"  /> 
	</form>
<br><br><br><br><br>
<a href="/luggage_tracker_demo/LuggageControllerServlet">or go to the list page</a>
</body>
</html>