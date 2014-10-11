<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script
	src="<c:url value="/resources/script/jquery.jsontotable.min.js" />"></script>
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<div id="jsontable" class="jsontotable"></div>
	<script>
		$(document).ready(function(event) {
			console.log("Table content ");
			var tableContent;
			$.ajax({
				Accept : "application/json",
				dataType : 'json',
				contentType: "application/json",
				/* url: $("#online").attr( "action"), */
				url : "table/data",
				type : "POST",

				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success : function(tableContent) {
					var id = tableContent[1]['id'];
					var className = tableContent[1]['className'];
					var header = tableContent[1]['header'];
					delete tableContent[1];
					$.jsontotable(tableContent, {
						id : "#"+id,
						className : className,
						header : header
					});
				},
				error: function(tableContent) {
					console.log("Table content error" + tableContent);
				}
			});
		});
		</script>
</body>
</html>