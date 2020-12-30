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
	private ProyectoTDS.LogicaNegocio.ControladorAppMusic controlador;

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		this.controlador = ProyectoTDS.LogicaNegocio.ControladorAppMusic.INSTANCE;
		/////////////////////////////////////////////////////////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Login");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelContrasena = new JLabel("Contrase\u00F1a:");
		LabelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LabelContrasena.setBounds(76, 126, 89, 14);
		contentPane.add(LabelContrasena);
		
		JLabel LabelTitulo = new JLabel("AppMusic");
		LabelTitulo.setFont(new Font("Tahoma", Font.BOLD, 23));
		LabelTitulo.setBounds(176, 11, 125, 38);
		LabelTitulo.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(LabelTitulo);
		
		JLabel LabelUsuario = new JLabel("Usuario:");
		LabelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LabelUsuario.setBounds(94, 82, 68, 14);
		contentPane.add(LabelUsuario);
		
		JLabel LabelTexto = new JLabel("Si no estas registrado ->");
		LabelTexto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelTexto.setBounds(76, 225, 149, 25);
		contentPane.add(LabelTexto);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(161, 81, 140, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldContrasena = new JPasswordField();
		textFieldContrasena.setBounds(161, 125, 140, 20);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);
		////////////////////////////////////////////////////////
		
		
		JButton btnNewButton = new JButton("Registrate");
		btnNewButton.addActionListener(event -> {
												abrirVentanaRegistro();
												dispose();});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(229, 227, 99, 23);
		contentPane.add(btnNewButton);
		
		/////////////////////////////////////////////////////////////
		JButton btnNewButton_1 = new JButton("Iniciar");
		btnNewButton_1.addActionListener(event -> {
			if (controlador.comprobarLoginUsuario(textFieldUsuario.getText(), textFieldContrasena.getText())) {
					abrirVentanaReciente();
					dispose();
				}
				else JOptionPane.showMessageDialog (null, "Usuario y/o contraseña incorrecta", "Error!", JOptionPane.ERROR_MESSAGE);
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(176, 156, 114, 44);
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
