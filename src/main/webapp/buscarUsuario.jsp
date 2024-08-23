<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
<meta charset="UTF-8">
<title>Buscar usuario</title>
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
					<h1>Buscar usuario</h1>
					<p>Ingrese el tipo y numero de documento del usuario</p>
					<div>
						<form action="SvBuscarUsuario" method="get">
							<p>
                				<label>Tipo de documento</label>
                				<select name="tipo_doc_editar" placeholder="Tipo" required>
                    				<option value="">Seleccione un tipo</option>
                    				<option value="DNI">DNI</option>
                				</select>
           					</p>
							<p><label>Número de documento</label></p>
							<p><input type="text" name="nro_doc_editar" placeholder="Número" required></p>
							<button type="submit"> Mostrar usuario </button>
						</form>
					</div>
					<a class="button-link back-to-main" href="indexUsuarios.jsp">Volver</a>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>


</body>
</html>