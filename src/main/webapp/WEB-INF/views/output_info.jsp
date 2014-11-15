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

		<table class="table table-bordered table-hover table-striped sortable resizable" width="100%">
		<tr>
		<td><spring:message code="label.initTemp" /></td>
		<td>${output.inputData.initTemp}</td>
		</tr>
		<tr>
		<td><spring:message code="label.iterations" /></td>
		<td>${output.inputData.iterationsPerTemperature}</td>
		</tr>
		<tr>
		<td><spring:message code="label.alpha" /></td>
		<td>${output.inputData.alpha}</td>
		</tr>
		<tr>
		<td><spring:message code="label.realCountOfIterations" /></td>
		<td>${output.iterationsCount}</td>
		</tr>
		<tr>
		<td><spring:message code="label.countOfCombinations" /></td>
		<td>${output.combinationsCount}</td>
		</tr>
		</table>

	</tiles:putAttribute>
</tiles:insertDefinition>