<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.LinkedList"%>
<%@page import = "entities.Entrada"%>
<%@page import = "entities.Lugar"%>
<%@page import = "entities.Fiesta"%>
<%@page import = "entities.Fiesta_lugar"%>
<%@page import = "entities.Asistente"%>
<%@page import = "data.DataAsistente"%>
<%@page import = "data.DataFiesta"%>
<%@page import = "data.DataLugar"%>
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
	<%@ include file="menu_cabecera_usuario.jsp" %>
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
								DataAsistente da = new DataAsistente();
								DataFiesta df = new DataFiesta();
								DataLugar dl = new DataLugar();
								Asistente asist = da.getById(ent.getIdasistente());
								Fiesta fies = df.getById(ent.getIdfiesta());
								Lugar lug = dl.getById(ent.getIdlugar());
							%>
							<tr>
								<td><%=ent.getIdentrada()%></td>
								<td><%=ent.getIdasistente()%></td>
								<td><%=asist.getNro_doc()%></td>
								<td><%=asist.getNombre()%></td>
								<td><%=asist.getApellido()%></td>
								<td><%=fies.getNombre_fiesta()%></td>
								<td><%=lug.getNombre_lugar()%></td>
								<td><%=lug.getDireccion()%></td>
								<td><%=lug.getCiudad()%></td>
								<td><%=ent.getFecha_evento()%></td>
								<td><%=ent.getHora_evento()%></td>
								<td><%=ent.getFecha_compra()%></td>
								<td><%=ent.getHora_compra()%></td>
								<td><a href="SvEditarEntrada?identrada_edit=<%=ent.getIdentrada()%>">Editar</a></td>
								<td>
		                            <form action="SvEliminarEntrada" method="post" onsubmit="return confirm('¿Estás seguro de que deseas eliminar esta entrada?');">
		                                <input type="hidden" name="identrada" value="<%=ent.getIdentrada()%>">
		                                <button type="submit"> Borrar </button>
		                            </form>
                        		</td>
							</tr>
						<% } %>	
						</tbody>
					</table>
				</div>
	
</body>
</html>