<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Usuarios</title>
	</head>
<body>
	<h1>Menu usuarios</h1>
		
		<div>	
			<nav>
            	<ul>
                	
                	<li><a href="indexUsuarios">ir a la seccion de usuario</a></li>
                	<!-- <li><a href="indexUsuarios.html">Eliminar un usuario</a></li> -->
            	</ul>
        	</nav>
        </div>
        
        <div>
        	<form action="mostrarUsuarios.jsp" method="get">
        		<button type="submit"> Mostrar usuarios </button>
        	</form>
        </div>
</body>
</html>