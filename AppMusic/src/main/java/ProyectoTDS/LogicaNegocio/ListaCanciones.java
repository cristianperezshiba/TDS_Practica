package ProyectoTDS.LogicaNegocio;
import java.util.LinkedList;

public class ListaCanciones {
	private String nombre;
	private LinkedList<Cancion> canciones;
	
	
	public ListaCanciones(String nombre) {
		super();
		this.nombre = nombre;
		this.canciones = new LinkedList<Cancion>();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	


	public LinkedList<Cancion> getCanciones() {
		//TODO: �Devolvemos la lista o una copia de ella?
		return canciones;
	}


	
	
	public void addCancion(Cancion cancion) {
		this.canciones.add(cancion);
	}

	

	
	
}
