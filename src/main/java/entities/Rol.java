package entities;

public class Rol {
	
	private int idrol;
	private String descripcion;
	
	public Rol() {};
	
	public Rol(int idrol, String descripcion) {
		this.idrol = idrol;
		this.descripcion = descripcion;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
    public String toString() {
        return "Rol [idrol=" + idrol + ", descripcion=" + descripcion + "]";
    }
	
}
