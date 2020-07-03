<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Collection, br.com.camposdeveloper.dealership.model.Motorcycle" %>

<% 

Collection<Motorcycle> motorcycles = (Collection<Motorcycle>) request.getAttribute("motorcycles");

Object attSave = request.getAttribute("save");
boolean respSave = attSave == null ? false : (boolean) attSave;

Collection<String> errors = (Collection<String>) request.getAttribute("msgsErro");

Object attDelete = request.getAttribute("delete");
boolean respDelete = attDelete == null ? false : (boolean) attDelete;

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div style="margin: 50px;" align="center">
		<span>Motorcycles</span>
	</div>
	
	<div hidden="true" id="div-errors" style="margin: 20px;"  align="center">
		<span id="span-errors"></span>
	</div>
	
	<div>
		<form action="/dealership-jsp/motorcycle" method="post">
			
			<label>Manufacturer</label>
			<input type="text" name="manufacturer"></input>
			
			<label>Model</label>
			<input type="text" name="model"></input>
			
			<label>Year</label>
			<input type="text" name="year"></input>
			
			<label>License Plate</label>
			<input type="text" name="licensePlate"></input>
			
			<button>Save</button>
			
		</form>
	</div>
	
	<ul>
		<%
		if (motorcycles != null) {
			System.out.println("Listing motorcycles...");
			for (Motorcycle motorcycle : motorcycles) {
		%>
		<li style="margin-top: 10px;"> 
			<form action="/dealership-jsp/motorcycle" method="post">
				<span><%= motorcycle.getId() %> - <%= motorcycle.getManufacturer() %> - <%= motorcycle.getModel() %></span>
				<input hidden="true" name="motorcycleIdToDelete" value="<%= motorcycle.getId() %>" />
				<button>Delete</button>
			</form>
		</li>
		<%
			}
		} else {
			System.out.println("The list of motorcycles is null.");
		}
		%>
	</ul>
	
	<script type="text/javascript">
		
		// Using Expression Language
		var respOperation = 'operation_'+'${operation}';
		var respSave = <%= respSave %>;
		var errors = '<%= errors %>';
		var errors = errors.replace('[', '').replace(']', '');
		
		var respDelete = <%= respDelete %>;
		
		if (respOperation == 'operation_save') {
			if (respSave) {
				alert("Motorcycle saved!");	
			} else {
				alert("Error saving Motorcycle!");
				var divErrors = document.getElementById("div-errors");
				var spanErrors = document.getElementById("span-errors");
				divErrors.hidden = false;
				spanErrors.innerHTML = "Errors: " + errors;
			}	
		}
		
		if (respOperation == 'operation_delete') {
			if (respDelete) {
 				alert("Motorcycle deleted!");	
 			} else {
 				alert("Error deleting Motorcycle!");
 			}	
 		}
		
	</script>
	
</body>
</html>