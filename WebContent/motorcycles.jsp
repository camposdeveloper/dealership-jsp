<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Collection, br.com.camposdeveloper.dealership.model.Motorcycle" %>

<% Collection<Motorcycle> motorcycles = (Collection<Motorcycle>) request.getAttribute("motorcycles"); %>

<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Motorcycles</title>
	</head>
	
	<body>
	
		<div style="margin: 50px;" align="center">
			<span>Motorcycles</span>
		</div>
		
		<div>
			<a href="/dealership-jsp/motorcycle-detalhe.jsp" ><button>New Motorcycle</button></a>
		</div>
		
		<ul>
			<%
			if (motorcycles != null && !motorcycles.isEmpty()) {
				System.out.println("Listing motorcycles...");
				for (Motorcycle motorcycle : motorcycles) {
			%>
					<li style="margin-top: 10px;">
						<span><%= motorcycle.getId() %> - <%= motorcycle.getManufacturer() %> - <%= motorcycle.getModel() %></span> 
						<form action="/dealership-jsp/motorcycle/find" method="get">
							<input hidden="true" name="id" value="<%= motorcycle.getId() %>" />
							<button>Detalhar</button>
						</form>
						<form action="/dealership-jsp/motorcycle/delete" method="post">
							<input hidden="true" name="id" value="<%= motorcycle.getId() %>" />
							<button>Delete</button>
						</form>
					</li>
			<%
				}
			} else {
				System.out.println("The list of motorcycles is null.");
			%>
				<span>Nenhum registro encontrado!</span>
			<%
			}
			%>
		</ul>
		
		<script type="text/javascript">
		
			// Using Expression Language
			var respOperation = 'operation_'+'${operation}';
		
			if (respOperation == 'operation_delete') {
				var respDelete = "${delete}";
				if (respDelete) {
	 				alert("Motorcycle deleted!");	
	 			} else {
	 				alert("Error deleting Motorcycle!");
	 			}	
	 		}
			
		</script>
		
	</body>
</html>