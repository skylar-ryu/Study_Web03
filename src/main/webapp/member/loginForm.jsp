<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web03 LoginForm **</title>
</head>
<body>
<h2>** Web03 LoginForm **</h2>
<br>
<table><form action="/Web03/login" method="get">
	<tr>
	<td bgcolor="Lavender">I D</td>
	<td><input type="text" name="id" value="banana"></td>
	</tr>
	<tr>
	<td bgcolor="Lavender">Password</td>
	<td><input type="password" name="password" value="12345"></td>	
	</tr>
	<tr><td></td>
		<td><input type="submit" value="Login">&nbsp;&nbsp;
			<input type="reset" value="cancel">
		</td>	
	</tr>
</form></table>
<c:if test="${message != null}">
	<br>${message}<br><br>	
</c:if>
<hr>
<a href="/Web03/index.jsp">HOME</a>
</body>
</html>