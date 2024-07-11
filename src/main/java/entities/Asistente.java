package entities;

import java.time.LocalDate;
//import java.util.Date;


public class Asistente {
	
	private int idasistente;
	private String tipo_doc;
	private int nro_doc;
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fecha_nacimiento;
	private String celular;
	private float saldo;
	private String password;
	private int idrol;
	


	public Asistente(int idAsistente, String tipo_doc, int nro_doc, String nombre, String apellido, String email, String celular, LocalDate fecha_nacimiento,
			float saldo, String password, int idrol) {
		super();
		this.idasistente = idAsistente;
		this.tipo_doc = tipo_doc;
		this.nro_doc = nro_doc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.celular = celular;
		this.fecha_nacimiento = fecha_nacimiento;
		this.saldo = saldo;
		this.password = password;
		this.idrol = idrol;
	}
	
	public Asistente(String tipo_doc, int nro_doc, String nombre, String apellido, String email, String celular, LocalDate fecha_nacimiento,
			float saldo, String password, int idrol) {
		super();
		this.tipo_doc = tipo_doc;
		this.nro_doc = nro_doc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.celular = celular;
		this.fecha_nacimiento = fecha_nacimiento;
		this.saldo = saldo;
		this.password = password;
		this.idrol = idrol;
	}
	
	public Asistente(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Asistente() {
		// TODO Auto-generated constructor stub
	}

	
	
	public int getIdasistente() {
		return idasistente;
	}

	public void setIdasistente(int idasistente) {
		this.idasistente = idasistente;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getTipo_doc() {
		return tipo_doc;
	}
	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
	public int getNro_doc() {
		return nro_doc;
	}
	public void setNro_doc(int nro_doc) {
		this.nro_doc = nro_doc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(LocalDate fecha_nac) {
		this.fecha_nacimiento = fecha_nac;
	}
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getRol() {
		return idrol;
	}
	public void setRol(int idrol) {
		this.idrol = idrol;
	}
	
	@Override
	public String toString() {
		return "Assistant [id_asistente=" + idasistente + ", tipo_doc=" + tipo_doc + ", nro_doc=" + nro_doc + ", nombre=" + nombre + ", apellido="
				+ apellido + ", email=" + email + ", fecha_nacimiento=" + fecha_nacimiento + ", celular=" + celular
				+ ", saldo=" + saldo + ", password=" + password + "]";
				
	}
	
	
}