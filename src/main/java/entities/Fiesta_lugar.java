package entities;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import entities.Lugar;
import entities.Fiesta;

public class Fiesta_lugar {
    private Fiesta fiesta;
    private Lugar lugar;
    private LocalDate fecha_fiesta;
    private LocalTime hora_fiesta;
    private double precio;  // Nuevo atributo

    public Fiesta_lugar() {};
    
    // Constructor original para compatibilidad con código existente
    public Fiesta_lugar(Fiesta fiesta, Lugar lugar, LocalDate fecha_fiesta, LocalTime hora_fiesta) {
        super();
        this.fiesta = fiesta;
        this.lugar = lugar;
        this.fecha_fiesta = fecha_fiesta;
        this.hora_fiesta = hora_fiesta;
    }
    
    // Nuevo constructor que incluye precio
    public Fiesta_lugar(Fiesta fiesta, Lugar lugar, LocalDate fecha_fiesta, LocalTime hora_fiesta, double precio) {
        super();
        this.fiesta = fiesta;
        this.lugar = lugar;
        this.fecha_fiesta = fecha_fiesta;
        this.hora_fiesta = hora_fiesta;
        this.precio = precio;
    }

    public Fiesta getFiesta() {
        return fiesta;
    }

    public void setFiesta(Fiesta fiesta) {
        this.fiesta = fiesta;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha_fiesta() {
        return fecha_fiesta;
    }

    public void setFecha_fiesta(LocalDate fecha_fiesta) {
        this.fecha_fiesta = fecha_fiesta;
    }

    public LocalTime getHora_fiesta() {
        return hora_fiesta;
    }

    public void setHora_fiesta(LocalTime hora_fiesta) {
        this.hora_fiesta = hora_fiesta;
    }
    
    // Nuevos getter y setter para precio
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Fiesta_lugar [fiesta=" + fiesta + ", lugar=" + lugar + 
               ", fecha_fiesta=" + fecha_fiesta + ", hora_fiesta=" + hora_fiesta + 
               ", precio=" + precio + "]";
    }
}