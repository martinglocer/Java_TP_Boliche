package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import entities.Fiesta_lugar;
import data.DataFiesta_lugar;

import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "Sv_fiesta_lugar_disponibles_para_entradas", urlPatterns = {"/Sv_fiesta_lugar_disponibles_para_entradas"})
public class Sv_fiesta_lugar_disponibles_para_entradas extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Servlet Sv_fiesta_lugar_disponibles_para_entradas ejecutándose");
    	
        DataFiesta_lugar dataFiestaLugar = new DataFiesta_lugar();
        LinkedList<Fiesta_lugar> fiestasDisponibles = dataFiestaLugar.getDisponibles();
        
        HttpSession misesion = request.getSession();
		misesion.setAttribute("fiestasDisponibles", fiestasDisponibles);
        
		response.sendRedirect("registrarEntrada.jsp");
		
		/*
		 * request.setAttribute("fiestasDisponibles", fiestasDisponibles);
		 * request.getRequestDispatcher("registrarEntrada.jsp").forward(request,
		 * response);
		 */
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
