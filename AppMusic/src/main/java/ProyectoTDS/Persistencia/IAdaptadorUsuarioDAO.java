package ProyectoTDS.Persistencia;

import java.util.List;

import ProyectoTDS.LogicaNegocio.Usuario;

public interface IAdaptadorUsuarioDAO {

	public void registrarUsuario(Usuario usuario);
	public void borrarUsuario(Usuario usuario);
	public Usuario recuperarUsuario(int codigo);
	public List<Usuario> recuperarTodosLosUsuarios();
	public void modificarUsuario(Usuario usuario);
}
