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
import data.DataFiesta_lugar;

@WebServlet(name = "RegistrarFiesta_lugar", urlPatterns = {"/RegistrarFiesta_lugar"})


public class RegistrarFiesta_lugar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataFiesta_lugar dfl = new DataFiesta_lugar();
		Fiesta f = new Fiesta();
		Lugar l = new Lugar();
		
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
		String precioStr = request.getParameter("precio_evento");
		double precio = Double.parseDouble(precioStr);
		
		Fiesta_lugar fl = new Fiesta_lugar(f, l, fecha_fiesta, hora_fiesta, precio );
		dfl.add(fl);
		
		System.out.println("Id de la fiesta es: "+ idfiesta);
		System.out.println("Id del lugar es: "+ idlugar);
		System.out.println("Fecha y hora es: "+ fecha_fiesta);
		System.out.println("Fecha y hora es: "+ hora_fiesta);
		
		response.sendRedirect("indexFiesta_lugar");

	}

}
