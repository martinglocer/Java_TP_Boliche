package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import data.DataLugar;
import entities.Lugar;

@WebServlet(name = "SvEditarLugar", urlPatterns = "/SvEditarLugar")
public class SvEditarLugar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	DataLugar dl = new DataLugar();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_editar = Integer.parseInt(request.getParameter("idlugar_edit"));
		
		Lugar lug = dl.getById(id_editar);
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("lugEditar", lug);
		
		response.sendRedirect("editarLugar.jsp");
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
		
		
		Lugar lug = (Lugar) request.getSession().getAttribute("lugEditar");
		lug.setIdlugar(idlugar);
		lug.setNombre_lugar(nombre_lugar);
		lug.setDireccion(direccion);
		lug.setCapacidad(capacidad);
		lug.setCiudad(ciudad);
		
		
		dl.actualizarLugar(lug);
		
		response.sendRedirect("indexLugares");
		
		System.out.println("Nombre del lugar es: "+nombre_lugar);
		System.out.println("Dirección es: "+direccion);
		System.out.println("Capcidad es: "+capacidad);
		System.out.println("Ciudad es: "+ciudad);
	}

}
