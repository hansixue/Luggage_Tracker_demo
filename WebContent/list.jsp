<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>Tag Number</th>
                <th>Amount</th>
                <th>Pickup Time</th>
                <th>Picked Up</th>
            </tr>
        </thead>
        <tbody>
            <!-- Generate 50 rows -->
            <%int number = Integer.parseInt(request.getParameter("number")); %>
            <% for (int i = number; i <= number+50; i++) { %>
                <tr>
                    <td><%= i %></td>
                    <td>1</td>
                    <td>2023-09-20 12:00:00</td>
                    <td><input type="checkbox" name="pickedUp" value="<%= i %>"></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>