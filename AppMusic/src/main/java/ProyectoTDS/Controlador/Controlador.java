package ProyectoTDS.Controlador;

public class Controlador {
	//TODO: Usar patron singleton o simplemente usamos metodos estaticos?�?�
	
	private static ProyectoTDS.LogicaNegocio.AppMusic AppMusic;

	public Controlador(ProyectoTDS.LogicaNegocio.AppMusic appMusic) {
		super();
		AppMusic = appMusic;
	}
	
	public static boolean ComprobarLoginUsuario(String usuario, String password) {
		return AppMusic.comprobarLoginUsuario(usuario, password);
	}
	
	public static boolean RegistroUsuario(String usuario, String contrasena, String nombre, String apellidos, String fechaNacimiento, String email) {
		return AppMusic.RegistroUsuario(usuario, contrasena, nombre, apellidos, fechaNacimiento, email);
	}
	
	public static String getUsuarioActivo() {
		return AppMusic.getUsuarioActivo();
	}
	
	
	
}
