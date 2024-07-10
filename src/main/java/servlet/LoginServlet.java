package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		Asistente a = new Asistente(email, password);
	 	if (validateUser(a)) {
	 		HttpSession session = request.getSession();
	 		int rol = a.getRol();
	 		session.setAttribute("rol", rol);
    		response.sendRedirect("index.jsp");
    	} else {
    		String redirectURL = "login.jsp?error=true&email=" + email;
			if (isEmailFound(a)) {
				redirectURL += "&incorrectPassword=true";
			} else {
				redirectURL += "&emailNotFound=true";
				}
			response.sendRedirect(redirectURL);
		}
	}

    
	private boolean validateUser(Asistente a) {
        Asistente asi = da.getByUser(a);
		
		if (asi == null) {
			return false;
	    }
	    return true;   	
    }
	

    private boolean isEmailFound(Asistente a) {
    	Asistente asi = da.getByEmail(a);
    	
    	if (asi == null) {
    		return false;
    	}
		return true;
    }

}


