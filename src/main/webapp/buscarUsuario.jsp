<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar usuario</title>
</head>
<body>
	<h1>Buscar usuario</h1>
	<p>Ingrese el tipo y numero de documento del usuario que quiere modificar</p>
	<div>
		<form action="SvBuscarUsuario" method="get">
			<p><input type="text" name="tipo_doc_editar" placeholder="Tipo de documento"></p>
			<p><input type="text" name="nro_doc_editar" placeholder="Numero de documento"></p>
			<button type="submit"> Mostrar usuario </button>
		</form>
	</div>
</body>
</html>