<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.LinkedList"%>
<%@page import = "entities.Fiesta"%>
<%@page import = "jakarta.servlet.http.HttpSession" %>
<%@page import = "entities.Asistente"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
	<title>Mostrar fiestas</title>
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
				<h1>Lista de fiestas registradas</h1>
				<%LinkedList<Fiesta> listaFiestas = (LinkedList) request.getSession().getAttribute("listaFiestas");%>
				<div>
					<table>
						<thead>
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Descripcion</th>
								<th>modificar</th>
								<th>eliminar</th>
							</tr>
						</thead>
						<tbody>
						<% for (Fiesta f : listaFiestas) {
								%>
							<tr>
								<td><%=f.getIdfiesta() %></td>
								<td><%=f.getNombre_fiesta()%></td>
								<td><%=f.getDescripcion()%></td>
								<td><a href="SvEditarFiesta?idfiesta_edit=<%= f.getIdfiesta() %>">Editar</a></td>
                                <td>
                            <form action="SvEliminarFiesta" method="post" onsubmit="return confirm('¿Estás seguro de que deseas eliminar esta fiesta?');">
                                <input type="hidden" name="idfiesta" value="<%=f.getIdfiesta()%>">
                                <button type="submit"> Borrar </button>
                            </form>
                        </td>
							</tr>
						<% } %>	
						</tbody>
					</table>
				</div>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>
	
</body>
</html>