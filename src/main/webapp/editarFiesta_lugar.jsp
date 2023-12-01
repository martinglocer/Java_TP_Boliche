<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Fiesta_lugar" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Fiesta_lugar</title>
	</head>
	<body>
	
		<% Fiesta_lugar fiesta = (Fiesta_lugar) request.getSession().getAttribute("fiesta_lugarEditar"); %>
		<h1>Datos de fiesta_lugar</h1>
		<form action="SvEditarFiesta_lugar" method="post">
			<p><input type="number" name="idfiesta" placeholder="Id fiesta" value="<%=fiesta.getIdfiesta()%>"></p>
			<p><input type="number" name="idlugar" placeholder="Id lugar" value="<%=fiesta.getIdlugar()%>"></p>
			<p><input type="datetime" name="fecha_hora" placeholder="Fecha realización" value="<%=fiesta.getFecha_hora_fiesta()%>"></p>
			<button type="submit"> Guardar cambios </button>
		</form>
		
	
	</body>
</html>