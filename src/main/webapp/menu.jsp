<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		<title>El boliche</title>
	</head>
<body>
	<h1 class=container>Bienvenido!</h1>
	
	<h2>Menu principal</h2>
		
		<div>	
			<nav>
            	<ul>
            		<!-- Opciones admin -->
                	<li><a class=button-link href="indexUsuarios.jsp">Usuarios</a></li>    
                	<li><a class=button-link href="indexLugares.jsp">Lugares</a></li>     
                	<li><a class=button-link href="indexFiestas.jsp">Fiestas</a></li>   
                	<li><a class=button-link href="indexFiesta_lugar.jsp">Fiesta en lugar</a></li>  <!-- CRUD Dependiente -->
                	<!-- Opciones usuario -->          
                	<li><a class=button-link href="indexEntrada.jsp">Comprar entrada</a></li> <!-- Caso de Uso EPIC -->    
            	</ul>
        	</nav>
        	<div id="background-image">
        	</div>
        </div>
        
</body>
</html>

