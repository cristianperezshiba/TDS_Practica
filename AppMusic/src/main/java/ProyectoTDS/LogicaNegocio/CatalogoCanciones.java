package ProyectoTDS.LogicaNegocio;
import static java.util.stream.Collectors.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public enum CatalogoCanciones {
	INSTANCE;
	//Usar patron singleton �?
	private Set<Cancion> listaCanciones;

	private CatalogoCanciones() {
		this.listaCanciones = new LinkedHashSet<Cancion>();		
		}

	public void cargarCanciones() {
		CargadorCanciones.cargarCanciones();
	}
	
	public boolean añadirCancionAcatalogo(Cancion c) {
		return listaCanciones.add(c);
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
	

	public Set<Cancion> getCancionesMasReproducidasAppMusic(){
		
		Set<Cancion> S = listaCanciones.stream()
							 .sorted((c1, c2) -> Integer.compare(c2.getNumReproducciones(), c1.getNumReproducciones()))
							 .limit(10)
							 .collect(toSet());
		
		S.stream().forEachOrdered(c -> System.out.println(c.getTitulo() + "  " + c.getNumReproducciones()));
		
		return S;
							
	}
	
	
	
	
}
