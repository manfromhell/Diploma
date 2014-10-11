<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>OUTPUT</h1>
<c:if test="${!empty outputList}">
<table class="table table-bordered table-hover table-striped sortable">
<tr>
	<th>OUTPUT</th>
</tr>
<c:forEach items="${outputList}" var="output">
<tr>
	<td>${output.startTime}</td>	
	<td>${output.finishTime}</td>		
	<td>${output.resultNumbers}</td>			
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>