<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<tiles:insertDefinition name="base-template">
	<tiles:putAttribute name="body">
	<img src="/SADiploma/resources/outmarks.gif" height="${picture.height}" width="${picture.width}"/>
	
	</tiles:putAttribute>
</tiles:insertDefinition>