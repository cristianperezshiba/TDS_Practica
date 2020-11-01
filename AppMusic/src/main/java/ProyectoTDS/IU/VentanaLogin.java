package ProyectoTDS.IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	private ProyectoTDS.Controlador.Controlador Controlador;

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		this.Controlador = Controlador.getUnicaInstancia();
		/////////////////////////////////////////////////////////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Login");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelContrasena = new JLabel("Contrase\u00F1a:");
		LabelContrasena.setBounds(37, 137, 89, 14);
		contentPane.add(LabelContrasena);
		
		JLabel LabelTitulo = new JLabel("AppMusic");
		LabelTitulo.setFont(new Font("Tahoma", Font.BOLD, 23));
		LabelTitulo.setBounds(151, 11, 125, 38);
		LabelTitulo.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(LabelTitulo);
		
		JLabel LabelUsuario = new JLabel("Usuario:");
		LabelUsuario.setBounds(37, 87, 68, 14);
		contentPane.add(LabelUsuario);
		
		JLabel LabelTexto = new JLabel("Si no estas registrado ->");
		LabelTexto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelTexto.setBounds(64, 225, 149, 25);
		contentPane.add(LabelTexto);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(136, 84, 140, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldContrasena = new JPasswordField();
		textFieldContrasena.setBounds(136, 134, 140, 20);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);
		////////////////////////////////////////////////////////
		
		
		JButton btnNewButton = new JButton("Registrate");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirVentanaRegistro();
				dispose();
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(235, 227, 99, 23);
		contentPane.add(btnNewButton);
		
		/////////////////////////////////////////////////////////////
		JButton btnNewButton_1 = new JButton("Iniciar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Controlador.ComprobarLoginUsuario(textFieldUsuario.getText(), textFieldContrasena.getText())) {
					abrirVentanaPrincipal();
					dispose();
				}
				else JOptionPane.showMessageDialog (null, "Usuario y/o contrase�a incorrecta", "Error!", JOptionPane.ERROR_MESSAGE);
				
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(146, 165, 114, 44);
		contentPane.add(btnNewButton_1);
	}
	
	private void abrirVentanaRegistro() {
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
	
	private void abrirVentanaPrincipal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
