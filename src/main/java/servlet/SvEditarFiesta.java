package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import data.DataFiesta;
import entities.Fiesta;

@WebServlet(name = "SvEditarFiesta", urlPatterns = "/SvEditarFiesta")
public class SvEditarFiesta extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	DataFiesta df = new DataFiesta();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_editar = Integer.parseInt(request.getParameter("idfiesta_edit"));
		
		Fiesta fiesta = df.getById(id_editar);
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("fiestaEditar", fiesta);
		
		response.sendRedirect("editarFiesta.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataFiesta df = new DataFiesta();
		
	
		String idfiestaStr = request.getParameter("idfiesta");
		int idfiesta = Integer.parseInt(idfiestaStr);
		String nombre_fiesta = request.getParameter("nombre_fiesta");
		String descripcion = request.getParameter("descripcion");
		
		
		Fiesta fiesta = (Fiesta) request.getSession().getAttribute("fiestaEditar");
		fiesta.setIdfiesta(idfiesta);
		fiesta.setNombre_fiesta(nombre_fiesta);
		fiesta.setDescripcion(descripcion);
		
		
		df.actualizarFiesta(fiesta);
		
		response.sendRedirect("indexFiestas");
		
		System.out.println("Nombre de la fiesta es: "+nombre_fiesta);
		System.out.println("Descripción es: "+descripcion);
	
	}

}