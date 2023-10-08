<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List all luggages</title>
</head>

<body>


	<table>
			
				<tr>
					<th>tagNumber</th>
					<th>amount</th>
					<th>keptTime</th>
					<th>keptStuffId</th>
					<th>Func</th>
				</tr>
				
				<c:forEach var="tempLuggage" items="${LUGGAGE_LIST}">
				
					<tr>
						<td> ${tempLuggage.tagNumber} </td>
						<td> ${tempLuggage.amount} </td>
						<td> ${tempLuggage.keptTime} </td>
						<td> ${tempLuggage.keptStuffId} </td>
						<td></td>
					</tr>
				
				</c:forEach>
				<form action="LuggageControllerServlet" method="get">
					<tr>
						<td> <input type="text" name="tagNumber" /> </td>
						<td> <input type="text" name="amount" /> </td>
						<td> <input type="date" name="keptTime" /> </td>
						<td> <input type="text" name="keptStuffId" /></td>	
						<td> <input type="submit" value="submit"  /> </td>
					</tr>
					</form>
			</table>
</body>
</html>