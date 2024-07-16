package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import entities.Fiesta_lugar;
import entities.Fiesta;
import entities.Lugar;
import entities.Asistente;
import entities.Entrada;
import data.DataAsistente;
import data.DataEntrada;

@WebServlet(name = "RegistrarEntrada", urlPatterns = {"/RegistrarEntrada"})


public class RegistrarEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataEntrada dent = new DataEntrada();
		Fiesta f = new Fiesta();
		Lugar l = new Lugar();
		Asistente asis = new Asistente();
		
		String tipo_doc = request.getParameter("tipo_doc");
		String nro_docStr = request.getParameter("nro_doc");
		int nro_doc = Integer.parseInt(nro_docStr);
		
		asis.setTipo_doc(tipo_doc);
		asis.setNro_doc(nro_doc);
		
		
		DataAsistente da = new DataAsistente();
		Asistente asist = da.getByDocumento(asis);
		
		System.out.println("el asissssssstt:"+asist);
		
		int idasist = asist.getIdasistente();
		System.out.println("Id asistente:"+idasist);
		
		String fiestaSeleccionada = request.getParameter("fiesta");
        String[] fiestaDetails = fiestaSeleccionada.split("_");
        int idfiesta = Integer.parseInt(fiestaDetails[0]);
        int idlugar = Integer.parseInt(fiestaDetails[1]);
        LocalDate fecha_fiesta = LocalDate.parse(fiestaDetails[2]);
        LocalTime hora_fiesta = LocalTime.parse(fiestaDetails[3]);

        LocalDate fecha_actual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        Entrada ent = new Entrada(0,idasist, idfiesta, idlugar, fecha_fiesta, hora_fiesta, fecha_actual, horaActual);

        dent.add(ent);

        response.sendRedirect("indexEntrada");
		
		
        // Formatear la hora actual en el formato "hh:mm:ss"
        //String hora_actual = horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        
		
		
		// System.out.println("Id de la entrada es: "+ identrada);
		System.out.println("Id del asistente es: "+ idasist);
		System.out.println("Id fiesta es: "+ idfiesta);
		System.out.println("Id lugar es: "+ idlugar);
		System.out.println("Fecha de la fiesta es: "+ fecha_fiesta);
		System.out.println("Hora de la fiesta es: "+ hora_fiesta);
		System.out.println("Fecha de la compra es: "+ fecha_actual);
		System.out.println("Hora de la compra es: "+ horaActual);
		
		System.out.println(ent);
		
	}

}
