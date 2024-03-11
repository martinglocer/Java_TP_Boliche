package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import data.DataEntrada;
import entities.Entrada;
import entities.Fiesta;
import entities.Lugar;

@WebServlet(name = "SvEditarEntrada", urlPatterns = "/SvEditarEntrada")
public class SvEditarEntrada extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	DataEntrada den = new DataEntrada();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Entrada ent = new Entrada();
		
		int id_editar = Integer.parseInt(request.getParameter("identrada_edit"));
		ent.setIdentrada(id_editar);
		
		System.out.println(id_editar);
		
		//Entrada entrada = den.getById(id_editar);
		 Entrada entrada = den.getOne(ent);
		
		System.out.println(entrada); 
		 
		HttpSession misesion = request.getSession();
		misesion.setAttribute("entradaEditar", entrada);
		
		response.sendRedirect("editarEntrada.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataEntrada den = new DataEntrada();
		
		Fiesta f = new Fiesta();
		Lugar l = new Lugar();
		
		String idfiestaStr = request.getParameter("idfiesta");
		int idfiesta = Integer.parseInt(idfiestaStr);
		f.setIdfiesta(idfiesta);
		String idlugarStr = request.getParameter("idlugar");
		int idlugar = Integer.parseInt(idlugarStr);
		l.setIdlugar(idlugar);
		
		String fecha_fiesta_vStr = request.getParameter("fecha_fiesta_vieja");
		LocalDate fecha_fiesta_vieja = LocalDate.parse(fecha_fiesta_vStr);
		String hora_fiesta_vStr = request.getParameter("hora_fiesta_vieja");
		LocalTime hora_fiesta_vieja = LocalTime.parse(hora_fiesta_vStr);
		
		String fecha_fiesta_nStr = request.getParameter("fecha_fiesta_nueva");
		LocalDate fecha_fiesta_nueva = LocalDate.parse(fecha_fiesta_nStr);
		String hora_fiesta_nStr = request.getParameter("hora_fiesta_nueva");
		LocalTime hora_fiesta_nueva = LocalTime.parse(hora_fiesta_nStr);
		
		/*
		
		Fiesta_lugar fiesta_lugar = new Fiesta_lugar(f, l, fecha_fiesta_vieja, hora_fiesta_vieja);
		
		dfl.actualizarFiesta_lugar(fiesta_lugar, fecha_fiesta_nueva, hora_fiesta_nueva);
		
		response.sendRedirect("indexFiesta_lugar");
		
		System.out.println("Id de la fiesta es: "+idfiesta);
		System.out.println("Id del lugar es: "+idlugar);
		System.out.println("Fecha nueva es: "+fecha_fiesta_nueva);
		System.out.println("Hora nueva es: "+hora_fiesta_nueva);
		
		*/
	
	}

}