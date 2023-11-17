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

@WebServlet(name = "SvEditarUsuario", urlPatterns = "/SvEditarUsuario")

public class SvEditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public SvEditarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo_doc_editar = request.getParameter("tipo_doc_editar");
		String nro_doc_editarStr = request.getParameter("nro_doc_editar");
		int nro_doc_editar = Integer.parseInt(nro_doc_editarStr);
		Asistente asi = new Asistente();
		asi.setTipo_doc(tipo_doc_editar);
		asi.setNro_doc(nro_doc_editar);
		Login l = new Login();
		Asistente a = l.getByDocumento(asi);
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("usuEditar", a);
		
		response.sendRedirect("editarUsuario.jsp");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Login l = new Login();
		
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
		
		
		Asistente a = new Asistente(tipo_doc, nro_doc, nombre, apellido, email, password, celular, fecha_nacimiento);
		l.actualizarDatos(a);
		
		response.sendRedirect("indexUsuarios");
		
		System.out.println("Nombre del usuario es: "+nombre);
		System.out.println("apellido es: "+apellido);
		System.out.println("celular es: "+celular);
		System.out.println("email es: "+email);
		
	}

}
