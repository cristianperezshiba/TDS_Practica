package ProyectoTDS.LogicaNegocio;
import static java.util.stream.Collectors.*;
import java.io.File;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;


public enum CatalogoCanciones {
	INSTANCE;
	//Uso del patron singleton mediante un enumerado
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
	
	
	public List<Cancion> buscarCanciones(String Titulo ,String Interprete,String  Estilo) {
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

		List<Cancion> matching = listaCanciones.stream()
		                            .filter(c -> c.getTitulo().matches(patronTitulo))
		                            .filter(c -> c.getInterprete().getNombre().matches(patronInterprete))
		                            .filter(c -> c.getEstilo().toString().matches(patronEstilo))
		                            .collect(toList());
		
		return matching;
	};
	
	public Cancion buscarCancion(String titulo, String interprete) {
		return listaCanciones.stream()	
							 .filter(c -> c.getTitulo().equals(titulo) && c.getInterprete().getNombre().equals(interprete))
							 .findFirst()
							 .get();
	}
	
	
	
	public void ReproducirCancion(Cancion cancionAreproducir, Usuario usuarioActivo) {
		Reproductor.reproducirCancion(cancionAreproducir);
		usuarioActivo.nuevaCancionReciente(cancionAreproducir);
		
	} 
	

	public List<Cancion> getCancionesMasReproducidasAppMusic(){
		
		return listaCanciones.stream()
							 .filter(c -> c.getNumReproducciones() > 0)
							 .sorted(Comparator.comparingInt(Cancion::getNumReproducciones).reversed())
							 .limit(10)
							 .collect(toList());
		
							
	}
	
	
	
	
}
