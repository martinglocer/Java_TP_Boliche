<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
<meta charset="UTF-8">
<title>Actualizar lugar</title>
</head>
<body>
	<h1>Editar lugar</h1>
	<p>Ingrese el id del lugar que quiere modificar</p>
	<div>
		<form action="SvEditarLugar" method="get">
			<p><input type="text" name="idlugar_edit" placeholder="Id lugar"></p>
			<button type="submit"> Editar lugar </button>
		</form>
	</div>
</body>
</html>