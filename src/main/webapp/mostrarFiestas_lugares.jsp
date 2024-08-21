<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.LinkedList"%>
<%@page import = "entities.Fiesta_lugar"%>
<%@page import = "entities.Lugar"%>
<%@page import = "entities.Fiesta"%>
<%@page import = "jakarta.servlet.http.HttpSession" %>
<%@page import = "java.time.LocalDateTime" %>
<%@page import = "entities.Asistente"%>
<%@page import = "java.util.stream.Collectors"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
	<title>Mostrar fiestas_lugares</title>
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
				<%
					LinkedList<Fiesta_lugar> listaFiestas_lugares = (LinkedList) request.getSession().getAttribute("listaFiestas_lugares");
					String searchQuery = request.getParameter("searchQuery");

					if (searchQuery != null && !searchQuery.isEmpty()) {
						listaFiestas_lugares = listaFiestas_lugares.stream() 
						.filter(lf -> lf.getFiesta().getNombre_fiesta().toLowerCase().contains(searchQuery.toLowerCase())||
								lf.getLugar().getNombre_lugar().toLowerCase().contains(searchQuery.toLowerCase()))
						.collect(Collectors.toCollection(LinkedList::new));
					}
				%>
				<!-- Formulario de búsqueda -->
				<form method="get" action="">
					<input type="text" name="searchQuery" placeholder="Buscar por nombre de fiesta o lugar" value="<%= searchQuery != null ? searchQuery : "" %>">
					<button type="submit">Buscar</button>
				</form>				
				
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
								<td><a href="SvEditarFiesta_lugar?idfiesta_edit=<%=f.getIdfiesta()%>&idlugar_edit=<%=l.getIdlugar()%>&fecha_edit=<%=fl.getFecha_fiesta()%>&hora_edit=<%=fl.getHora_fiesta()%>">Editar</a></td>
                                <td>
		                            <form action="SvEliminarFiesta_lugar" method="post" onsubmit="return confirm('¿Estás seguro de que deseas eliminar esta fiesta con su lugar de realización?');">
		                                <input type="hidden" name="idfiesta_elim" value="<%=f.getIdfiesta()%>">
		                                <input type="hidden" name="idlugar_elim" value="<%=l.getIdlugar()%>">
		                                <input type="hidden" name="fecha_fiesta_elim" value="<%=fl.getFecha_fiesta()%>">
		                                <input type="hidden" name="hora_fiesta_elim" value="<%=fl.getHora_fiesta()%>">
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