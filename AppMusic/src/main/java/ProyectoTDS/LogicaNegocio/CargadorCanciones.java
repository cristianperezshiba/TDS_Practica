package ProyectoTDS.LogicaNegocio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class CargadorCanciones {
	public static void cargarCanciones() {
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
					    	
					        CatalogoCanciones.INSTANCE.añadirCancionAcatalogo(new Cancion(titulo, new Interprete(interprete), estiloEnum, rutaCancion));
					    	
					    	
					    	
					    }
					});
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Error en la lectura de las canciones de los directorios (Constructor catalogoCanciones)");
					e.printStackTrace();
					
				}
	}
}
