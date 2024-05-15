<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		<title>Lugares</title>
	</head>
<body>
	<h1>Lugares</h1>
		
		<div>	
			<nav>
            	<ul class=opc>
                	<li><a class=button-link href="indexLugares">Listar lugares</a></li>
                	<li><a class=button-link href="buscarLugarPorId.jsp">Buscar lugar por id</a></li>    <!-- consultar si es necesario -->           
                	<li><a class=button-link href="registrarLugar.jsp">Registrar un lugar</a></li>                
                	<li><a class=button-link href="actualizarLugar.jsp">Modificar un lugar</a></li>
                	<li><a class=button-link href="eliminarLugar.jsp">Eliminar un lugar</a></li>
                	<li><a class="button-link back-to-main" href="menu.jsp">Volver al menú principal</a></li>
            	</ul>
        	</nav>
        </div>
        
</body>
</html>