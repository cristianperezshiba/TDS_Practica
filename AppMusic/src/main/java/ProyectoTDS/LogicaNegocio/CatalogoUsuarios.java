package ProyectoTDS.LogicaNegocio;

import java.util.*;
import java.util.stream.Collectors;

import ProyectoTDS.Persistencia.DAOException;
import ProyectoTDS.Persistencia.FactoriaDAO;
import ProyectoTDS.Persistencia.IAdaptadorUsuarioDAO;



public enum CatalogoUsuarios {
	INSTANCE;
	//Uso del patron singleton mediante un enumerado
	private Set<Usuario> listaUsuarios;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	
		
	
	 CatalogoUsuarios() {
		inicializarAdaptador();
		this.listaUsuarios = new LinkedHashSet<Usuario>();
	}

	
	private void inicializarAdaptador() {
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorUsuario = factoria.getUsuarioDAO();
	}


	public boolean loginUsuario(String usuario, String password) {
		//Comprobamos si el usuario y el password son correctos mediante un stream
		//adaptadorUsuario.recuperarUsuario();
		List<Usuario> todosUsuarios = adaptadorUsuario.recuperarTodosLosUsuarios();

		List<Usuario> usuarioLogin = todosUsuarios.stream()
				.filter(u -> u.getUsuario().equals(usuario))
				.collect(Collectors.toList());
		
		if(usuarioLogin.isEmpty()) return false;
		else return true;

		//return listaUsuarios.stream().anyMatch(u -> (usuario.equals(u.getUsuario()) && password.equals(u.getContrasena())));
	}
	
	public boolean registrarUsuario(Usuario nuevoUsuario) {
		adaptadorUsuario.registrarUsuario(nuevoUsuario);
		//Si ya hay una persona con el mismo Usuario o el mismo email entonces gracias a que la lista es un Set, y a que hemos añadido los metodos hashCode y equal en la clase usuario,
		//el usuario no se insertará la propia función nos devolverá false
		return listaUsuarios.add(nuevoUsuario);
		
	}
	
	public Usuario buscarObjetoUsuario(String usuario) {
		//Buscamos el objeto usuario a partir de su String usuario
		List<Usuario> todosLosUsuarios = adaptadorUsuario.recuperarTodosLosUsuarios();
		
		return todosLosUsuarios.stream()
				.filter(u -> u.getUsuario().equals(usuario)).
				findFirst()
				.get();
		//listaUsuarios.stream().filter(u -> (usuario.equals(u.getUsuario()))).findFirst().get();
	}
	
	
	
	
}
