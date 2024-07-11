<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
		<meta charset="UTF-8">
		<title>Editar Usuario</title>
	</head>
	<body>
	
		<% Asistente a = (Asistente) request.getSession().getAttribute("usuEditar"); %>
		<h1>Datos del usuario</h1>
		<form action="SvEditarUsuario" method="post">
			<p><input type="text" name="tipo_doc" placeholder="Tipo de documento" value="<%=a.getTipo_doc()%>"></p>
			<p><input type="text" name="nro_doc" placeholder="Numero de documento" value="<%=a.getNro_doc()%>"></p>
			<p><input type="text" name="nombre" placeholder="Nombre" value="<%=a.getNombre()%>"></p>
			<p><input type="text" name="apellido" placeholder="Apellido" value="<%=a.getApellido()%>"></p>
			<p><input type="email" name="email" placeholder="Email" value="<%=a.getEmail()%>"></p>
			<p><input type="date" name="fecha_nacimiento" placeholder="Fecha de nacimiento" value="<%=a.getFecha_nacimiento()%>"></p>
			<p><input type="text" name="celular" placeholder="Celular" value="<%=a.getCelular()%>"></p>
			<p><input type="text" name="saldo" placeholder="Saldo" value="<%=a.getSaldo()%>"></p>
			<p><input type="text" name="idrol" placeholder="Rol" value="<%=a.getRol()%>"></p>
			<p><input type="text" name="password" placeholder="Contraseña" value="<%=a.getPassword()%>"></p>
			<button type="submit"> Guardar cambios </button>
		</form>
		
	
	</body>
</html>