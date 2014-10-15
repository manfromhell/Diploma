<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>
<tiles:insertDefinition name="base-template">
	<tiles:putAttribute name="body">

		<form class="form-container">
			<div class="form-title">
				<h2>Set Data</h2>
			</div>
		<form:form commandName="inputData" action="setData" method="POST"
			class="form-horizontal form-validate">
			<form:label path="parentCode" class="form-title">Parent code</form:label>
			<form:input path="parentCode" value="0,1,2,3,4,5,6" class="form-field"/>
			<br>
			<br>
			<form:label path="numberOfMarks" class="form-title">Number Of Marks</form:label>
			<form:input path="numberOfMarks" value="7" class="form-field"/>
			<br>
			<br>
			<form:label path="initTemp" class="form-title">Initial temperature</form:label>
			<form:input path="initTemp" value="10" class="form-field"/>
			<br>
			<br>
			<form:label path="finalTemp" class="form-title">Final temperature</form:label>
			<form:input path="finalTemp" value="100" class="form-field"/>
			<br>
			<br>
			<form:label path="alpha" class="form-title">Temperature change coefficient (alpha)</form:label>
			<form:input path="alpha" value="0.5" class="form-field"/>
			<br>
			<br>
			<form:label path="iterationsPerTemperature" class="form-title">Iterations Per Temperature</form:label>
			<form:input path="iterationsPerTemperature" value="5" class="form-field"/>
			<br>
			<br>
			<form:label path="gapsCoef" class="form-title">Gaps Coefficient</form:label>
			<form:input path="gapsCoef" value="1.0" class="form-field"/>
			<br>
			<br>
			<form:label path="repCoef" class="form-title">Repeat Coefficient</form:label>
			<form:input path="repCoef" value="100.0" class="form-field"/>
			<br>
			<br>
			<form:button type="submit">CALCULATE</form:button>
		</form:form>
	</form>
		
	</tiles:putAttribute>
</tiles:insertDefinition>
