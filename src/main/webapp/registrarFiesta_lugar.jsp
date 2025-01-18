<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente, java.util.LinkedList, entities.Fiesta, entities.Lugar" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
    <title>Registrar fiesta con lugar</title>
</head>
<body>
    <% 
        Asistente loggedInUser = (Asistente) session.getAttribute("user");
        if (loggedInUser == null) {
            response.sendRedirect("index.jsp");
        } else {
            int isAdmin = (loggedInUser.getIdrol() == 1) ? 1 : 2;
            if (isAdmin == 1) { // Administrador
    %>
                <%@ include file="menu_cabecera_admin.jsp" %>
                <h1>Registro de una nueva fiesta con su lugar y fecha de realización</h1>
                <div class="card-container">
                    <form action="RegistrarFiesta_lugar" method="post">
                        <p>
                            <label>Selecciona la fiesta:</label>
                            <select name="idfiesta" required>
                                <option value="">Seleccione una fiesta</option>
                                <% 
                                    @SuppressWarnings("unchecked")
                                    LinkedList<Fiesta> fiestas = (LinkedList<Fiesta>) session.getAttribute("fiestas");
                                    for (Fiesta fiesta : fiestas) {
                                %>
                                    <option value="<%= fiesta.getIdfiesta() %>"><%= fiesta.getNombre_fiesta() %></option>
                                <% } %>
                            </select>
                        </p>
                        <p>
                            <label>Selecciona el lugar:</label>
                            <select name="idlugar" required>
                                <option value="">Seleccione un lugar</option>
                                <% 
                                    @SuppressWarnings("unchecked")
                                    LinkedList<Lugar> lugares = (LinkedList<Lugar>) session.getAttribute("lugares");
                                    for (Lugar lugar : lugares) {
                                %>
                                    <option value="<%= lugar.getIdlugar() %>"><%= lugar.getNombre_lugar() %></option>
                                <% } %>
                            </select>
                        </p>
                        <p><label>Fecha de realización:</label></p>
                        <p><input type="date" name="fecha_fiesta" required></p>
                        <p><label>Hora de realización:</label></p>
                        <p><input type="time" name="hora_fiesta" required></p>
                        <p><label>Precio de las entradas:</label></p>
                        <p><input type="number" name="precio_evento" required></p>
                        <button type="submit">Registrar</button>
                    </form>
                </div>
    <% 
            } else { // Usuario estándar
                response.sendRedirect("errorUsuario.jsp");
            }
        }
    %>
</body>
</html>
