<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>分页演示：用户列表</title>
</head>
<body>

		<table>
				<tr>
					<td>id</td>
					<td>username</td>
					<td>nickname</td>
					<td>password</td>
				</tr>
					
			<s:iterator value="#pageUser.datas">
				<tr>
					<td>${id }</td>
					<td>${username }</td>
					<td>${nickname }</td>
					<td>${password }</td>
				</tr>
			</s:iterator>	
		</table>


<%
	

%>
<jsp:include page="page.jsp">
	<jsp:param value="user_list.do"     name="url"/>
	<jsp:param value="${pageUser.pageSize}"     name="pageSize"/>
	<jsp:param value="${pageUser.totalRecord }" name="items"/>
</jsp:include>


</body>
</html>