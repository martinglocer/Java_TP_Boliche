<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Asistente" %>
<%@page import="entities.Fiesta" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
	<title>Editar Fiesta</title>
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
				<% Fiesta fiesta = (Fiesta) request.getSession().getAttribute("fiestaEditar"); %>
				<h1>Datos de la fiesta</h1>
				<form action="SvEditarFiesta" method="post">
					<p>ID 	<input type="number" name="idfiesta" placeholder="Id fiesta" value="<%=fiesta.getIdfiesta()%>"  readonly></p>
					<p>Nombre	<input type="text" name="nombre_fiesta" placeholder="Nombre" value="<%=fiesta.getNombre_fiesta()%>"></p>
					<p>Descripcion	<input type=text name="descripcion" placeholder="Descripción" value="<%=fiesta.getDescripcion()%>"></p>
					<button type="submit"> Guardar cambios </button>
				</form>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>

</body>
</html>