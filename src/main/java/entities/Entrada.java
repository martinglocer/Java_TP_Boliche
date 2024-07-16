package entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Entrada {
	
	private int identrada;
	private int idasistente;
	private int idfiesta;
	private int idlugar;
	private LocalDate fecha_evento;
	private LocalTime hora_evento;
	private LocalDate fecha_compra;
	private LocalTime hora_compra;
	
	
	public Entrada() {}
	
	public Entrada(int idasistente, int idfiesta, int idlugar, LocalDate fecha_evento, LocalTime hora_evento, LocalDate fecha_compra, LocalTime hora_compra) {
		super();
		this.idasistente = idasistente;
		this.idfiesta = idfiesta;
		this.idlugar = idlugar;
		this.fecha_evento = fecha_evento;
		this.hora_evento = hora_evento;
		this.fecha_compra = fecha_compra;
		this.hora_compra = hora_compra;
	}
	
	public Entrada(int identrada, int idasistente, int idfiesta, int idlugar, LocalDate fecha_evento, LocalTime hora_evento, LocalDate fecha_compra, LocalTime hora_compra) {
		super();
		this.identrada = identrada;
		this.idasistente = idasistente;
		this.idfiesta = idfiesta;
		this.idlugar = idlugar;
		this.fecha_evento = fecha_evento;
		this.hora_evento = hora_evento;
		this.fecha_compra = fecha_compra;
		this.hora_compra = hora_compra;
	}
	
	
	public int getIdasistente() {
		return idasistente;
	}

	public void setIdasistente(int idasistente) {
		this.idasistente = idasistente;
	}

	public int getIdfiesta() {
		return idfiesta;
	}

	public void setIdfiesta(int idfiesta) {
		this.idfiesta = idfiesta;
	}

	public int getIdlugar() {
		return idlugar;
	}

	public void setIdlugar(int idlugar) {
		this.idlugar = idlugar;
	}

	public LocalDate getFecha_evento() {
		return fecha_evento;
	}

	public void setFecha_evento(LocalDate fecha_evento) {
		this.fecha_evento = fecha_evento;
	}

	public LocalTime getHora_evento() {
		return hora_evento;
	}

	public void setHora_evento(LocalTime hora_evento) {
		this.hora_evento = hora_evento;
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
        return "Entrada [identrada=" + identrada + ", idasistente=" + idasistente + ", idfiesta=" + idfiesta + ", idlugar=" + idlugar + ", fecha_evento=" + fecha_evento + ", hora_evento=" + hora_evento + ", fecha_compra=" + fecha_compra + ", hora_compra=" + hora_compra + "]";
    }
	

}
