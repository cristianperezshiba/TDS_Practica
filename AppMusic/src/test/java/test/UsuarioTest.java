package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ProyectoTDS.LogicaNegocio.Cancion;
import ProyectoTDS.LogicaNegocio.EstiloMusical;
import ProyectoTDS.LogicaNegocio.Interprete;
import ProyectoTDS.LogicaNegocio.Usuario;

public class UsuarioTest {
	
	private Usuario usuario;
	
	@Before
	public void setup() {
		usuario = new Usuario("joselito34", "1234", "Jose", "Martinez", "07/08/1999", "joselitohd@gmail.com");
	}

	@Test
	public void testEliminarPlaylist() {
		usuario.crearNuevaPlaylist("playlistexiste");
		boolean resultado = usuario.eliminarPlaylist("playlistexiste");
		assertEquals(resultado,true);
	}
	
	@Test
	public void testisPremium() {
		usuario.setPremium(true);
		boolean resultado = usuario.isPremium();
		assertEquals(resultado,true);
	}
	
	@Test
	public void testgetApellidos() {
		String resultado = usuario.getApellidos();
		assertEquals(resultado, "Martinez");
	}

	@Test
	public void testCancionesRecientes() {
		Interprete interprete1 = new Interprete("Frank");
		EstiloMusical bolero = EstiloMusical.BOLERO;
		Cancion cancion1 = new Cancion("cancion1", interprete1, bolero, "/home");
		Cancion cancion2 = new Cancion("cancion2", interprete1, EstiloMusical.CANTAUTOR, "/home");
		usuario.nuevaCancionReciente(cancion1);
		usuario.nuevaCancionReciente(cancion2);
		List<Cancion> resultado = usuario.getCancionesRecientes();
		assertEquals(resultado.size(), 2);
	}
	
}
