<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.Asistente" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/estilo1.css">
    <meta charset="UTF-8">
    <title>Pago con Stripe</title>
    <script src="https://js.stripe.com/v3/"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
        .payment-container {
            max-width: 600px;
            margin: 40px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        #payment-element {
            margin: 20px 0;
        }

        #submit {
            background-color: #5469d4;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 12px 24px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            display: block;
            width: 100%;
            max-width: 300px;
            margin: 20px auto;
            transition: all 0.2s ease;
        }

        #submit:hover {
            background-color: #4456b3;
            transform: translateY(-1px);
        }

        #submit:disabled {
            opacity: 0.7;
            cursor: not-allowed;
        }

        .payment-message {
            color: #dc3545;
            text-align: center;
            margin-top: 10px;
            font-size: 14px;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
    <%
        Asistente loggedInUser = (Asistente) session.getAttribute("user");
        if (loggedInUser == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
     	// Capturar los parámetros
        String idFiesta = request.getParameter("id_fiesta");
        String idLugar = request.getParameter("id_lugar");
        String fechaEvento = request.getParameter("fecha_evento");
        String horaEvento = request.getParameter("hora_evento");
        
        // Validar que los parámetros existan
        if (idFiesta == null || idLugar == null || fechaEvento == null || horaEvento == null) {
            response.sendRedirect("comprar_entrada.jsp");
            return;
        }
        int isAdmin = (loggedInUser.getIdrol() == 1) ? 1 : 2;
        if (isAdmin == 1) { %>
            <%@ include file="menu_cabecera_admin.jsp" %>
        <% } else if (isAdmin == 2) { %>
            <%@ include file="menu_cabecera_usuario.jsp" %>
        <% }
    %>

    <div class="payment-container">
        <h1>Método de pago</h1>
        <input type="hidden" id="id_fiesta" value="<%= idFiesta %>">
	    <input type="hidden" id="id_lugar" value="<%= idLugar %>">
	    <input type="hidden" id="fecha_evento" value="<%= fechaEvento %>">
	    <input type="hidden" id="hora_evento" value="<%= horaEvento %>">
	    
	    <div id="payment-element"></div>

        <button id="submit">Pagar</button>
        <div id="payment-message" class="payment-message"></div>
    </div>

    <script>
        const stripe = Stripe('pk_test_51QNLtpAgf9Xw1p1yUbZNyW1xMSZ1RfuYsBKQnaKLcIL18kP9Yy13fmgQU8oj2kFkQiRJ7kmM8OoNl1kpox1pznS700WYWps3S0');

        let elements;
    
        var id_user = '<%= loggedInUser.getIdasistente() %>';
    
        
        initialize();

        async function initialize() {
            try {
                const response = await fetch('<%= request.getContextPath() %>/SvCreatePaymentIntent', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ amount: 1099 })
                });

                if (!response.ok) {
                    const errorText = await response.text();
                    console.error('Payment Intent Error:', errorText);
                    throw new Error(errorText);
                }

                const data = await response.json();
                
                const appearance = {
                    theme: 'stripe',
                    variables: {
                        colorPrimary: '#5469d4',
                    }
                };
                
                elements = stripe.elements({ 
                    appearance,
                    clientSecret: data.clientSecret
                });

                const paymentElement = elements.create('payment');
                paymentElement.mount('#payment-element');
            } catch (error) {
                console.error('Full Error:', error);
                showMessage(`Error al crear el pago: ${error.message}`);
            }
        }

        document.getElementById('submit').addEventListener('click', async (e) => {
            e.preventDefault();
            const button = e.target;
            button.disabled = true;

            try {
                const { error, paymentIntent } = await stripe.confirmPayment({
                    elements,
                    redirect: 'if_required'
                });

                if (error) {
                    console.error('Payment Error:', error);
                    showMessage(error.message);
                    button.disabled = false;
                    return;
                } else if (paymentIntent.status === 'succeeded') {
                	const id_user: '<%= loggedInUser.getIdasistente()%>';
                	const id_fiesta = document.getElementById('id_fiesta').value;
                    const id_lugar = document.getElementById('id_lugar').value;
                    const fecha_evento = document.getElementById('fecha_evento').value;
                    const hora_evento = document.getElementById('hora_evento').value;
                	
                    const eventData = {
                            id_user: '<%= loggedInUser.getIdasistente() %>',
                            id_fiesta: document.getElementById('id_fiesta').value,
                            id_lugar: document.getElementById('id_lugar').value,
                            fecha_evento: document.getElementById('fecha_evento').value,
                            hora_evento: document.getElementById('hora_evento').value                    
                    };

                    // Mostrar datos en la consola para ver si son correctos
                    //console.log('Datos del evento:', eventData);

                    const response = await fetch('<%= request.getContextPath() %>/RegistrarEntrada', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        body: new URLSearchParams({
                            id_user: eventData.id_user,
                            idfiesta: eventData.id_fiesta,
                            idlugar: eventData.id_lugar,
                            fecha: eventData.fecha_evento,
                            hora: eventData.hora_event
                        })
                    });
                    
                    if (!response.ok) {
                        throw new Error('Error al registrar la entrada');
                    }
                    
                    Swal.fire({
                        icon: 'success',
                        title: '¡Pago exitoso!',
                        text: 'Tu entrada ha sido registrada correctamente.',
                        confirmButtonText: 'OK',
                        confirmButtonColor: '#4CAF50'
                    }).then(() => {
                        window.location.href = '<%= request.getContextPath() %>/SvMisEntradas?id_user=' + eventData.id_user;
                    });
                }
            } catch (err) {
                console.error('Comprehensive Error:', err);

                Swal.fire({
                    icon: 'error',
                    title: 'Error de pago',
                    text: 'No se pudo procesar el pago. Por favor, intenta de nuevo.',
                    confirmButtonText: 'OK'
                });

                button.disabled = false;
            }
        });


        function showMessage(message) {
            const messageElement = document.getElementById('payment-message');
            messageElement.textContent = message;
            setTimeout(() => {
                messageElement.textContent = '';
            }, 7000);
        }
    </script>
</body>
</html>
