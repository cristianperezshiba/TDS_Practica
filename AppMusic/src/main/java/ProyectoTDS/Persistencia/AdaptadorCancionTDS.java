package ProyectoTDS.Persistencia;

import java.util.ArrayList;
import java.util.Arrays;

import ProyectoTDS.LogicaNegocio.Cancion;
import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorCancionTDS implements IAdaptadorCancionDAO{

	private static ServicioPersistencia servPersistencia;
	private static AdaptadorCancionTDS unicaInstancia = null;

	public static AdaptadorCancionTDS getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null) {
			return new AdaptadorCancionTDS();
		} else
			return unicaInstancia;
	}

	private AdaptadorCancionTDS() { 
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	@Override
	public void registrarCancion(Cancion cancion) {
		Entidad eCancion = null;
		// Si la entidad est� registrada no la registra de nuevo
		boolean existe = true; 
		try {
			eCancion = servPersistencia.recuperarEntidad(cancion.getCodigo());
		} catch (NullPointerException e) {
			existe = false;
		}
		if (existe) return;
		
		// crear entidad cancion
		eCancion = new Entidad();
		eCancion.setNombre("cancion");
		eCancion.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("titulo", cancion.getTitulo()), new Propiedad("interprete", cancion.getInterprete().getNombre()), 
						new Propiedad("estilo", cancion.getEstilo().toString()), new Propiedad("rutaFichero", cancion.getRutaFichero()), 
						new Propiedad("numReproducciones", String.valueOf(cancion.numReproducciones())))));
		
		// registrar entidad producto
		eCancion = servPersistencia.registrarEntidad(eCancion);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		cancion.setCodigo(eCancion.getId());  
		
	}

	@Override
	public void borrarCancion(Cancion cancion) {
		// TODO Auto-generated method stub
		
	}

}
