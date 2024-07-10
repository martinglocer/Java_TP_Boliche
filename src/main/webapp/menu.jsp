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
	<%@ include file="menu_cabecera.jsp" %>
	
	<h1 class=container>Bienvenido!</h1>
	
	<h2>Menu principal</h2> 
	
	<div>	
			<nav>
            	<ul>
            		<!-- Opciones admin -->
            		
						<%--HttpSession session = request.getSession();--%>
						<%--Integer rol = (Integer) session.getAttribute("rol");--%>
					
					<%-- <% if ("admin".equals(rol)) { %>
    					<h1>Bienvenido Administrador</h1>
    					<li><a class=button-link href="indexUsuarios.jsp">Usuarios</a></li>    
                		<li><a class=button-link href="indexLugares.jsp">Lugares</a></li>     
                		<li><a class=button-link href="indexFiestas.jsp">Fiestas</a></li>   
                		<li><a class=button-link href="indexFiesta_lugar.jsp">Fiesta en lugar</a></li>  <!-- CRUD Dependiente -->
					<% } else { %>
    					<h1>Bienvenido Usuario</h1>
    					<li><a class=button-link href="indexEntrada.jsp">Comprar entrada</a></li> <!-- Caso de Uso EPIC -->    
					<% } %> --%>
					
					<li><a class=button-link href="indexUsuarios.jsp">Usuarios</a></li>    
                	<li><a class=button-link href="indexLugares.jsp">Lugares</a></li>     
                	<li><a class=button-link href="indexFiestas.jsp">Fiestas</a></li>   
                	<li><a class=button-link href="indexFiesta_lugar.jsp">Fiesta en lugar</a></li>  <!-- CRUD Dependiente -->
                	
                	
    				<li><a class=button-link href="indexEntrada.jsp">Comprar entrada</a></li> <!-- Caso de Uso EPIC -->    
                	
            	</ul>
        	</nav>
        	<div id="background-image">
        	</div>
        </div>
        
</body>
	

		
        	<div id="background-image">
        	</div>
       
     
        
</body>
</html>

