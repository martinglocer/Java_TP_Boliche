<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
<meta charset="UTF-8">
<title>Actualizar Evento (Fiesta lugar)</title>
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
				<h1>Editar Evento</h1>
				<p>Ingrese el id de la fiesta, el id del lugar y la fecha de realización</p>
				<div>
					<form action="SvEditarFiesta_lugar" method="get">
					<p><input type="number" name="idfiesta_edit" placeholder="Id fiesta"></p>
					<p><input type="number" name="idlugar_edit" placeholder="Id lugar"></p>
					<p><input type="date" name="fecha_edit" placeholder="Fecha realización actual"></p>
					<p><input type="time" name="hora_edit" placeholder="Hora de realización actual"></p>
					<button type="submit"> Editar fiesta_lugar </button>
					</form>
				</div>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>

	
</body>
</html>