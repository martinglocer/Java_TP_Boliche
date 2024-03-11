<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Entrada" %>
<%@page import="entities.Fiesta_lugar" %>
<%@page import="entities.Asistente" %>
<%@page import="entities.Fiesta" %>
<%@page import="entities.Lugar" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Entrada</title>
	</head>
	<body>
	
		<%  
			Entrada ent = (Entrada) request.getSession().getAttribute("entradaEditar");
			Asistente asis = ent.getAsistente();
			Fiesta_lugar fl = ent.getFiesta_lugar();
			Fiesta f = fl.getFiesta();
			Lugar l = fl.getLugar();
		%>
		<h1>Datos de la entrada</h1>
		<form action="SvEditarEntrada" method="post">
			<p>Id Entrada<input type="number"  name="identrada" readonly placeholder="Id entrada" value="<%=ent.getIdentrada()%>"></p>
			<p>Tipo de documento<input type="text" name="tipo_doc" placeholder="Tipo de documento" value="<%=asis.getTipo_doc()%>"></p>
			<p>Número de documento<input type="number" name="nro_doc" placeholder="Número de documento" value="<%=asis.getNro_doc()%>"></p>
			<p>Id de la fiesta<input type="number" name="id_fiesta" placeholder="Id fiesta" value= "<%=f.getIdfiesta()%>"></p>
			<p>Id del lugar<input type="number" name="id_lugar" placeholder="Id lugar" value="<%=l.getIdlugar()%>"></p>
			<p>Fecha del evento<input type="time" name="fecha_fiesta" placeholder="Fecha del evento" value="<%=fl.getFecha_fiesta()%>" ></p>
			<p>Hora del evento<input type="time" name="hora_fiesta" placeholder="Hora de realización del evento" value="<%=fl.getHora_fiesta()%>" ></p>
			<p>Fecha de compra<input type="time" name="fecha_compra" readonly placeholder="Fecha de la compra" value="<%=ent.getFecha_compra()%>" ></p>
			<p>Hora de compra<input type="time" name="hora_compra" readonly placeholder="Hora de la compra" value="<%=ent.getHora_compra()%>" ></p>
			<button type="submit"> Guardar cambios </button>
		</form>
		
	
	</body>
</html>