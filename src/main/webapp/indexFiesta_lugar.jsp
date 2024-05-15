<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		<title>Fiestas organizadas (Fiesta_lugar)</title>
	</head>
<body>
	<h1>Fiestas y lugares</h1>
		
		<div>	
			<nav>
            	<ul class=opc>
                	<li><a class=button-link href="indexFiesta_lugar">Listar todas las fiestas organizadas</a></li>
                	<li><a class=button-link href="fiesta_lugar_disponibles">Listar las futuras fiestas disponibles</a></li>
                	<li><a class=button-link href="registrarFiesta_lugar.jsp">Registrar una nueva fiesta con su lugar y fecha de realización</a></li>                
                	<li><a class=button-link href="actualizarFiesta_lugar.jsp">Modificar una fiesta_lugar</a></li>
                	<li><a class=button-link href="eliminarFiesta_lugar.jsp">Eliminar una fiesta_lugar</a></li>
                	<li><a class="button-link back-to-main" href="menu.jsp">Volver al menú principal</a></li>
            	</ul>
        	</nav>
        </div>
        
</body>
</html>