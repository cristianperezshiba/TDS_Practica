package ProyectoTDS.Controlador;

public class Controlador {
	//Patron singleton
	private static Controlador Controlador = null; 
	
	
	private ProyectoTDS.LogicaNegocio.AppMusic AppMusic;

	private Controlador() {
		super();
	}
	
	public static Controlador getUnicaInstancia() {
		if (Controlador == null) {
			Controlador = new Controlador();
			Controlador.AppMusic = ProyectoTDS.LogicaNegocio.AppMusic.getUnicaInstancia();
		}
		return Controlador;
	}
	public boolean ComprobarLoginUsuario(String usuario, String password) {
		return AppMusic.comprobarLoginUsuario(usuario, password);
	}

	public boolean RegistroUsuario(String usuario, String contrasena, String nombre, String apellidos, String fechaNacimiento, String email) {
		return AppMusic.RegistroUsuario(usuario, contrasena, nombre, apellidos, fechaNacimiento, email);
	}
	
	public String getUsuarioActivo() {
		return AppMusic.getUsuarioActivo();
	}
	
	
	
}
