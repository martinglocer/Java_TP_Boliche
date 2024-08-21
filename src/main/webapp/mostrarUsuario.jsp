<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
	<meta charset="UTF-8">
	<title>Mostrar Usuario</title>
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
				<% Asistente a = (Asistente) request.getSession().getAttribute("usuMostrar"); %>
				<h1>Datos del usuario</h1>
				<%if (a != null){ %>
					<div>
						<p>Tipo de documento: <%=a.getTipo_doc()%></p>
						<p>Numero de documento: <%=a.getNro_doc()%></p>
						<p>Nombre: <%=a.getNombre()%></p>
						<p>Apellido: <%=a.getApellido()%></p>
						<p>Email: <%=a.getEmail()%></p>
						<p>Fecha de nacimiento: <%=a.getFecha_nacimiento()%></p>
						<p>Celular: <%=a.getCelular()%></p>
						<p>Rol: <%= a.getIdrol() == 1 ? "Administrador" : "Usuario normal" %></p>
						<p>Contraseña: <%=a.getPassword()%></p>
					</div>
				<% } else {%> 
						<p>No existe el usuario con los datos ingresados </p>
				<% } %>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>
	
</body>
</html>