<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
<meta charset="UTF-8">
<title>Comprar entrada</title>
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
			<h1>Compra tu entrada</h1>
			<div>
				<form action="RegistrarEntrada" method="post">
					<p><input type="text" name="tipo_doc" placeholder="Tipo de documento"></p>
					<p><input type="number" name="nro_doc" placeholder="Número de documento"></p>
					<p><input type="number" name="idfiesta" placeholder="Id de la fiesta"></p>
					<p><input type="number" name="idlugar" placeholder="Id del lugar"></p>
					<p><input type="date" name="fecha_fiesta" placeholder="Fecha de realización de la fiesta"></p>
					<p><input type="time" name="hora_fiesta" placeholder="Hora de realización de la fiesta"></p>
					<button type="submit"> Comprar </button>
				</form>
			</div>
		<% } else { %>
			<%@ include file="menu_cabecera_usuario.jsp" %>
			<h1>Compra tu entrada</h1>
			<div>
				<form action="RegistrarEntrada" method="post">
					<p><input type="text" name="tipo_doc" placeholder="Tipo de documento"></p>
					<p><input type="number" name="nro_doc" placeholder="Número de documento"></p>
					<p><input type="number" name="idfiesta" placeholder="Id de la fiesta"></p>
					<p><input type="number" name="idlugar" placeholder="Id del lugar"></p>
					<p><input type="date" name="fecha_fiesta" placeholder="Fecha de realización de la fiesta"></p>
					<p><input type="time" name="hora_fiesta" placeholder="Hora de realización de la fiesta"></p>
					<button type="submit"> Comprar </button>
				</form>
			</div>
		<% } %>
	<% } %>

</body>
</html>