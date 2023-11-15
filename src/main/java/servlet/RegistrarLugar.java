package servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import data.DataLugar;
import entities.Lugar;


public class RegistrarLugar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataLugar dl = new DataLugar();
		
		int idLugar = 0;
		String nombre_lugar = request.getParameter("nombre_lugar");
		String direccion = request.getParameter("direccion");
		String capacidadStr = request.getParameter("capacidad"); 
		int capacidad = Integer.parseInt(capacidadStr);
		String ciudad = request.getParameter("ciudad");
		
		Lugar l = new Lugar(idLugar, nombre_lugar, direccion, capacidad, ciudad);
		dl.add(l);
		
		response.getWriter().append("Registrado: ").append(l.getNombre_lugar()).append(" ").append(l.getDireccion());
		
		System.out.println("Nombre es: "+nombre_lugar);
		System.out.println("Direccion es: "+direccion);
		System.out.println("Capacidad es: "+capacidad);
		System.out.println("Ciudad es: "+ciudad);
	
		
	}

}
