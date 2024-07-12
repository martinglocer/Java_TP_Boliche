<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Lugar" %>
<%@page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
	<title>Editar Lugar</title>
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
				<% Lugar lug = (Lugar) request.getSession().getAttribute("lugEditar"); %>
				<h1>Datos del lugar</h1>
				<form action="SvEditarLugar" method="post">
					<p>Id<input type="number" name="idlugar" placeholder="Id lugar" value="<%=lug.getIdlugar()%>"></p>
					<p>Nombre<input type="text" name="nombre_lugar" placeholder="Nombre" value="<%=lug.getNombre_lugar()%>"></p>
					<p>Direccion<input type=text name="direccion" placeholder="Dirección" value="<%=lug.getDireccion()%>"></p>
					<p>Ciudad<input type="text" name="ciudad" placeholder="Ciudad" value="<%=lug.getCiudad()%>"></p>
					<p>Capacidad<input type="number" name="capacidad" placeholder="Capacidad" value="<%=lug.getCapacidad()%>"></p>
					<button type="submit"> Guardar cambios </button>
				</form>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>
	
</body>
</html>