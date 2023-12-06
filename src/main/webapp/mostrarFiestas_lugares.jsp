<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.LinkedList"%>
<%@page import = "entities.Fiesta_lugar"%>
<%@page import = "entities.Lugar"%>
<%@page import = "entities.Fiesta"%>
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
								<th>Fecha</th>
								<th>Hora</th>
								<th>Fiesta</th>
								<th>Lugar</th>
								<th>Direccion</th>
								<th>Ciudad</th>
								<th>modificar</th>
								<th>eliminar</th>
							</tr>
						</thead>
						<tbody>
						<% for (Fiesta_lugar fl : listaFiestas_lugares) {
								Lugar l = fl.getLugar();
								Fiesta f = fl.getFiesta();%>
							<tr>
								<td><%=fl.getFecha_fiesta()%></td>
								<td><%=fl.getHora_fiesta()%></td>
								<td><%=f.getNombre_fiesta()%></td>
								<td><%=l.getNombre_lugar()%></td>
								<td><%=l.getDireccion()%></td>
								<td><%=l.getCiudad()%></td>
								<td></td><!-- editar -->
								<td></td><!-- borrar -->
							</tr>
						<% } %>	
						</tbody>
					</table>
				</div>
	
</body>
</html>