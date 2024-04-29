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
		String email = request.getParameter("email");
		Asistente a = new Asistente(email, password);
		

		if (validateUser(dni, password)) {
            response.sendRedirect("index.jsp");
        } else {
        	boolean incorrectPassword = isIncorrectPassword(dni, password);
        	boolean dniNotFound = isDniNotFound(dni);
        	
        	String redirectURL = "login.jsp?error=true&dni=" + dni;
        	
        	if (incorrectPassword) {
                redirectURL += "&incorrectPassword=true";
            } else if (dniNotFound) {
                redirectURL += "&dniNotFound=true";
            }            
            response.sendRedirect(redirectURL);
        }
		/*
	 	if (validateUserDos(a)) {
    		response.sendRedirect("index.jsp");
    	} else {
    		String redirectURL = "login.jsp?error=true&email=" + email;
			if (isEmailNotFound(a)) {
				redirectURL += "&incorrectPassword=true";
			} else {
				redirectURL += "&emailNotFound=true";
				}
			response.sendRedirect(redirectURL);
		}
	 */
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
    
    private boolean isIncorrectPassword(int dni, String password) {
    	
    	LinkedList<Asistente> listaAsistentes = da.getAll();
    	
    	for (Asistente asi : listaAsistentes) {
    		if (asi.getNro_doc() == dni) {
    			if (asi.getPassword().equals(password)) {
	                return false;
	            } else {
	            	return true;
	            }
    		}
    	}
		return false;
    }

    private boolean isDniNotFound(int dni) {
    	
    	
    	LinkedList<Asistente> listaAsistentes = da.getAll();
    	
    	for (Asistente asi : listaAsistentes) {
    		if (asi.getNro_doc() == dni) {
    			return false;
    		}
    	}
		return true;
    }
	
private boolean validateUserDos(Asistente a) {
        
    	Asistente asi = da.getByUser(a);
		
		if (asi == null) {
			return false;
	    }
	    return true;   	
    }
    
    private boolean isIncorrectPasswordDos(int dni, String password) {
    	
    	LinkedList<Asistente> listaAsistentes = da.getAll();
    	
    	for (Asistente asi : listaAsistentes) {
    		if (asi.getNro_doc() == dni) {
    			if (asi.getPassword().equals(password)) {
	                return false;
	            } else {
	            	return true;
	            }
    		}
    	}
		return false;
    }

    private boolean isEmailFound(Asistente a) {
    	
    	Asistente asi = da.getByEmail(a);
    	if (a == null) {
    		return false;
    	}
		return true;
    }

}


