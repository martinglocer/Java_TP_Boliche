<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.LinkedList"%>
<%@page import = "entities.Asistente"%>
<%@page import = "jakarta.servlet.http.HttpSession" %>
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar usuarios</title>
</head>
<body>
	<h1>Lista de usuarios registrados</h1>
	<%
		LinkedList<Asistente> listaUsuarios = (LinkedList) request.getSession().getAttribute("listaUsuarios");
		int cont = 1;
		for(Asistente a : listaUsuarios){
	%>
			<p> <b>Usuario N° <%=cont %> </b> </p>
			<p> Tipo de documento: <%=a.getNro_doc() %></p>
			<p> Numero de documento: <%=a.getNro_doc() %></p>
			<p> Nombre: <%= a.getNombre() %> </p>
			<p> Apellido: <%= a.getApellido() %> </p>
			<p> Saldo: <%= a.getSaldo() %> </p>
			<p> Celular: <%= a.getCelular() %> </p>
			<p> Email: <%=a.getEmail() %></p>
			<p>----------------------------------</p>
			<%cont = cont + 1; %>
	<% } %>
</body>
</html>