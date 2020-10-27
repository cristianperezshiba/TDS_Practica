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
	
	public boolean registrarUsuario(String usuario, String contrasena, String nombre, String apellidos, String fechaNacimiento, String email) {
		
		Usuario usuarioNuevo = new Usuario(usuario, contrasena, nombre, apellidos, fechaNacimiento, email);
		
		//Si ya hay una persona con el mismo Usuario o el mismo email entonces no dejamos que se registre
		
		if (listaUsuarios.stream().anyMatch(
				u -> (usuarioNuevo.getUsuario().equals(u.getUsuario()) || usuarioNuevo.getEmail().equals(u.getEmail()))
				)) return false;
		
		return listaUsuarios.add(usuarioNuevo);
		
	}
	
	
}
