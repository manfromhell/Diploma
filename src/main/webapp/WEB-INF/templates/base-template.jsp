<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>

<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/jquery.datetimepicker.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/datepicker.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/jquery.timepicker.css" />"
	rel="stylesheet" type="text/css" />
<%-- <link href="<c:url value="/resources/css/pickmeup.min.css" />"
	rel="stylesheet" type="text/css" />  --%>
	<link href="<c:url value="/resources/js/jquery.validate.js" />"
	type="text/javascript" />
<script src="<c:url value="/resources/js/js.js" />"></script>
<script src="<c:url value="/resources/js/jquery.jsontotable.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>
<script src="<c:url value="/resources/js/sorttable.js" />"></script>
<script src="<c:url value="/resources/js/validation.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
<script src="<c:url value="/resources/js/jquery.timepicker.js" />"></script>
<script src="<c:url value="/resources/js/jquery.timepicker.js" />"></script>
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/jquery.datetimepicker.js" />"></script>
<script src="<c:url value="/resources/js/colResizable-1.3.min.js" />"></script>
<!-- <link rel="stylesheet" href="/css/style.css" type="text/css"/>
Bootstrap
    <link href="css/bootstrap.min.css" rel="stylesheet">
 jQuery (necessary for Bootstrap's JavaScript plugins)
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
Latest compiled and minified CSS
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

Optional theme
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

Latest compiled and minified JavaScript
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
</head>
<body>
 <tiles:insertAttribute name="header" />
 <tiles:insertAttribute name="menu" />
 <div class="container">
		<tiles:insertAttribute name="body" />
</div>
 <tiles:insertAttribute name="footer" />
</body>
</html>