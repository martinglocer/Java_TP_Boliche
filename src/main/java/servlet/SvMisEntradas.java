package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

import entities.Asistente;
import entities.Entrada;
import data.DataAsistente; 
import data.DataEntrada; 
//import logic.Login;

@WebServlet(name = "SvMisEntradas", urlPatterns = "/SvMisEntradas")

public class SvMisEntradas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public SvMisEntradas() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_asi = request.getParameter("id_user");
        
        if (id_asi == null || id_asi.isEmpty()) {
            response.getWriter().write("Error: El parámetro id_user no fue proporcionado o está vacío.");
            return;
        }

        try {
            int id_asi_editar = Integer.parseInt(id_asi);

            DataAsistente da = new DataAsistente();
            Asistente a = da.getById(id_asi_editar);

            DataEntrada de = new DataEntrada();
            LinkedList<Entrada> listaEntradas = de.getByUser(a);

            HttpSession misesion = request.getSession();
            misesion.setAttribute("listaEntradas", listaEntradas);

            response.sendRedirect("misEntradas.jsp");
        } catch (NumberFormatException e) {
            response.getWriter().write("Error: El parámetro id_user debe ser un número válido.");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAsi = request.getParameter("id_user");
	    
	    if (idAsi == null || idAsi.isEmpty()) {
	        // El atributo no fue enviado o está vacío
	        response.getWriter().write("Error: id_user es null o vacío.");
	        return;
	    }

	    // Conversión de String a Integer si es necesario
	    int idAsistente = Integer.parseInt(idAsi);

		
		
	}

}