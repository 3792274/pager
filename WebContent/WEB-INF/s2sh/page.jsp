<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

-----------------------------------------------------------------<br>
 

 
<!-- 
	1. maxIndexPages="20"           当前页面显示的索引20条
	2. maxPageItems="${pageSize}"   每页显示多少条
	3. items="${items}"             总记录数
 -->
 
<center> 
<pg:pager url="${param.url}"  maxPageItems="${param.pageSize}"  items="${param.items}"   export="currentPage = pageNumber">
<pg:index>	
	
	<!-- 测试带参数传递的 -->
	 <pg:param name="param01" value="param01Value" />
	 <pg:param name="param02" value="param02Value" />
	 
	<pg:first>
		<a href="${pageUrl}">首页  </a>
	</pg:first>
	
	
	<pg:prev>
		<a href="${pageUrl}">上一页</a>
	</pg:prev>
	
	
	<pg:pages>
		  <c:choose> 
	            <c:when test="${currentPage eq pageNumber }">  
	            	<font color="red">[${pageNumber}]</font>  
	            </c:when>  
	            <c:otherwise>  
	                <a href="${pageUrl}"> ${pageNumber} </a>  
	            </c:otherwise>  
	        </c:choose>  
	 </pg:pages>
	 
	 
	 
	 <pg:next>
	 	<a href="${pageUrl}">下一页</a>
	 </pg:next>
	 
	 
	 <pg:last>
	 	<a href="${pageUrl}">尾页</a>
	 </pg:last>
	 
	 <pg:last>
	|  共：${items}条 ,共${pageNumber}页   | 当前页是${currentPage}页
	</pg:last>
	
		
	
	  
</pg:index>	
</pg:pager>
</center>