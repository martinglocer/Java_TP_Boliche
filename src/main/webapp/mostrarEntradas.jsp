<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.LinkedList"%>
<%@page import = "entities.Entrada"%>
<%@page import = "entities.Lugar"%>
<%@page import = "entities.Fiesta"%>
<%@page import = "entities.Fiesta_lugar"%>
<%@page import = "entities.Asistente"%>
<%@page import = "jakarta.servlet.http.HttpSession" %>
<%@page import = "java.time.LocalDateTime" %>
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
	<title>Mostrar entradas</title>
</head>
<body>
	<h1>Lista de todas las entradas</h1>
	<%
		LinkedList<Entrada> listaEntradas = (LinkedList) request.getSession().getAttribute("listaEntradas");
	%>
				<div>
					<table>
						<thead>
							<tr>
								<th>Id entrada</th>
								<th>Tipo documento</th>
								<th>Número documento</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Fiesta</th>
								<th>Lugar</th>
								<th>Dirección</th>
								<th>Ciudad</th>
								<th>Fecha evento</th>
								<th>Hora evento</th>
								<th>Fecha compra</th>
								<th>Hora compra</th>
								<th>modificar</th>
								<th>eliminar</th>
							</tr>
						</thead>
						<tbody>
						<% for (Entrada ent : listaEntradas) {
								Fiesta_lugar fl = ent.getFiesta_lugar();
								Lugar l = fl.getLugar();
								Fiesta f = fl.getFiesta();
								Asistente asis = ent.getAsistente();%>
							<tr>
								<td><%=ent.getIdentrada()%></td>
								<td><%=asis.getTipo_doc()%></td>
								<td><%=asis.getNro_doc()%></td>
								<td><%=asis.getNombre()%></td>
								<td><%=asis.getApellido()%></td>
								<td><%=f.getNombre_fiesta()%></td>
								<td><%=l.getNombre_lugar()%></td>
								<td><%=l.getDireccion()%></td>
								<td><%=l.getCiudad()%></td>
								<td><%=fl.getFecha_fiesta()%></td>
								<td><%=fl.getHora_fiesta()%></td>
								<td><%=ent.getFecha_compra()%></td>
								<td><%=ent.getHora_compra()%></td>
								<td></td><!-- editar -->
								<td></td><!-- borrar -->
							</tr>
						<% } %>	
						</tbody>
					</table>
				</div>
	
</body>
</html>