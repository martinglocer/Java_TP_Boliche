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
            <ul>
                <!-- Opciones admin -->
                <li><a href="indexUsuarios.jsp">Usuarios</a></li>
                <li><a href="indexLugares.jsp">Lugares</a></li>
                <li><a href="indexFiestas.jsp">Fiestas</a></li>
                <li><a href="indexFiesta_lugar.jsp">Fiesta en lugar</a></li>
                <!-- Opciones usuario -->
                <li><a href="indexEntrada.jsp">Entradas</a></li>
            </ul>
        </nav>
    </div>
</body>
</html>
