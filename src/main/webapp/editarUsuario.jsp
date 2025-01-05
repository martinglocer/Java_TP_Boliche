<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
	<meta charset="UTF-8">
	<title>Editar Usuario</title>
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
				<% 
					Asistente a = (Asistente) request.getSession().getAttribute("usuEditar"); 
					String errorMessage = (String) request.getSession().getAttribute("error");
				%>
				<h1>Datos del usuario</h1>
				<% if (errorMessage != null) { %>
                    <div style="color: red; font-weight: bold;">
                        <p><%= errorMessage %></p>
                    </div>
                    <% session.removeAttribute("error"); // Limpia el error una vez mostrado %>
                <% } %>
				
				<form action="SvEditarUsuario" method="post">
					<p><input type="hidden" name="id_user" required placeholder="Id del usuario" value="<%=a.getIdasistente()%>"></p>
					<p><label>Tipo de documento</label></p>
					<p><input type="text" name="tipo_doc" required placeholder="Tipo de documento" value="<%=a.getTipo_doc()%>" readonly></p>
					<p><label>Número de documento</label></p>
					<p><input type="text" name="nro_doc" required placeholder="Número de documento" value="<%=a.getNro_doc()%>" readonly></p>
					<p><label>Nombre</label><p>
					<p><input type="text" name="nombre" required placeholder="Nombre" value="<%=a.getNombre()%>"></p>
					<p><label>Apellido</label><p>
					<p><input type="text" name="apellido" required placeholder="Apellido" value="<%=a.getApellido()%>"></p>
					<p><label>Email</label><p>
					<p><input type="email" name="email" required placeholder="Email" value="<%=a.getEmail()%>"></p>
					<p><label>Fecha de nacimiento</label><p>
					<p><input type="date" name="fecha_nacimiento" required placeholder="Fecha de nacimiento" value="<%=a.getFecha_nacimiento()%>"></p>
					<p><label>Celular</label><p>
					<p><input type="text" name="celular" required placeholder="Celular" value="<%=a.getCelular()%>"></p>
					<!-- <p><label>Saldo</label><p>
					<p><input type="text" name="saldo" placeholder="Saldo" value="<%=a.getSaldo()%>"></p> -->
					<!-- <p><label>Rol</label><p>
					<p><input type="text" name="idrol" placeholder="Rol" value="<%=a.getRol()%>"></p>-->
					<p>
					    <label>Rol</label>
					</p>
					<p>
					    <select name="idrol" required>
					        <option value="">Seleccione un rol</option>
					        <option value="1" <%= (a.getIdrol() == 1) ? "selected" : "" %>>Administrador</option>
					        <option value="2" <%= (a.getIdrol() == 2) ? "selected" : "" %>>Usuario estándar</option>
					    </select>
					</p>
					<p><label>Contraseña</label><p>
					<p><input type="text" name="password" required placeholder="Contraseña" value="<%=a.getPassword()%>"></p>
					<button type="submit"> Guardar cambios </button>
				</form>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>
	
</body>
</html>