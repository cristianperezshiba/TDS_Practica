package ProyectoTDS.LogicaNegocio;

import java.util.*;

public class CatalogoUsuarios {

	//Usar patron singleton �?
	private Set<Usuario> listaUsuarios;
		
	
	public CatalogoUsuarios() {
		super();
		this.listaUsuarios = new LinkedHashSet<Usuario>();
	}

	
	public boolean loginUsuario(String usuario, String password) {
		//Comprobamos si el usuario y el password son correctos mediante un stream
		return listaUsuarios.stream().anyMatch(u -> (usuario.equals(u.getUsuario()) && password.equals(u.getContrasena())));
	}
	
	public boolean registrarUsuario(String usuario, String contrasena, String repite, String nombre, String apellidos, String fechaNacimiento, String email) {
		Usuario usuarioNuevo = new Usuario(usuario, contrasena, nombre, apellidos, fechaNacimiento, email);
		//Si ya hay una persona con el mismo Usuario o el mismo email entonces gracias a que la lista es un Set, y a que hemos añadido los metodos hashCode y equal en la clase usuario,
		//el usuario no se insertará la propia función nos devolverá false
		return listaUsuarios.add(usuarioNuevo);
		
	}
	
	
}
