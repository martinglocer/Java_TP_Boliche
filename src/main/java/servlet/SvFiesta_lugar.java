package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;

import entities.Fiesta_lugar;
import data.DataFiesta_lugar;

import java.util.LinkedList;
import java.util.Collections;

@WebServlet(name = "indexFiesta_lugar", urlPatterns = {"/indexFiesta_lugar"})


public class SvFiesta_lugar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SvFiesta_lugar() {
        super();       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DataFiesta_lugar dfl = new DataFiesta_lugar();
		LinkedList<Fiesta_lugar> listaFiestas_lugares = dfl.getAll();
		
		System.out.println(listaFiestas_lugares);
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("listaFiestas_lugares", listaFiestas_lugares);
		
		response.sendRedirect("mostrarFiestas_lugares.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
