<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Asistente" %>
<%@page import="entities.Fiesta_lugar" %>
<%@page import="entities.Fiesta" %>
<%@page import="entities.Lugar" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
	<meta charset="UTF-8">
	<title>Editar Fiesta_lugar</title>
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
				<p>Precio actual del evento<input type="number" name="precio_fiesta_viejo" readonly placeholder="Precio" value="<%=fl.getPrecio()%>"></p>
				<p>Elegir nuevo precio del evento<input type="number" name="precio_fiesta_nuevo" placeholder="Precio" ></p>
				<button type="submit"> Guardar cambios </button>
			</form>
            <% } else if (isAdmin == 2) {
                response.sendRedirect("errorUsuario.jsp");
               } %>
    <% } %>
	

</body>
</html>