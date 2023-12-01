<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>El boliche</title>
	</head>
<body>
	<h1>Bienvenido</h1>
	
	<h2>Menu</h2>
		
		<div>	
			<nav>
            	<ul>
            		<!-- Opciones admin -->
                	<li><a href="indexUsuarios.jsp">Usuarios</a></li>    
                	<li><a href="indexLugares.jsp">Lugares</a></li>     
                	<li><a href="indexFiestas.jsp">Fiestas</a></li>   
                	<li><a href="indexFiesta_lugar.jsp">Fiesta en lugar</a></li>  <!-- CRUD Dependiente -->
                	<!-- Opciones usuario -->          
                	<li><a href="indexEntrada.jsp">Comprar entrada</a></li> <!-- Caso de Uso EPIC -->    
            	</ul>
        	</nav>
        </div>
        
</body>
</html>