<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
<meta charset="UTF-8">
<title>Eliminar fiesta_lugar</title>
</head>
<body>
	<h1>Eliminar fiesta en determinado lugar y en una fecha</h1>
	<p>Ingrese el id de la fiesta, el id del lugar y la fecha de realización</p>
	<div>
		<form action="SvEliminarFiesta_lugar" method="post">
			<p><input type="number" name="idfiesta_elim" placeholder="Id fiesta"></p>
			<p><input type="number" name="idlugar_elim" placeholder="Id lugar"></p>
			<p><input type="datetime" name="fecha_elim" placeholder="Fecha realización"></p>
			<button type="submit"> Eliminar Fiesta_lugar </button>
		</form>
	</div>
</body>
</html>