<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web03 MemberList2 **</title>
</head>
<body>
<h2>** Web03 MemberList2 **</h2>
<br>
<c:if test="${not empty message}">
=> ${message}<br>
</c:if>
<hr>
<table border="1" width=800>
<form action="memberList2.jsp" method="get">

<tr height="30" bgcolor="SlateBlue" >
	<th>ID</th><th>Password</th><th>Name</th><th>Level</th>
	<th>BirthDay</th><th>Point</th><th>Weight</th>

<c:forEach var="list" items="${Banana}">
<tr height="30" align="center">
	<td><c>${list.id}</td>
	<td>${list.password}</td>
	<td>${list.name}</td>
	<td>${list.lev}</td>
	<td>${list.birthd}</td>
	<td>${list.point}</td>
	<td>${list.weight}</td> 
</tr>
</c:forEach>

<c:choose>
	<c:when test="${list.id==list.id}">
	<a href="/mdetail">${list.id}</a>
	</c:when>
</c:choose>
</form>
</table>
<hr>
<a href="/Web03/index.jsp">HOME</a>
</body>
</html>