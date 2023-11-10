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

@WebServlet(name = "UpdateUser", urlPatterns = {"/updateUser"})
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login log = new Login();
		
		String tipo_doc = request.getParameter("tipo_doc");
		String nroDocStr = request.getParameter("nro_doc");
		int nro_doc = Integer.parseInt(nroDocStr);
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String fechaNacimientoStr = request.getParameter("fecha_nacimiento");
		LocalDate fecha_nacimiento = LocalDate.parse(fechaNacimientoStr);
		String celular = request.getParameter("celular");
		String password = request.getParameter("password");
		
		
		Asistente a = new Asistente(tipo_doc, nro_doc, nombre, apellido, email, fecha_nacimiento, celular, password);
		log.actualizarDatos(a);
		
		System.out.println("Dni es: "+nro_doc);
		System.out.println("nombre es: "+nombre);
		System.out.println("apellido es: "+apellido);
		System.out.println("telefono es: "+celular);
	}

}
