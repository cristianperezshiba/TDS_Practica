package ProyectoTDS.Persistencia;

import ProyectoTDS.LogicaNegocio.Usuario;

public interface IAdaptadorUsuarioDAO {

	public void registrarUsuario(Usuario usuario);
	public void borrarUsuario(Usuario usuario);
	public Usuario recuperarUsuario(int codigo);
}
