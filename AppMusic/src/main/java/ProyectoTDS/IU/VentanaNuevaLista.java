package ProyectoTDS.IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class VentanaNuevaLista extends JFrame {

	private JPanel contentPane;
	private ProyectoTDS.LogicaNegocio.ControladorAppMusic controlador;
	private JTable tableIzq;
	private JTable tableDcha;
	private JTextField textFieldNombrePlaylist;
	private String playlistMostrada;
	private String ultimaPlaylistCreada;
	
	public VentanaNuevaLista() {
		setTitle("Ventana nueva lista");
		controlador = ProyectoTDS.LogicaNegocio.ControladorAppMusic.INSTANCE;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 569);
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
		
		JLabel lblInterprete = new JLabel("Interprete:");
		lblInterprete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInterprete.setBounds(420, 99, 89, 14);
		contentPane.add(lblInterprete);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(250, 99, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblEstilo = new JLabel("Estilo:");
		lblEstilo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstilo.setBounds(579, 99, 89, 14);
		contentPane.add(lblEstilo);
		
		JTextField textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(250, 118, 149, 23);
		contentPane.add(textTitulo);
		
		JTextField txtInterprete = new JTextField();
		txtInterprete.setBounds(420, 118, 149, 23);
		contentPane.add(txtInterprete);
		txtInterprete.setColumns(10);
		
		JComboBox comboBoxEstilo = new JComboBox();
		comboBoxEstilo.setBounds(579, 118, 126, 23);
		comboBoxEstilo.addItem("TODOS");
		comboBoxEstilo.addItem("BOLERO");
		comboBoxEstilo.addItem("CANTAUTOR");
		comboBoxEstilo.addItem("CLASICA");
		comboBoxEstilo.addItem("FLAMENCO");
		comboBoxEstilo.addItem("JAZZ");
		comboBoxEstilo.addItem("OPERA");
		comboBoxEstilo.addItem("POP");
		comboBoxEstilo.addItem("ROCK");
		comboBoxEstilo.addItem("ROMANTICA");
		contentPane.add(comboBoxEstilo);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnNuevaLista = new JButton("Nueva lista");
		btnNuevaLista.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNuevaLista.setBounds(39, 93, 117, 44);
		panelLeft.add(btnNuevaLista);
		
		JButton btnReciente = new JButton("Reciente");
		btnReciente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrirVentanaReciente();
				dispose();
			}
		});
		btnReciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReciente.setBounds(39, 158, 117, 44);
		panelLeft.add(btnReciente);
		
		JButton btnMisListas = new JButton("Mis listas");
		btnMisListas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrirVentanaMisListas();
				dispose();
			}
		});
		btnMisListas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMisListas.setBounds(39, 228, 117, 44);
		panelLeft.add(btnMisListas);
		
		JButton btnMejoraCuenta = new JButton("Mejora tu cuenta");
		btnMejoraCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMejoraCuenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.setUsuarioActivoPremium();
			}
		});
		btnMejoraCuenta.setBounds(700, 11, 167, 37);
		contentPane.add(btnMejoraCuenta);


		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.logout();
				abrirVentanaLogin();
				dispose();
				
			}
		});
		
		btnLogout.setBounds(936, 11, 98, 37);
		contentPane.add(btnLogout);
		
		JLabel lblUsuario = new JLabel("Hola " + controlador.getUsuarioActivo() + "!");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUsuario.setBounds(291, 19, 293, 19);
		contentPane.add(lblUsuario);
		
		JScrollPane scrollPaneIzq = new JScrollPane();
		scrollPaneIzq.setBounds(211, 157, 373, 265);
		contentPane.add(scrollPaneIzq);
		
		tableIzq = new JTable();
		scrollPaneIzq.setViewportView(tableIzq);
		
		JScrollPane scrollPaneDcha = new JScrollPane();
		scrollPaneDcha.setBounds(663, 152, 371, 265);
		contentPane.add(scrollPaneDcha);
		
		tableDcha = new JTable();
		scrollPaneDcha.setViewportView(tableDcha);
		
		JButton btnCrear = new JButton("Crear playlist");
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrear.setBounds(652, 59, 111, 31);
		contentPane.add(btnCrear);
		
		textFieldNombrePlaylist = new JTextField();
		textFieldNombrePlaylist.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldNombrePlaylist.setBounds(469, 62, 173, 26);
		contentPane.add(textFieldNombrePlaylist);
		textFieldNombrePlaylist.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.setBounds(738, 107, 133, 40);
		contentPane.add(btnBuscar);
		
		JButton btnDCHA_IZQ = new JButton("<<");
		btnDCHA_IZQ.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDCHA_IZQ.setBounds(594, 283, 59, 48);
		contentPane.add(btnDCHA_IZQ);
		
		JButton btnIZQ_DCHA = new JButton(">>");
		btnIZQ_DCHA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnIZQ_DCHA.setBounds(594, 209, 59, 48);
		contentPane.add(btnIZQ_DCHA);
		
		JButton btnEliminarPlaylist = new JButton("Eliminar playlist");
		btnEliminarPlaylist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarPlaylist.setBounds(783, 59, 126, 31);
		contentPane.add(btnEliminarPlaylist);
	  
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cargarTablaBusqueda(textTitulo.getText() ,txtInterprete.getText(), comboBoxEstilo.getSelectedItem().toString());
			}
		});
		
		btnCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nuevaPlaylist = textFieldNombrePlaylist.getText();
				int reply = JOptionPane.showConfirmDialog(null, "¿Quiere crear una nueva playlist llamada " +nuevaPlaylist + "?", "Crear playlist", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					if (controlador.crearPlaylist(nuevaPlaylist)) {
						JOptionPane.showMessageDialog(null, "Playlist " + nuevaPlaylist + " creada");
						//Cargar tabla playlist a la dcha y la de explorar a la izq
						cargarTablaBusqueda("", "", "TODOS");
						cargarCancionesPlaylist(nuevaPlaylist);
						playlistMostrada = nuevaPlaylist;
						ultimaPlaylistCreada = nuevaPlaylist;
						
						lblInterprete.setVisible(true);
						lblTitulo.setVisible(true);
						lblEstilo.setVisible(true);
						txtInterprete.setVisible(true);
						textTitulo.setVisible(true);
						comboBoxEstilo.setVisible(true);
						tableDcha.setVisible(true);
						tableIzq.setVisible(true);
						btnDCHA_IZQ.setVisible(true);
						btnIZQ_DCHA.setVisible(true);
						btnBuscar.setVisible(true);
						btnAceptar.setVisible(true);
						btnCancelar.setVisible(true);
						scrollPaneDcha.setVisible(true);
						scrollPaneIzq.setVisible(true);
					
					}
					
					else JOptionPane.showMessageDialog(null, "Ya existe una playlist con este nombre", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnExplorar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrirVentanaExplorar();
				dispose();
			}
		});
		
		btnEliminarPlaylist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (playlistMostrada == null) return;
				int reply = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea eliminar la playlist " + playlistMostrada + "?","Confirmar accion", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) { 
					controlador.eliminarPlaylist(playlistMostrada);
					playlistMostrada = null;
					}
			}
		});
		
		btnIZQ_DCHA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Insertar cancion en la playlist
				String selectedData = null;
			    int[] selectedRow = tableIzq.getSelectedRows();
				String cancion = (String) tableIzq.getValueAt(selectedRow[0], 0);
				String interprete = (String) tableIzq.getValueAt(selectedRow[0], 1);
				//System.out.println("Fila selecionada: " + cancion + " " + interprete);
				if (!controlador.insertarCancionEnPlaylist(playlistMostrada, cancion.trim(), interprete.trim())) {
					JOptionPane.showMessageDialog(null, "La cancion no se ha podido insertar", "Error", JOptionPane.ERROR_MESSAGE);
				};
				cargarCancionesPlaylist(playlistMostrada);
			}
		});
		
		btnDCHA_IZQ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Eliminar cancion de la playlist
				String selectedData = null;
			    int[] selectedRow = tableDcha.getSelectedRows();
				String cancion = (String) tableDcha.getValueAt(selectedRow[0], 0);
				String interprete = (String) tableDcha.getValueAt(selectedRow[0], 1);
				//System.out.println("Fila selecionada: " + cancion + " " + interprete);
				if (!controlador.borrarCancionDePlaylist(playlistMostrada, cancion.trim(), interprete.trim())) {
					JOptionPane.showMessageDialog(null, "La cancion no se ha podido eliminar", "Error", JOptionPane.ERROR_MESSAGE);
				};
				cargarCancionesPlaylist(playlistMostrada);
			}
		});
		
		
		JScrollPane scrollPaneListas = new JScrollPane();
		scrollPaneListas.setBounds(10, 283, 181, 138);
		panelLeft.add(scrollPaneListas);
		JTable table_listas = new JTable();
		DefaultTableModel tableModelListas = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Listas"
			}
		);
		Set<String> misListas = controlador.cargarMisListas();
		for  (String s : misListas) {
			Object[] data = new Object[1];
			data[0] = s;
			tableModelListas.addRow(data);
		}
		table_listas.setModel(tableModelListas);
		scrollPaneListas.setViewportView(table_listas);
		
		table_listas.setCellSelectionEnabled(true);
		
		
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Guardar en persistencia la lista que acabamos de crear o directamente guardar todas las playlists
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(461, 450, 136, 38);
		contentPane.add(btnAceptar);
		
		
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ultimaPlaylistCreada != null) controlador.eliminarPlaylist(ultimaPlaylistCreada);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(637, 449, 136, 40);
		contentPane.add(btnCancelar);
		
		JLabel lblTipoCuenta = new JLabel("Tipo de cuenta actual: Basica");
		if (controlador.isUsuarioActivoPremium()) lblTipoCuenta.setText("Tipo de cuenta actual: Premium");
		lblTipoCuenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoCuenta.setBounds(469, 23, 215, 14);
		contentPane.add(lblTipoCuenta);
	    ListSelectionModel cellSelectionModel = table_listas.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	      public void valueChanged(ListSelectionEvent e) {
	        String selectedData = null;
	        int[] selectedRow = table_listas.getSelectedRows();
	        selectedData = (String) table_listas.getValueAt(selectedRow[0], 0);
	        System.out.println("Selected: " + selectedData);

	        
	        ArrayList<List<String>> cancionesEncontradas = controlador.getCancionesLista(selectedData);
	        
			List<String> listaTitulos = cancionesEncontradas.get(0);
			List<String> listaInterpretes = cancionesEncontradas.get(1);
			
			DefaultTableModel tableMode = new DefaultTableModel(null,  new String[] {"Titulo", "Interprete"});
			for(int i=0 ; i<listaTitulos.size(); i++) {
				Object[] data = new Object[2];
				data[0] = listaTitulos.get(i);
				data[1] = listaInterpretes.get(i);
				tableMode.addRow(data);
				}
			tableDcha.setModel(tableMode);
			playlistMostrada = selectedData;
	      }

	    });
	    
		
	    lblInterprete.setVisible(false);
		lblTitulo.setVisible(false);
		lblEstilo.setVisible(false);
		txtInterprete.setVisible(false);
		textTitulo.setVisible(false);
		comboBoxEstilo.setVisible(false);
		tableDcha.setVisible(false);
		tableIzq.setVisible(false);
		btnDCHA_IZQ.setVisible(false);
		btnIZQ_DCHA.setVisible(false);
		btnBuscar.setVisible(false);
		btnAceptar.setVisible(false);
		btnCancelar.setVisible(false);
		scrollPaneDcha.setVisible(false);
		scrollPaneIzq.setVisible(false);
	    
		
		
	}
	
	private void cargarTablaBusqueda(String titulo, String Interprete, String Estilo) {
		ArrayList<List<String>> cancionesEncontradas = controlador.buscarCanciones(titulo, Interprete, Estilo);
		List<String> listaTitulos = cancionesEncontradas.get(0);
		List<String> listaInterpretes = cancionesEncontradas.get(1);
		
		String[] columnas = new String[] {"Titulo", "Interprete"};
		DefaultTableModel tableMode = new DefaultTableModel(null, columnas);
		for(int i=0 ; i<listaTitulos.size(); i++) {
			Object[] data = new Object[2];
			data[0] = listaTitulos.get(i);
			data[1] = listaInterpretes.get(i);
			tableMode.addRow(data);
			}
		tableIzq.setModel(tableMode);
		//scrollPaneIzq.setVisible(true);
		
	}
	
	private void cargarCancionesPlaylist(String playlist) {
		ArrayList<List<String>> canciones = controlador.getCancionesLista(playlist);
		
		List<String> listaTitulos = canciones.get(0);
		List<String> listaInterpretes = canciones.get(1);
		
		String[] columnas = new String[] {"Titulo", "Interprete"};
		DefaultTableModel tableMode = new DefaultTableModel(null, columnas);
		for(int i=0 ; i<listaTitulos.size(); i++) {
			Object[] data = new Object[2];
			data[0] = listaTitulos.get(i);
			data[1] = listaInterpretes.get(i);
			tableMode.addRow(data);
			}
		tableDcha.setModel(tableMode);
		//scrollPaneIzq.setVisible(true);
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
	
	private void abrirVentanaMisListas() {
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
