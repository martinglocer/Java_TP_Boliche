<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente, entities.Fiesta_lugar, java.util.LinkedList" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo2.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo_cards.css">
    <meta charset="UTF-8">
    <title>Comprar entrada</title>
    <style>
        /* ... (mantener los estilos existentes) ... */
    </style>
</head>
<body>
    <%
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
        <form id="purchase-form" action="pago.jsp" method="post">

            <input type="hidden" name="id_user" value="<%=loggedInUser.getIdasistente()%>">
            <!-- Campos ocultos para los detalles del evento -->
		    <input type="hidden" name="id_fiesta" id="id_fiesta">
		    <input type="hidden" name="id_lugar" id="id_lugar">
		    <input type="hidden" name="fecha_evento" id="fecha_evento">
		    <input type="hidden" name="hora_evento" id="hora_evento">
            
            
            <div id="fiestas">
                <%
                    LinkedList<Fiesta_lugar> eventos = (LinkedList<Fiesta_lugar>) session.getAttribute("fiestasDisponibles");
                    if (eventos != null && !eventos.isEmpty()) {
                        for (Fiesta_lugar evento : eventos) {
                %>
                <div class="card">
                    <input type="radio" name="evento" 
                           value="<%= evento.getFiesta().getIdfiesta() %>_<%= evento.getLugar().getIdlugar() %>_<%= evento.getFecha_fiesta() %>_<%= evento.getHora_fiesta() %>_<%= evento.getPrecio() %>"
                           data-precio="<%= evento.getPrecio() %>">
                    <div class="precio">$<%= String.format("%.2f", evento.getPrecio()) %></div>
                    <div class="detalles-evento">
                        <p><strong>Fiesta:</strong> <%= evento.getFiesta().getNombre_fiesta() %></p>
                        <p><strong>Lugar:</strong> <%= evento.getLugar().getNombre_lugar() %></p>
                        <p><strong>Fecha:</strong> <%= evento.getFecha_fiesta() %></p>
                        <p><strong>Hora:</strong> <%= evento.getHora_fiesta() %></p>
                    </div>
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
            
            <div id="error-message" class="error-message"></div>
            <div id="success-message" class="success-message"></div>
            
            <button type="submit" id="payment-button" class="payment-button" disabled>
                Comprar Entrada
            </button>
        </form>
    </div>

    <script>
    	
    document.addEventListener('DOMContentLoaded', () => {
        const form = document.getElementById('purchase-form');
        const errorDiv = document.getElementById('error-message');
        const submitButton = document.getElementById('payment-button');

        // Habilitar botón al seleccionar evento
        document.querySelectorAll('input[name="evento"]').forEach(radio => {
            radio.addEventListener('change', () => {
                const [idFiesta, idLugar, fechaEvento, horaEvento] = radio.value.split('_');
                document.getElementById('id_fiesta').value = idFiesta;
                document.getElementById('id_lugar').value = idLugar;
                document.getElementById('fecha_evento').value = fechaEvento;
                document.getElementById('hora_evento').value = horaEvento;

                submitButton.disabled = false;
                errorDiv.style.display = 'none';
            });
        });

        // Validación del formulario
        form.addEventListener('submit', (e) => {
            const selectedEvent = document.querySelector('input[name="evento"]:checked');
            if (!selectedEvent) {
                e.preventDefault();
                showError('Por favor seleccione un evento.');
            }
        });
        
        
    });


        
    </script>
    <% } %>
</body>
</html>