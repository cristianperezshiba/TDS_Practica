package ProyectoTDS.LogicaNegocio;

import java.io.File;
import javafx.scene.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



public enum Reproductor {
		INSTANCE;
		static MediaPlayer mediaPlayer;
		Reproductor() {}
		public static boolean reproduciendo = false; //Esta variable es para controlar si al darle al play a una nueva canción ya estabamos reproduciendo una anteriormente
		
		public static void reproducirCancion(Cancion cancion) {
			// activar reproductor
			if (reproduciendo) mediaPlayer.pause();
			try {
			com.sun.javafx.application.PlatformImpl.startup(()->{});
			} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception: " + ex.getMessage());
			 }
		
			cancion.sumarReproduccionCancion();
			// reproducir una canción
			String fileName = cancion.getRutaFichero();
			String pathLocal = System.getProperty("user.dir");
			File f = new File(pathLocal +fileName);
			System.out.println("Ruta fichero mp3 que intentaremos abrir: " + f.toURI().toString());
			Media hit = new Media(f.toURI().toString());
			mediaPlayer = new  MediaPlayer(hit); 
			mediaPlayer.play();
			reproduciendo = true;
		}
		
		public static void pausarCancion() {
			mediaPlayer.pause();
		}

}
