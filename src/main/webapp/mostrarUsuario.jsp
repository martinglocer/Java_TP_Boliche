<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
		<meta charset="UTF-8">
		<title>Mostrar Usuario</title>
	</head>
	<body>
	
		<% Asistente a = (Asistente) request.getSession().getAttribute("usuMostrar"); %>
		<h1>Datos del usuario</h1>
		<div>
			<p>Tipo de documento: <%=a.getTipo_doc()%></p>
			<p>Numero de documento: <%=a.getNro_doc()%></p>
			<p>Nombre: <%=a.getNombre()%></p>
			<p>Apellido: <%=a.getApellido()%></p>
			<p>Email: <%=a.getEmail()%></p>
			<p>Fecha de nacimiento: <%=a.getFecha_nacimiento()%></p>
			<p>Celular: <%=a.getCelular()%></p>
			<p>Contraseña: <%=a.getPassword()%></p>
		</div>
		
		
	
	</body>
</html>