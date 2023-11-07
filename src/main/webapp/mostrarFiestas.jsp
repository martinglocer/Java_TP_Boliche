<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.LinkedList"%>
<%@page import = "entities.Fiesta"%>
<%@page import = "jakarta.servlet.http.HttpSession" %>
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar fiestas</title>
</head>
<body>
	<h1>Lista de fiestas registradas</h1>
	<%
		LinkedList<Fiesta> listaFiestas = (LinkedList) request.getSession().getAttribute("listaFiestas");
		int cont = 1;
		for(Fiesta f : listaFiestas){
	%>
			<p> <b>Fiesta N° <%=cont %> </b> </p>
			<p> Id Fiesta: <%=f.getIdfiesta() %></p>
			<p> Numero de documento: <%=f.getNombre_fiesta() %></p>
			<p> Nombre: <%= f.getDescripcion() %> </p>
			<p>----------------------------------</p>
			<%cont = cont + 1; %>
	<% } %>
</body>
</html>