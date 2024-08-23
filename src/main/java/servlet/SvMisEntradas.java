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
		Asistente a = new Asistente();
		DataAsistente da = new DataAsistente();
		String id_asi = request.getParameter("id_user");
		int id_asi_editar = Integer.parseInt(id_asi);
		a = da.getById(id_asi_editar);
		DataEntrada de = new DataEntrada();
		
		LinkedList<Entrada> listaEntradas = de.getByUser(a);
		System.out.println(listaEntradas.size());
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("listaEntradas", listaEntradas);
		
		response.sendRedirect("misEntradas.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}