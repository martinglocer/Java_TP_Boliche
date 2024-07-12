<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
<meta charset="UTF-8">
<title>Actualizar usuario</title>
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
					<h1>Editar usuario</h1>
					<p>Ingrese el tipo y numero de documento del usuario que quiere modificar</p>
					<div>
						<form action="SvEditarUsuario" method="get">
							<p><input type="text" name="tipo_doc_editar" placeholder="Tipo de documento"></p>
							<p><input type="text" name="nro_doc_editar" placeholder="Numero de documento"></p>
							<button type="submit"> Editar usuario </button>
						</form>
					</div>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>

</body>
</html>