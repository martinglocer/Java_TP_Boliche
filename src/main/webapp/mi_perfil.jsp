<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
    <title>Mi perfil</title>
</head>
<body>
	<% 
		// HttpSession session = request.getSession();
	    Asistente loggedInUser = (Asistente) session.getAttribute("user");
	    if (loggedInUser == null) {
	        response.sendRedirect("index.jsp");
	    } else {
	        boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
	        /* boolean isAdmin = isAdminAttr != null && isAdminAttr; */
	%>
	
		<% if (isAdmin) { %>
			<%@ include file="menu_cabecera_admin.jsp" %>
			<h1>Perfil Administrador!</h1>
			<!-- <li><a class=button-link href="indexUsuarios.jsp">Usuarios</a></li>    
			<li><a class=button-link href="Editar_mi_perfil.jsp">Editar perfil</a></li>     
			<li><a class=button-link href="indexFiestas.jsp">Fiestas</a></li>   
			<li><a class=button-link href="indexFiesta_lugar.jsp">Fiesta en lugar</a></li>  CRUD Dependiente -->
		<% } else { %>
			<%@ include file="menu_cabecera_usuario.jsp" %>
			<h1>Perfil Usuario!</h1>
			<!-- <li><a class=button-link href="indexEntrada.jsp">Comprar entrada</a></li>
			<li><a class=button-link href="indexFiestas">Ver eventos futuros</a></li>     -->
		<% } %>
		<ul class="opc">
			<li><a class=button-link href="Editar_mi_perfil.jsp">Editar perfil</a></li>
		</ul>    
	<% } %>
	
	<div id="background-image">
	</div>
</body>
</html>