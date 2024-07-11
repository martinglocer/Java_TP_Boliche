<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="servlet.LoginServlet" %>
<%@ page import="data.DataAsistente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
    <title>El boliche</title>
</head>
<body>
    
    <!-- Obtener el usuario y su estado de administrador -->
    <% 
        //HttpSession session = request.getSession();
        Asistente loggedInUser = (Asistente) session.getAttribute("user");
        boolean isAdmin = (boolean) session.getAttribute("isAdmin");
    %>
    
    <nav>
        <!-- Incluir menu_cabecera.jsp y pasar isAdmin como atributo del contexto -->
        <% pageContext.setAttribute("isAdmin", isAdmin); %>
        <%@ include file="menu_cabecera.jsp" %>
  
        
        <!-- Resto del contenido según isAdmin -->
        <% if (isAdmin) { %>
            <h1>Bienvenido Administrador <%= loggedInUser.getNombre() %>!</h1>
            <!-- Opciones para administradores -->
        <% } else { %>
            <h1>Bienvenido Usuario <%= loggedInUser.getNombre() %>!</h1>
            <!-- Opciones para usuarios normales -->
        <% } %>
        
    </nav>
    
</body>
</html>
