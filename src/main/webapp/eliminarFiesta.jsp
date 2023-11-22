<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar fiesta</title>
</head>
<body>
	<h1>Eliminar fiesta</h1>
	<p>Ingrese el id de la fiesta que quiere eliminar</p>
	<div>
		<form action="SvEliminarFiesta" method="post">
			<p><input type="text" name="idfiesta" placeholder="Id fiesta"></p>
			<button type="submit"> Eliminar Fiesta </button>
		</form>
	</div>
</body>
</html>