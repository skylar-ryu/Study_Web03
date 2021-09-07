<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web03 MemberDetail **</title>
</head>
<body>
<h2>** Web03 MemberDetail **</h2>
<table>
	<tr height="40">
	<td bgcolor="Lavender">I  D</td>
	<td>${Apple.id}</td>
	</tr>
	<tr height="40">
	<td bgcolor="Lavender">Password</td>
	<td>${Apple.password}</td>
	</tr>
	<tr height="40">
	<td bgcolor="Lavender">이  름</td>
	<td>${Apple.name}</td>
	</tr>
	<tr height="40">
	<td bgcolor="Lavender">Level</td>
	<td>${Apple.lev}</td>
	</tr>
	<tr height="40">
	<td bgcolor="Lavender">생년월일</td>
	<td>${Apple.birthd}</td>
	</tr>
	<tr height="40">
	<td bgcolor="Lavender">Point</td>
	<td>${Apple.point}</td>
	</tr>
	<tr height="40">
	<td bgcolor="Lavender">Weight</td>
	<td>${Apple.weight}</td>

</table>
<hr>
<a href="/Web03/mdetail?jcode=U">내정보수정</a>&nbsp;&nbsp;
<a href="/Web03/mdelete">회원탈퇴</a>
<br>
<c:if test="${message != null}">
	<br>${message}<br><br>	
</c:if>
<hr>
<a href="/Web03/index.jsp">HOME</a>
</body>
</html>