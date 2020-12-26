package ProyectoTDS.LogicaNegocio;

public class Cancion {
	private int codigo;
	private String titulo;
	private Interprete interprete;
	private EstiloMusical estilo;
	private String rutaFichero;
	private int numReproducciones;
	
	public Cancion(String titulo, Interprete interprete, EstiloMusical estilo, String rutaFichero) {
		super();
		codigo=0;
		this.titulo = titulo;
		this.interprete = interprete;
		this.estilo = estilo;
		this.rutaFichero = rutaFichero;
		this.numReproducciones = 0;
	}

	
	//TODO: �Generamos solo los getters o tanto los getters como los setters?
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getCodigo() {
		return codigo;
	}
	
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
