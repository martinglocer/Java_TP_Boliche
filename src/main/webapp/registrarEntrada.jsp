<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comprar entrada</title>
</head>
<body>
	<h1>Compra tu entrada</h1>
	<div>
		<form action="RegistrarEntrada" method="post">
			<p><input type="text" name="tipo_doc" placeholder="Tipo de documento"></p>
			<p><input type="number" name="nro_doc" placeholder="Número de documento"></p>
			<p><input type="number" name="idfiesta" placeholder="Id de la fiesta"></p>
			<p><input type="number" name="idlugar" placeholder="Id del lugar"></p>
			<p><input type="date" name="fecha_fiesta" placeholder="Fecha de realización de la fiesta"></p>
			<p><input type="time" name="hora_fiesta" placeholder="Hora de realización de la fiesta"></p>
			<button type="submit"> Comprar </button>
		</form>
	</div>
</body>
</html>