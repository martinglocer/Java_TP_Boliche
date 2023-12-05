package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import data.DataFiesta_lugar;
import entities.Fiesta_lugar;

@WebServlet(name = "SvEditarFiesta_lugar", urlPatterns = "/SvEditarFiesta_lugar")
public class SvEditarFiesta_lugar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	DataFiesta_lugar dfl = new DataFiesta_lugar();

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_editar1 = Integer.parseInt(request.getParameter("idfiesta_edit"));
		int id_editar2 = Integer.parseInt(request.getParameter("idlugar_edit"));
		
		String fecha_hora_fiestaStr = request.getParameter("fecha_edit");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime fecha_hora_fiesta = LocalDateTime.parse(fecha_hora_fiestaStr, formatter);		
		
		
		Fiesta_lugar fiesta_lugar = dfl.getByData(id_editar1, id_editar2, fecha_hora_fiesta);
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("fiesta_lugarEditar", fiesta_lugar);
		
		response.sendRedirect("editarFiesta_lugar.jsp");
	}*/

	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataFiesta_lugar dfl = new DataFiesta_lugar();
		
	
		String idfiestaStr = request.getParameter("idfiesta");
		int idfiesta = Integer.parseInt(idfiestaStr);
		String idlugarStr = request.getParameter("idlugar");
		int idlugar = Integer.parseInt(idlugarStr);
		
		String fecha_hora_fiestaStr = request.getParameter("fecha_hora");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime fecha_hora_fiesta = LocalDateTime.parse(fecha_hora_fiestaStr, formatter);		
		
		
		Fiesta_lugar fiesta_lugar = (Fiesta_lugar) request.getSession().getAttribute("fiesta_lugarEditar");
		fiesta_lugar.setIdfiesta(idfiesta);
		fiesta_lugar.setIdlugar(idlugar);
		fiesta_lugar.setFecha_hora_fiesta(fecha_hora_fiesta);
		
		
		dfl.actualizarFiesta_lugar(fiesta_lugar);
		
		response.sendRedirect("indexFiesta_lugar");
		
		System.out.println("Id de la fiesta es: "+idfiesta);
		System.out.println("Id del lugar es: "+idlugar);
		System.out.println("Fecha es: "+fecha_hora_fiesta);
	
	}*/

}