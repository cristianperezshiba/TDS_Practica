package ProyectoTDS.Persistencia;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import ProyectoTDS.LogicaNegocio.Cancion;
import ProyectoTDS.LogicaNegocio.ListaCanciones;
import ProyectoTDS.LogicaNegocio.Usuario;
import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorUsuarioTDS implements IAdaptadorUsuarioDAO{
	
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorUsuarioTDS unicaInstancia=null;

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
		
		//Igual con las canciones mas reproducidas
			
		
		// crear entidad Cliente
		eUsuario = new Entidad();
		eUsuario.setNombre("usuario");
		eUsuario.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("usuario", usuario.getUsuario()), new Propiedad("contrasena", usuario.getContrasena()),
						new Propiedad("nombre", usuario.getNombre()), new Propiedad("apellidos", usuario.getApellidos()), 
						new Propiedad("fechaNacimiento", usuario.getFechaNacimiento()), new Propiedad("email", usuario.getEmail()),
						new Propiedad("premium", Boolean.toString(usuario.isPremium())), 
						new Propiedad("listaCanciones", obtenerCodigosPlaylists(usuario.getPlaylists())),
						new Propiedad("cancionesRecientes", obtenerCodigosCancionesRecientes(usuario.getCancionesRecientes())))));
						//new Propiedad("cancionesMasReproducidas", obtenerCodigosCancionesMasReproducidas(usuario.getCancionesMasReproducidas()))
						//)));
		
		// registrar entidad cliente
		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		usuario.setCodigo(eUsuario.getId()); 
		
	}


	@Override
	public void borrarUsuario(Usuario usuario) {
		Entidad eUsuario;
		try{
			eUsuario = servPersistencia.recuperarEntidad(usuario.getCodigo());
		} catch(NullPointerException e) {return;}
		
		AdaptadorListaCancionesTDS adaptadorListaCanciones = AdaptadorListaCancionesTDS.getUnicaInstancia();
		for (ListaCanciones listaCanciones : usuario.getPlaylists()) {
				ListaCanciones lista = (ListaCanciones) listaCanciones;
				adaptadorListaCanciones.borrarLista(lista);
		}
		servPersistencia.borrarEntidad(eUsuario);
	}

	@Override
	public Usuario recuperarUsuario(int codigo) {
		// TODO Auto-generated method stub
		
		// Si la entidad est� en el pool la devuelve directamente
		if (PoolDAO.getUnicaInstancia().contiene(codigo))
			return (Usuario) PoolDAO.getUnicaInstancia().getObjeto(codigo);

		// si no, la recupera de la base de datos
		
		String usuario = null;
		String contrasena = null;
		String nombre = null;
		String apellidos = null;
		String fechaNacimiento = null;
		String email = null;
		boolean premium = false;
		Set<ListaCanciones> playlists;

		List<Cancion> cancionesRecientes;

		List<ArrayList<Object>> cancionesMasReproducidas;
		// recuperar entidad
		Entidad eUsuario = servPersistencia.recuperarEntidad(codigo);
		
		try {
			premium = Boolean.parseBoolean(servPersistencia.recuperarPropiedadEntidad(eUsuario, "premium"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		// recuperar propiedades que no son objetos
		Usuario persona = new Usuario(usuario, contrasena, nombre, apellidos, fechaNacimiento, email);
		persona.setCodigo(codigo);
		persona.setPremium(premium);
		persona.setUsuario(servPersistencia.recuperarPropiedadEntidad(eUsuario, "usuario"));
		persona.setContrasena(servPersistencia.recuperarPropiedadEntidad(eUsuario, "contrasena"));
		persona.setNombre(servPersistencia.recuperarPropiedadEntidad(eUsuario, "nombre"));
		persona.setApellidos(servPersistencia.recuperarPropiedadEntidad(eUsuario, "apellidos"));
		persona.setFechaNacimiento(servPersistencia.recuperarPropiedadEntidad(eUsuario, "fechaNacimiento"));
		persona.setEmail(servPersistencia.recuperarPropiedadEntidad(eUsuario, "email"));
		
		PoolDAO.getUnicaInstancia().addObjeto(codigo, persona);
		
		AdaptadorListaCancionesTDS adaptadorListaCanciones = AdaptadorListaCancionesTDS.getUnicaInstancia();
		playlists = obtenerListaCancionesDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(eUsuario, "listaCanciones"));
		
		cancionesRecientes = obtenerCancionesRecientesDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(eUsuario, "listaCanciones"));
		for (Cancion c: cancionesRecientes) {
			persona.nuevaCancionReciente(c);
		}
		
		return persona;
	}
	
	@Override
	public List<Usuario> recuperarTodosLosUsuarios() {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		List<Entidad> eUsuarios = servPersistencia.recuperarEntidades("Usuario");
		
		for (Entidad usuario : eUsuarios) {
			usuarios.add(recuperarUsuario(usuario.getId()));
		}
		return usuarios;
	}

	private String obtenerCodigosPlaylists(Set<ListaCanciones> set) {
		String aux = "";
		for (ListaCanciones lc : set) {
			aux += lc.getCodigo() + " ";
		}
		return aux.trim();
	}
	
	private Set<ListaCanciones> obtenerListaCancionesDesdeCodigos(String lista) {

		Set<ListaCanciones> listaCanciones = null;
		StringTokenizer strTok = new StringTokenizer(lista, " ");
		AdaptadorListaCancionesTDS adaptadorLC = AdaptadorListaCancionesTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			listaCanciones.add(adaptadorLC.recuperarLista(Integer.valueOf((String) strTok.nextElement())));
		}
		return listaCanciones;
	}
	
	private String obtenerCodigosCancionesRecientes(List<Cancion> cancionesRecientes) {
		String aux = "";
		for (Cancion lc : cancionesRecientes) {
			aux += lc.getCodigo() + " ";
		}
		return aux.trim();
	}
	
	private List<Cancion> obtenerCancionesRecientesDesdeCodigos(String lista){
		List<Cancion> cancionesRecientes = null;
		StringTokenizer strTok = new StringTokenizer(lista, " ");
		AdaptadorCancionTDS adaptadorCR = AdaptadorCancionTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			cancionesRecientes.add(adaptadorCR.recuperarCancion(Integer.valueOf((String) strTok.nextElement())));
		}
		return cancionesRecientes;
	}
	
	private String obtenerCodigosCancionesMasReproducidas(List<ArrayList<Object>> cancionesMasReproducidas) {
		String aux = "";
		for (ArrayList<Object> lc : cancionesMasReproducidas) {
			//aux += lc.getCodigo() + " ";
		}
		return aux.trim();
	}




}
