<%@page import="java.util.LinkedList" %>
<%@page import="entities.Lugar" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<%
			LinkedList<Lugar> ll = (LinkedList) request.getSession().getAttribute("listaLugares");
		%>
		
		<title>Lugares</title>
	</head>
	<body>
		<div>
			<h1>Lugares</h1>
				<div>
					<table>
						<thead>
							<tr>
								<th>nombre</th>
								<th>direccion</th>
								<th>capacidad</th>
								<th>ciudad</th>
								<th>modificar</th>
								<th>eliminar</th>
							</tr>
						</thead>
						<tbody>
						<% for (Lugar l : ll) {%>
							<tr>
								<td><%=l.getNombre_lugar()%></td>
								<td><%=l.getDireccion()%></td>
								<td><%=l.getCapacidad()%></td>
								<td><%=l.getCiudad()%></td>
								<td></td><!-- editar -->
								<td></td><!-- borrar -->
							</tr>
						<% } %>	
						</tbody>
					</table>
				</div>
		
		</div>
		
			
			
	</body>
</html>