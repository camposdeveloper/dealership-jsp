<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Collection, br.com.camposdeveloper.dealership.model.Motorcycle" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
<body>

	<div style="margin: 50px;" align="center">
		<span>Motorcycle</span>
	</div>
	
	<div hidden="true" id="div-errors" style="margin: 20px;"  align="center">
		<span id="span-errors"></span>
	</div>
	
	<div>
		
		<a href="/dealership-jsp/motorcycle/find"><button type="button">List Motorcycles</button></a>
		
		<form style="margin-top: 15px;" action="/dealership-jsp/motorcycle/save" method="post">
			
			<label>Id</label>
			<input type="text" name="id" value="${motorcycle.id}" readonly />
			
			<label>Manufacturer</label>
			<input type="text" name="manufacturer" value="${motorcycle.manufacturer}" />
			
			<label>Model</label>
			<input type="text" name="model" value="${motorcycle.model}" />
			
			<label>Year</label>
			<input type="number" name="year" value="${motorcycle.year}" />
			
			<label>License Plate</label>
			<input type="text" name="licensePlate" value="${motorcycle.licensePlate}" />
			
			<button>Save</button>
			
		</form>
	</div>
	
	<script type="text/javascript">
	
		// Using Expression Language
		var respOperation = 'operation_'+'${operation}';
		
		if (respOperation == 'operation_save') {
			if (${save} == true) {
				alert("Motorcycle saved!");	
			} else {
				alert("Error saving Motorcycle!");
				var errors = "${errors}";
				var errors = errors.replace('[', '').replace(']', '');
				document.getElementById("span-errors").innerHTML = "Errors: " + errors;
				document.getElementById("div-errors").hidden = false;
			}	
		}
		
	</script>
	
</body>
</html>