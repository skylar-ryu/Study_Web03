<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web03 MVC **</title>
<link rel="stylesheet" type="text/css" href="./myLib/myStyle.css">
</head>
<body>
<h2>** Web03 MVC **</h2>
<c:if test="${loginID!=null}">
	<br>&nbsp;&nbsp;${loginName} 님 안녕하세요 :) <br>
</c:if>
<c:if test="${not empty message}">
	=> ${message} <br>
</c:if>
<hr>
<img src="./image/mooon.jpg" width="600">
<hr>
<c:if test="${loginID!=null}">
	<a href="/Web03/mdetail">MyInfo</a>&nbsp;&nbsp;
	<a href="/Web03/mdelete">회원탈퇴</a><br>
<!-- 	<a href="/Web03/mlist">List</a>&nbsp;&nbsp; -->
	<a href="/Web03/logout">로그아웃</a>
</c:if>
<c:if test="${loginID==null}">
	<a href="/Web03/member/loginForm.jsp">Login</a>&nbsp;&nbsp;
	<a href="/Web03/member/joinForm.jsp">Join</a>
</c:if>
</body>
</html>