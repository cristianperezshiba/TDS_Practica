package ProyectoTDS.LogicaNegocio;
import static java.util.stream.Collectors.*;
import java.util.*;

public class CatalogoCanciones {
	//Usar patron singleton �?
	private Set<Cancion> listaCanciones;

	public CatalogoCanciones() {
		super();
		this.listaCanciones = new LinkedHashSet<Cancion>();
		
		//Canciones para testear
		listaCanciones.add(new Cancion("Zooilogco", new Interprete("Foyone"), EstiloMusical.CANTAUTOR, "/.../.."));
		listaCanciones.add(new Cancion("TituloBolero", new Interprete("INterpreteBolero"), EstiloMusical.BOLERO, "/.Bolero../.."));
		listaCanciones.add(new Cancion("TituloOpera", new Interprete("InterpreteOpera"), EstiloMusical.OPERA, "/..Opera./.."));
		
	}
	
	
	
	public Set<Cancion> buscarCanciones(String Titulo ,String Interprete,String  Estilo) {
		//Expresiones Regulares que se usaran para los filtros
		String patronTitulo = "(.*)"+Titulo+"(.*)";
		String patronInterprete = "(.*)"+Interprete+"(.*)";
		String patronEstilo = "(.*)"+Estilo+"(.*)";

		Set<Cancion> matching = listaCanciones.stream()
		                            .filter(c -> c.getTitulo().matches(patronTitulo))
		                            .filter(c -> c.getInterprete().getNombre().matches(patronInterprete))
		                            .filter(c -> c.getEstilo().toString().matches(patronTitulo))
		                            .collect(toSet());
		
		
		
		return matching;
	};
	
	
	
	
	

	/*
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
	}*/
	
	
	
	
}
