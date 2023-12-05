package entities;

public class Fiesta {
	
	private int idfiesta;
	private String nombre_fiesta;
	private String descripcion;
	
	public Fiesta() {}
	
	public Fiesta(int idfiesta, String nombre_f, String descripcion_f) {
		super();
		this.idfiesta = idfiesta;
		this.nombre_fiesta = nombre_f;
		this.descripcion = descripcion_f;
	}
	
	public int getIdfiesta() {
		return idfiesta;
	}
	public void setIdfiesta(int idfiesta) {
		this.idfiesta = idfiesta;
	}
	public String getNombre_fiesta() {
		return nombre_fiesta;
	}
	public void setNombre_fiesta(String nombre_fiesta) {
		this.nombre_fiesta = nombre_fiesta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Fiesta [idfiesta=" + idfiesta + ", nombre_fiesta=" + nombre_fiesta + ", descripcion=" + descripcion
				+ "]";
	}
	
	
	

}
