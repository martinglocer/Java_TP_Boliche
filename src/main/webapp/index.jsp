<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/login.css">
		<title>Login</title>
	</head>
	<body>
		<div> <h1>Incio de sesión</h1> </div>
		<% if (request.getParameter("email") != null) { %>
        	<% if (request.getParameter("error") != null && request.getParameter("error").equals("true")) { %>
            	<% if (request.getParameter("incorrectPassword") != null && request.getParameter("incorrectPassword").equals("true")) { %>
                	<p id=warning style="color: red;">Contraseña incorrecta. Por favor, inténtelo de nuevo.</p>
            	<% } else if (request.getParameter("emailNotFound") != null && request.getParameter("emailNotFound").equals("true")) { %>
                	<p id=warning style="color: red;">El Email ingresado no se encontró. Por favor, verifique y vuelva a intentarlo.</p>
            	<% } else { %>
                	<p id=warning style="color: red;">Email o contraseña incorrectos. Por favor, inténtelo de nuevo.</p>
            	<% } %>
        	<% } %>
    	<% } %>
	
		<div >
		<form action="LoginServlet" method="post">
			<p><label>Email</label><p>
			<p><input type="text" name="email" value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>"></p>
			<p><label>Contraseña</label><p>
			<p><input type="password" name="password" value=""></p>
			<button type="submit"> Ingresar </button>
		</form>
		</div>
		
		<div>
		<a class= register-link href="RegisterUser.jsp">Todavia no tienes una cuenta creada? Registrate aqui!</a></div>
	
	</body>
</html>