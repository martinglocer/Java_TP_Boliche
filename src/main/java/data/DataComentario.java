package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import entities.Asistente;
import entities.Comentario;

public class DataComentario {

    public void agregarComentario(Comentario comentario) {
        PreparedStatement stmt = null;
        try {
            Connection conn = DbConnector.getInstancia().getConn();
            stmt = conn.prepareStatement(
                    "INSERT INTO comentario (texto, fechahora, idasistente, idfiesta, idlugar, fecha_evento, hora_evento) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            stmt.setString(1, comentario.getTexto());
            stmt.setObject(2, comentario.getFechaHora());
            stmt.setInt(3, comentario.getAsistente().getIdasistente());
            stmt.setInt(4, comentario.getIdFiesta());
            stmt.setInt(5, comentario.getIdLugar());
            stmt.setObject(6, comentario.getFechaEvento()); 
            stmt.setObject(7, comentario.getHoraEvento()); 
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Comentario> getComentarios(int idFiesta, int idLugar, LocalDate fechaEvento, LocalTime horaEvento) { 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Comentario> comentarios = new LinkedList<>();
        try {
            Connection conn = DbConnector.getInstancia().getConn();
            stmt = conn.prepareStatement(
                    "SELECT c.*, a.nombre, a.apellido " +
                    "FROM comentario c " +
                    "INNER JOIN asistente a ON c.idasistente = a.idasistente " +
                    "WHERE c.idfiesta = ? AND c.idlugar = ? AND c.fecha_evento = ? AND c.hora_evento = ?"
            );
            stmt.setInt(1, idFiesta);
            stmt.setInt(2, idLugar);
            stmt.setObject(3, fechaEvento); 
            stmt.setObject(4, horaEvento);
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Comentario c = new Comentario();
                    c.setIdcomentario(rs.getInt("idcomentario"));
                    c.setTexto(rs.getString("texto"));
                    c.setFechaHora(rs.getTimestamp("fechahora").toLocalDateTime());

                    Asistente a = new Asistente();
                    a.setIdasistente(rs.getInt("idasistente"));
                    a.setNombre(rs.getString("nombre"));
                    a.setApellido(rs.getString("apellido"));
                    c.setAsistente(a);

                    c.setIdFiesta(rs.getInt("idfiesta"));
                    c.setIdLugar(rs.getInt("idlugar"));
                    c.setFechaEvento(rs.getObject("fecha_evento", LocalDate.class)); 
                    c.setHoraEvento(rs.getObject("hora_evento", LocalTime.class)); 

                    comentarios.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return comentarios;
    }
}