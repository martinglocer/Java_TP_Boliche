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

        // Validación de campos vacíos
        if (tipo_doc_editar == null || tipo_doc_editar.trim().isEmpty() ||
            nro_doc_editarStr == null || nro_doc_editarStr.trim().isEmpty()) {

            // Manejar el caso de campos vacíos, por ejemplo, redirigir a una página de error
            System.out.println("El tipo o número de documento no puede estar vacío");
            response.sendRedirect("buscarUsuario.jsp"); // O cualquier otra acción apropiada
        } else {
            try {
                // Validación de que el número de documento sea un número válido
                int nro_doc_editar = Integer.parseInt(nro_doc_editarStr);

                // Crear y llenar el objeto Asistente
                Asistente asi = new Asistente();
                asi.setTipo_doc(tipo_doc_editar);
                asi.setNro_doc(nro_doc_editar);

                // Buscar el usuario
                Login l = new Login();
                Asistente a = l.getByDocumento(asi);

                // Guardar el usuario en la sesión
                HttpSession misesion = request.getSession();
                misesion.setAttribute("usuMostrar", a);

                if (a != null) {
                    System.out.println("Usuario encontrado");
                } else {
                    System.out.println("Usuario no encontrado");
                }
                response.sendRedirect("mostrarUsuario.jsp");

            } catch (NumberFormatException e) {
                // Manejar el caso donde el número de documento no sea un número válido
                System.out.println("El número de documento debe ser un número válido");
                response.sendRedirect("buscarUsuario.jsp"); // O cualquier otra acción apropiada
            }
        }
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
