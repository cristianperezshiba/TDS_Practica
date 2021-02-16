package ProyectoTDS.LogicaNegocio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class Usuario {

	static final int TAM_COLA_CANCIONES_RECIENTES = 10;
	
	private int codigo;
	private String usuario;
	private String contrasena;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String email;
	private boolean premium;
	private Set<ListaCanciones> playlists;
	private Descuento descuentoActivo;

	private List<Cancion> cancionesRecientes;

																

	public Usuario(String usuario, String contrasena, String nombre, String apellidos, String fechaNacimiento,
			String email) {
		super();
		codigo = 0;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.premium = false;
		this.playlists = new LinkedHashSet<ListaCanciones>();
		this.cancionesRecientes = new LinkedList<Cancion>();
		this.descuentoActivo = null;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getCodigo() {
		return codigo;
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
	
	public Set<ListaCanciones> getPlaylists(){
		return this.playlists;
	}
	
	public Descuento getDescuentoActivo() {
		return descuentoActivo;
	}
	
	public void setDescuentoActivo(Descuento d) {
		this.descuentoActivo = d;
	}

	public List<String> getNombrePlaylists() {
		return playlists.stream().map(p -> p.getNombre()).collect(Collectors.toList());
	}

	public boolean crearNuevaPlaylist(String nombre) {
		return this.playlists.add(new ListaCanciones(nombre));
	}

	public boolean añadirCancionAPlaylist(String lista, Cancion cancion) {
		return this.playlists.stream().filter(l -> l.getNombre().equals(lista)).findFirst().get()
				.añadirCancion(cancion);
	}

	public boolean borrarCancionDePlaylist(String playlist, Cancion cancion) {
		return this.playlists.stream().filter(l -> l.getNombre().equals(playlist)).findFirst().get()
				.eliminarCancion(cancion);
	}

	public List<Cancion> getCancionesPlaylist(String lista) {
		return new LinkedList<Cancion> (playlists.stream().filter(p -> p.getNombre().equals(lista)).findFirst().get().getCanciones());

	}

	public boolean eliminarPlaylist(String nombrePlaylist) {
		ListaCanciones lista = playlists.stream().filter(p -> p.getNombre().equals(nombrePlaylist)).findFirst().get();
		return playlists.remove(lista);
	}

	public void nuevaCancionReciente(Cancion cancion) {
		if (cancion == null || cancionesRecientes.contains(cancion))
			return;
		else if (cancionesRecientes.size() >= TAM_COLA_CANCIONES_RECIENTES) {
			cancionesRecientes.remove(cancionesRecientes.size() - 1);
		}
		cancionesRecientes.add(0, cancion);
		System.out.println("Nueva cancion reciente");
	}

	public List<Cancion> getCancionesRecientes() {
		return cancionesRecientes;

	}
	

	public void crearPDF() throws DocumentException {
		 ServicioPdf.crearPDF(playlists);
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
