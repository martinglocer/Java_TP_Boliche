package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import data.DataFiesta;
import entities.Fiesta;


@WebServlet(name = "SvEliminarFiesta", urlPatterns = {"/SvEliminarFiesta"})
public class SvEliminarFiesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DataFiesta df = new DataFiesta();
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id_fiesta = Integer.parseInt(request.getParameter("idfiesta"));
		System.out.println(id_fiesta);
		Fiesta f = new Fiesta(0,null,null);
		f = df.getById(id_fiesta);
		System.out.println(" id:" + f.getIdfiesta() + " nombre: " + f.getNombre_fiesta() );
		df.deleteByID(f);
		response.sendRedirect("indexFiestas");
		
	}

}
