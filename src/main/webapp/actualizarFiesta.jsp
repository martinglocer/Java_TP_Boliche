<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar fiesta</title>
</head>
<body>
	<h1>Editar fiesta</h1>
	<p>Ingrese el id de la fiesta que quiere modificar</p>
	<div>
		<form action="SvEditarFiesta" method="get">
			<p><input type="text" name="idfiesta_edit" placeholder="Id fiesta"></p>
			<button type="submit"> Editar fiesta </button>
		</form>
	</div>
</body>
</html>