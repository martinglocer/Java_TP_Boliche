package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import entities.Fiesta_lugar;
import entities.Fiesta;
import entities.Lugar;
import entities.Asistente;
import entities.Entrada;
import data.DataAsistente;
import data.DataEntrada;

@WebServlet(name = "RegistrarEntrada", urlPatterns = {"/RegistrarEntrada"})


public class RegistrarEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        // Verificar los parámetros de entrada
	        String id_asi = request.getParameter("id_user");
	        String fiestaSeleccionada = request.getParameter("evento");
	        
	        // Depuración de parámetros
	        System.out.println("DEBUG: ID Usuario recibido: " + id_asi);
	        System.out.println("DEBUG: Evento seleccionado: " + fiestaSeleccionada);
	        
	        if (id_asi == null || fiestaSeleccionada == null) {
	            System.out.println("ERROR: Parámetros nulos");
	            response.getWriter().write("Error: Parámetros incompletos");
	            return;
	        }

	        int id_asi_editar = Integer.parseInt(id_asi);
	        System.out.println("DEBUG: ID Usuario entero recibido: " + id_asi_editar);
	        
	        // Obtener el asistente
	        DataAsistente da = new DataAsistente();
	        Asistente asist = da.getById(id_asi_editar);
	        
	        if (asist == null) {
	            System.out.println("ERROR: Asistente no encontrado para ID: " + id_asi_editar);
	            response.getWriter().write("Error: Asistente no encontrado");
	            return;
	        }

	        // Parsear los detalles del evento
	        String[] fiestaDetails = fiestaSeleccionada.split("_");
	        
	        if (fiestaDetails.length < 4) {
	            System.out.println("ERROR: Formato de evento inválido");
	            response.getWriter().write("Error: Formato de evento inválido");
	            return;
	        }

	        // Depuración de detalles del evento
	        System.out.println("DEBUG: Detalles del evento:");
	        for (int i = 0; i < fiestaDetails.length; i++) {
	            System.out.println("  Índice " + i + ": " + fiestaDetails[i]);
	        }

	        int idfiesta = Integer.parseInt(fiestaDetails[0]);
	        int idlugar = Integer.parseInt(fiestaDetails[1]);
	        LocalDate fecha_fiesta = LocalDate.parse(fiestaDetails[2]);
	        LocalTime hora_fiesta = LocalTime.parse(fiestaDetails[3]);

	        Fiesta f = new Fiesta();
	        f.setIdfiesta(idfiesta);
	        
	        Lugar l = new Lugar();
	        l.setIdlugar(idlugar);

	        Fiesta_lugar fl = new Fiesta_lugar();
	        fl.setFiesta(f);
	        fl.setLugar(l);
	        fl.setFecha_fiesta(fecha_fiesta);
	        fl.setHora_fiesta(hora_fiesta);

	        LocalDate fecha_actual = LocalDate.now();
	        LocalTime horaActual = LocalTime.now();

	        Entrada ent = new Entrada(0, asist, fl, fecha_actual, horaActual);
	        
	        // Depuración de la entrada
	        System.out.println("DEBUG: Entrada a registrar:");
	        System.out.println("  Asistente ID: " + asist.getIdasistente());
	        System.out.println("  Fiesta ID: " + idfiesta);
	        System.out.println("  Lugar ID: " + idlugar);
	        System.out.println("  Fecha Fiesta: " + fecha_fiesta);
	        System.out.println("  Hora Fiesta: " + hora_fiesta);
	        System.out.println("  Fecha Compra: " + fecha_actual);
	        System.out.println("  Hora Compra: " + horaActual);

	        DataEntrada dent = new DataEntrada();
	        dent.add(ent);

	        // Redirigir al servlet de mis entradas
	        response.sendRedirect(request.getContextPath() + "/SvMisEntradas?id_user=" + asist.getIdasistente());
	        
	        /*
		     // Verificar si la solicitud viene de Stripe
		     String stripeToken = request.getParameter("stripeToken"); // O el parámetro que Stripe envía en la respuesta
		     if (stripeToken != null) {
		         // El pago fue exitoso, registrar la entrada en la base de datos
		         dent.add(ent);
	
		         // Redirigir al servlet SvMisEntradas con el ID del usuario
		         response.sendRedirect(request.getContextPath() + "/SvMisEntradas?id_user=" + asist.getIdasistente());
		     } else {
		         // Redirigir al usuario al formulario de pago
		         response.sendRedirect("pago.jsp"); 
		     }
		     */

	    } catch (Exception e) {
	        // Capturar y loggear cualquier excepción
	        System.out.println("ERROR COMPLETO:");
	        e.printStackTrace();
	        response.sendRedirect("error.jsp");
	    }
	}
}
