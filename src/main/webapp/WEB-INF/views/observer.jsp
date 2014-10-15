<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script>
$('.datepicker').datepicker({
	format : "yyyy-mm-dd"
})
</script>
<tiles:insertDefinition name="base-template">
	<tiles:putAttribute name="body">
		<h1><center>Calculations results</center></h1>
		Start time <input type="text" class="datepicker"/>
		Finish time <input type="text" class="datepicker"/>
		Marks <input type="text"/>
		<button>Filter</button>
		<c:if test="${!empty outputList}">
			<table
				class="table table-bordered table-hover table-striped sortable">
				<tr>
					<th>Start time</th>
					<th>Finish time</th>
					<th>Marks</th>
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
	</tiles:putAttribute>
</tiles:insertDefinition>