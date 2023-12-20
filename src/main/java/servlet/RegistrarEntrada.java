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
import data.DataEntrada;

@WebServlet(name = "RegistrarEntrada", urlPatterns = {"/RegistrarEntrada"})


public class RegistrarEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataEntrada dent = new DataEntrada();
		Fiesta f = new Fiesta();
		Lugar l = new Lugar();
		Asistente asis = new Asistente();
		
		String tipo_doc = request.getParameter("tipo_doc");
		
		String nro_docStr = request.getParameter("nro_doc");
		int nro_doc = Integer.parseInt(nro_docStr);
		
		asis.setTipo_doc(tipo_doc);
		asis.setNro_doc(nro_doc);
		
		
		String idfiestaStr = request.getParameter("idfiesta");
		int idfiesta = Integer.parseInt(idfiestaStr);
		f.setIdfiesta(idfiesta);
		
		String idlugarStr = request.getParameter("idlugar");
		int idlugar = Integer.parseInt(idlugarStr);
		l.setIdlugar(idlugar);
		
		String fecha_fiestaStr = request.getParameter("fecha_fiesta");
		LocalDate fecha_fiesta = LocalDate.parse(fecha_fiestaStr);
		String hora_fiestaStr = request.getParameter("hora_fiesta");
		LocalTime hora_fiesta = LocalTime.parse(hora_fiestaStr);
		
		Fiesta_lugar fl = new Fiesta_lugar(f, l, fecha_fiesta, hora_fiesta );
		
		
		int identrada = 0;
		LocalDate fecha_actual = LocalDate.now();
		
		LocalTime horaActual = LocalTime.now();
        
        // Formatear la hora actual en el formato "hh:mm:ss"
        //String hora_actual = horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        
		Entrada ent = new Entrada(identrada, asis, fl, fecha_actual, horaActual);
		
		System.out.println("Id de la entrada es: "+ identrada);
		System.out.println("Tipo de documento es: "+ tipo_doc);
		System.out.println("Número de documento es: "+ nro_doc);
		System.out.println("Id fiesta es: "+ idfiesta);
		System.out.println("Id lugar es: "+ idlugar);
		System.out.println("Fecha de la fiesta es: "+ fecha_fiesta);
		System.out.println("Hora de la fiesta es: "+ hora_fiesta);
		System.out.println("Fecha de la compra es: "+ fecha_actual);
		System.out.println("Hora de la fiesta es: "+ horaActual);
		
		
		response.sendRedirect("indexEntrada");

	}

}
