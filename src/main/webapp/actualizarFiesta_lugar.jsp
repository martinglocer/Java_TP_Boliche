<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar fiesta con su lugar y fecha</title>
</head>
<body>
	<h1>Editar fiesta_lugar</h1>
	<p>Ingrese el id de la fiesta, el id del lugar y la fecha de realización</p>
	<div>
		<form action="SvEditarFiesta_lugar" method="get">
			<p><input type="number" name="idfiesta_edit" placeholder="Id fiesta"></p>
			<p><input type="number" name="idlugar_edit" placeholder="Id lugar"></p>
			<p><input type="date" name="fecha_edit" placeholder="Fecha realización actual"></p>
			<p><input type="time" name="hora_edit" placeholder="Hora de realización actual"></p>
			<button type="submit"> Editar fiesta_lugar </button>
		</form>
	</div>
</body>
</html>