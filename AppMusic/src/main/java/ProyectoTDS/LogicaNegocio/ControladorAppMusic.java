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
	
	// TODO: private controlador?? Tiene referencia a controlador o no ??
	
	private CatalogoCanciones catalogoCanciones;
	private CatalogoUsuarios catalogoUsuarios;
	private LinkedList<Cancion> cancionesMasReproducidas; 
	private Usuario usuarioActivo;  //Variable que contendra  el usuario activo
	


	private ControladorAppMusic() {
		this.catalogoCanciones = CatalogoCanciones.INSTANCE;
		this.catalogoUsuarios = CatalogoUsuarios.INSTANCE;
		this.cancionesMasReproducidas = new LinkedList<Cancion>();
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
	
	public void logout() {
		usuarioActivo = null;
		//Hay que hacer algo mas¿?¿?¿?¿?¿? Supongo que si
	}
	
	public boolean comprobarLoginUsuario(String usuario, String password) {
		if (this.catalogoUsuarios.loginUsuario(usuario, password)){
			usuarioActivo = this.catalogoUsuarios.buscarObjetoUsuario(usuario);
			return true;
		}
		else return false;
	};
	
	public boolean RegistroUsuario(String usuario, String contrasena, String repite, String nombre, String apellidos, String fechaNacimiento, String email) {
		Usuario nuevoUsuario = new Usuario(usuario, contrasena, nombre, apellidos, fechaNacimiento, email);
		return this.catalogoUsuarios.registrarUsuario(nuevoUsuario);
	};
	
	public ArrayList<List<String>> buscarCanciones(String Titulo ,String Interprete,String  Estilo) {
		Set<Cancion> canciones = new LinkedHashSet<Cancion>(catalogoCanciones.buscarCanciones(Titulo, Interprete, Estilo));
		ArrayList<List<String>> ArrayConLasDosListas = new ArrayList<>();
		List<String> listaTitulos = new ArrayList<String>();
		List<String> listaInterpretes = new ArrayList<String>();
	    for (Cancion c : canciones) {
			listaTitulos.add(c.getTitulo());
			listaInterpretes.add(c.getInterprete().getNombre());
		}
	    ArrayConLasDosListas.add(0, listaTitulos);
	    ArrayConLasDosListas.add(1, listaInterpretes);
	    
		return ArrayConLasDosListas;
	};
	
	public Set<String> cargarMisListas(){
		return usuarioActivo.getNombrePlaylists();
	}
	
	
	public ArrayList<List<String>> getCancionesLista(String lista) {
		Set<Cancion> canciones = new LinkedHashSet<Cancion>(usuarioActivo.getCancionesPlaylist(lista));
		ArrayList<List<String>> ArrayConLasDosListas = new ArrayList<>();
		List<String> listaTitulos = new ArrayList<String>();
		List<String> listaInterpretes = new ArrayList<String>();
	    for (Cancion c : canciones) {
			listaTitulos.add(c.getTitulo());
			listaInterpretes.add(c.getInterprete().getNombre());
		}
	    ArrayConLasDosListas.add(0, listaTitulos);
	    ArrayConLasDosListas.add(1, listaInterpretes);
	    
		return ArrayConLasDosListas;
	};
	
	public boolean crearPlaylist(String nombre) {
		return usuarioActivo.crearNuevaPlaylist(nombre);
	}
	
	public boolean  insertarCancionEnPlaylist(String playlist, String nombreCancion, String interprete) {
		Cancion cancion = catalogoCanciones.buscarCancion(nombreCancion, interprete);
		if (cancion == null) return false;
		return usuarioActivo.añadirCancionAPlaylist(playlist, cancion);
	}
	
	public boolean borrarCancionDePlaylist(String playlist,String  cancion,String  interprete) {
		Cancion cancionAborrar = catalogoCanciones.buscarCancion(cancion, interprete);
		if (cancion == null) return false;
		return usuarioActivo.borrarCancionDePlaylist(playlist, cancionAborrar);
	}

	public boolean eliminarPlaylist(String nombre) {
		return usuarioActivo.eliminarPlaylist(nombre);
	}
	
	
	public void ReproducirCancion(String nombre, String artista) {
		catalogoCanciones.ReproducirCancion(nombre, artista, usuarioActivo);
	}
	
	public void pausarCancion() {
		Reproductor.INSTANCE.pausarCancion();
	}
	
	public ArrayList<List<String>> getCancionesRecientes() {
		Set<Cancion> canciones = new LinkedHashSet<Cancion>(usuarioActivo.getCancionesRecientes());
		ArrayList<List<String>> ArrayConLasDosListas = new ArrayList<>();
		List<String> listaTitulos = new ArrayList<String>();
		List<String> listaInterpretes = new ArrayList<String>();
	    for (Cancion c : canciones) {
			listaTitulos.add(c.getTitulo());
			listaInterpretes.add(c.getInterprete().getNombre());
		}
	    ArrayConLasDosListas.add(0, listaTitulos);
	    ArrayConLasDosListas.add(1, listaInterpretes);
	    
		return ArrayConLasDosListas;
	}
	
	public void generarPdf() {
		try {
			usuarioActivo.crearPDF();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
}
