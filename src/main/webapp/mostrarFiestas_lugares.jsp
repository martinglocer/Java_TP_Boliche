<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.LinkedList"%>
<%@page import = "entities.Fiesta_lugar"%>
<%@page import = "jakarta.servlet.http.HttpSession" %>
<%@page import = "java.time.LocalDateTime" %>
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
	<title>Mostrar fiestas_lugares</title>
</head>
<body>
	<h1>Lista de fiestas registradas</h1>
	<%
		LinkedList<Fiesta_lugar> listaFiestas_lugares = (LinkedList) request.getSession().getAttribute("listaFiestas_lugares");
	%>
				<div>
					<table>
						<thead>
							<tr>
								<th>Id fiesta</th>
								<th>Id lugar</th>
								<th>Fecha y hora de realización</th>
								<th>modificar</th>
								<th>eliminar</th>
							</tr>
						</thead>
						<tbody>
						<% for (Fiesta_lugar fl : listaFiestas_lugares) {%>
							<tr>
								<td><%=fl.getIdfiesta() %></td>
								<td><%=fl.getIdlugar()%></td>
								<td><%=fl.getFecha_hora_fiesta()%></td>
								<td></td><!-- editar -->
								<td></td><!-- borrar -->
							</tr>
						<% } %>	
						</tbody>
					</table>
				</div>
	
</body>
</html>