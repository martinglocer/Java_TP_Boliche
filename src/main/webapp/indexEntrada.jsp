<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		<title>Entradas</title>
	</head>
<body>
	<h1>Entrada</h1>
		
		<div>	
			<nav>
            	<ul class=opc>
            		<li><a class=button-link href="registrarEntrada.jsp">Adquirir entrada</a></li> <!-- USUARIO (CU Epic) -->                
                	<li><a class=button-link href="indexEntrada">Listar todas las entradas</a></li>	<!-- admin -->
                	<li><a class=button-link href="actualizarEntrada.jsp">Modificar una entrada</a></li> <!-- admin -->
                	<li><a class=button-link href="eliminarEntrada.jsp">Eliminar una entrada</a></li> <!-- admin -->
                	<li><a class="button-link back-to-main" href="index.jsp">Volver al menú principal</a></li>
            	</ul>
        	</nav>
        </div>
        
</body>
</html>