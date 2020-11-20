package ProyectoTDS.IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import ProyectoTDS.LogicaNegocio.EstiloMusical;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ScrollPaneConstants;
import java.awt.ScrollPane;
import javax.swing.SwingConstants;

public class VentanaMisListas extends JFrame {

	private JPanel contentPane;
	private ProyectoTDS.Controlador.Controlador Controlador;
	private JTable table_listas;
	
	
	public VentanaMisListas() {
		setTitle("Ventana mis listas");
		Controlador = Controlador.getUnicaInstancia();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 570);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.GRAY);
		panelLeft.setBounds(0, 99, 201, 421);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
		JButton btnExplorar = new JButton("Explorar");
		btnExplorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExplorar.setBounds(39, 25, 117, 44);
		panelLeft.add(btnExplorar);
		
		JButton btnNuevaLista = new JButton("Nueva lista");
		btnNuevaLista.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNuevaLista.setBounds(39, 93, 117, 44);
		panelLeft.add(btnNuevaLista);
		btnNuevaLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirVentanaNuevaLista();
				dispose();
			}
		});
		
		JButton btnReciente = new JButton("Reciente");
		btnReciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReciente.setBounds(39, 158, 117, 44);
		panelLeft.add(btnReciente);
		btnReciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirVentanaReciente();
				dispose();
			}
		});
		
		JButton btnMisListas = new JButton("Mis listas");
		btnMisListas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMisListas.setBounds(39, 228, 117, 44);
		panelLeft.add(btnMisListas);
		
		
		
		
		
		JButton btnMejoraCuenta = new JButton("Mejora tu cuenta");
		btnMejoraCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMejoraCuenta.setBounds(433, 11, 167, 37);
		contentPane.add(btnMejoraCuenta);


		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controlador.logout();
				abrirVentanaLogin();
				dispose();
				
			}
		});
		
		btnLogout.setBounds(625, 11, 98, 37);
		contentPane.add(btnLogout);
		
		JLabel lblUsuario = new JLabel("Hola " + Controlador.getUsuarioActivo() + "!");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUsuario.setBounds(106, 19, 293, 19);
		contentPane.add(lblUsuario);
	  
		
		
		btnExplorar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirVentanaExplorar();
				dispose();
			}
		});


		JScrollPane scrollPane = new JScrollPane();
		JTable table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					String nombre = null;
					String artista = null;
					int[] selectedRow = table.getSelectedRows();
					nombre = (String) table.getValueAt(selectedRow[0], 0);
					artista = (String) table.getValueAt(selectedRow[0], 1);
					Controlador.ReproducirCancion(nombre, artista);
				}
			}
		});
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(211, 118, 512, 252);
		contentPane.add(scrollPane);
		String[] columnas = new String[] {"Titulo", "Interprete"};
		table.setModel(new DefaultTableModel(null, columnas));	  
		scrollPane.setViewportView(table);
		scrollPane.setVisible(false); //Por defecto ocultamos el panel con la tabla, cuando nos haga falta lo activaremos
		
		
		
		
		
		
		
		
		JScrollPane scrollPaneListas = new JScrollPane();
		scrollPaneListas.setBounds(10, 283, 181, 138);
		panelLeft.add(scrollPaneListas);
		table_listas = new JTable();
		DefaultTableModel tableModelListas = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Listas"
			}
		);
		Set<String> misListas = Controlador.cargarMisListas();
		for  (String s : misListas) {
			Object[] data = new Object[1];
			data[0] = s;
			tableModelListas.addRow(data);
		}

		table_listas.setModel(tableModelListas);
		scrollPaneListas.setViewportView(table_listas);
		
		table_listas.setCellSelectionEnabled(true);
	    ListSelectionModel cellSelectionModel = table_listas.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	      public void valueChanged(ListSelectionEvent e) {
	        String selectedData = null;
	        int[] selectedRow = table_listas.getSelectedRows();
	        selectedData = (String) table_listas.getValueAt(selectedRow[0], 0);
	        System.out.println("Selected: " + selectedData);

	        
	        ArrayList<List<String>> cancionesEncontradas = Controlador.getCancionesLista(selectedData);
	        
			List<String> listaTitulos = cancionesEncontradas.get(0);
			List<String> listaInterpretes = cancionesEncontradas.get(1);
			
			DefaultTableModel tableMode = new DefaultTableModel(null,  new String[] {"Titulo", "Interprete"}){

			    /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			for(int i=0 ; i<listaTitulos.size(); i++) {
				Object[] data = new Object[2];
				data[0] = listaTitulos.get(i);
				data[1] = listaInterpretes.get(i);
				tableMode.addRow(data);
				}
			table.setModel(tableMode);
			scrollPane.setVisible(true);
	      }

	    });
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				///////////////////////////////////////////////////////////
				String nombre = null;
				String artista = null;
				int[] selectedRow = table.getSelectedRows();
				nombre = (String) table.getValueAt(selectedRow[0], 0);
				artista = (String) table.getValueAt(selectedRow[0], 1);
				Controlador.ReproducirCancion(nombre, artista);

			}
		});
		btnPlay.setBounds(433, 405, 66, 37);
		contentPane.add(btnPlay);

		JButton btnPause = new JButton("Pause");
		btnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controlador.pausarCancion();
			}
		});

		btnPause.setBounds(433, 453, 66, 35);
		contentPane.add(btnPause);

		JButton btnCancionAnterior = new JButton("<<");
		btnCancionAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Coger fila seleccionada y coger la anterior y reproducirla
				String nombre = null;
				String artista = null;
				int[] selectedRow = table.getSelectedRows();
				if (selectedRow[0] == 0)
					return;
				int numFilas = table.getRowCount();
				table.setRowSelectionInterval((selectedRow[0] - 1) % numFilas, (selectedRow[0] - 1) % numFilas);
				nombre = (String) table.getValueAt((selectedRow[0] - 1) % numFilas, 0);
				artista = (String) table.getValueAt((selectedRow[0] - 1) % numFilas, 1);
				Controlador.ReproducirCancion(nombre, artista);
			}
		});
		btnCancionAnterior.setBounds(370, 433, 53, 35);
		contentPane.add(btnCancionAnterior);

		JButton btnCancionSiguiente = new JButton(">>");
		btnCancionSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Coger fila seleccionada y coger la siguiente y reproducirla
				String nombre = null;
				String artista = null;
				int[] selectedRow = table.getSelectedRows();
				if (selectedRow[0] == table.getRowCount() - 1)
					return;
				int numFilas = table.getRowCount();
				table.setRowSelectionInterval((selectedRow[0] + 1) % numFilas, (selectedRow[0] + 1) % numFilas);
				nombre = (String) table.getValueAt((selectedRow[0] + 1) % numFilas, 0);
				artista = (String) table.getValueAt((selectedRow[0] + 1) % numFilas, 1);
				Controlador.ReproducirCancion(nombre, artista);
			}
		});
		btnCancionSiguiente.setBounds(516, 433, 53, 35);
		contentPane.add(btnCancionSiguiente);
		
		JButton btnPdf = new JButton("PDF");
		btnPdf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controlador.generarPdf();
			}
		});
		btnPdf.setBounds(608, 453, 98, 67);
		contentPane.add(btnPdf);
		
		
	}
	
	
	private void abrirVentanaLogin() {
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
	
	private void abrirVentanaExplorar() {
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
	
	private void abrirVentanaNuevaLista() {
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
	
	private void abrirVentanaReciente() {

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
}
