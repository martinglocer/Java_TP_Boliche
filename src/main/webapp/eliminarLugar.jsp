<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar lugar</title>
</head>
<body>
	<h1>Eliminar lugar</h1>
	<p>Ingrese el id del lugar que quiere eliminar</p>
	<div>
		<form action="SvEliminarLugar" method="post">
			<p><input type="text" name="idlugar" placeholder="Id lugar"></p>
			<button type="submit"> Eliminar Lugar </button>
		</form>
	</div>
</body>
</html>