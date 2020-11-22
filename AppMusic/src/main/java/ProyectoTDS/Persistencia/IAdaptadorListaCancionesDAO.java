package ProyectoTDS.Persistencia;

import java.util.List;
import ProyectoTDS.LogicaNegocio.ListaCanciones;

public interface IAdaptadorListaCancionesDAO {

	public void registrarLista(ListaCanciones lista);
	public void borrarLista(ListaCanciones lista);
	public void modificarLista(ListaCanciones lista);
	public ListaCanciones recuperarLista(int codigo);
}
