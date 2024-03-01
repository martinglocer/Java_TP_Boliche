package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

import data.DataAsistente;
import entities.Asistente;


public class LoginServlet extends HttpServlet {
	
	private DataAsistente da;
	
	@Override
    public void init() throws ServletException {
        da = new DataAsistente();
    }
	
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dni = Integer.parseInt(request.getParameter("dni"));
		String password = request.getParameter("password");

        if (validateUser(dni, password)) {
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }

    private boolean validateUser(int dni, String password) {
        
    	LinkedList<Asistente> listaAsistentes = da.getAll();
		
		if (listaAsistentes == null) {
	        return false;
	    }

	    for (Asistente asi : listaAsistentes) {
	        if (asi.getNro_doc() == dni) {
	            if (asi.getPassword().equals(password)) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	    }
	    
	    return false;
    	
    }
		
	}


