package ProyectoTDS.LogicaNegocio;

import java.util.LinkedList;

public class AppMusic {
	//Usar patron singleton �?
	
	// TODO: private controlador �?�?��?� Tiene referencia a controlador o no ?��?�
	
	private CatalogoCanciones catalogoCanciones;
	private CatalogoUsuarios catalogoUsuarios;
	private LinkedList<Cancion> CancionesMasReproducidas; 
	private String UsuarioActivo;  //Variable que contendr� el usuario activo
	


	public AppMusic() {
		super();
		this.catalogoCanciones = new CatalogoCanciones();
		this.catalogoUsuarios = new CatalogoUsuarios();
		this.CancionesMasReproducidas = new LinkedList<Cancion>();
		this.UsuarioActivo = "";
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
	
	public boolean comprobarLoginUsuario(String usuario, String password) {
		if (this.catalogoUsuarios.loginUsuario(usuario, password)){
			this.UsuarioActivo = usuario;
			return true;
		}
		else return false;
	};
	
	public boolean RegistroUsuario(String usuario, String contrasena, String nombre, String apellidos, String fechaNacimiento, String email) {
		return this.catalogoUsuarios.registrarUsuario(usuario, contrasena, nombre, apellidos, fechaNacimiento, email);
	};
	
	
}
