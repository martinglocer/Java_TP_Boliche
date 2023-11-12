package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;


import entities.Fiesta;
import data.DataFiesta;

@WebServlet(name = "RegistrarFiesta", urlPatterns = {"/RegistrarFiesta"})


public class RegistrarFiesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrarFiesta() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataFiesta df = new DataFiesta();
		
		String nombre_fiesta = request.getParameter("nombre_fiesta");
		String descripcion = request.getParameter("descripcion");
		
		Fiesta f = new Fiesta(nombre_fiesta, descripcion);
		df.add(f);
		
		//System.out.println("Id es: "+ idLugar);
		System.out.println("Nombre es: "+ nombre_fiesta);
		System.out.println("Descripcion es: "+ descripcion);

	}

}
