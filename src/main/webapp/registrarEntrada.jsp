<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente, entities.Fiesta_lugar, java.util.LinkedList" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo_cards.css">
<meta charset="UTF-8">
<title>Comprar entrada</title>
</head>
<body>
<%
	System.out.println("Entrando a registrarEntrada.jsp");
    Asistente loggedInUser = (Asistente) session.getAttribute("user");
    if (loggedInUser == null) {
        response.sendRedirect("index.jsp");
    } else {
        boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
%>
    <% if (isAdmin) { %>
        <%@ include file="menu_cabecera_admin.jsp" %>
    <% } else { %>
        <%@ include file="menu_cabecera_usuario.jsp" %>
    <% } %>
    <h1>Compra tu entrada</h1>
    <div>
        <form action="RegistrarEntrada" method="post">
            <p><input type="hidden" name="tipo_doc" placeholder="Tipo de documento" value="<%=loggedInUser.getTipo_doc()%>"></p>
            <p><input type="hidden" name="nro_doc" placeholder="Número de documento" value= "<%=loggedInUser.getNro_doc()%>"></p>
            <div id="fiestas">
                <!-- Aquí es donde mostraremos las tarjetas de las fiestas -->
                <%
                    
                    LinkedList<Fiesta_lugar> fiestas = (LinkedList<Fiesta_lugar>) session.getAttribute("fiestasDisponibles");
                    if (fiestas != null && !fiestas.isEmpty()) {
                        for (Fiesta_lugar fiesta : fiestas) {
                %>
                <div class="card">
                    <input type="radio" name="fiesta" value="<%= fiesta.getFiesta().getIdfiesta() %>_<%= fiesta.getLugar().getIdlugar() %>_<%= fiesta.getFecha_fiesta() %>_<%= fiesta.getHora_fiesta() %>">
                    <p>Fiesta: <%= fiesta.getFiesta().getNombre_fiesta() %></p>
                    <p>Lugar: <%= fiesta.getLugar().getNombre_lugar() %></p>
                    <p>Fecha: <%= fiesta.getFecha_fiesta() %></p>
                    <p>Hora: <%= fiesta.getHora_fiesta() %></p>
                </div>
                <%
                        }
                    } else {
                %>
                <p>No hay fiestas disponibles en este momento.</p>
                <%
                    }
                %>
            </div>
            <button type="submit">Comprar</button>
        </form>
    </div>
<% } %>
</body>
</html>
