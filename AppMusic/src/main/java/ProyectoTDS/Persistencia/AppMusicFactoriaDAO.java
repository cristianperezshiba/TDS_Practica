package ProyectoTDS.Persistencia;

public class AppMusicFactoriaDAO extends FactoriaDAO{
	
	public AppMusicFactoriaDAO () {
	}
	

	@Override
	public IAdaptadorUsuarioDAO getUsuarioDAO() {
		return AdaptadorUsuarioTDS.getUnicaInstancia();
	}

	@Override
	public IAdaptadorListaCancionesDAO getListaCancionesDAO() {
		return AdaptadorListaCancionesTDS.getUnicaInstancia();
	}

}
