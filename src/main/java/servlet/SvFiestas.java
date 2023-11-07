package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;

import entities.Fiesta;
import data.DataFiesta;

import java.util.LinkedList;
import java.util.Collections;

@WebServlet(name = "indexFiestas", urlPatterns = {"/indexFiestas"})

/**
 * Servlet implementation class SvUsuarios
 */
public class SvFiestas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SvFiestas() {
        super();       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DataFiesta df = new DataFiesta();
		LinkedList<Fiesta> listaFiestas = df.getAll();
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("listaFiestas", listaFiestas);
		
		response.sendRedirect("mostrarFiestas.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
