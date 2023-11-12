package entities;


public class Lugar {
	
	private int idlugar;
	private String nombre_lugar;
	private String direccion;
	private int capacidad;
	private String ciudad;
	
	
	
	public Lugar(int idlugar, String nombre_lugar, String direccion, int capacidad, String ciudad) {
		super();
		this.idlugar = idlugar;
		this.nombre_lugar = nombre_lugar;
		this.direccion = direccion;
		this.capacidad = capacidad;
		this.ciudad = ciudad;
	}
	public int getIdlugar() {
		return idlugar;
	}
	public void setIdlugar(int idlugar) {
		this.idlugar = idlugar;
	}
	public String getNombre_lugar() {
		return nombre_lugar;
	}
	public void setNombre_lugar(String nombre_lugar) {
		this.nombre_lugar = nombre_lugar;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@Override
	public String toString() {
		return "Lugar [idlugar=" + idlugar + ", nombre_lugar=" + nombre_lugar + ", direccion=" + direccion
				+ ", capacidad=" + capacidad + ", ciudad=" + ciudad + "]";
	}
	
	

}
