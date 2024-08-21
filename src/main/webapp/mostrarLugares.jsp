<%@page import="java.util.LinkedList" %>
<%@page import="entities.Lugar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "entities.Asistente"%>
<%@page import = "java.util.stream.Collectors"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
	<meta charset="UTF-8">
	<title>Lugares</title>
</head>
<body>
		
	<% 
        // HttpSession session = request.getSession();
        Asistente loggedInUser = (Asistente) session.getAttribute("user");
        if (loggedInUser == null) {
            response.sendRedirect("index.jsp");
        } else { %>
            <% int isAdmin = (loggedInUser.getIdrol() == 1) ? 1 : 2;
            if (isAdmin == 1) { %>
                <%@ include file="menu_cabecera_admin.jsp" %>
				<div>
					<h1>Lugares</h1>
				<%
					LinkedList<Lugar> ll = (LinkedList<Lugar>) request.getSession().getAttribute("listaLugares");
					String searchQuery = request.getParameter("searchQuery");

					if (searchQuery != null && !searchQuery.isEmpty()) {
						ll = ll.stream() 
						.filter(lu -> lu.getNombre_lugar().toLowerCase().contains(searchQuery.toLowerCase()))
						.collect(Collectors.toCollection(LinkedList::new));
					}
				%>
				<!-- Formulario de búsqueda -->
				<form method="get" action="">
					<input type="text" name="searchQuery" placeholder="Buscar por nombre de lugar" value="<%= searchQuery != null ? searchQuery : "" %>">
					<button type="submit">Buscar</button>
				</form>					
					
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
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>			
			
</body>
</html>