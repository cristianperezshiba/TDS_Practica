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
	

	

	
	
}
