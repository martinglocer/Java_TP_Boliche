package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Asistente;
import logic.Login;

@WebServlet(name = "SvBuscarUsuario", urlPatterns = "/SvBuscarUsuario")

public class SvBuscarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SvBuscarUsuario() {
        super();
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
		misesion.setAttribute("usuMostrar", a);
		
		response.sendRedirect("mostrarUsuario.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
