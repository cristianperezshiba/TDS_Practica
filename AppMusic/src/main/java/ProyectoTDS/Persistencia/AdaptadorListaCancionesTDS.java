package ProyectoTDS.Persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import ProyectoTDS.LogicaNegocio.Cancion;
import ProyectoTDS.LogicaNegocio.ListaCanciones;
import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorListaCancionesTDS implements IAdaptadorListaCancionesDAO{

	private static ServicioPersistencia servPersistencia;
	private static AdaptadorListaCancionesTDS unicaInstancia = null;
	
	public static AdaptadorListaCancionesTDS getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorListaCancionesTDS();
		else
			return unicaInstancia;
	}
	
	private AdaptadorListaCancionesTDS() { 
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia(); 
	}
	
	@Override
	public void registrarLista(ListaCanciones lista) {
		Entidad eListaCanciones;
		boolean existe = true; 
		
		// Si la entidad esta registrada no la vuelve a registrar
		try {
			eListaCanciones = servPersistencia.recuperarEntidad(lista.getCodigo());
		} catch (NullPointerException e) {
			existe = false;
		}
		if (existe) return;

		// registrar primero los atributos que son objetos
		AdaptadorCancionTDS adaptadorCancion = AdaptadorCancionTDS.getUnicaInstancia();
		
		for(Cancion c : lista.getCanciones()) {
			adaptadorCancion.registrarCancion(c);
		}
		
		// crear entidad Lista Canciones
		eListaCanciones = new Entidad();
		eListaCanciones.setNombre("usuario");
		eListaCanciones.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("nombre", lista.getNombre()), 
						new Propiedad("canciones", obtenerCodigosCanciones(lista.getCanciones())))));
		
		// registrar entidad cliente
		eListaCanciones = servPersistencia.registrarEntidad(eListaCanciones);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		lista.setCodigo(eListaCanciones.getId()); 
	}

	@Override
	public void borrarLista(ListaCanciones lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarLista(ListaCanciones lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListaCanciones recuperarLista(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String obtenerCodigosCanciones(Set<Cancion> canciones) {
		String aux = "";
		for (Cancion c : canciones) {
			aux += c.getCodigo() + " ";
		}
		return aux.trim();
	}


}
