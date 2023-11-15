<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Lugar" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Lugar</title>
	</head>
	<body>
	
		<% Lugar lug = (Lugar) request.getSession().getAttribute("lugEditar"); %>
		<h1>Datos del lugar</h1>
		<form action="SvEditarLugar" method="post">
			<p><input type="number" name="idlugar" placeholder="Id lugar" value="<%=lug.getIdlugar()%>"></p>
			<p><input type="text" name="nombre_lugar" placeholder="Nombre" value="<%=lug.getNombre_lugar()%>"></p>
			<p><input type=text name="direccion" placeholder="Dirección" value="<%=lug.getDireccion()%>"></p>
			<p><input type="number" name="capacidad" placeholder="Capacidad" value="<%=lug.getCapacidad()%>"></p>
			<p><input type="text" name="ciudad" placeholder="Ciudad" value="<%=lug.getCiudad()%>"></p>
			<button type="submit"> Guardar cambios </button>
		</form>
		
	
	</body>
</html>