package ProyectoTDS.IU;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ProyectoTDS.LogicaNegocio.Cancion;

public class ServicioVentanas {
	//Clase usada para la funcionalidad compartida entre todas las ventanas
	public static void abrirVentanaLogin() {
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
	
	public static void abrirVentanaMisListas() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMisListas frame = new VentanaMisListas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void abrirVentanaNuevaLista() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevaLista frame = new VentanaNuevaLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void abrirVentanaReciente() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReciente frame = new VentanaReciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void abrirVentanaDescuentos() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDescuentos frame = new VentanaDescuentos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void abrirVentanaRegistro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public static void abrirVentanaExplorar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaExplorar frame = new VentanaExplorar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
