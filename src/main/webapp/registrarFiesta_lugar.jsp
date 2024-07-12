<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
<meta charset="UTF-8">
<title>Registrar fiesta_lugar</title>
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
				<h1>Registro de una nueva fiesta con su lugar y fecha de realización</h1>
				<div>
					<form action="RegistrarFiesta_lugar" method="post">
						<p><input type="number" name="idfiesta" placeholder="Id de la fiesta (ya existente)"></p>
						<p><input type="number" name="idlugar" placeholder="Id del lugar (ya existente)"></p>
						<p><input type="date" name="fecha_fiesta" placeholder="Fecha realizarse la fiesta"></p>
							<p><input type="time" name="hora_fiesta" placeholder="Hora a realizar la fiesta"></p>
						<button type="submit"> Registrar </button>
					</form>
				</div>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>

</body>
</html>