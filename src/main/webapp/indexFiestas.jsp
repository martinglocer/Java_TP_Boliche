<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		<title>Fiestas</title>
	</head>
<body>
		
		<div>	
			<nav>
            	<ul class=opc>
                	<li><a class=button-link href="indexFiestas">Listar fiestas</a></li>
                	<li><a class=button-link href="registrarFiesta.jsp">Registrar una nueva fiesta</a></li> 
                	<li><a class="button-link back-to-main" href="menu.jsp">Volver al menú principal</a></li>               
            	</ul>
        	</nav>
        </div>
	
	<% 
        // HttpSession session = request.getSession();
        Asistente loggedInUser = (Asistente) session.getAttribute("user");
        if (loggedInUser == null) {
            response.sendRedirect("index.jsp");
        } else { %>
            <% int isAdmin = (loggedInUser.getIdrol() == 1) ? 1 : 2;
            if (isAdmin == 1) { %>
                <jsp:include page="menu_cabecera_admin.jsp" />
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
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>
	
</body>
</html>