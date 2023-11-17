<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar usuario</title>
</head>
<body>
	<h1>Editar usuario</h1>
	<p>Ingrese el tipo y numero de documento del usuario que quiere modificar</p>
	<div>
		<form action="SvEditarUsuario" method="get">
			<p><input type="text" name="tipo_doc_editar" placeholder="Tipo de documento"></p>
			<p><input type="text" name="nro_doc_editar" placeholder="Numero de documento"></p>
			<button type="submit"> Editar usuario </button>
		</form>
	</div>
</body>
</html>