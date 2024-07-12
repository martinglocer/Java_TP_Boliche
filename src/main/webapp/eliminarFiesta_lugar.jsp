<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
<meta charset="UTF-8">
<title>Eliminar fiesta_lugar</title>
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
				<h1>Eliminar fiesta en determinado lugar y en una fecha</h1>
				<p>Ingrese el id de la fiesta, el id del lugar y la fecha y hora de realización</p>
				<div>
					<form action="SvEliminarFiesta_lugar" method="post">
						<p><input type="number" name="idfiesta_elim" placeholder="Id fiesta"></p>
						<p><input type="number" name="idlugar_elim" placeholder="Id lugar"></p>
						<p><input type="date" name="fecha_elim" placeholder="Fecha realización"></p>
						<p><input type="time" name="hora_elim" placeholder="Hora de realización"></p>
						<button type="submit"> Eliminar Fiesta_lugar </button>
					</form>
				</div>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>

</body>
</html>