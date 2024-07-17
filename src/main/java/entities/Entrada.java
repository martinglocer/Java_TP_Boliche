package entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Entrada {
	
	private int identrada;
	private Asistente asistente;
	private Fiesta_lugar fiesta_lugar;
	private LocalDate fecha_compra;
	private LocalTime hora_compra;
	
	
	public Entrada() {}
	
	public Entrada(Asistente asistente, Fiesta_lugar fiesta_lugar, LocalDate fecha_compra, LocalTime hora_compra) {
		super();
		this.asistente = asistente;
		this.fiesta_lugar = fiesta_lugar;
		this.fecha_compra = fecha_compra;
		this.hora_compra = hora_compra;
	}
	
	public Entrada(int identrada, Asistente asistente, Fiesta_lugar fiesta_lugar, LocalDate fecha_compra, LocalTime hora_compra) {
		super();
		this.identrada = identrada;
		this.asistente = asistente;
		this.fiesta_lugar = fiesta_lugar;
		this.fecha_compra = fecha_compra;
		this.hora_compra = hora_compra;
	}
	
	
	public Asistente getAsistente() {
		return asistente;
	}

	public void setAsistente(Asistente asistente) {
		this.asistente = asistente;
	}

	public Fiesta_lugar getFiesta_lugar() {
		return fiesta_lugar;
	}

	public void setFiesta_lugar(Fiesta_lugar fiesta_lugar) {
		this.fiesta_lugar = fiesta_lugar;
	}

	public int getIdentrada() {
		return identrada;
	}
	
	public void setIdentrada(int identrada) {
		this.identrada = identrada;
	}
	
	public LocalDate getFecha_compra() {
		return fecha_compra;
	}
	
	public void setFecha_compra(LocalDate fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	
	public LocalTime getHora_compra() {
		return hora_compra;
	}
	
	public void setHora_compra(LocalTime hora_compra) {
		this.hora_compra = hora_compra;
	}
	
	@Override
    public String toString() {
        return "Entrada [identrada=" + identrada + ", idasistente=" + asistente.getIdasistente() + ", idfiesta=" 
        		+ fiesta_lugar.getFiesta().getIdfiesta() + ", idlugar=" + fiesta_lugar.getLugar().getIdlugar() 
        		+ ", fecha_evento=" + fiesta_lugar.getFecha_fiesta() + ", hora_evento=" + fiesta_lugar.getHora_fiesta() 
        		+ ", fecha_compra=" + fecha_compra + ", hora_compra=" + hora_compra + "]";
    }
	

}
