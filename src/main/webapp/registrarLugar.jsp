<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
<meta charset="UTF-8">
<title>Registrar lugar</title>
</head>
<body>
	<h1>Registro de nuevo lugar</h1>
	<div>
		<form action="RegistrarLugar" method="post">
			<p><input type="text" name="nombre_lugar" placeholder="Nombre"></p>
			<p><input type=text name="direccion" placeholder="Dirección"></p>
			<p><input type="number" name="capacidad" placeholder="Capacidad"></p>
			<p><input type="text" name="ciudad" placeholder="Ciudad"></p>
			<button type="submit"> Registrar </button>
		</form>
	</div>
</body>
</html>