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
                <li><a href="fiesta_lugar_disponibles">Eventos futuros</a></li>
               <!--  <li><a href="mi_perfil.jsp" id="mi_perfil">Mi perfil</a></li> -->
            </ul>
            <ul class="menu-corners">
    			<li><a href="menu.jsp" id="volver">Home</a></li>
  				  <!-- Contenedor para las opciones de perfil y logout -->
    			<div class="profile-logout">
        			<li><a href="mi_perfil.jsp" id="mi_perfil">Mi perfil</a></li>
        			<li><a href="Logout" id="logout">Cerrar sesión</a></li>
    			</div>
			</ul>

        </nav>
    </div>
</body>
</html>

