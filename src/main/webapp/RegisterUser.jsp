<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/login.css">
    <title>Registrarse</title>
</head>
<body>
	<% Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
       if (isAdmin != null && isAdmin) { // Mostrar solo si es admin %>
    	  	<%@ include file="menu_cabecera_admin.jsp" %>
			<% Asistente a = (Asistente) request.getSession().getAttribute("usuMostrar"); %>     
		<% } %>

    <div> <h1>Registro de usuario</h1> </div>
    <%
        String error = (String) session.getAttribute("error");
        if (error != null) {
    %>
        <p id="warning" style="color: red;"><%= error %></p>
    <%
        }
        session.removeAttribute("error");
    %>
    <div>
        <form action="RegisterUser" method="post">
            <p>
                <label>Tipo de documento</label>
                <select name="tipo_doc" required>
                    <option value="">Seleccione un tipo</option>
                    <option value="DNI">DNI</option>
                </select>
            </p>
            <p><label>Número de documento</label></p>
            <p><input type="text" name="nro_doc" required></p>
            <p><label>Nombre</label><p>
            <p><input type="text" name="nombre" required></p>
            <p><label>Apellido</label><p>
            <p><input type="text" name="apellido" required></p>
            <p><label>Email</label><p>
            <p><input type="email" name="email" required></p>
            <p><label>Celular</label><p>
            <p><input type="text" name="celular" required></p>
            <p>Fecha de nacimiento</p><p><input type="date" name="fecha_nacimiento" required></p>
           <!--  <p><label>Saldo</label><p>
            <p><input type="text" name="saldo" required></p> -->
            <p><label>Contraseña</label><p>
            <p><input type="password" name="password" required></p>
            <%
                if (isAdmin != null && isAdmin) { // Mostrar solo si es admin
            %>
                <p>
                    <select name="idrol" required>
                        <option value="">Seleccione un rol</option>
                        <option value="1">Administrador</option>
                        <option value="2">Usuario estándar</option>
                    </select>
                </p>
            <%
                } else { // Por defecto, registrar como usuario estándar
            %>
                <input type="hidden" name="idrol" value="2">
            <%
                }
            %>
            <button type="submit"> Registrarme </button>
        </form>
    </div>
</body>
</html>
