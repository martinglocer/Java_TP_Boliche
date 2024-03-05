<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
		<title>Login</title>
	</head>
	<body>
		<h1>Incio de sesión</h1>
		<% if (request.getParameter("dni") != null) { %>
        	<% if (request.getParameter("error") != null && request.getParameter("error").equals("true")) { %>
            	<% if (request.getParameter("incorrectPassword") != null && request.getParameter("incorrectPassword").equals("true")) { %>
                	<p style="color: red;">Contraseña incorrecta. Por favor, inténtelo de nuevo.</p>
            	<% } else if (request.getParameter("dniNotFound") != null && request.getParameter("dniNotFound").equals("true")) { %>
                	<p style="color: red;">El DNI ingresado no se encontró. Por favor, verifique y vuelva a intentarlo.</p>
            	<% } else { %>
                	<p style="color: red;">DNI o contraseña incorrectos. Por favor, inténtelo de nuevo.</p>
            	<% } %>
        	<% } %>
    	<% } %>
		<form action="LoginServlet" method="post">
			<p><label>DNI</label><p>
			<p><input type="text" name="dni" value="<%= request.getParameter("dni") != null ? request.getParameter("dni") : "" %>"></p>
			<p><label>Contraseña</label><p>
			<p><input type="password" name="password" value=""></p>
			<button type="submit"> Enviar </button>
		</form>
		
	
	</body>
</html>