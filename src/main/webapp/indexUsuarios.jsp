<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		<title>Usuarios</title>
	</head>
<body>

	<% 
        // HttpSession session = request.getSession();
        Asistente loggedInUser = (Asistente) session.getAttribute("user");
        System.out.println("Usuario rol en sesión: " + loggedInUser.getIdrol());
        if (loggedInUser == null) {
            response.sendRedirect("index.jsp");
        } else { %>
            <% int isAdmin = (loggedInUser.getIdrol() == 1) ? 1 : 2;
            if (isAdmin == 1) { %>
                <%@ include file="menu_cabecera_admin.jsp" %>
				<h1>Usuarios</h1>
		
				<div>	
					<nav id="menu">
            			<ul class=opc>
            				<li><a class=button-link href="indexUsuarios">Listar usuarios</a></li>
            				<li><a class=button-link href="buscarUsuario.jsp">Buscar usuarios por tipo y numero de documento</a></li>
                			<li><a class=button-link href="RegisterUser.jsp">Registrar un usuario</a></li>
                   			<li><a class="button-link back-to-main" href="menu.jsp">Volver al menú principal</a></li>
            			</ul>
        			</nav>
        		</div>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>

</body>
</html>