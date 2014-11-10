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

		<spring:message code="label.initTemp" />
		${output.inputData.initTemp}
		<spring:message code="label.finalTemp" />
		${output.inputData.finalTemp}
		<spring:message code="label.iterations" />
		${output.inputData.iterationsPerTemperature}
		<spring:message code="label.alpha" />
		${output.inputData.iterationsPerTemperature}
		<spring:message code="label.realCountOfIterations" />
		${output.iterationsCount}
		<spring:message code="label.countOfCombinations" />
		${output.combinationsCount}


	</tiles:putAttribute>
</tiles:insertDefinition>