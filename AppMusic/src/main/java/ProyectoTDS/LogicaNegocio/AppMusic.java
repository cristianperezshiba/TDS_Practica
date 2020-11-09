package ProyectoTDS.LogicaNegocio;

import java.util.LinkedList;

public class AppMusic {
	//Usamos patron singleton
	private static AppMusic AppMusic = null;
	
	// TODO: private controlador?? Tiene referencia a controlador o no ??
	
	
	private CatalogoCanciones catalogoCanciones;
	private CatalogoUsuarios catalogoUsuarios;
	private LinkedList<Cancion> CancionesMasReproducidas; 
	private String UsuarioActivo;  //Variable que contendra  el usuario activo
	


	private AppMusic() {
		super();
		this.catalogoCanciones = new CatalogoCanciones();
		this.catalogoUsuarios = new CatalogoUsuarios();
		this.CancionesMasReproducidas = new LinkedList<Cancion>();
		this.UsuarioActivo = "";
	}
	
	public static AppMusic getUnicaInstancia() {
		if (AppMusic == null) {
			AppMusic = new AppMusic();
		}
		return AppMusic;
	}

	public CatalogoCanciones getCatalogoCanciones() {
		return catalogoCanciones;
	}

	public CatalogoUsuarios getCatalogoUsuarios() {
		return catalogoUsuarios;
	}

	public String getUsuarioActivo() {
		return UsuarioActivo;
	}

	public void setUsuarioActivo(String usuarioActivo) {
		UsuarioActivo = usuarioActivo;
	}
	
	public void logout() {
		UsuarioActivo = null;
		//Hay que hacer algo mas¿?¿?¿?¿?¿? Supongo que si
	}
	
	public boolean comprobarLoginUsuario(String usuario, String password) {
		if (this.catalogoUsuarios.loginUsuario(usuario, password)){
			this.UsuarioActivo = usuario;
			return true;
		}
		else return false;
	};
	
	public boolean RegistroUsuario(String usuario, String contrasena, String repite, String nombre, String apellidos, String fechaNacimiento, String email) {
		return this.catalogoUsuarios.registrarUsuario(usuario, contrasena, repite, nombre, apellidos, fechaNacimiento, email);
	};
	
	
}
