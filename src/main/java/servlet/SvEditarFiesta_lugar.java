package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import data.DataFiesta_lugar;
import entities.Fiesta_lugar;
import entities.Fiesta;
import entities.Lugar;

@WebServlet(name = "SvEditarFiesta_lugar", urlPatterns = "/SvEditarFiesta_lugar")
public class SvEditarFiesta_lugar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	DataFiesta_lugar dfl = new DataFiesta_lugar();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtener parámetros de la solicitud
	    int idFiesta = Integer.parseInt(request.getParameter("idfiesta_edit"));
	    int idLugar = Integer.parseInt(request.getParameter("idlugar_edit"));
	    String fechaStr = request.getParameter("fecha_edit");
	    String horaStr = request.getParameter("hora_edit");

	    // Parsear fecha y hora
	    LocalDate fecha = LocalDate.parse(fechaStr);
	    LocalTime hora = LocalTime.parse(horaStr);

	    // Crear objetos Fiesta, Lugar y Fiesta_lugar
	    Fiesta f = new Fiesta();
	    f.setIdfiesta(idFiesta);

	    Lugar l = new Lugar();
	    l.setIdlugar(idLugar);

	    Fiesta_lugar fl = new Fiesta_lugar(f, l, fecha, hora);

	    // Obtener Fiesta_lugar completo desde DataFiesta_lugar
	    Fiesta_lugar fiestaLugar = dfl.getOne(fl);

	    // Verificar que fiestaLugar no sea null antes de continuar
	    if (fiestaLugar == null) {
	        request.setAttribute("error", "No se encontraron los datos necesarios.");
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	        return;
	    }

	    // Establecer atributos en la sesión
	    HttpSession session = request.getSession();
	    session.setAttribute("fiesta_lugarEditar", fiestaLugar);
	    session.setAttribute("f", fiestaLugar.getFiesta());
	    session.setAttribute("l", fiestaLugar.getLugar());
	    session.setAttribute("fl", fiestaLugar);

	    // Redirigir a editarFiesta_lugar.jsp
	    response.sendRedirect("editarFiesta_lugar.jsp");
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
		
		String fecha_fiesta_vStr = request.getParameter("fecha_fiesta_vieja");
		LocalDate fecha_fiesta_vieja = LocalDate.parse(fecha_fiesta_vStr);
		String hora_fiesta_vStr = request.getParameter("hora_fiesta_vieja");
		LocalTime hora_fiesta_vieja = LocalTime.parse(hora_fiesta_vStr);
		
		String fecha_fiesta_nStr = request.getParameter("fecha_fiesta_nueva");
		LocalDate fecha_fiesta_nueva = LocalDate.parse(fecha_fiesta_nStr);
		String hora_fiesta_nStr = request.getParameter("hora_fiesta_nueva");
		LocalTime hora_fiesta_nueva = LocalTime.parse(hora_fiesta_nStr);
		
		
		Fiesta_lugar fiesta_lugar = new Fiesta_lugar(f, l, fecha_fiesta_vieja, hora_fiesta_vieja);
		
		dfl.actualizarFiesta_lugar(fiesta_lugar, fecha_fiesta_nueva, hora_fiesta_nueva);
		
		response.sendRedirect("indexFiesta_lugar");
		
		System.out.println("Id de la fiesta es: "+idfiesta);
		System.out.println("Id del lugar es: "+idlugar);
		System.out.println("Fecha nueva es: "+fecha_fiesta_nueva);
		System.out.println("Hora nueva es: "+hora_fiesta_nueva);
	
	}

}