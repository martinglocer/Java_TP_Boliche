package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;
import entities.Asistente;
import entities.Entrada;
import entities.Fiesta;
import entities.Fiesta_lugar;
import entities.Lugar;
import data.DataEntrada;

import java.util.LinkedList;
import java.util.Collections;

@WebServlet(name = "indexEntrada", urlPatterns = {"/indexEntrada"})


public class SvEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SvEntrada() {
        super();       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DataEntrada de = new DataEntrada();
		LinkedList<Entrada> listaEntradas = de.getAll();
		System.out.println(listaEntradas.size());
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("listaEntradas", listaEntradas);
		
		response.sendRedirect("mostrarEntradas.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
