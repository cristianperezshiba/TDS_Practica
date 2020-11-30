package ProyectoTDS.Persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import ProyectoTDS.LogicaNegocio.Cancion;
import ProyectoTDS.LogicaNegocio.ListaCanciones;
import ProyectoTDS.LogicaNegocio.Usuario;
import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorUsuarioTDS implements IAdaptadorUsuarioDAO{
	
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorUsuarioTDS unicaInstancia = null;
	
	public static AdaptadorUsuarioTDS getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorUsuarioTDS();
		else
			return unicaInstancia;
	}
	
	private AdaptadorUsuarioTDS() { 
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia(); 
	}

	@Override
	public void registrarUsuario(Usuario usuario) {
		Entidad eUsuario;
		boolean existe = true; 
		
		// Si la entidad esta registrada no la vuelve a registrar
		try {
			eUsuario = servPersistencia.recuperarEntidad(usuario.getCodigo());
		} catch (NullPointerException e) {
			existe = false;
		}
		if (existe) return;

		// registrar primero los atributos que son objetos
		//TODO hacer el registro de las playlists
		
		AdaptadorListaCancionesTDS adaptadorListaCanciones = AdaptadorListaCancionesTDS.getUnicaInstancia();
		for (ListaCanciones lc : usuario.getPlaylists()) {
			adaptadorListaCanciones.registrarLista(lc);
		}
		
		//Es necesario este registro?? Ya que no estamos registrando una cancion sino una canción reciente
		AdaptadorCancionTDS adaptadorCancion = AdaptadorCancionTDS.getUnicaInstancia();
		for (Cancion c : usuario.getCancionesRecientes()) {
			
		}
		
		//Igual con las canciones mas reproducidas
			
		
		// crear entidad Cliente
		eUsuario = new Entidad();
		eUsuario.setNombre("usuario");
		eUsuario.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("usuario", usuario.getUsuario()), new Propiedad("contrasena", usuario.getContrasena()),
						new Propiedad("nombre", usuario.getNombre()), new Propiedad("apellidos", usuario.getApellidos()), 
						new Propiedad("fechaNacimiento", usuario.getFechaNacimiento()), new Propiedad("email", usuario.getEmail()),
						new Propiedad("premium", Boolean.toString(usuario.isPremium())), 
						new Propiedad("listaCanciones", obtenerCodigosListaCanciones(usuario.getPlaylists())))));
		
		// registrar entidad cliente
		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		usuario.setCodigo(eUsuario.getId()); 
		
	}

	@Override
	public void borrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario recuperarUsuario(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	private String obtenerCodigosListaCanciones(Set<ListaCanciones> set) {
		String aux = "";
		for (ListaCanciones lc : set) {
			aux += lc.getCodigo() + " ";
		}
		return aux.trim();
	}

}