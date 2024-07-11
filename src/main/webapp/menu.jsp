<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="servlet.LoginServlet" %>
<%@ page import="data.DataAsistente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		<title>El boliche</title>
	</head>
<body>
	<% 
		// HttpSession session = request.getSession();
	    Asistente loggedInUser = (Asistente) session.getAttribute("user");
	    if (loggedInUser == null) {
	        response.sendRedirect("index.jsp");
	    } else {
	        Boolean isAdminAttr = (Boolean) session.getAttribute("isAdmin");
	        boolean isAdmin = isAdminAttr != null && isAdminAttr;
	%>
	
		<% if (isAdmin) { %>
			<%@ include file="menu_cabecera_admin.jsp" %>
			<h1>Bienvenido Administrador!</h1>
			<!-- <li><a class=button-link href="indexUsuarios.jsp">Usuarios</a></li>    
			<li><a class=button-link href="indexLugares.jsp">Lugares</a></li>     
			<li><a class=button-link href="indexFiestas.jsp">Fiestas</a></li>   
			<li><a class=button-link href="indexFiesta_lugar.jsp">Fiesta en lugar</a></li>  CRUD Dependiente -->
		<% } else { %>
			<%@ include file="menu_cabecera_usuario.jsp" %>
			<h1>Bienvenido Usuario!</h1>
			<!-- <li><a class=button-link href="indexEntrada.jsp">Comprar entrada</a></li>
			<li><a class=button-link href="indexFiestas">Ver eventos futuros</a></li>     -->
		<% } %>
	<% } %>
	
	<div id="background-image">
	</div>
</body>
</html>

