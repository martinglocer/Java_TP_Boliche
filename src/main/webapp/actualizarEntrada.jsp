<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar entrada</title>
</head>
<body>
	<h1>Editar entrada</h1>
	<p>Ingrese el id de la entrada</p>
	<div>
		<form action="SvEditarEntrada" method="get">
			<p><input type="number" name="identrada_edit" placeholder="Id entrada"></p>
			<button type="submit"> Editar entrada </button>
		</form>
	</div>
</body>
</html>