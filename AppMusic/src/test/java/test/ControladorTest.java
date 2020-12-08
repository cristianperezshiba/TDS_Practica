package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ProyectoTDS.Controlador.Controlador;

public class ControladorTest {

	private Controlador controlador;
	
	@Before
	public void setup() {
		controlador = Controlador.getUnicaInstancia();
	}

	@Test	//Comprobar que un usuario se puede registrar correctamente cuando no existe otro
	public void testRegistroUsuario() {
		//Controlador controlador = Controlador.getUnicaInstancia();
		boolean resultado=controlador.RegistroUsuario("pepito", "1234", "1234", "Pepe", "Hurtado", "03/10/1990", "pepe@gmail.com");
		assertEquals(resultado,true);
		
	}
	
	@Test	//Comprobar que un usuario se puede registrar correctamente cuando ya existro otro idéntico
	public void testRegistroUsuario2() {
		//Controlador controlador = Controlador.getUnicaInstancia();
		boolean resultado=controlador.RegistroUsuario("pepito", "1234", "1234", "Pepe", "Hurtado", "03/10/1990", "pepe@gmail.com");
		assertEquals(resultado,false);
	}
	
	
	@Test	//Comprobar que una vez un usuario se ha registrado, puede acceder a la aplicación
	public void testComprobarLoginUsuario() {
		controlador.RegistroUsuario("joselito", "1234", "1234", "Jose", "Lopez", "03/10/1990", "tujoselito@gmail.com");
		boolean resultado=controlador.ComprobarLoginUsuario("joselito", "1234");
		assertEquals(resultado,true);
	}
	
	@Test	//Comprobar que una vez un usuario introduciendo valores incorrectos no puede acceder a la aplicación
	public void testComprobarLoginUsuario2() {
		controlador.RegistroUsuario("francisquito", "1234", "1234", "Francisco", "Mieres", "23/10/1995", "mieresfrancisco@gmail.com");
		boolean resultado=controlador.ComprobarLoginUsuario("francisquito", "123");
		assertEquals(resultado,false);
	}

}
