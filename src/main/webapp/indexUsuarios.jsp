<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		<title>Usuarios</title>
	</head>
<body>

	<%@ include file="menu_cabecera.jsp" %>
	<h1>Usuarios</h1>
		
		<div>	
			<nav id="menu">
            	<ul class=opc>
            		<li><a class=button-link href="indexUsuarios">Listar usuarios</a></li>
            		<li><a class=button-link href="buscarUsuario.jsp">Buscar usuarios por tipo y numero de documento</a></li>
                	<li><a class=button-link href="RegisterUser.jsp">Registrar un usuario</a></li>
                	<li><a class=button-link href="actualizarUsuario.jsp">Modificar un usuario</a></li>
                	<li><a class=button-link href="buscarUsuario.jsp">Eliminar un usuario</a></li>
                	<li><a class="button-link back-to-main" href="menu.jsp">Volver al menú principal</a></li>
            	</ul>
        	</nav>
        </div>
</body>
</html>