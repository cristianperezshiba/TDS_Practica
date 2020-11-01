package ProyectoTDS.IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldFecha;
	private JTextField textFieldEmail;
	private JTextField textFieldUsuario;
	private JTextField textFieldClave;
	private JTextField textFieldRepite;
	private ProyectoTDS.Controlador.Controlador Controlador;

	public VentanaRegistro() {
		Controlador = Controlador.getUnicaInstancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 323);
		this.setTitle("Registro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelUsuario = new JLabel("Usuario:");
		LabelUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelUsuario.setBounds(22, 126, 51, 14);
		contentPane.add(LabelUsuario);
		
		JLabel LabelNombre = new JLabel("Nombre:");
		LabelNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelNombre.setBounds(22, 22, 51, 14);
		contentPane.add(LabelNombre);
		
		JLabel LabelApellidos = new JLabel("Apellidos:");
		LabelApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelApellidos.setBounds(217, 22, 68, 14);
		contentPane.add(LabelApellidos);
		
		JLabel LabelEmail = new JLabel("Email:");
		LabelEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelEmail.setBounds(22, 69, 40, 14);
		contentPane.add(LabelEmail);
		
		JLabel LabelFechaNacimiento = new JLabel("Fecha de nacimiento:");
		LabelFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelFechaNacimiento.setBounds(254, 69, 136, 14);
		contentPane.add(LabelFechaNacimiento);
		
		JLabel LabelRepite = new JLabel("Repite:");
		LabelRepite.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelRepite.setBounds(211, 151, 74, 14);
		contentPane.add(LabelRepite);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClave.setBounds(217, 126, 40, 14);
		contentPane.add(lblClave);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(83, 20, 86, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(283, 20, 212, 20);
		contentPane.add(textFieldApellidos);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(387, 67, 108, 20);
		contentPane.add(textFieldFecha);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(72, 67, 141, 20);
		contentPane.add(textFieldEmail);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(83, 124, 86, 20);
		contentPane.add(textFieldUsuario);
		
		textFieldClave = new JPasswordField();
		textFieldClave.setColumns(10);
		textFieldClave.setBounds(274, 124, 116, 20);
		contentPane.add(textFieldClave);
		
		textFieldRepite = new JPasswordField();
		textFieldRepite.setColumns(10);
		textFieldRepite.setBounds(274, 149, 116, 20);
		contentPane.add(textFieldRepite);
		
		JButton btnIrALogin = new JButton("Ya tengo cuenta");
		btnIrALogin.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnIrALogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirVentanaLogin();
				dispose();
			}
		});
		btnIrALogin.setBounds(382, 243, 136, 30);
		contentPane.add(btnIrALogin);
		
		JButton btnRegistrar = new JButton("Registrarme");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Hace falta hacer mas comprovaciones de este tipo o no ?¿?¿?¿
				//Condiciones para que el usuario pueda registrarse 
				if (textFieldClave.getText() != textFieldRepite.getText()) {
					JOptionPane.showMessageDialog (null, "Las contraseñas no coinciden", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				//Intentamos registrar al usuario
				else if (Controlador.RegistroUsuario(textFieldUsuario.getText(), textFieldClave.getText(), textFieldNombre.getText(), textFieldApellidos.getText(), textFieldFecha.getText(), textFieldEmail.getText())) {
					abrirVentanaLogin();
					dispose();
				}
				else JOptionPane.showMessageDialog (null, "Este usuario/email ya esta registrado", "Error!", JOptionPane.ERROR_MESSAGE);
				
				
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRegistrar.setBounds(173, 189, 166, 51);
		contentPane.add(btnRegistrar);
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
