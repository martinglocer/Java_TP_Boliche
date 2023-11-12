package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;


import entities.Lugar;
import data.DataLugar;

@WebServlet(name = "ActualizarLugar", urlPatterns = {"/actualizarLugar"})
public class ActualizarLugar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ActualizarLugar() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataLugar dl = new DataLugar();
		
		String idlugarStr = request.getParameter("idlugar");
		int idlugar = Integer.parseInt(idlugarStr);
		String nombre_lugar = request.getParameter("nombre_lugar");
		String direccion = request.getParameter("direccion");
		String capacidadStr = request.getParameter("capacidad");
		int capacidad = Integer.parseInt(capacidadStr);
		String ciudad = request.getParameter("ciudad");
		
		
		Lugar l = new Lugar(idlugar, nombre_lugar, direccion, capacidad, ciudad);
		dl.actualizarLugar(l);
		
		System.out.println("Nombre del lugar es: "+nombre_lugar);
		System.out.println("Dirección es: "+direccion);
		System.out.println("Capcidad es: "+capacidad);
		System.out.println("Ciudad es: "+ciudad);

	}

}
