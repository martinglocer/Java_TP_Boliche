<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/menu.css">
    <title>El boliche</title>
</head>
<body>
    <div class="menu">
        <nav>
            <ul class="menu-items">
                <!-- Opciones usuario -->
                <li><a href="indexEntrada.jsp">Entradas</a></li>
                <li><a href="indexFiestas">Eventos futuros</a></li>
            </ul>
            <ul class="menu-corners">
                <li><a href="menu.jsp" id="volver">Home</a></li>
                <li><a href="Logout" id="logout">Cerrar sesión</a></li>
            </ul>
        </nav>
    </div>
</body>
</html>
