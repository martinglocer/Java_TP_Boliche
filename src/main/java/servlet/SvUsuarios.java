package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;

import entities.Asistente;
import logic.Login;

import java.util.LinkedList;
import java.util.Collections;

@WebServlet(name = "indexUsuarios", urlPatterns = {"/indexUsuarios"})

/**
 * Servlet implementation class SvUsuarios
 */
public class SvUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SvUsuarios() {
        super();       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Login log = new Login();
		
		LinkedList <Asistente> listaUsuarios = log.getAll();
		
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("listaUsuarios", listaUsuarios);
		
		response.sendRedirect("mostrarUsuarios.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
