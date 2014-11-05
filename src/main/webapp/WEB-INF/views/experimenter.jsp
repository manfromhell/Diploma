<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>
<tiles:insertDefinition name="base-template">
	<tiles:putAttribute name="body">
<script type="text/javascript">
$(document).ready(function(){
$('#spinner').change(function(){
	var val = $('#spinner').val();
	if (val==-100){
		document.getElementById('textInputG').value=100;
		document.getElementById('textInputR').value=1;
	}
	if (val==0){
		document.getElementById('textInputG').value=1;
		document.getElementById('textInputR').value=1;
	}
	if (val==100){
		document.getElementById('textInputG').value=1;
		document.getElementById('textInputR').value=100;
	}
})
})
  </script>

		<form:form commandName="inputData" action="setData" method="POST"
			class="form-horizontal form-validate form-container">
			<form:label path="parentCode" class="form-title">Parent code</form:label>
			<form:input path="parentCode" value="0,1,2,3,4,5,6" class="form-field"/>
			<a href="#">Generate picture</a>
			<br>
			<br>
			<form:label path="gapsCoef" class="form-title">Gaps Coefficient</form:label>
			<form:input path="gapsCoef" type="text" id="textInputG" readonly="true" class="form-field"/>
			<br>
			<br>
			<form:label path="repCoef" class="form-title">Repeat Coefficient</form:label>
			<form:input path="repCoef" class="form-field" type="text" id="textInputR" readonly="true" />
			<input value="100" type="range" MIN="-100" MAX="100" STEP="100" id="spinner"/>
			<br>
			<br>
			<form:label path="initTemp" class="form-title">Initial temperature</form:label>
			<form:input path="initTemp" value="100" class="form-field" type="number" min="0"/>
			<br>
			<br>
			<form:label path="finalTemp" class="form-title">Final temperature</form:label>
			<form:input path="finalTemp" value="10" class="form-field" type="number" min="0"/>
			<br>
			<br>
			<form:label path="alpha" class="form-title">Temperature change coefficient (alpha)</form:label>
			<form:input path="alpha" value="0.99" class="form-field" type="number" min="0" max = "1" step="0.001"/>
			<br>
			<br>
			<form:label path="iterationsPerTemperature" class="form-title">Iterations Per Temperature</form:label>
			<form:input path="iterationsPerTemperature" value="5" class="form-field" type="number" min="0"/>
			<br>
			<br>
			<form:label path="comment" class="form-title">Comment</form:label>
			<form:input path="comment" value="" class="form-field"/>
			<br>
			<br>
			<form:button type="submit">CALCULATE</form:button>
		</form:form>
		
	</tiles:putAttribute>
</tiles:insertDefinition>
