<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>
<tiles:insertDefinition name="base-template">
	<tiles:putAttribute name="body">
<script type="text/javascript">
$(document).ready(function(){
	console.log("Bleat");

$('#spinner').change(function(){
	var val = $('#spinner').val();
	console.log("Spinner val: "+val);
	document.getElementById('textInput').value=val; 
})
})
  </script>

		<form:form commandName="inputData" action="setData" method="POST"
			class="form-horizontal form-validate form-container">
			<form:label path="parentCode" class="form-title">Parent code</form:label>
			<form:input path="parentCode" value="0,1,2,3,4,5,6" class="form-field"/>
			<br>
			<br>
			<form:label path="gapsCoef" class="form-title">Gaps Coefficient</form:label>
			<input type="number" id="textInput" value="">
			<form:input path="gapsCoef" value="1.0" type="range" MIN="0" MAX="10" STEP="2" VALUE="4" id="spinner"/>
			<br>
			<br>
			<form:label path="repCoef" class="form-title">Repeat Coefficient</form:label>
			<form:input path="repCoef" value="100.0" class="form-field"/>
			<form:label path="initTemp" class="form-title">Initial temperature</form:label>
			<form:input path="initTemp" value="100" class="form-field"/>
			<br>
			<br>
			<form:label path="finalTemp" class="form-title">Final temperature</form:label>
			<form:input path="finalTemp" value="10" class="form-field"/>
			<br>
			<br>
			<form:label path="alpha" class="form-title">Temperature change coefficient (alpha)</form:label>
			<form:input path="alpha" value="0.99" class="form-field"/>
			<br>
			<br>
			<form:label path="iterationsPerTemperature" class="form-title">Iterations Per Temperature</form:label>
			<form:input path="iterationsPerTemperature" value="5" class="form-field"/>
			<br>
			<br>
			<form:button type="submit">CALCULATE</form:button>
		</form:form>
		
	</tiles:putAttribute>
</tiles:insertDefinition>
