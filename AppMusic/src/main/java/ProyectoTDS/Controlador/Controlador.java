package ProyectoTDS.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ProyectoTDS.LogicaNegocio.App;
import ProyectoTDS.LogicaNegocio.Cancion;

public class Controlador {
	//Patron singleton
	private static Controlador Controlador = null; 
	
	
	private ProyectoTDS.LogicaNegocio.AppMusic AppMusic;

	private Controlador() {
		super();
	}
	
	public static Controlador getUnicaInstancia() {
		if (Controlador == null) {
			Controlador = new Controlador();
			Controlador.AppMusic = ProyectoTDS.LogicaNegocio.AppMusic.getUnicaInstancia();
		}
		return Controlador;
	}
	public boolean ComprobarLoginUsuario(String usuario, String password) {
		return AppMusic.comprobarLoginUsuario(usuario, password);
	}

	public boolean RegistroUsuario(String usuario, String contrasena, String repite, String nombre, String apellidos, String fechaNacimiento, String email) {
		return AppMusic.RegistroUsuario(usuario, contrasena, repite, nombre, apellidos, fechaNacimiento, email);
	}
	
	public String getUsuarioActivo() {
		return AppMusic.getUsuarioActivo();
	}
	
	public void logout() {
		AppMusic.logout();
	}
	
	public ArrayList<List<String>> buscarCanciones(String Titulo ,String Interprete,String  Estilo) {
		return AppMusic.buscarCanciones(Titulo, Interprete, Estilo);
	};
	
	public Set<String> cargarMisListas(){
		return AppMusic.cargarMisListas();
	}
	
	public ArrayList<List<String>> getCancionesLista(String lista) {
		return AppMusic.getCancionesLista(lista);
	};
	
	public boolean crearPlaylist(String nombre) {
		return AppMusic.crearPlaylist(nombre);
	}
	
	public boolean insertarCancionEnPlaylist(String playlistMostrada, String cancion, String interprete) {
		return AppMusic.insertarCancionEnPlaylist(playlistMostrada, cancion, interprete);
	}
	
	public boolean borrarCancionDePlaylist(String playlistMostrada,String  cancion,String  interprete) {
		return AppMusic.borrarCancionDePlaylist(playlistMostrada, cancion, interprete);
	}
	
	public boolean eliminarPlaylist(String nombre) {
		return AppMusic.eliminarPlaylist(nombre);
	}
	
}
