package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import entities.Fiesta;
import data.DataFiesta;
import entities.Lugar;
import data.DataLugar;

import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "Sv_fiestas_para_fiesta_lugar", urlPatterns = {"/Sv_fiestas_para_fiesta_lugar"})
public class Sv_fiestas_para_fiesta_lugar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Servlet Sv_fiesta_para_fiestas_lugar ejecutándose");
    	
        DataFiesta dataFiesta = new DataFiesta();
        LinkedList<Fiesta> fiestas = dataFiesta.getAll();
        
        DataLugar dataLugar = new DataLugar();
        LinkedList<Lugar> lugares = dataLugar.getAll();
        
        HttpSession misesion = request.getSession();
		misesion.setAttribute("fiestas", fiestas);
		misesion.setAttribute("lugares", lugares);
        
		request.getRequestDispatcher("registrarFiesta_lugar.jsp").forward(request, response);
		
	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
