package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import data.DataFiesta_lugar;
import entities.Fiesta_lugar;


@WebServlet(name = "SvEliminarFiesta_lugar", urlPatterns = {"/SvEliminarFiesta_lugar"})
public class SvEliminarFiesta_lugar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DataFiesta_lugar dfl = new DataFiesta_lugar();
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/*@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_fiesta = Integer.parseInt(request.getParameter("idfiesta_elim"));
		int id_lugar = Integer.parseInt(request.getParameter("idfiesta_elim"));
		String fecha_hora_fiestaStr = request.getParameter("fecha_elim");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime fecha_hora_fiesta = LocalDateTime.parse(fecha_hora_fiestaStr, formatter);		
		
		System.out.println(id_fiesta);
		System.out.println(id_lugar);
		System.out.println(fecha_hora_fiesta);
		
		Fiesta_lugar fl = new Fiesta_lugar(0,0,null);
		fl = dfl.getByData(id_fiesta, id_lugar, fecha_hora_fiesta);
		System.out.println(" id fiesta:" + fl.getIdfiesta() + " id lugar: " + fl.getIdlugar() + " fecha: " + fl.getFecha_hora_fiesta() );
		dfl.deleteByIDs(fl);
		response.sendRedirect("indexFiesta_lugar");
		
	}*/

}
