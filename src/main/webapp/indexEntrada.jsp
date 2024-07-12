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

    <% 
        // HttpSession session = request.getSession();
        Asistente loggedInUser = (Asistente) session.getAttribute("user");
        if (loggedInUser == null) {
            response.sendRedirect("index.jsp");
        } else { %>
            <% int isAdmin = (loggedInUser.getIdrol() == 1) ? 1 : 2;
            if (isAdmin == 1) { %>
                <jsp:include page="menu_cabecera_admin.jsp" />
                <h1>Entrada</h1>
                <div>    
                    <nav>
                        <ul class=opc>
                            <li><a class=button-link href="indexEntrada">Listar todas las entradas</a></li>  <!-- admin -->
                            <li><a class=button-link href="registrarEntrada.jsp">Registrar una entrada</a></li> <!-- admin -->
                            <li><a class=button-link href="actualizarEntrada.jsp">Modificar una entrada</a></li> <!-- admin -->
                            <li><a class=button-link href="eliminarEntrada.jsp">Eliminar una entrada</a></li> <!-- admin -->
                            <li><a class="button-link back-to-main" href="menu.jsp">Volver al menú principal</a></li>
                        </ul>
                    </nav>
                </div>
            <% } else if (isAdmin == 2) { %>
                <jsp:include page="menu_cabecera_usuario.jsp" />
                <h1>Entrada</h1>
                <div>    
                    <nav>
                        <ul class=opc>
                            <li><a class=button-link href="registrarEntrada.jsp">Adquirir entrada</a></li> <!-- USUARIO (CU Epic) -->
                            <li><a class="button-link back-to-main" href="menu.jsp">Volver al menú principal</a></li>
                        </ul>
                    </nav>
                </div>
            <% } %>
    <% } %>

</body>
</html>
