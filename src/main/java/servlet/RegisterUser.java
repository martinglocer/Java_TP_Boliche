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
		
		String tipo_doc = request.getParameter("tipo_doc");
		String nroDocStr = request.getParameter("nro_doc");
		int nro_doc = Integer.parseInt(nroDocStr);
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String celular = request.getParameter("celular");
		String fechaNacimientoStr = request.getParameter("fecha_nacimiento");
		LocalDate fecha_nacimiento = LocalDate.parse(fechaNacimientoStr);
		String saldo_Str = request.getParameter("saldo");
		float saldo = Float.parseFloat(saldo_Str);
		String password = request.getParameter("password");
		String idrolStr = request.getParameter("idrol");
		int idrol = Integer.parseInt(idrolStr);
		
		
		Asistente a = new Asistente(tipo_doc, nro_doc, nombre, apellido, email, celular, fecha_nacimiento, saldo, password, idrol);
		log.addAsistente(a);
		response.sendRedirect("indexUsuarios");
		
		System.out.println("Dni es: "+nro_doc);
		System.out.println("nombre es: "+nombre);
		System.out.println("apellido es: "+apellido);
		System.out.println("telefono es: "+celular);
		System.out.println("password es: "+password);

	}

}
