package ProyectoTDS.Persistencia;

import ProyectoTDS.LogicaNegocio.ListaCanciones;
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
		// TODO Auto-generated method stub
		
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

}
