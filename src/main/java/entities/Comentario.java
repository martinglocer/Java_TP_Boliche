package entities;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

public class Comentario {

    private int idcomentario;
    private String texto;
    private LocalDateTime fechahora;
    private Asistente asistente; 
    private int idFiesta;
    private int idLugar;
    private LocalDate fechaEvento; 
    private LocalTime horaEvento; 

  
    public Comentario() {
    }

    
    public Comentario(int idcomentario, String texto, LocalDateTime fechahora, Asistente asistente, int idFiesta, int idLugar, LocalDate fechaEvento, LocalTime horaEvento) {
        this.idcomentario = idcomentario;
        this.texto = texto;
        this.fechahora = fechahora;
        this.asistente = asistente;
        this.idFiesta = idFiesta;
        this.idLugar = idLugar;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
    }


    public int getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(int idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getFechaHora() {
        return fechahora;
    }

    public void setFechaHora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }

    public Asistente getAsistente() {
        return asistente;
    }

    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }

    public int getIdFiesta() {
        return idFiesta;
    }

    public void setIdFiesta(int idFiesta) {
        this.idFiesta = idFiesta;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public LocalTime getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(LocalTime horaEvento) {
        this.horaEvento = horaEvento; 
    }
}