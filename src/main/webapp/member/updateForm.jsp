<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web03 Member Update Form **</title>
<style>
* {size: 20; }
.updateform { background-color:Lavender ; font-size: 14px; width: 100%;  border: none; border-radius: 5px; padding: 10px; margin-bottom: 10px;}
.btn {font-size: 14px; background-color:SlateBlue ; color:white;  
			  width: 100px;  border: none; border-radius: 5px; padding: 10px; margin-bottom: 10px;}

</style>
</head>
<body>
<h2 >** Web03 Member Update Form **</h2>
<table width="300" height="200" border=0>
<form action="/Web03/mupdate" method="get">
	<tr><td>I D</td>
		<td><input type="text" name="id"class="updateform" value="${Apple.id}" readonly></td>
	</tr>
	<tr><td>Password</td>
		<td><input type="password" name="password"class="updateform" value="${Apple.password}" ></td>
	</tr>
	<tr><td>이 름</td>
		<td><input type="text" name="name"class="updateform" value="${Apple.name}"></td>
	</tr>
	<tr><td>Level</td>
		<td><select  name="lev"class="updateform" >
			<c:choose>
			<c:when test="${Apple.lev =='A'}">
				<option value="A" selected>관리자</option>
				<option value="B">나무</option>
				<option value="C">잎새</option>
				<option value="D">새싹</option>				
			</c:when>
			</c:choose>
			<c:choose>
			<c:when test="${Apple.lev =='B'}">
				<option value="A">관리자</option>
				<option value="B" selected>나무</option>
				<option value="C">잎새</option>
				<option value="D">새싹</option>				
			</c:when>
			</c:choose>
			<c:choose>
			<c:when test="${Apple.lev =='C'}">
				<option value="A">관리자</option>
				<option value="B">나무</option>
				<option value="C" selected>잎새</option>
				<option value="D">새싹</option>				
			</c:when>
			</c:choose>
			<c:choose>
			<c:when test="${Apple.lev =='D'}">
				<option value="A">관리자</option>
				<option value="B">나무</option>
				<option value="C">잎새</option>
				<option value="D" selected>새싹</option>				
			</c:when>
			</c:choose>
		</select></td>
	</tr>
	<tr><td>생년월일</td>
		<td><input type="date" name="birthd"class="updateform" value="${Apple.birthd}"></td>
	</tr>
	<tr><td>Point</td>
		<td><input type="text" name="point"class="updateform" value="${Apple.point}"></td>
	</tr>
	<tr><td>Weight</td>
		<td><input type="text" name="weight"class="updateform" value="${Apple.weight}"></td>
	</tr>
	<tr><td></td>
	<td><input type="submit" value="Update" class="btn">
	<input type="reset" value="Cancel" class="btn"></td>
	</tr>
</form></table>
<hr>
<c:if test="${message != null}">
	<br>${message}<br><br>	
</c:if>
<a href="/Web03/index.jsp">HOME</a>
</body>
</html>