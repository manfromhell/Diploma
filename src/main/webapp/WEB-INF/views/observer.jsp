<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<tiles:insertDefinition name="base-template">
	<tiles:putAttribute name="body">
		<script>
			$(document).ready(function() {
				console.log("Document is ready");
				$('.datetimepicker').datetimepicker({
					format : 'Y-m-d H:i'
				});
				$('#timepicker').timepicker();
				$(function(){
					$('table').colResizable({ disable : true });
					$('#resizable').resizable();
				})
				$('#getPic')
										.click(
												function() {
													var parentCode = $(
															'#parentCodeO')
															.val();
													var marks = $('#marks').val();
													$
															.ajax({
																type : "Get",
																url : "getPic",
																data : "marks="+marks,
																success : function(
																		response) {
																var picture = document
																	.getElementById('thedialog');
																	picture.innerHTML = '<img src="resources/outmarks.gif" height="'+response.height+'" width="'+response.width+'"/>'
																	$('div#thedialog').dialog('open');
																},
																error : function(
																		e) {
																	alert('Error: '
																			+ e);
																}
															});
												})
												$('div#thedialog').dialog({ autoOpen: false })
			})
		</script>

		<br>
		<br>
		<br>
		<form action="filter" method="get">
			<table>
				<tr>
					<td><spring:message code="label.treeType" /></td>
					<td><select style="width: 200px">
							<option><spring:message code="label.all" /></option>
							<option><spring:message code="label.golombTrees" /></option>
							<option><spring:message
									code="label.restrictedLeechTrees" /></option>
							<option><spring:message
									code="label.unrestrictedLeechTrees" /></option>
					</select></td>
					<td><spring:message code="label.startTime" /></td>
					<td><input class="datetimepicker" name="startTimeFrom" /></td>
					<td>--</td>
					<td><input class="datetimepicker" name="startTimeTo" /></td>
					<td>&nbsp;</td>
					<td><spring:message code="label.requestToDb" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.parentCode" /></td>
					<td><input type="text" name="parentCode" /></td>
					<td><spring:message code="label.finishTime" /></td>
					<td><input class="datetimepicker" name="finishTimeFrom" /></td>
					<td>--</td>
					<td><input class="datetimepicker" name="finishTimeTo" /></td>
					<td>&nbsp;</td>
					<td rowspan="3"><input type="text" name="query"
						style="height: 100px;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.numberOfNodes" /></td>
					<td><input type="number" min="1" value="1"
						name="numberOfNodesFrom" style="width: 90px" /> -- <input
						type="number" size="10" min="1" value="7" name="numberOfNodesTo"
						style="width: 90px" /></td>


				</tr>
				<tr>
					<td><spring:message code="label.comment" /></td>
					<td><input type="text" name="comment" /></td>
				</tr>
				<tr>
					<td><input type="submit"
						value="<spring:message code="label.filter" />"></td>
				</tr>
			</table>
		</form>
		<c:if test="${!empty outputList}">
			<table
				class="table table-bordered table-hover table-striped sortable resizable" width="100%">
				<thead>
				<tr>
					<th style="font-size: 75%; background-color: red; color:white;"><spring:message
							code="label.treeType" /></th>
					<th style="font-size: 75%; background-color: red;color:white;"><spring:message
							code="label.numberOfNodes" /></th>
					<th style="font-size: 75%; background-color: red;color:white;"><spring:message
							code="label.parentCode" /></th>
					<th style="font-size: 75%; background-color: red;color:white;"><spring:message
							code="label.comment" /></th>

					<th style="font-size: 75%; background-color: blue;color:white;"><spring:message
							code="label.startTime" /></th>
					<th style="font-size: 75%; background-color: blue;color:white;"><spring:message
							code="label.finishTime" /></th>
					<th style="font-size: 100%; background-color: magenta;color:white;"><spring:message
							code="label.resultMarks" /></th>
					<th style="font-size: 75%; background-color: blue;color:white;"><spring:message
							code="label.energy" /></th>
					<th style="font-size: 75%; background-color: blue;color:white;"><spring:message
							code="label.fitness" /></th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${outputList}" var="output">
					<tr>
						<td class="cellRed"><a href="info/${output.id}">${output.inputData.treeType}</a></td>
						<td class="cellRed">${output.inputData.numberOfNodes}</td>
						<td class="cellRed" id="parentCodeO">${output.inputData.parentCode}</td>
						<td class="cellRed">${output.inputData.comment}</td>

						<td class="cellBlue"><fmt:formatDate value="${output.startTime}" pattern="dd.MM.yyyy HH:mm:ss" /></td>
						<td class="cellBlue"><fmt:formatDate value="${output.finishTime}" pattern="dd.MM.yyyy HH:mm:ss" /></td>
						<td class="cellBlue"><a href="picture/${output.id}">${output.resultNumbers}</a></td>
						<td class="cellBlue">${output.solutionEnergy}</td>
						<td class="cellBlue">${output.fitness}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<a href="#" id="getPic"> GET PICTURE</a>
		</c:if>
		<div id="thedialog" title="Download complete">
    <img src="image.ico" height="100" width="100"/>
</div>
	</tiles:putAttribute>
</tiles:insertDefinition>