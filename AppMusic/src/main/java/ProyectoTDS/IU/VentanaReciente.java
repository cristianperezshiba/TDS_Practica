package ProyectoTDS.IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import ProyectoTDS.LogicaNegocio.Cancion;

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

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ScrollPaneConstants;

import java.util.*;

public class VentanaReciente extends JFrame {

	private ProyectoTDS.LogicaNegocio.ControladorAppMusic controlador;
    private List<Cancion> listaCancionesMostradas; 
    
	public VentanaReciente() {
		JButton btnCancionesMasReproducidas = new JButton("Top 10 Hits de AppMusic");
		setTitle("Ventana reciente");
		controlador = ProyectoTDS.LogicaNegocio.ControladorAppMusic.INSTANCE;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 437);
		JPanel contentPane = new JPanel();
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
		btnNuevaLista.addActionListener(event -> {
				ServicioVentanas.abrirVentanaNuevaLista();
				this.setVisible(false);
		});
		btnNuevaLista.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNuevaLista.setBounds(39, 93, 117, 44);
		panelLeft.add(btnNuevaLista);

		JButton btnReciente = new JButton("Reciente");

		btnReciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReciente.setBounds(39, 158, 117, 44);
		panelLeft.add(btnReciente);

		JButton btnMisListas = new JButton("Mis listas");
		btnMisListas.addActionListener(event -> {
				ServicioVentanas.abrirVentanaMisListas();
				this.setVisible(false);
		});
		btnMisListas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMisListas.setBounds(39, 228, 117, 44);
		panelLeft.add(btnMisListas);

		JLabel lblTipoCuenta = new JLabel("Tipo de cuenta actual: Basica");
		if (controlador.isUsuarioActivoPremium()) lblTipoCuenta.setText("Tipo de cuenta actual: Premium");
		lblTipoCuenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoCuenta.setBounds(418, 59, 216, 14);
		contentPane.add(lblTipoCuenta);
		
		JButton btnMejoraCuenta = new JButton("Mejora tu cuenta");
		btnMejoraCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMejoraCuenta.addActionListener(event -> {
				ServicioVentanas.abrirVentanaDescuentos();
				controlador.setUsuarioActivoPremium();	
				lblTipoCuenta.setText("Tipo de cuenta actual: Premium");
				btnCancionesMasReproducidas.setEnabled(true);
		});
		btnMejoraCuenta.setBounds(433, 11, 167, 37);
		contentPane.add(btnMejoraCuenta);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.addActionListener(event -> {
				controlador.logout();
				ServicioVentanas.abrirVentanaLogin();
				this.setVisible(false);
		});

		btnLogout.setBounds(625, 11, 98, 37);
		contentPane.add(btnLogout);

		JLabel lblUsuario = new JLabel("Hola " + controlador.getUsuarioActivo() + "!");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUsuario.setBounds(106, 19, 293, 19);
		contentPane.add(lblUsuario);

		btnExplorar.addActionListener(event -> {
				ServicioVentanas.abrirVentanaExplorar();
				this.setVisible(false);
		});

		JScrollPane scrollPane = new JScrollPane();
		JTable table = new JTable();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					int[] selectedRow = table.getSelectedRows();
					String nombre = (String) table.getValueAt(selectedRow[0], 0);
					String artista = (String) table.getValueAt(selectedRow[0], 1);
					Cancion cancionReproducir = listaCancionesMostradas.stream().filter(
			        		 c -> c.getTitulo().equals(nombre) && c.getInterprete().getNombre().equals(artista))
							 .findFirst()
							 .get();
			        controlador.ReproducirCancion(cancionReproducir);
				}
			}
		});
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(211, 117, 512, 186);
		contentPane.add(scrollPane);
		String[] columnas = new String[] { "Titulo", "Interprete" };
		table.setModel(new DefaultTableModel(null, columnas));
		scrollPane.setViewportView(table);
		
		ServicioVentanas.cargarCanciones(controlador.getCancionesRecientes(), table, scrollPane);

		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(event -> {
				///////////////////////////////////////////////////////////
				int[] selectedRow = table.getSelectedRows();
				String nombre = (String) table.getValueAt(selectedRow[0], 0);
				String artista = (String) table.getValueAt(selectedRow[0], 1);
				Cancion cancionReproducir = listaCancionesMostradas.stream().filter(
		        		 c -> c.getTitulo().equals(nombre) && c.getInterprete().getNombre().equals(artista))
						 .findFirst()
						 .get();
		        controlador.ReproducirCancion(cancionReproducir);
		});
		btnPlay.setBounds(387, 314, 66, 37);
		contentPane.add(btnPlay);

		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(event -> {
				controlador.pausarCancion();
		});

		btnPause.setBounds(387, 362, 66, 35);
		contentPane.add(btnPause);

		JButton btnCancionAnterior = new JButton("<<");
		btnCancionAnterior.addActionListener(event -> {
				// Coger fila seleccionada y coger la anterior y reproducirla
				int[] selectedRow = table.getSelectedRows();
				if (selectedRow[0] == 0)
					return;
				int numFilas = table.getRowCount();
				table.setRowSelectionInterval((selectedRow[0] - 1) % numFilas, (selectedRow[0] - 1) % numFilas);
				String nombre = (String) table.getValueAt((selectedRow[0] - 1) % numFilas, 0);
				String artista = (String) table.getValueAt((selectedRow[0] - 1) % numFilas, 1);
				Cancion cancionReproducir = listaCancionesMostradas.stream().filter(
		        		 c -> c.getTitulo().equals(nombre) && c.getInterprete().getNombre().equals(artista))
						 .findFirst()
						 .get();
		        controlador.ReproducirCancion(cancionReproducir);
		});
		btnCancionAnterior.setBounds(324, 340, 53, 35);
		contentPane.add(btnCancionAnterior);

		JButton btnCancionSiguiente = new JButton(">>");
		btnCancionSiguiente.addActionListener(event -> {
				// Coger fila seleccionada y coger la siguiente y reproducirla
				int[] selectedRow = table.getSelectedRows();
				if (selectedRow[0] == table.getRowCount() - 1)
					return;
				int numFilas = table.getRowCount();
				table.setRowSelectionInterval((selectedRow[0] + 1) % numFilas, (selectedRow[0] + 1) % numFilas);
				String nombre = (String) table.getValueAt((selectedRow[0] + 1) % numFilas, 0);
				String artista = (String) table.getValueAt((selectedRow[0] + 1) % numFilas, 1);
				Cancion cancionReproducir = listaCancionesMostradas.stream().filter(
		        		 c -> c.getTitulo().equals(nombre) && c.getInterprete().getNombre().equals(artista))
						 .findFirst()
						 .get();
		        controlador.ReproducirCancion(cancionReproducir);
		});
		btnCancionSiguiente.setBounds(463, 340, 53, 35);
		contentPane.add(btnCancionSiguiente);
		
		
		
		btnCancionesMasReproducidas.setEnabled(false);
		if (controlador.isUsuarioActivoPremium()) btnCancionesMasReproducidas.setEnabled(true);
		btnCancionesMasReproducidas.addActionListener(event -> {
				ServicioVentanas.cargarCanciones(controlador.getCancionesMasReproducidasAppMusic(), table, scrollPane);
		});
		
		
		btnCancionesMasReproducidas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancionesMasReproducidas.setBounds(543, 330, 180, 55);
		contentPane.add(btnCancionesMasReproducidas);

	}





	
	
}
