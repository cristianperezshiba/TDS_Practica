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
		//Expresiones Regulares que se usaran para los filtros la (?i) es para no discriminar entre mayusculas y minusculas
		String patronTitulo;
		if (Titulo == null) patronTitulo = "(?i)(.*)";
		else patronTitulo = "(?i)(.*)"+Titulo+"(.*)";
		
		String patronInterprete;
		if (Interprete == null) patronInterprete = "(?i)(.*)";
		else patronInterprete = "(?i)(.*)"+Interprete+"(.*)";
		
		String patronEstilo;
		if (Estilo.equals("TODOS")) patronEstilo = "(?i)(.*)";
		else patronEstilo = "(?i)(.*)"+Estilo+"(.*)";

		Set<Cancion> matching = listaCanciones.stream()
		                            .filter(c -> c.getTitulo().matches(patronTitulo))
		                            .filter(c -> c.getInterprete().getNombre().matches(patronInterprete))
		                            .filter(c -> c.getEstilo().toString().matches(patronEstilo))
		                            .collect(toSet());
		/*
		System.out.println("Parametros búsqueda (titulo, interprete, estilo): " + Titulo + " " + Interprete + " " + Estilo);
		System.out.println("Catalogo canciones: Canciones matching tras hacer busqueda:");
		for (Cancion cancion : matching) {
			System.out.println("		" + cancion.getTitulo() + ", " + cancion.getInterprete() + ", " + cancion.getEstilo());
		}
		*/ 
		
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
