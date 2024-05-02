<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/login.css">
	<title>Registrarse</title>
</head>
<body>
	<h1>Registro de usuario</h1>
	<div>
		<form action="RegisterUser" method="post">
			<p><input type="text" name="tipo_doc" placeholder="Tipo de documento"></p>
			<p><input type="text" name="nro_doc" placeholder="Número de documento"></p>
			<p><input type="text" name="nombre" placeholder="Nombre"></p>
			<p><input type="text" name="apellido" placeholder="Apellido"></p>
			<p><input type="email" name="email" placeholder="Email"></p>
			<p><input type="text" name="celular" placeholder="Celular"></p>
			<p>Fecha de nacimiento <input type="date" name="fecha_nacimiento" placeholder="Fecha de nacimiento"></p>
			<p><input type="text" name="saldo" placeholder="Saldo"></p>
			<p><input type="password" name="password" placeholder="Contraseña"></p>
			<p>
        		<select name="idrol">
          		  <option value="">Seleccione un rol</option>
          		  <option value="1">Administrador</option>
          		  <option value="2">Usuario estándar</option>
        		</select>
    		</p>
			<button type="submit"> Registrar Usuario </button>
		</form>
	</div>
</body>
</html>