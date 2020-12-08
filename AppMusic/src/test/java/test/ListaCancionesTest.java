package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ProyectoTDS.LogicaNegocio.Cancion;
import ProyectoTDS.LogicaNegocio.EstiloMusical;
import ProyectoTDS.LogicaNegocio.Interprete;
import ProyectoTDS.LogicaNegocio.ListaCanciones;

public class ListaCancionesTest {
	
	private ListaCanciones playlist;
	
	@Before
	public void setup() {
		playlist = new ListaCanciones("lista1");
	}

	@Test
	public void testGetNombre() {
		String resultado = playlist.getNombre();
		assertEquals(resultado, "lista1");
	}

	@Test
	public void testAñadirCancion() {
		Interprete interprete = new Interprete("John");
		Cancion cancion = new Cancion("cancion", interprete, EstiloMusical.CANTAUTOR, "/home");
		boolean resultado = playlist.añadirCancion(cancion);
		assertEquals(resultado, true);
	}

	@Test	//Intentamos eliminar una cancion que no hemos añadido a nuestra playlist
	public void testEliminarCancion() {
		Interprete interprete1 = new Interprete("Frank");
		EstiloMusical bolero = EstiloMusical.BOLERO;
		Cancion cancion1 = new Cancion("cancionnoenlista", interprete1, bolero, "/home");
		boolean resultado = playlist.eliminarCancion(cancion1);
		assertEquals(resultado, false);
	}

}
