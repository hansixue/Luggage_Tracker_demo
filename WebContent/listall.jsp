<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
					<th>keptPlace<th>
					<th>keptTime</th>
					<th>keptStuffId</th>
					<th>pickedup</th>
					<th>func</th>
					<th>edit</th>
				</tr>

		<c:forEach var="tempLuggage" items="${LUGGAGE_LIST}">
			<c:choose>
				<c:when test="${tempLuggage.id == 0}">
					<form action="LuggageControllerServlet" method="get">
						<input type="hidden" name="command" value="ADD50">
						<input type="hidden" value="${tempLuggage.tagNumber}" name="tagNumber" />
						<input type="hidden" value="${START_NUMBER}" name="startNumber">
					<tr>
						<td>${tempLuggage.tagNumber}</td>
						<td><input type="text" name="amount" /></td>
						<td>
						 <select name="keptPlace" >
						    <option value="A1">A1</option>
						    <option value="A2">A2</option>
						    <option value="A3">A3</option>
						    <option value="L">L</option>
						  </select>
						</td>
						<td><input type="datetime-local" name="keptTime" /></td>
						<td><input type="text" name="keptStuffId" /></td>
						<td><input type="submit" value="submit" /></td>
					</tr>
					</form>
				</c:when>
				<c:otherwise>
					<tr>
						<td>${tempLuggage.tagNumber}</td>
						<td>${tempLuggage.amount}</td>
						<td>${tempLuggage.keptPlace}</td>
						<td>${tempLuggage.keptTime}</td>
						<td>${tempLuggage.keptStuffId}</td>
						<c:choose>
						<c:when test="${empty tempLuggage.pickedUpTime}">
							<td></td>
							<td><form action="LuggageControllerServlet" method="get">
									<input type="hidden" name="command" value="PICKUP"> <input
										type="hidden" name="id" value="${tempLuggage.id}"> <input
										type="text" name="stuffId" /> <input type="submit"
										value="pickup" />
								</form></td>
						</c:when>
						<c:otherwise>
						<td>O</td>
						<td></td>
						</c:otherwise>
						</c:choose>
						<td><form action="LuggageControllerServlet" method="get">
								<input type="hidden" name="command" value="EDIT"> <input
									type="hidden" name="id" value="${tempLuggage.id}"> <input
									type="submit" value="edit" />
							</form></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<form action="LuggageControllerServlet" method="get">
					<input type="hidden" name="command" value="ADD">
					<tr>
						<td> <input type="text" name="tagNumber" /> </td>
						<td> <input type="text" name="amount" /> </td>
						<td><select name="keptPlace" >
						    <option value="A1">A1</option>
						    <option value="A2">A2</option>
						    <option value="A3">A3</option>
						    <option value="L">L</option>
						</select></td>
						<td> <input type="datetime-local" name="keptTime" /> </td>
						<td> <input type="text" name="keptStuffId" /></td>	
						<td> <input type="submit" value="submit"  /> </td>
					</tr>
					</form>
			</table>
</body>
</html>