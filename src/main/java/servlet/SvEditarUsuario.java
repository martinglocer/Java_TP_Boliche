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
		
		System.out.println(asi);
		
		DataAsistente da = new DataAsistente();
		Asistente a = da.getByDocumento(asi);
		System.out.println(a);
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("usuEditar", a);
		
		response.sendRedirect("editarUsuario.jsp");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String id_asi = request.getParameter("id_user");
	    String tipo_doc = request.getParameter("tipo_doc");
	    String nroDocStr = request.getParameter("nro_doc");
	    String nombre = request.getParameter("nombre");
	    String apellido = request.getParameter("apellido");
	    String email = request.getParameter("email");
	    String celular = request.getParameter("celular");
	    String fechaNacimientoStr = request.getParameter("fecha_nacimiento");
	    String password = request.getParameter("password");
	    String idrolStr = request.getParameter("idrol");

	    // Inicializamos las variables necesarias
	    int nro_doc = 0;
	    int idrol = 0;
	    LocalDate fecha_nacimiento = null;
	    String errorMessage = null;

	    try {
	        // Validaciones de formato
	        if (id_asi == null || id_asi.isEmpty() ||
	            tipo_doc == null || tipo_doc.isEmpty() ||
	            nroDocStr == null || nroDocStr.isEmpty() ||
	            !nroDocStr.matches("\\d+") || // Verificar si nroDocStr contiene solo números
	            nombre == null || nombre.isEmpty() ||
	            apellido == null || apellido.isEmpty() ||
	            email == null || email.isEmpty() ||
	            celular == null || celular.isEmpty() ||
	            fechaNacimientoStr == null || fechaNacimientoStr.isEmpty() ||
	            password == null || password.isEmpty() ||
	            idrolStr == null || idrolStr.isEmpty() ||
	            !idrolStr.matches("\\d+")) { // Verificar si idrolStr contiene solo números
	            
	            errorMessage = "Todos los campos son obligatorios y deben contener datos válidos.";
	            throw new IllegalArgumentException(errorMessage);
	        }

	        nro_doc = Integer.parseInt(nroDocStr);
	        idrol = Integer.parseInt(idrolStr);

	        // Validación adicional de rol y fecha
	        if (idrol < 1 || idrol > 2) {
	            errorMessage = "El rol debe ser 1 o 2.";
	            throw new IllegalArgumentException(errorMessage);
	        }

	        fecha_nacimiento = LocalDate.parse(fechaNacimientoStr);

	    } catch (IllegalArgumentException e) {
	        // Si ocurre algún error, mantenemos los datos y redirigimos con mensaje de error
	        Asistente currentAsistente = new Asistente();
	        currentAsistente.setIdasistente(id_asi != null ? Integer.parseInt(id_asi) : 0);
	        currentAsistente.setTipo_doc(tipo_doc);
	        currentAsistente.setNro_doc(nro_doc);
	        currentAsistente.setNombre(nombre);
	        currentAsistente.setApellido(apellido);
	        currentAsistente.setEmail(email);
	        currentAsistente.setCelular(celular);
	        currentAsistente.setFecha_nacimiento(fechaNacimientoStr != null ? LocalDate.parse(fechaNacimientoStr) : null);
	        currentAsistente.setPassword(password);
	        currentAsistente.setIdrol(idrol);

	        HttpSession session = request.getSession();
	        session.setAttribute("usuEditar", currentAsistente);
	        session.setAttribute("error", errorMessage != null ? errorMessage : e.getMessage());
	        response.sendRedirect("editarUsuario.jsp");
	        return;
	    }

	    // Si las validaciones son exitosas, procesamos la actualización
	    DataAsistente da = new DataAsistente();
	    float saldo = 0; // Se asigna un saldo por defecto
	    Asistente asistenteActualizado = new Asistente(
	        Integer.parseInt(id_asi), tipo_doc, nro_doc, nombre, apellido, email, celular, fecha_nacimiento, saldo, password, idrol
	    );

	    da.actualizarAsist(asistenteActualizado);
	    response.sendRedirect("indexUsuarios");
	}

}
