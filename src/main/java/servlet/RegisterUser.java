package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;


import entities.Asistente;
import logic.Login;

@WebServlet(name = "RegisterUser", urlPatterns = {"/RegisterUser"})

public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterUser() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login log = new Login();
		
		// Obtener los parámetros del formulario
	    String tipo_doc = request.getParameter("tipo_doc");
	    String nroDocStr = request.getParameter("nro_doc");
	    String nombre = request.getParameter("nombre");
	    String apellido = request.getParameter("apellido");
	    String email = request.getParameter("email");
	    String celular = request.getParameter("celular");
	    String fechaNacimientoStr = request.getParameter("fecha_nacimiento");
	    String saldoStr = request.getParameter("saldo");
	    String password = request.getParameter("password");
	    String idrolStr = request.getParameter("idrol");

	    // Verificación de los campos
	    if (tipo_doc.isEmpty() || nroDocStr.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() ||
	            celular.isEmpty() || fechaNacimientoStr.isEmpty() || saldoStr.isEmpty() || password.isEmpty() ||
	            idrolStr.isEmpty()) {
	        HttpSession session = request.getSession();
	        session.setAttribute("error", "Por favor complete todos los campos.");
	        response.sendRedirect("RegisterUser.jsp"); 
	        return; 
	    }

	    // Validación del número de documento y el saldo
	    int nro_doc;
	    float saldo;
	    try {
	        nro_doc = Integer.parseInt(nroDocStr);
	        saldo = Float.parseFloat(saldoStr);
	    } catch (NumberFormatException e) {
	        HttpSession session = request.getSession();
	        session.setAttribute("error", "Por favor ingrese números válidos para el número de documento y el saldo.");
	        response.sendRedirect("RegisterUser.jsp"); // Reemplaza "tuPagina.jsp" con la página donde está tu formulario
	        return; 
	    }
	    
	    LocalDate fecha_nacimiento;
	    int idrol;
	    
	    try {
	    	fecha_nacimiento = LocalDate.parse(fechaNacimientoStr);
	    	idrol = Integer.parseInt(idrolStr);
	    } catch (NumberFormatException e) {
	        HttpSession session = request.getSession();
	        session.setAttribute("error", "Por favor ingrese valores válidos para la fecha de nacimiento y el rol.");
	        response.sendRedirect("RegisterUser.jsp"); 
	        return; 
	    }
		
		Asistente a = new Asistente(tipo_doc, nro_doc, nombre, apellido, email, celular, fecha_nacimiento, saldo, password, idrol);
		log.addAsistente(a);
		response.sendRedirect("indexUsuarios");
		
		System.out.println("Dni es: "+nro_doc);
		System.out.println("nombre es: "+nombre);
		System.out.println("apellido es: "+apellido);
		System.out.println("telefono es: "+celular);
		System.out.println("password es: "+password);
		System.out.println("saldo es: "+saldo);

	}

}
