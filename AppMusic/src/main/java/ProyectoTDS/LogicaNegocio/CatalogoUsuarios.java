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
	
	public int registrarUsuario(String usuario, String contrasena, String repite, String nombre, String apellidos, String fechaNacimiento, String email) {
		
		//Comprobar si las contraseñas son diferentes
		
		if (!contrasena.equals(repite)) return 1;
		
		if (usuario.length()==0 || contrasena.length()==0 || nombre.length()==0 || apellidos.length()==0 || fechaNacimiento.length()==0 || email.length()==0) return 2;
		
		
		Usuario usuarioNuevo = new Usuario(usuario, contrasena, nombre, apellidos, fechaNacimiento, email);
		
		//Si ya hay una persona con el mismo Usuario o el mismo email entonces no dejamos que se registre
		
		if (listaUsuarios.stream().anyMatch(
				u -> (usuarioNuevo.getUsuario().equals(u.getUsuario()) || usuarioNuevo.getEmail().equals(u.getEmail()))
				)) return 3;
		
		if (listaUsuarios.add(usuarioNuevo)) return 0;
		else return 4;
		
	}
	
	
}
