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
        } else {
            int isAdmin = (loggedInUser.getIdrol() == 1) ? 1 : 2;
            if (isAdmin == 1) { %>
                <%@ include file="menu_cabecera_admin.jsp" %>
            <% } else if (isAdmin == 2) { %>
                <%@ include file="menu_cabecera_usuario.jsp" %> <!-- Cambiar el archivo de cabecera para usuario -->
            <% } %>
            <h1>Lista de futuros eventos</h1>
            <%
                LinkedList<Fiesta_lugar> listaFiestas_lugares = (LinkedList<Fiesta_lugar>) request.getSession().getAttribute("listaFiestas_lugares");
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
				<input type="text" name="searchQuery" placeholder="Buscar por fiesta o lugar" value="<%= searchQuery != null ? searchQuery : "" %>">
				<button type="submit">Buscar</button>
			</form>				
                
            <%    if (listaFiestas_lugares != null && !listaFiestas_lugares.isEmpty()) {%>
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
                            <th>Comentarios</th>
                         </tr>
                    </thead>
                    <tbody>
                        <% for (Fiesta_lugar fl : listaFiestas_lugares) {
                            Lugar l = fl.getLugar();
                            Fiesta f = fl.getFiesta(); %>
                        <tr>
                            <td><%= fl.getFecha_fiesta() %></td>
                            <td><%= fl.getHora_fiesta() %></td>
                            <td><%= f.getNombre_fiesta() %></td>
                            <td><%= l.getNombre_lugar() %></td>
                            <td><%= l.getDireccion() %></td>
                            <td><%= l.getCiudad() %></td>
                            <td><a href="comentarios.jsp?idFiesta=<%= f.getIdfiesta() %>&idLugar=<%= l.getIdlugar() %>&fechaEvento=<%= fl.getFecha_fiesta() %>&horaEvento=<%= fl.getHora_fiesta() %>">Ver comentarios</a></td> 
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
            <% } else { %>
                <p>No hay fiestas registradas.</p>
            <% } %>
        <% } %>
</body>
</html>
