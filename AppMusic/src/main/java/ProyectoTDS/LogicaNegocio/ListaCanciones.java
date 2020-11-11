package ProyectoTDS.LogicaNegocio;
import java.util.*;

public class ListaCanciones {
	private String nombre;
	private Set<Cancion> canciones;
	
	
	public ListaCanciones(String nombre) {
		super();
		this.nombre = nombre;
		this.canciones = new LinkedHashSet<Cancion>();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	


	public Set<Cancion> getCanciones() {
		//TODO: �Devolvemos la lista o una copia de ella?
		return canciones;
	}


	
	
	public void añadirCancion(Cancion cancion) {
		this.canciones.add(cancion);
	}
	
	public void eliminarCancion(Cancion cancion) {
		this.canciones.remove(cancion);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		ListaCanciones other = (ListaCanciones) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	

	

	
	
}
