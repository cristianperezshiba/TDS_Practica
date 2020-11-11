package ProyectoTDS.LogicaNegocio;

import java.util.*;
import java.util.stream.Collectors; 

public class Usuario {
	


	private String usuario;
	private String contrasena;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String email;
	private boolean premium;
	private Set<ListaCanciones> playlists;
	
	private List<Cancion> cancionesRecientes;
	
	

	public Usuario(String usuario, String contrasena, String nombre, String apellidos, String fechaNacimiento, String email) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.premium = false;
		this.playlists = new LinkedHashSet<ListaCanciones>();
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
	
	public Set<String> getNombrePlaylists() {
		return playlists.stream()
			.map(p -> p.getNombre())
			.collect(Collectors.toSet());
	}
	
	public boolean crearNuevaPlaylist(String nombre) {
		return this.playlists.add(new ListaCanciones(nombre));
	}
	
	public boolean añadirCancionAPlaylist(String lista, Cancion cancion) {
		return this.playlists.stream()
			.filter(l -> l.getNombre().equals(lista))
			.findFirst()
			.get()
			.añadirCancion(cancion);
	}
	
	public boolean borrarCancionDePlaylist(String playlist, Cancion cancion){
		return this.playlists.stream()
				.filter(l -> l.getNombre().equals(playlist))
				.findFirst()
				.get()
				.eliminarCancion(cancion);
	}
	
	public Set<Cancion> getCancionesPlaylist(String lista){
		return playlists.stream()
				.filter(p -> p.getNombre().equals(lista))
				.findFirst()
				.get()
				.getCanciones();

	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	

	
	
}
