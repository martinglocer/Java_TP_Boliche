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
import data.DataFiesta_lugar;
import entities.Entrada;
import entities.Fiesta;
import entities.Fiesta_lugar;
import entities.Lugar;
import entities.Asistente;

@WebServlet(name = "SvEditarEntrada", urlPatterns = "/SvEditarEntrada")
public class SvEditarEntrada extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	DataEntrada den = new DataEntrada();
	DataFiesta_lugar dfl = new DataFiesta_lugar();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Entrada ent = new Entrada();
		
		int id_editar = Integer.parseInt(request.getParameter("identrada_edit"));
		ent.setIdentrada(id_editar);
		
		System.out.println(id_editar);
		
		//Entrada entrada = den.getById(id_editar);
		Entrada entrada = den.getOne(ent);
		 
		
		 
		/*
		Fiesta_lugar fiesta_lug = ent.getFiesta_lugar();
		Fiesta_lugar fiesta_lugar = dfl.getOne(fiesta_lug);
		
		System.out.println(fiesta_lugar);
		
		entrada.setFiesta_lugar(fiesta_lugar);
		*/
		 
		HttpSession misesion = request.getSession();
		misesion.setAttribute("entradaEditar", entrada);
		
		response.sendRedirect("editarEntrada.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataEntrada den = new DataEntrada();
		
		Fiesta_lugar fl = new Fiesta_lugar();
		Fiesta f = new Fiesta();
		Lugar l = new Lugar();
		Asistente asis = new Asistente();
		
		String identrada_Str = request.getParameter("identrada");
		int identrada = Integer.parseInt(identrada_Str);
		
		String tipo_doc = request.getParameter("tipo_doc");
		String nro_doc_Str = request.getParameter("nro_doc");
		int nro_doc = Integer.parseInt(nro_doc_Str);
		asis.setTipo_doc(tipo_doc);
		asis.setNro_doc(nro_doc);
		
		String idfiestaStr = request.getParameter("id_fiesta");
		int idfiesta = Integer.parseInt(idfiestaStr);
		f.setIdfiesta(idfiesta);
		String idlugarStr = request.getParameter("id_lugar");
		int idlugar = Integer.parseInt(idlugarStr);
		l.setIdlugar(idlugar);
		
		String fecha_fiesta_Str = request.getParameter("fecha_fiesta");
		LocalDate fecha_fiesta = LocalDate.parse(fecha_fiesta_Str);
		String hora_fiesta_Str = request.getParameter("hora_fiesta");
		LocalTime hora_fiesta = LocalTime.parse(hora_fiesta_Str);
		
		
		String fecha_compra_vStr = request.getParameter("fecha_compra_vieja");
		LocalDate fecha_compra_vieja = LocalDate.parse(fecha_compra_vStr);
		String hora_compra_vStr = request.getParameter("hora_compra_vieja");
		LocalTime hora_compra_vieja = LocalTime.parse(hora_compra_vStr);
		
		String fecha_compra_nStr = request.getParameter("fecha_compra_nueva");
		LocalDate fecha_compra_nueva = LocalDate.parse(fecha_compra_nStr);
		String hora_compra_nStr = request.getParameter("hora_compra_nueva");
		LocalTime hora_compra_nueva = LocalTime.parse(hora_compra_nStr);
		
		fl.setFiesta(f);
		fl.setLugar(l);
		fl.setFecha_fiesta(fecha_fiesta);
		fl.setHora_fiesta(hora_fiesta);
		
		Entrada entrada = new Entrada(identrada, asis, fl, fecha_compra_vieja, hora_compra_vieja);
		
		den.actualizarEntrada(entrada, fecha_compra_nueva, hora_compra_nueva);
		
		response.sendRedirect("indexEntrada");
		
	
	}

}