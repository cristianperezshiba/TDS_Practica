package ProyectoTDS.LogicaNegocio;

public final class Cancion {
	private int codigo;
	private final String titulo;
	private final Interprete interprete;
	private final EstiloMusical estilo;
	private final String rutaFichero;
	private int numReproducciones;
	
	public Cancion(String titulo, Interprete interprete, EstiloMusical estilo, String rutaFichero) {
		super();
		this.codigo=0;
		this.titulo = titulo;
		this.interprete = interprete;
		this.estilo = estilo;
		this.rutaFichero = rutaFichero;
		this.numReproducciones = 0;
	}
	

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int c) {
		this.codigo = c;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public Interprete getInterprete() {
		return interprete;
	}

	public EstiloMusical getEstilo() {
		return estilo;
	}


	public String getRutaFichero() {
		return rutaFichero;
	}

	
	public int getNumReproducciones() {
		return numReproducciones;
	}
	
	public void sumarReproduccionCancion() {
		numReproducciones++;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estilo == null) ? 0 : estilo.hashCode());
		result = prime * result + ((interprete == null) ? 0 : interprete.hashCode());
		result = prime * result + ((rutaFichero == null) ? 0 : rutaFichero.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		if (estilo != other.estilo)
			return false;
		if (interprete == null) {
			if (other.interprete != null)
				return false;
		} else if (!interprete.equals(other.interprete))
			return false;
		if (rutaFichero == null) {
			if (other.rutaFichero != null)
				return false;
		} else if (!rutaFichero.equals(other.rutaFichero))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	
	
}
