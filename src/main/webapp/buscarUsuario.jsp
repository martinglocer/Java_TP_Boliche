<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
<meta charset="UTF-8">
<title>Buscar usuario</title>
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
					<h1>Buscar usuario</h1>
					<p>Ingrese el tipo y numero de documento del usuario</p>
					<div>
						<form action="SvBuscarUsuario" method="get">
							<p><input type="text" name="tipo_doc_editar" placeholder="Tipo"></p>
							<p><input type="text" name="nro_doc_editar" placeholder="Número"></p>
							<button type="submit"> Mostrar usuario </button>
						</form>
						<form action="SvEliminarUsuario" method="get">
							<p><input type="text" name="tipo_doc_editar" placeholder="Tipo"></p>
							<p><input type="text" name="nro_doc_editar" placeholder="Numero"></p>
							<button>Eliminar usuario</button>
						</form>
					</div>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>


</body>
</html>