package ProyectoTDS.Persistencia;

import ProyectoTDS.LogicaNegocio.Cancion;

public interface IAdaptadorCancionDAO {
	public void registrarCancion(Cancion cancion);
	public void borrarCancion(Cancion cancion);

}
