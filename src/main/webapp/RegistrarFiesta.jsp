
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar fiesta</title>
</head>
<body>
	<h1>Registro de fiesta</h1>
	<div>
		<form action="RegistrarFiesta" method="post">
			<p><input type="text" name="nombre_fiesta" placeholder="Nombre de la fiesta"></p>
			<p><input type="text" name="descripcion" placeholder="Descripción de la fiesta"></p>
			<button type="submit"> Registrar fiesta </button>
		</form>
	</div>
</body>
</html>