<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
<meta charset="UTF-8">
<title>Actualizar lugar</title>
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
					<h1>Editar lugar</h1>
					<p>Ingrese el id del lugar que quiere modificar</p>
					<div>
						<form action="SvEditarLugar" method="get">
							<p><input type="text" name="idlugar_edit" placeholder="Id lugar"></p>
							<button type="submit"> Editar lugar </button>
						</form>
					</div>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>

</body>
</html>