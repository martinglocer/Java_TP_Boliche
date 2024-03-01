<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<h1>Incio de sesión</h1>
		<form action="LoginServlet" method="post">
			<p><input type="number" name="dni" placeholder="Ingrese su DNI"></p>
			<p><input type="text" name="password" placeholder="Ingrese su contraseña""></p>
			<button type="submit"> Enviar </button>
		</form>
		
	
	</body>
</html>