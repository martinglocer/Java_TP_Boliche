package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import data.DataComentario;
import entities.Asistente;
import entities.Comentario;

@WebServlet(name = "SvAgregarComentario", urlPatterns = "/SvAgregarComentario")

public class SvAgregarComentario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener los parámetros del formulario
        int idFiesta = Integer.parseInt(request.getParameter("idFiesta"));
        int idLugar = Integer.parseInt(request.getParameter("idLugar"));
        String fechaEventoStr = request.getParameter("fechaEvento");
        String horaEventoStr = request.getParameter("horaEvento");
        String texto = request.getParameter("texto");

        // Obtener la fecha y hora del evento como LocalDate y LocalTime
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaEvento = LocalDate.parse(fechaEventoStr, dateFormatter);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaEvento = LocalTime.parse(horaEventoStr, timeFormatter);

        // Obtener el usuario logueado
        Asistente loggedInUser = (Asistente) request.getSession().getAttribute("user");

        // Crear un nuevo comentario
        Comentario comentario = new Comentario();
        comentario.setAsistente(loggedInUser);
        comentario.setIdFiesta(idFiesta);
        comentario.setIdLugar(idLugar);
        comentario.setFechaEvento(fechaEvento); 
        comentario.setHoraEvento(horaEvento);
        comentario.setTexto(texto);
        comentario.setFechaHora(LocalDateTime.now());

        // Guardar el comentario en la base de datos
        DataComentario dataComentario = new DataComentario();
        dataComentario.agregarComentario(comentario);

        // Redirigir a la página de comentarios
        String redirectURL = "comentarios.jsp?idFiesta=" + idFiesta + "&idLugar=" + idLugar
                + "&fechaEvento=" + fechaEvento.format(dateFormatter) + "&horaEvento=" + horaEvento.format(timeFormatter);
        response.sendRedirect(redirectURL);
    }
}