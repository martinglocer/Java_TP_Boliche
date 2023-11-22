<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Fiesta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Fiesta</title>
	</head>
	<body>
	
		<% Fiesta fiesta = (Fiesta) request.getSession().getAttribute("fiestaEditar"); %>
		<h1>Datos de la fiesta</h1>
		<form action="SvEditarFiesta" method="post">
			<p><input type="number" name="idfiesta" placeholder="Id fiesta" value="<%=fiesta.getIdfiesta()%>"></p>
			<p><input type="text" name="nombre_fiesta" placeholder="Nombre" value="<%=fiesta.getNombre_fiesta()%>"></p>
			<p><input type=text name="descripcion" placeholder="Descripción" value="<%=fiesta.getDescripcion()%>"></p>
			<button type="submit"> Guardar cambios </button>
		</form>
		
	
	</body>
</html>