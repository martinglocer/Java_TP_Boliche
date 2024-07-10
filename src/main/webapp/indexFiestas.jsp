<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		<title>Fiestas</title>
	</head>
<body>
	
	<%@ include file="menu_cabecera_admin.jsp" %>
	<h1>Fiestas</h1>
		
		<div>	
			<nav>
            	<ul class=opc>
                	<li><a class=button-link href="indexFiestas">Listar fiestas</a></li>
                	<li><a class=button-link href="registrarFiesta.jsp">Registrar una nueva fiesta</a></li> 
                	<li><a class="button-link back-to-main" href="menu.jsp">Volver al menú principal</a></li>               
            	</ul>
        	</nav>
        </div>
        
</body>
</html>