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
	private LinkedList<Cancion> CancionesMasReproducidas; 
	private Usuario UsuarioActivo;  //Variable que contendra  el usuario activo
	


	private ControladorAppMusic() {
		this.catalogoCanciones = new CatalogoCanciones();
		this.catalogoUsuarios = new CatalogoUsuarios();
		this.CancionesMasReproducidas = new LinkedList<Cancion>();
		this.UsuarioActivo = null;
	}
	


	public CatalogoCanciones getCatalogoCanciones() {
		return catalogoCanciones;
	}

	public CatalogoUsuarios getCatalogoUsuarios() {
		return catalogoUsuarios;
	}

	public String getUsuarioActivo() {
		return UsuarioActivo.getUsuario();
	}

	public void setUsuarioActivo(Usuario usuarioActivo) {
		UsuarioActivo = usuarioActivo;
	}
	
	public void logout() {
		UsuarioActivo = null;
		//Hay que hacer algo mas¿?¿?¿?¿?¿? Supongo que si
	}
	
	public boolean comprobarLoginUsuario(String usuario, String password) {
		if (this.catalogoUsuarios.loginUsuario(usuario, password)){
			UsuarioActivo = this.catalogoUsuarios.buscarObjetoUsuario(usuario);
			return true;
		}
		else return false;
	};
	
	public boolean RegistroUsuario(String usuario, String contrasena, String repite, String nombre, String apellidos, String fechaNacimiento, String email) {
		return this.catalogoUsuarios.registrarUsuario(usuario, contrasena, repite, nombre, apellidos, fechaNacimiento, email);
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
		return UsuarioActivo.getNombrePlaylists();
	}
	
	
	public ArrayList<List<String>> getCancionesLista(String lista) {
		Set<Cancion> canciones = new LinkedHashSet<Cancion>(UsuarioActivo.getCancionesPlaylist(lista));
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
		return UsuarioActivo.crearNuevaPlaylist(nombre);
	}
	
	public boolean  insertarCancionEnPlaylist(String playlist, String nombreCancion, String interprete) {
		Cancion cancion = catalogoCanciones.buscarCancion(nombreCancion, interprete);
		if (cancion == null) return false;
		return UsuarioActivo.añadirCancionAPlaylist(playlist, cancion);
	}
	
	public boolean borrarCancionDePlaylist(String playlist,String  cancion,String  interprete) {
		Cancion cancionAborrar = catalogoCanciones.buscarCancion(cancion, interprete);
		if (cancion == null) return false;
		return UsuarioActivo.borrarCancionDePlaylist(playlist, cancionAborrar);
	}

	public boolean eliminarPlaylist(String nombre) {
		return UsuarioActivo.eliminarPlaylist(nombre);
	}
	
	
	public void ReproducirCancion(String nombre, String artista) {
		catalogoCanciones.ReproducirCancion(nombre, artista, UsuarioActivo);
	}
	
	public void pausarCancion() {
		Reproductor.pausarCancion();
	}
	
	public ArrayList<List<String>> getCancionesRecientes() {
		Set<Cancion> canciones = new LinkedHashSet<Cancion>(UsuarioActivo.getCancionesRecientes());
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
			UsuarioActivo.crearPDF();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
}
