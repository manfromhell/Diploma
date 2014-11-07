<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<tiles:insertDefinition name="base-template">
	<tiles:putAttribute name="body">
		<script>
			$(document).ready(function() {
				console.log("Document is ready");
				$('.datetimepicker').datetimepicker({
					format:'Y-m-d H:i'
				});
				$('#timepicker').timepicker();
			})
		</script>
		<form action="request" method="get">
		<spring:message code="label.requestToDb" />
		<input type="text" size="100" name="query"/>
		<input type="submit" value="<spring:message code="label.send" />">
		</form>
		<br>
		<br>
		<br>
		<form action="filter" method="get">
		<spring:message code="label.treeType" />
		<select>
			<option><spring:message code="label.all" /></option>
			<option><spring:message code="label.golombTrees" /></option>
			<option><spring:message code="label.restrictedLeechTrees" /></option>
			<option><spring:message code="label.unrestrictedLeechTrees" /></option>
		</select>
		<spring:message code="label.parentCode" />
		<input type="text" name="parentCode" />
		<spring:message code="label.numberOfNodes" />
		<input type="number" min="1" value="1" name="numberOfNodesFrom" />
		-
		<input type="number" min="1" value="7" name="numberOfNodesTo" />
		<spring:message code="label.comment" />
		<input type="text" name="comment" />
		<spring:message code="label.startTime" />
		<input class="datetimepicker" name="startTimeFrom" />
		-
		<input class="datetimepicker" name="startTimeTo" />
		<spring:message code="label.finishTime" />
		<input class="datetimepicker" name="finishTimeFrom"/>
		-
		<input class="datetimepicker" name="finishTimeTo"/>
		<br>
		<br>
		<input type="submit" value="<spring:message code="label.filter" />">
		</form>
		<c:if test="${!empty outputList}">
			<table
				class="table table-bordered table-hover table-striped sortable">
				<tr>
					<th><spring:message code="label.treeType" /></th>
					<th><spring:message code="label.numberOfNodes" /></th>
					<th><spring:message code="label.parentCode" /></th>
					<th><spring:message code="label.gapsCoef" /></th>
					<th><spring:message code="label.repeatsCoef" /></th>
					<th><spring:message code="label.comment" /></th>

					<th><spring:message code="label.initTemp" /></th>
					<th><spring:message code="label.finalTemp" /></th>
					<th><spring:message code="label.iterations" /></th>
					<th><spring:message code="label.alpha" /></th>

					<th><spring:message code="label.startTime" /></th>
					<th><spring:message code="label.finishTime" /></th>
					<th><spring:message code="label.resultMarks" /></th>
					<th><spring:message code="label.energy" /></th>
					<th><spring:message code="label.fitness" /></th>
					<th><spring:message code="label.realCountOfIterations" /></th>
					<th><spring:message code="label.countOfCombinations" /></th>

				</tr>
				<c:forEach items="${outputList}" var="output">
					<tr>
						<td class="cellRed">${output.inputData.treeType}</td>
						<td class="cellRed">${output.inputData.numberOfNodes}</td>
						<td class="cellRed">${output.inputData.parentCode}</td>
						<td class="cellRed">${output.inputData.gapsCoef}</td>
						<td class="cellRed">${output.inputData.repCoef}</td>
						<td class="cellRed">${output.inputData.comment}</td>

						<td class="cellGreen">${output.inputData.initTemp}</td>
						<td class="cellGreen">${output.inputData.finalTemp}</td>
						<td class="cellGreen">${output.inputData.iterationsPerTemperature}</td>
						<td class="cellGreen">${output.inputData.alpha}</td>

						<td class="cellBlue">${output.startTime}</td>
						<td class="cellBlue">${output.finishTime}</td>
						<td class="cellBlue">${output.resultNumbers}</td>
						<td class="cellBlue">${output.solutionEnergy}</td>
						<td class="cellBlue">${output.fitness}</td>
						<td class="cellBlue">${output.iterationsCount}</td>
						<td class="cellBlue">${output.combinationsCount}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</tiles:putAttribute>
</tiles:insertDefinition>