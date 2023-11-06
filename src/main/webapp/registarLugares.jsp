<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lugares</title>
	</head>
	<body>
		<h1>Datos del lugar</h1>
			<form action="SvLugar" method="post">
				<p><label>Nombre: </label> <input type="text" name="nombre"></p>
				<p><label>Dirección: </label> <input type="text" name="direccion"></p>
				<p><label>Capacidad: </label> <input type="text" name="capacidad"></p>
				<p><label>Código postal: </label> <input type="text" name="codigo_postal"></p>
				<button type="submit"> Enviar </button>
			</form>
	</body>
</html>