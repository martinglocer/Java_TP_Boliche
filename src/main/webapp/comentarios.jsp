<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.Comentario" %>
<%@ page import="data.DataComentario" %>
<%@ page import="entities.Asistente" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="data.DataFiesta_lugar" %>
<%@ page import="entities.Fiesta_lugar" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/comentarios.css">
<meta charset="UTF-8">
<title>Comentarios</title>
</head>
<body>
    <%
        
        int idFiesta = Integer.parseInt(request.getParameter("idFiesta"));
        int idLugar = Integer.parseInt(request.getParameter("idLugar"));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaEvento = LocalDate.parse(request.getParameter("fechaEvento"), dateFormatter);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaEvento = LocalTime.parse(request.getParameter("horaEvento"), timeFormatter);


        Asistente loggedInUser = (Asistente) session.getAttribute("user");

        if (loggedInUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

    
        int isAdmin = (loggedInUser.getIdrol() == 1) ? 1 : 2;
        if (isAdmin == 1) { %>
            <%@ include file="menu_cabecera_admin.jsp" %>
        <% } else if (isAdmin == 2) { %>
            <%@ include file="menu_cabecera_usuario.jsp" %>
        <% }
    %>
    
    <%  DataFiesta_lugar dfl = new DataFiesta_lugar();
        Fiesta_lugar fl = dfl.getByData(idFiesta, idLugar, fechaEvento, horaEvento); 
    %>
    
	<div class="container">
    	<h1>Comentarios del evento: <%= fl.getFiesta().getNombre_fiesta() %></h1> 

	    <p>
	        <strong>Fecha y hora:</strong> <%= fl.getFecha_fiesta() %> a las <%= fl.getHora_fiesta() %><br>
	        <strong>Lugar:</strong> <%= fl.getLugar().getNombre_lugar() %><br>
	    </p>
    	<%
     
        	DataComentario dataComentario = new DataComentario();
        	List<Comentario> comentarios = dataComentario.getComentarios(idFiesta, idLugar, fechaEvento, horaEvento);

        	// Mostrar los comentarios existentes
        	if (comentarios != null && !comentarios.isEmpty()) {
            	for (Comentario comentario : comentarios) {
    	%>
                	<p><strong><%= comentario.getAsistente().getNombre() %> (<%= comentario.getFechaHora() %>):</strong> <%= comentario.getTexto() %></p>
    	<%
            }
        	} else {
    	%>
            	<p>No hay comentarios para este evento.</p>
    	<%
        	}
    	%>

    	<h2>Agregar un nuevo comentario</h2>
    	<form action="SvAgregarComentario" method="post">
        	<input type="hidden" name="idFiesta" value="<%= idFiesta %>">
        	<input type="hidden" name="idLugar" value="<%= idLugar %>">
        	<input type="hidden" name="fechaEvento" value="<%= fechaEvento %>">
        	<input type="hidden" name="horaEvento" value="<%= horaEvento %>">
        	<textarea name="texto" rows="5" cols="40" required></textarea>
        	<br>
        	<button type="submit">Enviar comentario</button>
    	</form>
    </div>
</body>
</html>