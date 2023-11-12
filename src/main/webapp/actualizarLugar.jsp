<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar lugar</title>
</head>
<body>
	<h1>Ingresar informacion</h1>
	<div>
		<form action="ActualizarLugar" method="post">
			<p><input type="number" name="idlugar" placeholder="Id lugar"></p>
			<p><input type="text" name="nombre_lugar" placeholder="Nombre"></p>
			<p><input type="text" name="direccion" placeholder="Dirección"></p>
			<p><input type="number" name="capacidad" placeholder="Capacidad"></p>
			<p><input type="text" name="ciudad" placeholder="Ciudad"></p>
			<button type="submit"> Actualizar </button>
		</form>
	</div>
</body>
</html>