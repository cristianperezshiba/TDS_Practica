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
import java.awt.Font;
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

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtInterprete;
	private JTextField textTitulo;
	private ProyectoTDS.Controlador.Controlador Controlador;
	private JComboBox comboBoxEstilo = new JComboBox();
	
	
	public VentanaPrincipal() {
		setTitle("Ventana principal");
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
		
		JButton btnReciente = new JButton("Reciente");
		btnReciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReciente.setBounds(39, 158, 117, 44);
		panelLeft.add(btnReciente);
		
		JButton btnMisListas = new JButton("Mis listas");
		btnMisListas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMisListas.setBounds(39, 228, 117, 44);
		panelLeft.add(btnMisListas);
		
		txtInterprete = new JTextField();
		txtInterprete.setBounds(420, 118, 149, 23);
		contentPane.add(txtInterprete);
		txtInterprete.setColumns(10);
		
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
		
		
		
		
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(250, 118, 149, 23);
		contentPane.add(textTitulo);
		
		JLabel lblUsuario = new JLabel("Hola " + Controlador.getUsuarioActivo() + "!");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUsuario.setBounds(106, 19, 293, 19);
		contentPane.add(lblUsuario);
		
		
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
		

	  
	  JScrollPane scrollPane = new JScrollPane();
	  JTable table = new JTable();
	  scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	  scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	  scrollPane.setBounds(211, 186, 512, 331);
	  contentPane.add(scrollPane);
	  /*String[][] tituloEInterpretes = new String[][] {{"EjemploTitulo", "EjemploInterprete"},
			  {"Aqui habra las canciones", "segun se necesiten en busquedas, etc"}};*/
	  String[] columnas = new String[] {"Titulo", "Interprete"};
	  table.setModel(new DefaultTableModel(null, columnas));	  
	  scrollPane.setViewportView(table);
	  scrollPane.setVisible(false); //Por defecto ocultamos el panel con la tabla, cuando nos haga falta lo activaremos
	  
	  
	  JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<List<String>> cancionesEncontradas = Controlador.buscarCanciones(textTitulo.getText() ,txtInterprete.getText(), comboBoxEstilo.getSelectedItem().toString());
				List<String> listaTitulos = cancionesEncontradas.get(0);
				List<String> listaInterpretes = cancionesEncontradas.get(1);
				
				DefaultTableModel tableMode = new DefaultTableModel(null, columnas);
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
		btnBuscar.setBounds(334, 152, 89, 23);
		contentPane.add(btnBuscar);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setVisible(false);
			}
		});
		btnCancelar.setBounds(470, 152, 89, 23);
		
		contentPane.add(btnCancelar);
		
		JLabel lblInterprete = new JLabel("Interprete:");
		lblInterprete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInterprete.setBounds(420, 99, 89, 14);
		contentPane.add(lblInterprete);
		
		JLabel lblNewLabel = new JLabel("Titulo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(250, 99, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEstilo = new JLabel("Estilo:");
		lblEstilo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstilo.setBounds(579, 99, 89, 14);
		contentPane.add(lblEstilo);
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
}
