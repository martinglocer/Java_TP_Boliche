<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar usuario</title>
</head>
<body>
	<h1>Ingresar informacion</h1>
	<div>
		<form action="indexUsuarios" method="Post">
			<p><input type="text" name="tipo_doc" placeholder="Tipo de documento"></p>
			<p><input type="number" name="nro_doc" placeholder="Número de documento"></p>
			<p><input type="text" name="nombre" placeholder="Nombre"></p>
			<p><input type="text" name="apellido" placeholder="Apellido"></p>
			<p><input type="email" name="email" placeholder="Email"></p>
			<p><input type="date" name="fecha_nacimiento" placeholder="Fecha de nacimiento"></p>
			<p><input type="number" name="celular" placeholder="Celular"></p>
			<p><input type="password" name="celular" placeholder="Contraseña"></p>
			<button type="submit"> Actualizar </button>
		</form>
	</div>
</body>
</html>