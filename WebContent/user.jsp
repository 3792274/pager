<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="基于JSP的ThreadLocal分页.IUserDAO" %>
<%@page import="基于JSP的ThreadLocal分页.UserDAO" %>
<%@page import="基于JSP的ThreadLocal分页.User" %>
<%@page import="基于JSP的ThreadLocal分页.Pager" %>
<%@page import="java.util.List" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>分页演示： 用户列表</title>
</head>
<body>


<%
	IUserDAO userDao = new UserDAO();
	Pager<User> pageUser = userDao.list();
	
	request.setAttribute("items", pageUser.getTotalRecord()); //总记录数	
	request.setAttribute("pageSize", pageUser.getPageSize());//每页显示页数 
	request.setAttribute("pageUser",pageUser);
%>


<table border="1">
	<tr>
		<td>id</td>
		<td>username</td>
		<td>password</td>
		<td>nickname</td>
	</tr>
	
	
	
<c:forEach var="user" items="${pageUser.getDatas()}">
		<tr>
			<td>${user.getId()}</td>
			<td>${user.getUsername()}</td>
			<td>${user.getPassword()}</td>
			<td>${user.getNickname()}</td>
		</tr>

</c:forEach> 
	
	


</table>

<!-- 通用分页底部 -->
<jsp:include page="page.jsp"  />



</body>
</html>