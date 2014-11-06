<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<tiles:insertDefinition name="base-template">
	<tiles:putAttribute name="body">
		<script>
			$(document).ready(function() {
				console.log("Document is ready");
				$('.datepicker').datepicker({
					format : "yyyy-mm-dd"
				})
				$('#timepicker').timepicker();
			})
		</script>
		<h1>
			<center>Calculations results</center>
		</h1>
		
		<form action="filter" method="get">
		Tree type
		<select>
			<option>Golomb Trees</option>
			<option>Restricted Leech Trees</option>
			<option>Unrestricted Leech Trees</option>
		</select>
		Parent code
		<input type="text" name="parentCode" />
		Number of nodes
		<input type="number" min="1" value="1" name="numberOfNodesFrom" />
		-
		<input type="number" min="1" value="7" name="numberOfNodesTo" />
		Comment
		<input type="text" name="comment" />
		Start time
		<input class="datepicker" name="startTimeFrom" />
		-
		<input class="datepicker" name="startTimeTo" />
		Finish time
		<input class="datepicker" name="finishTimeFrom"/>
		-
		<input class="datepicker" name="finishTimeTo"/>
		<br>
		<br>
		<input type="submit" value="Submit">
		</form>
		<c:if test="${!empty outputList}">
			<table
				class="table table-bordered table-hover table-striped sortable">
				<tr>
					<th class="cellRed">Tree type</th>
					<th class="cellRed">Number of nodes</th>
					<th class="cellRed">Parent code</th>
					<th class="cellRed">Gaps coefficient</th>
					<th class="cellRed">Repeat coefficient</th>
					<th class="cellRed">Comment</th>

					<th class="cellGreen">Initial temperature</th>
					<th class="cellGreen">Final temperature</th>
					<th class="cellGreen">Iterations per temperature</th>
					<th class="cellGreen">Alpha</th>

					<th class="cellBlue">Start time</th>
					<th class="cellBlue">Finish time</th>
					<th class="cellBlue">Result Marks</th>
					<th class="cellBlue">Energy</th>
					<th class="cellBlue">Fitness</th>
					<th class="cellBlue">Real count of iterations</th>
					<th class="cellBlue">Count of combinations</th>

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

		<c:if test="${!empty result}">
			<table
				class="table table-bordered table-hover table-striped sortable" id="testTable">
				<c:forEach items="${result}" var="res">
					<td>${output.inputData.numberOfNodes}</td>
				</c:forEach>
			</table>
		</c:if>

	</tiles:putAttribute>
</tiles:insertDefinition>