<%@page import="java.util.LinkedList" %>
<%@page import="entities.Lugar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
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
								<th>id</th>
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
								<td><%=l.getIdlugar()%></td>
								<td><%=l.getNombre_lugar()%></td>
								<td><%=l.getDireccion()%></td>
								<td><%=l.getCapacidad()%></td>
								<td><%=l.getCiudad()%></td>
								<td><a href="SvEditarLugar?idlugar_edit=<%= l.getIdlugar() %>">Editar</a></td>
                                <td>
		                            <form action="SvEliminarLugar" method="post" onsubmit="return confirm('¿Estás seguro de que deseas eliminar esta fiesta?');">
		                                <input type="hidden" name="idlugar" value="<%=l.getIdlugar()%>">
		                                <button type="submit"> Borrar </button>
		                            </form>
                        		</td>
							</tr>
						<% } %>	
						</tbody>
					</table>
				</div>
		
		</div>
		
			
			
	</body>
</html>