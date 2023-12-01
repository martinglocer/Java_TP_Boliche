<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar fiesta_lugar</title>
</head>
<body>
	<h1>Registro de una nueva fiesta con su lugar y fecha de realización</h1>
	<div>
		<form action="RegistrarFiesta_lugar" method="post">
			<p><input type="number" name="idfiesta" placeholder="Id de la fiesta (ya existente)"></p>
			<p><input type="number" name="idlugar" placeholder="Id del lugar (ya existente)"></p>
			<p><input type="datetime" name="fecha_hora_fiesta" placeholder="Fecha y hora a realizar la fiesta"></p>
			<button type="submit"> Registrar </button>
		</form>
	</div>
</body>
</html>