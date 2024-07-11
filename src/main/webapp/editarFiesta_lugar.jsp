<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Fiesta_lugar" %>
<%@page import="entities.Fiesta" %>
<%@page import="entities.Lugar" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
		<meta charset="UTF-8">
		<title>Editar Fiesta_lugar</title>
	</head>
	<body>
	
		<%  
			Fiesta_lugar fl = (Fiesta_lugar) request.getSession().getAttribute("fiesta_lugarEditar"); 
			Fiesta f = fl.getFiesta();
			Lugar l = fl.getLugar();
		%>
		<h1>Datos de fiesta_lugar</h1>
		<form action="SvEditarFiesta_lugar" method="post">
			<p>Id Fiesta<input type="number"  name="idfiesta" readonly placeholder="Id fiesta" value="<%=f.getIdfiesta()%>"></p>
			<p>Id Lugar<input type="number" name="idlugar" readonly placeholder="Id lugar" value="<%=l.getIdlugar()%>"></p>
			<p>Fecha actual del evento<input type="date" name="fecha_fiesta_vieja" readonly placeholder="Fecha realización" value="<%=fl.getFecha_fiesta()%>"></p>
			<p>Elegir fecha nueva del evento<input type="date" name="fecha_fiesta_nueva" placeholder="Fecha nueva de realización" ></p>
			<p>Hora actual del evento<input type="time" name="hora_fiesta_vieja" readonly placeholder="Hora realización" value="<%=fl.getHora_fiesta()%>"></p>
			<p>Elegir hora nueva del evento<input type="time" name="hora_fiesta_nueva" placeholder="Hora realización" ></p>
			<button type="submit"> Guardar cambios </button>
		</form>
		
	
	</body>
</html>