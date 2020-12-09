package ProyectoTDS.Persistencia;

public class TDSFactoriaDAO extends FactoriaDAO{
	
	public TDSFactoriaDAO(){
		
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
