<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/login.css">
	<title>Registrarse</title>
</head>
<body>
	<div> <h1>Registro de usuario</h1> </div>
	<%
		String error = (String) session.getAttribute("error");
    	if (error != null) {
    %>
        <p id=warning style="color: red;"><%= error %></p>
    <%
    }
    session.removeAttribute("error");
    %>
	<div>
		<form action="RegisterUser" method="post">
			<p>
				<label>Tipo de documento</label>
				<select name="tipo_doc">
          		  <option value="">Seleccione un tipo</option>
          		  <option value="DNI">DNI</option>
        		</select>
        	<p>
			<p><label>Número de documento</label><p>
			<p><input type="text" name="nro_doc"></p>
			<p><label>Nombre</label><p>
			<p><input type="text" name="nombre"></p>
			<p><label>Apellido</label><p>
			<p><input type="text" name="apellido"></p>
			<p><label>Email</label><p>
			<p><input type="email" name="email"></p>
			<p><label>Celular</label><p>
			<p><input type="text" name="celular"></p>
			<p>Fecha de nacimiento</p><p><input type="date" name="fecha_nacimiento"></p>
			<p><label>Saldo</label><p>
			<p><input type="text" name="saldo"></p>
			<p><label>Contraseña</label><p>
			<p><input type="password" name="password"></p>
			<p>
        		<select name="idrol">
          		  <option value="">Seleccione un rol</option>
          		  <option value="1">Administrador</option>
          		  <option value="2">Usuario estándar</option>
        		</select>
    		</p>
			<button type="submit"> Registrarme </button>
		</form>
	</div>
</body>
</html>