package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedList;

import entities.Lugar;

import data.DataLugar;

@WebServlet(name = "indexLugares", urlPatterns = {"/indexLugares"})

public class SvLugar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataLugar dl = new DataLugar();
		
		LinkedList<Lugar> lugares = dl.getAll();
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("listaLugares", lugares);
		
		response.sendRedirect("mostrarLugares.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
