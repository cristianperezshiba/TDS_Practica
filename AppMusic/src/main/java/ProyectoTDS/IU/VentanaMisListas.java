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

public class VentanaMisListas extends JFrame {

	private JPanel contentPane;
	private ProyectoTDS.Controlador.Controlador Controlador;
	
	
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
	  /*String[][] tituloEInterpretes = new String[][] {{"EjemploTitulo", "EjemploInterprete"},
			  {"Aqui habra las canciones", "segun se necesiten en busquedas, etc"}};*/
	    String[] columnas = new String[] {"Titulo", "Interprete"};
		
		
		btnExplorar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirVentanaExplorar();
				dispose();
			}
		});
		

		
		
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
