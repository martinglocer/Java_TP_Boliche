package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

import entities.Lugar;

import data.DataLugar;

public class SvLugar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataLugar dl = new DataLugar();
		
		LinkedList<Lugar> lugares = dl.getAll();
		
		request.getSession().setAttribute("listaLugares",lugares);
		
		request.getRequestDispatcher("webapp/mostrarLugares.jsp").forward(request, response);
		
		
		
		//response.getWriter().append("Registrado: ").append(l.getNombre_lugar()).append(" ").append(l.getDireccion());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Lugar l = new Lugar();
		DataLugar dl = new DataLugar();
		
		String nombre_lugar = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String capacidad = request.getParameter("capacidad");
		String ciudad = request.getParameter("ciudad");
		
		dl.add(l);
		
		//response.getWriter().append("Registrado: ").append(l.getNombre_lugar()).append(" ").append(l.getDireccion());
		
	}

}
