package ProyectoTDS.IU;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ProyectoTDS.LogicaNegocio.Cancion;

public class ServicioVentanas {
	//Clase usada para la funcionalidad compartida entre todas las ventanas
	public static void abrirVentanaLogin() {
		VentanaLogin frame = new VentanaLogin();
		frame.setVisible(true);
	}
	
	public static void abrirVentanaMisListas() {
		VentanaMisListas frame = new VentanaMisListas();
		frame.setVisible(true);
	}
	
	public static void abrirVentanaNuevaLista() {
		VentanaNuevaLista frame = new VentanaNuevaLista();
		frame.setVisible(true);
	}
	
	public static void abrirVentanaReciente() {
		VentanaReciente frame = new VentanaReciente();
		frame.setVisible(true);
	}
	
	public static void abrirVentanaDescuentos() {
		VentanaDescuentos frame = new VentanaDescuentos();
		frame.setVisible(true);
	}
	
	public static void abrirVentanaRegistro() {
		VentanaRegistro frame = new VentanaRegistro();
		frame.setVisible(true);
	}
	
	

	public static void abrirVentanaExplorar() {
		VentanaExplorar frame = new VentanaExplorar();
		frame.setVisible(true);
	}
	
	public static void cargarCanciones(List<Cancion> listaCanciones, JTable table, JScrollPane scrollPane) {


		DefaultTableModel tableMode = new DefaultTableModel(null, new String[] { "Titulo", "Interprete" }){
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		System.out.println("Canciones a cargar:");
		for (Cancion c : listaCanciones) {

			Object[] data = new Object[2];
			data[0] = c.getTitulo();
			data[1] = c.getInterprete().getNombre();
			System.out.println(" " + data[0]);
			tableMode.addRow(data);
		}
		table.setModel(tableMode);
		scrollPane.setVisible(true);
	}
	
	
}
