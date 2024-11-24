package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entities.Entrada;
import data.DataEntrada;

@WebServlet(name = "SvEliminarEntrada", urlPatterns = {"/SvEliminarEntrada"})
public class SvEliminarEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SvEliminarEntrada() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_entrada = Integer.parseInt(request.getParameter("identrada"));
        Entrada en = new Entrada();
        en.setIdentrada(id_entrada);
        DataEntrada de = new DataEntrada();
        
        System.out.println(" id:" + en.getIdentrada());
        de.deleteByID(en);
        
        response.sendRedirect(request.getContextPath() + "/indexEntrada.jsp");
    }

}
