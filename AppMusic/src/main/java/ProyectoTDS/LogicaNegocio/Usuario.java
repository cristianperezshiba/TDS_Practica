package ProyectoTDS.LogicaNegocio;

import java.util.LinkedList;

public class Usuario {
	


	private String usuario;
	private String contrasena;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String email;
	private boolean premium;
	private LinkedList<ListaCanciones> playlists;
	
	private LinkedList<Cancion> cancionesRecientes;
	
	

	public Usuario(String usuario, String contrasena, String nombre, String apellidos, String fechaNacimiento, String email) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.premium = false;
		this.playlists = new LinkedList<ListaCanciones>();
		this.cancionesRecientes = new LinkedList<Cancion>();
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	
	

	
	
}
