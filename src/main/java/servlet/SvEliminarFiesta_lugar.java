package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import data.DataFiesta_lugar;
import entities.Fiesta_lugar;


@WebServlet(name = "SvEliminarFiesta_lugar", urlPatterns = {"/SvEliminarFiesta_lugar"})
public class SvEliminarFiesta_lugar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DataFiesta_lugar dfl = new DataFiesta_lugar();
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String message = null;
    	
		int id_fiesta = Integer.parseInt(request.getParameter("idfiesta_elim"));
		int id_lugar = Integer.parseInt(request.getParameter("idlugar_elim"));
		String fecha_fiestaStr = request.getParameter("fecha_fiesta_elim");
		String hora_fiestaStr = request.getParameter("hora_fiesta_elim"); 
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm"); 
		LocalDate fecha_fiesta = LocalDate.parse(fecha_fiestaStr, dateFormatter); 
		LocalTime hora_fiesta = LocalTime.parse(hora_fiestaStr, timeFormatter); 
		
		System.out.println(id_fiesta);
		System.out.println(id_lugar);
		System.out.println(fecha_fiesta);
		System.out.println(hora_fiesta);
		
		Fiesta_lugar fl = new Fiesta_lugar();
		fl = dfl.getByData(id_fiesta, id_lugar, fecha_fiesta, hora_fiesta);
		System.out.println(" fiesta:" + fl.getFiesta() + " lugar: " + fl.getLugar() + " fecha: " + fl.getFecha_fiesta() + " hora: " + fl.getHora_fiesta() );
		message = dfl.deleteByIDs(fl);
		System.out.println(message);
		response.sendRedirect("indexFiesta_lugar");
		
	}

}
