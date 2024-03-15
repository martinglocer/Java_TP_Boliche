<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Eliminar usario</title>
	</head>
	<body>
	
		<% Asistente a = (Asistente) request.getSession().getAttribute("usuMostrar"); %>
		<h1>Datos del usuario que desea eliminar</h1>
		<div>
			<p>Tipo de documente: <%=a.getTipo_doc()%></p>
			<p>Numero de documento: <%=a.getNro_doc()%></p>
			<p>Nombre: <%=a.getNombre()%></p>
			<p>Apellido: <%=a.getApellido()%></p>
			<p>Email: <%=a.getEmail()%></p>
			<p>Fecha de nacimiento: <%=a.getFecha_nacimiento()%></p>
			<p>Celular: <%=a.getCelular()%></p>
			<p>Contraseña: <%=a.getPassword()%></p>
			<p>Rol: <%=a.getRol()%></p>
		</div>
		<div>
			<form action="SvEliminarUsuario" method="post">
				<input type="hidden" name="tipo_doc" value="<%=a.getTipo_doc()%>">
            	<input type="hidden" name="nro_doc" value="<%=a.getNro_doc()%>">
				<button>Si, quiero eliminarlo</button>
			</form>
			<form action="indexUsuarios">
				<button>No quiero eliminarlo</button>
			</form>
		</div>
	
	</body>
</html>