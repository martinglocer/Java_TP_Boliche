<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.LinkedList"%>
<%@page import = "entities.Asistente"%>
<%@page import = "jakarta.servlet.http.HttpSession" %>
<% %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
<meta charset="UTF-8">
<%
	LinkedList<Asistente> listaUsuarios = (LinkedList) request.getSession().getAttribute("listaUsuarios");
%>
<title>Mostrar usuarios</title>
</head>
<body>
	<h1>Lista de usuarios registrados</h1>
   
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

</body>
</html>