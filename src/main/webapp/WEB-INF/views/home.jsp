<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>
<tiles:insertDefinition name="base-template">
	<tiles:putAttribute name="body">

		<form:form commandName="inputData" action="setData" method="POST"
			class="form-horizontal form-validate">
			<form:label path="parentCode">Parent code</form:label>
			<form:input path="parentCode" value="0,1,2,3,4,5,6" />
			<br>
			<br>
			<form:label path="numberOfMarks">Number Of Marks</form:label>
			<form:input path="numberOfMarks" value="7" />
			<br>
			<br>
			<form:label path="marks">Marks</form:label>
			<form:input path="marks" value="1 3 5 6 7 10 2" />
			<br>
			<br>
			<form:label path="initTemp">Initial temperature</form:label>
			<form:input path="initTemp" value="10" />
			<br>
			<br>
			<form:label path="finalTemp">Final temperature</form:label>
			<form:input path="finalTemp" value="100" />
			<br>
			<br>
			<form:label path="alpha">Alpha</form:label>
			<form:input path="alpha" value="0.5" />
			<br>
			<br>
			<form:label path="iterationsPerTemperature">Iterations Per Temperature</form:label>
			<form:input path="iterationsPerTemperature" value="5" />
			<br>
			<br>
			<form:label path="gapsCoef">Gaps Coefficient</form:label>
			<form:input path="gapsCoef" value="1.0" />
			<br>
			<br>
			<form:label path="repCoef">Repeat Coefficient</form:label>
			<form:input path="repCoef" value="100.0" />
			<br>
			<br>
			<form:button type="submit">CALCULATE</form:button>
		</form:form>

	</tiles:putAttribute>
</tiles:insertDefinition>
