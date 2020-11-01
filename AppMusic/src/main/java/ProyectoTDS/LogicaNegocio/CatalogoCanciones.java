package ProyectoTDS.LogicaNegocio;
import static java.util.stream.Collectors.*;
import java.util.*;

public class CatalogoCanciones {
	//Usar patron singleton �?
	private Set<Cancion> listaCanciones;

	public CatalogoCanciones() {
		super();
		this.listaCanciones = new LinkedHashSet<Cancion>();
		
	}
	
	
	
	//Busqueda en la lista de canciones por estilo musical
	public List<Cancion> buscarCancionPorEstilo(EstiloMusical e){
		return listaCanciones.stream()
			.filter(c -> c.getEstilo() == e)
			.collect(toList());
	}
	
	//Busqueda en la lista de canciones por titulo (subcadena)
	public List<Cancion> buscarCancionPorTitulo(String titulo){
		return listaCanciones.stream()
			.filter(c -> c.getInterprete().getNombre().contains(titulo))
			.collect(toList());
	}
	
	//Busqueda en la lista de canciones por autor (subcadena)
	public List<Cancion> buscarCancionPorAutor(String autor){
		return listaCanciones.stream()
			.filter(c -> c.getTitulo().contains(autor))
			.collect(toList());
	}
	
	
	
	
}
