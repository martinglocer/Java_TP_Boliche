<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Entrada" %>
<%@page import="entities.Fiesta_lugar" %>
<%@page import="entities.Asistente" %>
<%@page import="entities.Fiesta" %>
<%@page import="entities.Lugar" %>
<%@page import="data.DataAsistente" %>
<%@page import="data.DataFiesta" %>
<%@page import="data.DataLugar" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
	<title>Editar Entrada</title>
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
				<%  Entrada ent = (Entrada) request.getSession().getAttribute("entradaEditar");
					DataAsistente da = new DataAsistente();
					DataFiesta df = new DataFiesta();
					DataLugar dl = new DataLugar();
					Asistente asist = ent.getAsistente();
					Fiesta_lugar fl = ent.getFiesta_lugar();
					Fiesta fies = fl.getFiesta();
					Lugar lug = fl.getLugar();
				%>
				<h1>Datos de la entrada</h1>
				<form action="SvEditarEntrada" method="post">
					<p>Id Entrada<input type="number"  name="identrada" readonly placeholder="Id entrada" value="<%=ent.getIdentrada()%>"></p>
					<p>Tipo de documento<input type="text" name="tipo_doc" readonly placeholder="Tipo de documento" value="<%=asist.getTipo_doc()%>"></p>
					<p>Número de documento<input type="number" name="nro_doc" readonly placeholder="Número de documento" value="<%=asist.getNro_doc()%>"></p>
					<p>Id de la fiesta<input type="number" name="id_fiesta" readonly placeholder="Id fiesta" value= "<%=fies.getIdfiesta()%>"></p>
					<p>Id del lugar<input type="number" name="id_lugar" readonly placeholder="Id lugar" value="<%=lug.getIdlugar()%>"></p>
					<p>Fecha del evento<input type="date" name="fecha_fiesta" readonly placeholder="Fecha del evento" value="<%=fl.getFecha_fiesta()%>" ></p>
					<p>Hora del evento<input type="time" name="hora_fiesta" readonly placeholder="Hora de realización del evento" value="<%=fl.getHora_fiesta()%>" ></p>
					<p>Fecha de compra<input type="date" name="fecha_compra_vieja" readonly placeholder="Fecha de compra actual" value="<%=ent.getFecha_compra()%>" ></p>
					<p>Elegir nueva fecha de compra<input type="date" name="fecha_compra_nueva" placeholder="Nueva fecha de compra" ></p>
					<p>Hora de compra<input type="time" name="hora_compra_vieja" readonly placeholder="Hora de compra actual" value="<%=ent.getHora_compra()%>" ></p>
					<p>Elegir nueva fecha de compra<input type="time" name="hora_compra_nueva" placeholder="Nueva hora de compra" ></p>
					<button type="submit"> Guardar cambios </button>
				</form>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>
	
	
</body>
</html>