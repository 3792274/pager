<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>分页演示： 用户列表</title>
</head>
<body>

 
<table border="1">
	<tr>
		<td>id</td>
		<td>username</td>
		<td>password</td>
		<td>nickname</td>
	</tr>
	
	
	
<c:forEach items="${pagerUser.datas}" var="user" >
		<tr>
			<td>${user.getId()}</td>
			<td>${user.getUsername()}</td>
			<td>${user.getPassword()}</td>
			<td>${user.getNickname()}</td>
		</tr>

</c:forEach> 
	
	


</table>

<hr />
<!-- 通用分页底部 -->
<jsp:include page="page.jsp"  />



</body>
</html>