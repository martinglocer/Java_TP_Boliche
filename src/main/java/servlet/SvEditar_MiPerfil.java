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
import data.DataAsistente; 
import logic.Login;

@WebServlet(name = "SvEditar_MiPerfil", urlPatterns = "/SvEditar_MiPerfil")

public class SvEditar_MiPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public SvEditar_MiPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_asi = request.getParameter("id_user");
		int id_asi_editar = Integer.parseInt(id_asi);
		String tipo_doc = request.getParameter("tipo_doc");
		String nroDocStr = request.getParameter("nro_doc");
		int nro_doc = Integer.parseInt(nroDocStr);
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String celular = request.getParameter("celular");
		String fechaNacimientoStr = request.getParameter("fecha_nacimiento");
		LocalDate fecha_nacimiento = LocalDate.parse(fechaNacimientoStr);
		//String saldo_Str = request.getParameter("saldo");
		//System.out.println("Saldo STR es: "+saldo_Str);
		float saldo = 0;
		String password = request.getParameter("password");
		String idrolStr = request.getParameter("idrol");
		int idrol = Integer.parseInt(idrolStr);
		
		DataAsistente da = new DataAsistente();
		Asistente a = new Asistente(id_asi_editar, tipo_doc, nro_doc, nombre, apellido, email, celular, fecha_nacimiento, saldo, password, idrol);
		//DataAsistente da = new DataAsistente();
		da.actualizarAsist(a);
		HttpSession session = request.getSession();
		session.setAttribute("user", a);
		response.sendRedirect("Editar_mi_perfil.jsp");
		
		System.out.println("Nombre del usuario es: "+a.getNombre());
		System.out.println("apellido es: "+a.getApellido());
		System.out.println("celular es: "+a.getCelular());
		System.out.println("email es: "+a.getEmail());
		System.out.println("Saldo es: "+a.getSaldo());
	}

}
