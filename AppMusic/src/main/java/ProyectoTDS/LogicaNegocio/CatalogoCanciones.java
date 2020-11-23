package ProyectoTDS.LogicaNegocio;
import static java.util.stream.Collectors.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class CatalogoCanciones {
	//Usar patron singleton �?
	private Set<Cancion> listaCanciones;

	public CatalogoCanciones() {
		super();
		this.listaCanciones = new LinkedHashSet<Cancion>();
		
		//Leemos las canciones de los directorios
		String pathLocal = System.getProperty("user.dir");
		String pathCanciones = pathLocal + File.separator + "Canciones";
		//System.out.println(pathCanciones);
		
		try {
			Files.walk(Paths.get(pathCanciones)).forEach(ruta-> {
			    if (Files.isRegularFile(ruta)) {
			    	
			    	String stringRuta = ruta.toString();
			    	String rutaCancion = stringRuta.replace(pathLocal, ""); //ruta que añadiremos al objeto cancion
			    	//Separamos la cabecera de la ruta y nos quedamos unicamente con "ESTILO\interprete-cancion"
			    	stringRuta = stringRuta.replace(pathCanciones + File.separator, "");

			    	
			    	//Ahora separamos el estilo de interprete-cancion
			    	String[] partes1 = stringRuta.split(Pattern.quote (File.separator));
			    	String estilo = partes1[0];
			    	String titulo_interprete = partes1[1];
			    	//System.out.println(estilo + "  " + titulo_interprete);
			    	//Ahora separamos titulo de interprete
			    	String[] partes2 = titulo_interprete.split("-");
			    	String interprete = partes2[0];
			    	String titulo = partes2[1];
			    	titulo = titulo.replace((".mp3"), "");
			    	//El .trim() es para eliminar los espacios al principio y al final de los arrays
			    	titulo = titulo.trim();
			    	interprete = interprete.trim();
			    	//System.out.println(stringRuta); System.out.println("   " + estilo); System.out.println("   " + interprete); System.out.println("   " + titulo);
			    	EstiloMusical estiloEnum = EstiloMusical.valueOf(estilo);
			    	// Creamos las canciones añadiendolas a la lista 
			    	
			    	listaCanciones.add(new Cancion(titulo, new Interprete(interprete), estiloEnum, rutaCancion));
			    	
			    	
			    	
			    }
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la lectura de las canciones de los directorios (Constructor catalogoCanciones)");
			e.printStackTrace();
			
		}
		

	
		
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
	
	public Cancion buscarCancion(String titulo, String interprete) {
		return listaCanciones.stream()	
							 .filter(c -> c.getTitulo().equals(titulo) && c.getInterprete().getNombre().equals(interprete))
							 .findFirst()
							 .get();
	}
	
	
	
	public void ReproducirCancion(String nombre, String artista, Usuario usuarioActivo) {
		Cancion cancionAreproducir = buscarCancion(nombre, artista);
		Reproductor.reproducirCancion(cancionAreproducir);
		usuarioActivo.nuevaCancionReciente(cancionAreproducir);
		
	} 
	

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
