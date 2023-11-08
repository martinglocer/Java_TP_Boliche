<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.LinkedList"%>
<%@page import = "entities.Asistente"%>
<%@page import = "jakarta.servlet.http.HttpSession" %>
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
	LinkedList<Asistente> listaUsuarios = (LinkedList) request.getSession().getAttribute("listaUsuarios");
%>
<title>Mostrar usuarios</title>
</head>
<body>
	<h1>Lista de usuarios registrados</h1>
				<div>
					<table>
						<thead>
							<tr>
								<th>Apellido</th>
								<th>Nombre</th>
								<th>Tipo documento</th>
								<th>Nro documento</th>
								<th>Email</th>
								<th>Celular</th>
								<th>Fecha de nacimiento</th>
							</tr>
						</thead>
						<tbody>
						<% for (Asistente a : listaUsuarios) {%>
							<tr>
								<td><%=a.getApellido()%></td>
								<td><%=a.getNombre()%></td>
								<td><%=a.getTipo_doc()%></td>
								<td><%=a.getNro_doc()%></td>
								<td><%=a.getEmail()%></td>
								<td><%=a.getCelular()%></td>
								<td><%=a.getFecha_nacimiento()%></td>
								<td></td><!-- editar -->
								<td></td><!-- borrar -->
							</tr>
						<% } %>	
						</tbody>
					</table>
				</div>
</body>
</html>