package ProyectoTDS.IU;

import java.awt.EventQueue;

public class Main {
	
	private static void abrirVentanaLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {

		//Creamos el objeto Controlador, que creara automaticamente el objeto AppMusic
		//y luego abrimos la ventana del Login 
		//ProyectoTDS.LogicaNegocio.AppMusic appMusic = ProyectoTDS.LogicaNegocio.AppMusic.getUnicaInstancia();
		ProyectoTDS.LogicaNegocio.ControladorAppMusic controlador = ProyectoTDS.LogicaNegocio.ControladorAppMusic.INSTANCE;
		controlador.cargarCanciones();
		abrirVentanaLogin();
		
	}

}
