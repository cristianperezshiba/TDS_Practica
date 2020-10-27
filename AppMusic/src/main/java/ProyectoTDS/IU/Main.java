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

		//Creamos el objeto appMusic y el objeto Controlador y luego abrimos la ventana del Login 
		ProyectoTDS.LogicaNegocio.AppMusic appMusic = new ProyectoTDS.LogicaNegocio.AppMusic();
		ProyectoTDS.Controlador.Controlador controlador = new ProyectoTDS.Controlador.Controlador(appMusic);
		abrirVentanaLogin();
		
	}

}
