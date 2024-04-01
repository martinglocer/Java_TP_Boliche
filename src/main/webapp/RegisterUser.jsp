<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<p><input type="date" name="fecha_nacimiento" placeholder="Fecha de nacimiento"></p>
			<p><input type="number" name="saldo" placeholder="Saldo"></p>
			<p><input type="password" name="password" placeholder="Contraseña"></p>
			<p><input type="text" name="idrol" placeholder="Rol"></p>
			<button type="submit"> Registrar Usuario </button>
		</form>
	</div>
</body>
</html>