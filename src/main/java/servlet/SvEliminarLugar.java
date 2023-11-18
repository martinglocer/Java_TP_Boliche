package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import data.DataLugar;
import entities.Lugar;


@WebServlet(name = "SvEliminarLugar", urlPatterns = {"/SvEliminarLugar"})
public class SvEliminarLugar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DataLugar dl = new DataLugar();
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_lugar = Integer.parseInt(request.getParameter("idlugar"));
		Lugar l = new Lugar();
		l.setIdlugar(id_lugar);
		l = dl.getById(l);
		System.out.println(" id:" + l.getIdlugar() + " nombre: " + l.getNombre_lugar() );
		dl.deleteByID(l);
		
	}

}
