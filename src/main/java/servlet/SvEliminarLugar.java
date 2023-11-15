package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import data.DataLugar;


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
		dl.deleteByID(id_lugar);
		
	}

}
