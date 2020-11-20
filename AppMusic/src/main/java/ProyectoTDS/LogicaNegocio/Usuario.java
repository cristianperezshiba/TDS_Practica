package ProyectoTDS.LogicaNegocio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Arrays;

public class Usuario {

	static final int TAM_COLA_CANCIONES_RECIENTES = 10;

	private String usuario;
	private String contrasena;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String email;
	private boolean premium;
	private Set<ListaCanciones> playlists;

	private List<Cancion> cancionesRecientes;

	private List<ArrayList<Object>> cancionesMasReproducidas; // Cada elemento será un par (cancion,
																// numVecesReproducida)

	public Usuario(String usuario, String contrasena, String nombre, String apellidos, String fechaNacimiento,
			String email) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.premium = false;
		this.playlists = new LinkedHashSet<ListaCanciones>();
		this.cancionesRecientes = new LinkedList<Cancion>();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public Set<String> getNombrePlaylists() {
		return playlists.stream().map(p -> p.getNombre()).collect(Collectors.toSet());
	}

	public boolean crearNuevaPlaylist(String nombre) {
		return this.playlists.add(new ListaCanciones(nombre));
	}

	public boolean añadirCancionAPlaylist(String lista, Cancion cancion) {
		return this.playlists.stream().filter(l -> l.getNombre().equals(lista)).findFirst().get()
				.añadirCancion(cancion);
	}

	public boolean borrarCancionDePlaylist(String playlist, Cancion cancion) {
		return this.playlists.stream().filter(l -> l.getNombre().equals(playlist)).findFirst().get()
				.eliminarCancion(cancion);
	}

	public Set<Cancion> getCancionesPlaylist(String lista) {
		return playlists.stream().filter(p -> p.getNombre().equals(lista)).findFirst().get().getCanciones();

	}

	public boolean eliminarPlaylist(String nombrePlaylist) {
		ListaCanciones lista = playlists.stream().filter(p -> p.getNombre().equals(nombrePlaylist)).findFirst().get();
		return playlists.remove(lista);
	}

	public void nuevaCancionReciente(Cancion cancion) {
		if (cancion == null || cancionesRecientes.contains(cancion))
			return;
		else if (cancionesRecientes.size() >= TAM_COLA_CANCIONES_RECIENTES) {
			cancionesRecientes.remove(cancionesRecientes.size() - 1);
		}
		cancionesRecientes.add(0, cancion);
	}

	public List<Cancion> getCancionesRecientes() {
		return cancionesRecientes;

	}

	public void crearPDF() throws DocumentException {

		String archivo = System.getProperty("user.dir") + "/playlists.pdf";
		// Declaramos un documento como un objecto Document.
		Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);
		// writer es declarado como el método utilizado para escribir en el archivo.
		PdfWriter writer = null;

		try {
			// Obtenemos la instancia del archivo a utilizar.
			writer = PdfWriter.getInstance(documento, new FileOutputStream(archivo));
		} catch (FileNotFoundException | DocumentException ex) {
			ex.getMessage();
		}

		// Agregamos un título al documento.
		documento.addTitle("ARCHIVO PDF GENERADO DESDE JAVA");

		// Abrimos el documento a editar.
		documento.open();

		try {
			// Obtenemos la instancia de la imagen/logo.
			Image imagen = Image.getInstance("..\\imagenes\\LOGO.png");
			// Alineamos la imagen al centro del documento.
			imagen.setAlignment(Image.ALIGN_CENTER);
			// Agregamos la imagen al documento.
			documento.add(imagen);
		} catch (IOException | DocumentException ex) {
			ex.getMessage();
		}

		// Creamos un párrafo nuevo llamado "vacio1" para espaciar los elementos.
		Paragraph vacio1 = new Paragraph();
		vacio1.add("\n\n");
		documento.add(vacio1);

		// Declaramos un texto como Paragraph. Le podemos dar formato alineado, tamaño,
		// color, etc.
		Paragraph titulo = new Paragraph();
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		titulo.setFont(FontFactory.getFont("Times New Roman", 24, Font.BOLD, BaseColor.BLACK));
		titulo.add("Tus playlists");

		try {
			// Agregamos el texto al documento.
			documento.add(titulo);
		} catch (DocumentException ex) {
			ex.getMessage();
		}

		// Creamos un párrafo nuevo llamado "saltolinea" simulando un salto de linea
		// para espaciar
		// los elementos del PDF.
		Paragraph saltolinea = new Paragraph();
		saltolinea.add("\n\n");
		documento.add(saltolinea);

		// Creamos un párrafo llamado "parrafo" donde irá el contenido del PDF.
		Paragraph parrafo = new Paragraph();
		for (ListaCanciones lista : playlists) {
			parrafo = new Paragraph();
			parrafo.setAlignment(Paragraph.ALIGN_LEFT);
			parrafo.setFont(FontFactory.getFont("Times New Roman", 15, Font.BOLD, BaseColor.BLACK));
			// Añadimos al párrafo "parrafo" el nombre de la playlists.
			parrafo.add(lista.getNombre() + "\n");
			// Añadimos ese párrafo "parrafo" al documento "documento".
			for (Cancion cancion : lista.getCanciones()) {
				parrafo.setFont(FontFactory.getFont("Times New Roman", 12, Font.ITALIC, BaseColor.BLACK));
				parrafo.add("	" + cancion.getTitulo() + ", " + cancion.getInterprete().getNombre() + ", "
						+ cancion.getEstilo().toString() + "\n");
			}
			parrafo.add("\n");
			documento.add(parrafo);
		}

		// Cerramos el documento.
		documento.close();
		// Cerramos el writer.
		writer.close();
	}

	public void nuevaCancionReproducida(Cancion nuevaCancion) {
		//TODO: No estoy seguro de si esto funcionara bien, mucho lio con referencias
		ArrayList<Object> DuplaValores = cancionesMasReproducidas.stream()	
								.filter(l -> l.get(0).equals(nuevaCancion))
								.findFirst().get();
		if (DuplaValores.isEmpty()) {
			ArrayList<Object> nuevaDuplaValores = new ArrayList<Object>();
			nuevaDuplaValores.add(0, nuevaCancion);
			nuevaDuplaValores.add(1, 1);
			cancionesMasReproducidas.add(nuevaDuplaValores);
		}
		else {
			DuplaValores.set(1,(int)DuplaValores.get(1) + 1);
		}
	};
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
