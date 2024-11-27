<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		<title>Eventos (Fiesta en lugar)</title>
	</head>
<body>
		        
	<% 
        // HttpSession session = request.getSession();
        Asistente loggedInUser = (Asistente) session.getAttribute("user");
        if (loggedInUser == null) {
            response.sendRedirect("index.jsp");
        } else { %>
            <% int isAdmin = (loggedInUser.getIdrol() == 1) ? 1 : 2;
            if (isAdmin == 1) { %>
                <%@ include file="menu_cabecera_admin.jsp" %>
				<h1>Fiestas y lugares</h1>
		
				<div>	
					<nav>
            			<ul class=opc>
                			<li><a class=button-link href="indexFiesta_lugar">Listar todas las fiestas organizadas</a></li>
                			<li><a class=button-link href="Sv_fiesta_lugar_disponibles_para_entradas">Listar las futuras fiestas disponibles</a></li>
                			<li><a class=button-link href="Sv_fiestas_para_fiesta_lugar">Registrar una nueva fiesta con su lugar y fecha de realización</a></li>                
                			<li><a class="button-link back-to-main" href="menu.jsp">Volver al menú principal</a></li>
            			</ul>
        			</nav>
       			</div>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>
        
</body>
</html>