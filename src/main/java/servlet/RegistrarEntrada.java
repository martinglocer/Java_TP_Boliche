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
	        String idFiestaStr = request.getParameter("id_fiesta");
	        String idLugarStr = request.getParameter("id_lugar");
	        String fechaStr = request.getParameter("fecha_evento");
	        String horaStr = request.getParameter("hora_evento");

            // Depuración de parámetros
            System.out.println("DEBUG: ID Usuario recibido: " + id_asi);
            System.out.println("DEBUG: ID Fiesta recibido: " + idFiestaStr);
            System.out.println("DEBUG: ID Lugar recibido: " + idLugarStr);
            System.out.println("DEBUG: Fecha recibida: " + fechaStr);
            System.out.println("DEBUG: Hora recibida: " + horaStr);
	        
            if (id_asi == null || idFiestaStr == null || idLugarStr == null || fechaStr == null || horaStr == null) {
	            System.out.println("ERROR: Parámetros nulos");
	            response.getWriter().write("Error: Parámetros incompletos");
	            return;
	        }

            int idAsistente = Integer.parseInt(id_asi);
            int idFiesta = Integer.parseInt(idFiestaStr);
            int idLugar = Integer.parseInt(idLugarStr);
            LocalDate fechaFiesta = LocalDate.parse(fechaStr);
            LocalTime horaFiesta = LocalTime.parse(horaStr);
	        System.out.println("DEBUG: ID Usuario entero recibido: " + idAsistente);
	        
	        // Obtener el asistente
	        DataAsistente da = new DataAsistente();
	        Asistente asist = da.getById(idAsistente);
	        
	        if (asist == null) {
	            System.out.println("ERROR: Asistente no encontrado para ID: " + idAsistente);
	            response.getWriter().write("Error: Asistente no encontrado");
	            return;
	        }

	        // Configurar las entidades Fiesta, Lugar y Fiesta_lugar
	        Fiesta f = new Fiesta();
	        f.setIdfiesta(idFiesta);

	        Lugar l = new Lugar();
	        l.setIdlugar(idLugar);

	        Fiesta_lugar fl = new Fiesta_lugar();
	        fl.setFiesta(f);
	        fl.setLugar(l);
	        fl.setFecha_fiesta(fechaFiesta);
	        fl.setHora_fiesta(horaFiesta);

	        // Crear y registrar la entrada
	        LocalDate fechaActual = LocalDate.now();
	        LocalTime horaActual = LocalTime.now();
	        
	       
	        Entrada ent = new Entrada(0, asist, fl, fechaActual, horaActual);
	        
	        // Depuración de la entrada
	        System.out.println("DEBUG: Entrada a registrar:");
	        System.out.println("  Asistente ID: " + asist.getIdasistente());
	        System.out.println("  Fiesta ID: " + idFiesta);
	        System.out.println("  Lugar ID: " + idLugar);
	        System.out.println("  Fecha Fiesta: " + fechaFiesta);
	        System.out.println("  Hora Fiesta: " + horaFiesta);
	        System.out.println("  Fecha Compra: " + fechaActual);
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
