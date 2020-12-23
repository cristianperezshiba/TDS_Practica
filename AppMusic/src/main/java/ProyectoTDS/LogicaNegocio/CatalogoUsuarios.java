package ProyectoTDS.LogicaNegocio;

import java.util.*;

import ProyectoTDS.Persistencia.DAOException;
import ProyectoTDS.Persistencia.FactoriaDAO;
import ProyectoTDS.Persistencia.IAdaptadorUsuarioDAO;


public class CatalogoUsuarios {

	//Usar patron singleton �?
	private Set<Usuario> listaUsuarios;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	
		
	
	public CatalogoUsuarios() {
		super();
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
		return listaUsuarios.stream().anyMatch(u -> (usuario.equals(u.getUsuario()) && password.equals(u.getContrasena())));
	}
	
	public boolean registrarUsuario(String usuario, String contrasena, String repite, String nombre, String apellidos, String fechaNacimiento, String email) {
		Usuario usuarioNuevo = new Usuario(usuario, contrasena, nombre, apellidos, fechaNacimiento, email);
		adaptadorUsuario.registrarUsuario(usuarioNuevo);
		//Si ya hay una persona con el mismo Usuario o el mismo email entonces gracias a que la lista es un Set, y a que hemos añadido los metodos hashCode y equal en la clase usuario,
		//el usuario no se insertará la propia función nos devolverá false
		return listaUsuarios.add(usuarioNuevo);
		
	}
	
	public Usuario buscarObjetoUsuario(String usuario) {
		//Buscamos el objeto usuario a partir de su String usuario
		return listaUsuarios.stream().filter(u -> (usuario.equals(u.getUsuario()))).findFirst().get();
	}
	
	
	
	
}
