package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Fiesta_lugar {

	private int idfiesta;
	private int idlugar;
	private LocalDateTime fecha_hora_fiesta;
	
	
	public Fiesta_lugar(int idfiesta, int idlugar, LocalDateTime fecha_hora_fiesta) {
		super();
		this.idfiesta = idfiesta;
		this.idlugar = idlugar;
		this.fecha_hora_fiesta = fecha_hora_fiesta;
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


	public LocalDateTime getFecha_hora_fiesta() {
		return fecha_hora_fiesta;
	}


	public void setFecha_hora_fiesta(LocalDateTime fecha_hora_fiesta) {
		this.fecha_hora_fiesta = fecha_hora_fiesta;
	}
	
	
	
}
