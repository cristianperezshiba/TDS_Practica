package ProyectoTDS.LogicaNegocio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.itextpdf.text.DocumentException;

public enum ControladorAppMusic {
	INSTANCE;
	//Usamos patron singleton

	
	private CatalogoCanciones catalogoCanciones;
	private CatalogoUsuarios catalogoUsuarios;
	private Usuario usuarioActivo;  //Variable que contendra  el usuario activo
	


	private ControladorAppMusic() {
		this.catalogoCanciones = CatalogoCanciones.INSTANCE;
		this.catalogoUsuarios = CatalogoUsuarios.INSTANCE;
		this.usuarioActivo = null;
	}
	

	public void cargarCanciones() {
		catalogoCanciones.cargarCanciones();
	}
	public CatalogoCanciones getCatalogoCanciones() {
		return catalogoCanciones;
	}

	public CatalogoUsuarios getCatalogoUsuarios() {
		return catalogoUsuarios;
	}

	public String getUsuarioActivo() {
		return usuarioActivo.getUsuario();
	}

	public void setUsuarioActivo(Usuario nuevoUsuarioActivo) {
		this.usuarioActivo = nuevoUsuarioActivo;
	}
	
	public boolean isUsuarioActivoPremium() {
		return usuarioActivo.isPremium();
	}
	
	public void setUsuarioActivoPremium() {
		usuarioActivo.setPremium(true);
	}
	public void logout() {
		usuarioActivo = null;
	}
	
	public boolean comprobarLoginUsuario(String usuario, String password) {
		if (this.catalogoUsuarios.loginUsuario(usuario, password)){
			usuarioActivo = this.catalogoUsuarios.buscarObjetoUsuario(usuario);
			return true;
		}
		else return false;
	};
	
	public boolean RegistroUsuario(String usuario, String contrasena, String repite, String nombre, String apellidos, String fechaNacimiento, String email) {
		ProyectoTDS.LogicaNegocio.Usuario nuevoUsuario = new ProyectoTDS.LogicaNegocio.Usuario(usuario, contrasena, nombre, apellidos, fechaNacimiento, email);
		return this.catalogoUsuarios.registrarUsuario(nuevoUsuario);
	};
	
	public List<Cancion> buscarCanciones(String Titulo ,String Interprete,String  Estilo) {
		return catalogoCanciones.buscarCanciones(Titulo, Interprete, Estilo);
	};
	
	public List<String> cargarMisListas(){
		return usuarioActivo.getNombrePlaylists();
	}
	
	
	public List<Cancion> getCancionesLista(String lista) {
		return usuarioActivo.getCancionesPlaylist(lista);
	};
	
	public boolean crearPlaylist(String nombre) {
		return usuarioActivo.crearNuevaPlaylist(nombre);
	}
	
	public boolean  insertarCancionEnPlaylist(String playlist, Cancion cancion) {
		//Cancion cancion = catalogoCanciones.buscarCancion(nombreCancion, interprete);
		if (cancion == null) return false;
		return usuarioActivo.añadirCancionAPlaylist(playlist, cancion);
	}
	
	public boolean borrarCancionDePlaylist(String playlist, Cancion cancion) {
		//Cancion cancionAborrar = catalogoCanciones.buscarCancion(cancion, interprete);
		if (cancion == null) return false;
		return usuarioActivo.borrarCancionDePlaylist(playlist, cancion);
	}

	public boolean eliminarPlaylist(String nombre) {
		return usuarioActivo.eliminarPlaylist(nombre);
	}
	
	
	public void ReproducirCancion(Cancion cancion) {
		catalogoCanciones.ReproducirCancion(cancion, usuarioActivo);
	}
	
	public void pausarCancion() {
		Reproductor.INSTANCE.pausarCancion();
	}
	
	public List<Cancion> getCancionesRecientes() {
		return usuarioActivo.getCancionesRecientes();
		
	}
	
	public void generarPdf() {
		try {
			usuarioActivo.crearPDF();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Cancion> getCancionesMasReproducidasAppMusic(){
		return catalogoCanciones.getCancionesMasReproducidasAppMusic();
	}
	
	public Descuento getDescuentoActivo() {
		return usuarioActivo.getDescuentoActivo();
	}
	
	public void setDescuentoActivo(Descuento d) {
		usuarioActivo.setDescuentoActivo(d);
	}
	
	
	

}
