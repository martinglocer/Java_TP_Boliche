package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;
import entities.Asistente;
import entities.Fiesta_lugar;
import data.DataFiesta_lugar;

import java.util.LinkedList;
import java.util.Collections;

@WebServlet(name = "fiesta_lugar_disponibles", urlPatterns = {"/fiesta_lugar_disponibles"})

public class SvFiesta_lugar_disponibles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SvFiesta_lugar_disponibles() {
        super();
           }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataFiesta_lugar dfl = new DataFiesta_lugar();
		LinkedList<Fiesta_lugar> listaFiestas_lugares = dfl.getDisponibles();
		
		System.out.println(listaFiestas_lugares);
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("listaFiestas_lugares", listaFiestas_lugares);
		
		Asistente loggedInUser = (Asistente) misesion.getAttribute("user");
		if (1 == loggedInUser.getIdrol()) {
			response.sendRedirect("mostrarFiestas_lugares.jsp");
		} else {
			response.sendRedirect("mostrar_eventos_usuarios.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
