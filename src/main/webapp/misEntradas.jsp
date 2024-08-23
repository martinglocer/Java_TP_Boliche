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
<%@page import = "java.util.stream.Collectors"%>
<%@page import = "java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
	<title>Mostrar entradas</title>
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
            <% } else if (isAdmin == 2) { %>
            	<%@ include file="menu_cabecera_usuario.jsp" %>
            <% } %>
				<h1>Lista de todas mis entradas</h1>
				<%
					LinkedList<Entrada> listaEntradas = (LinkedList<Entrada>) request.getSession().getAttribute("listaEntradas");
					String searchQuery = request.getParameter("searchQuery");

					if (searchQuery != null && !searchQuery.isEmpty()) {
						listaEntradas = listaEntradas.stream() 
						.filter(le -> le.getFiesta_lugar().getFiesta().getNombre_fiesta().toLowerCase().contains(searchQuery.toLowerCase())||
								le.getFiesta_lugar().getLugar().getNombre_lugar().toLowerCase().contains(searchQuery.toLowerCase()))
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
								<th>eliminar</th>
							</tr>
						</thead>
						<tbody>
						<% for (Entrada ent : listaEntradas) {
								DataAsistente da = new DataAsistente();
								DataFiesta df = new DataFiesta();
								DataLugar dl = new DataLugar();
								Asistente asist = ent.getAsistente();
								Fiesta_lugar fl = ent.getFiesta_lugar();
								Fiesta fies = fl.getFiesta();
								Lugar lug = fl.getLugar();
							%>
							<tr>
								<td><%=ent.getIdentrada()%></td>
								<td><%=asist.getIdasistente() %></td>
								<td><%=asist.getNro_doc()%></td>
								<td><%=asist.getNombre()%></td>
								<td><%=asist.getApellido()%></td>
								<td><%=fies.getNombre_fiesta()%></td>
								<td><%=lug.getNombre_lugar()%></td>
								<td><%=lug.getDireccion()%></td>
								<td><%=lug.getCiudad()%></td>
								<td><%=fl.getFecha_fiesta() %></td>
								<td><%=fl.getHora_fiesta() %></td>
								<td><%=ent.getFecha_compra()%></td>
								<td><%=ent.getHora_compra()%></td>
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
    <% } %>
	
</body>
</html>
