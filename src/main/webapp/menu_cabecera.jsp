<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/menu.css">
    <title>Menú cabecera</title>
</head>
<body>
    
    <div class="menu">
        <nav>
            <ul class="menu-items">
                <% 
                	boolean isAd = (boolean) pageContext.getAttribute("isAdmin"); 
                	if (isAd) { 
                %>
                    <!-- Opciones para administradores -->
                    <li><a href="indexUsuarios.jsp">Usuarios</a></li>
                    <li><a href="indexLugares.jsp">Lugares</a></li>
                    <li><a href="indexFiestas.jsp">Fiestas</a></li>
                    <li><a href="indexFiesta_lugar.jsp">Fiesta en lugar</a></li>
                <% } else { %>
                    <!-- Opciones para usuarios normales -->
                    <li><a href="indexEntrada.jsp">Entradas</a></li>
                    <li><a href="indexFiestas.jsp">Eventos futuros</a></li>
                <% } %>
            </ul>
            <ul class="menu-corners">
                <li><a href="menu.jsp" id="volver">Home</a></li>
                <li><a href="Logout" id="logout">Cerrar sesión</a></li>
            </ul>
        </nav>
    </div>
    
</body>
</html>

