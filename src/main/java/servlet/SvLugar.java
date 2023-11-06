package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entities.Lugar;

public class SvLugar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Lugar l = new Lugar();
		
		String nombre_lugar = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String capacidad = request.getParameter("capacidad");
		
		response.getWriter().append("Registrado: ").append(l.getNombre_lugar()).append(" ").append(l.getDireccion());
		
	}

}
