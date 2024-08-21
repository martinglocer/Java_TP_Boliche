<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.LinkedList"%>
<%@page import = "java.util.stream.Collectors"%>
<%@page import = "entities.Asistente"%>
<%@page import = "jakarta.servlet.http.HttpSession" %>
<% %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
	<meta charset="UTF-8">
	<title>Mostrar usuarios</title>
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
				<h1>Lista de usuarios registrados</h1>
				<%
					LinkedList<Asistente> listaUsuarios = (LinkedList) request.getSession().getAttribute("listaUsuarios");
					String searchQuery = request.getParameter("searchQuery");

					if (searchQuery != null && !searchQuery.isEmpty()) {
						listaUsuarios = listaUsuarios.stream()
						.filter(a -> a.getApellido().toLowerCase().contains(searchQuery.toLowerCase()) ||
									 a.getNombre().toLowerCase().contains(searchQuery.toLowerCase()))
						.collect(Collectors.toCollection(LinkedList::new));
					}
				%>
				
				<!-- Formulario de búsqueda -->
				<form method="get" action="">
					<input type="text" name="searchQuery" placeholder="Buscar por nombre o apellido" value="<%= searchQuery != null ? searchQuery : "" %>">
					<button type="submit">Buscar</button>
				</form>
				
        		<div>
          		  <table>
              		  <thead>
                  		  <tr>
                     		<th>Apellido</th>
                     	  	<th>Nombre</th>
                     	   	<th>Tipo documento</th>
                     	  	<th>Nro documento</th>
                      	  	<th>Email</th>
                        	<th>Celular</th>
                        	<th>Fecha de nacimiento</th>
                        	<th>Rol</th>
                        	<th>Saldo</th>
                        	<th>---</th>
                        	<th>---</th>
                   		 </tr>
                   	</thead>
                <tbody>
                    <% for (Asistente a : listaUsuarios) { %>
                        <tr>
                            <td><%=a.getApellido()%></td>
                            <td><%=a.getNombre()%></td>
                            <td><%=a.getTipo_doc()%></td>
                            <td><%=a.getNro_doc()%></td>
                            <td><%=a.getEmail()%></td>
                            <td><%=a.getCelular()%></td>
                            <td><%=a.getFecha_nacimiento()%></td>
                            <td><%=a.getRol()%></td>
                            <td><%=a.getSaldo()%></td>
                            <td><a href="SvEditarUsuario?tipo_doc_editar=<%=a.getTipo_doc()%>&nro_doc_editar=<%= a.getNro_doc() %>">Editar</a></td>
                            <td>
	                            <form action="SvEliminarUsuario" method="post" onsubmit="return confirm('¿Estás seguro de que deseas eliminar este usuario?');">
	                                <input type="hidden" name="tipo_doc" value="<%=a.getTipo_doc()%>">
	                                <input type="hidden" name="nro_doc" value="<%= a.getNro_doc() %>">
	                                <button type="submit"> Borrar </button>
	                            </form>
                       		</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>

</body>
</html>
