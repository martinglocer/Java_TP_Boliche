<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		
		<title>Entradas</title>
	</head>
<body>
	
	<%@ include file="menu_cabecera_usuario.jsp" %>
	<h1>Entrada</h1>
		
		<div>	
			<nav>
            	<ul class=opc>
            		<% 
	            		/* HttpSession session = request.getSession(); */
	                    Asistente loggedInUser = (Asistente) session.getAttribute("user");
	                    boolean isAdmin = (boolean) session.getAttribute("isAdmin");
					%>
					<% if (isAdmin) { %>
    					<li><a class=button-link href="indexEntrada">Listar todas las entradas</a></li>	<!-- admin -->
                		<li><a class=button-link href="actualizarEntrada.jsp">Modificar una entrada</a></li> <!-- admin -->
                		<li><a class=button-link href="eliminarEntrada.jsp">Eliminar una entrada</a></li> <!-- admin -->
					<% } else { %>
    					<li><a class=button-link href="registrarEntrada.jsp">Adquirir entrada</a></li> <!-- USUARIO (CU Epic) -->      
					<% } %> 
						
            		          
                	
                	<li><a class="button-link back-to-main" href="menu.jsp">Volver al menú principal</a></li>
            	</ul>
        	</nav>
        </div>
        
</body>
</html>