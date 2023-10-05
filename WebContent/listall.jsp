<%@ page import="java.util.*, com.hansixue.tracker.luggage.*"
language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List all luggages</title>
</head>

<%
	// get the students from the request object (sent by servlet)
	List<Luggage> theLuggages = 
					(List<Luggage>) request.getAttribute("LUGGAGE_LIST");
%>
<body>
	<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<% for (Luggage tempLuggage : theLuggages) { %>
				
					<tr>
						<td> <%= tempLuggage.getTagNumber() %> </td>
						<td> <%= tempLuggage.getKeptTime() %> </td>
						<td> <%= tempLuggage.getKeptStuffId() %> </td>
					</tr>
				
				<% } %>
				
			</table>

</body>
</html>