package ProyectoTDS.LogicaNegocio;

public class Cancion {
	private String titulo;
	private Interprete interprete;
	private EstiloMusical estilo;
	private String rutaFichero;
	private int numReproducciones;
	
	public Cancion(String titulo, Interprete interprete, EstiloMusical estilo, String rutaFichero) {
		super();
		this.titulo = titulo;
		this.interprete = interprete;
		this.estilo = estilo;
		this.rutaFichero = rutaFichero;
		this.numReproducciones = 0;
	}

	
	//TODO: �Generamos solo los getters o tanto los getters como los setters?
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Interprete getInterprete() {
		return interprete;
	}

	public void setInterprete(Interprete interprete) {
		this.interprete = interprete;
	}

	public EstiloMusical getEstilo() {
		return estilo;
	}

	public void setEstilo(EstiloMusical estilo) {
		this.estilo = estilo;
	}

	public String getRutaFichero() {
		return rutaFichero;
	}

	public void setRutaFichero(String rutaFichero) {
		this.rutaFichero = rutaFichero;
	}
	
	public int numReproducciones() {
		return numReproducciones;
	}
	
	
	
	
}
