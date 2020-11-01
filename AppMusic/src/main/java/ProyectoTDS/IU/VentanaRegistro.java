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
		setBounds(100, 100, 450, 300);
		this.setTitle("Registro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelUsuario = new JLabel("Usuario:");
		LabelUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelUsuario.setBounds(47, 183, 51, 14);
		contentPane.add(LabelUsuario);
		
		JLabel LabelNombre = new JLabel("Nombre:");
		LabelNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelNombre.setBounds(47, 22, 51, 14);
		contentPane.add(LabelNombre);
		
		JLabel LabelApellidos = new JLabel("Apellidos:");
		LabelApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelApellidos.setBounds(47, 65, 68, 14);
		contentPane.add(LabelApellidos);
		
		JLabel LabelEmail = new JLabel("Email:");
		LabelEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelEmail.setBounds(47, 145, 40, 14);
		contentPane.add(LabelEmail);
		
		JLabel LabelFechaNacimiento = new JLabel("Fecha de nacimiento:");
		LabelFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelFechaNacimiento.setBounds(10, 106, 136, 14);
		contentPane.add(LabelFechaNacimiento);
		
		JLabel LabelRepite = new JLabel("Repite:");
		LabelRepite.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelRepite.setBounds(242, 223, 74, 14);
		contentPane.add(LabelRepite);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClave.setBounds(47, 223, 40, 14);
		contentPane.add(lblClave);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(125, 20, 86, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(125, 63, 86, 20);
		contentPane.add(textFieldApellidos);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(151, 104, 86, 20);
		contentPane.add(textFieldFecha);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(88, 143, 86, 20);
		contentPane.add(textFieldEmail);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(108, 181, 86, 20);
		contentPane.add(textFieldUsuario);
		
		textFieldClave = new JPasswordField();
		textFieldClave.setColumns(10);
		textFieldClave.setBounds(108, 221, 86, 20);
		contentPane.add(textFieldClave);
		
		textFieldRepite = new JPasswordField();
		textFieldRepite.setColumns(10);
		textFieldRepite.setBounds(304, 221, 86, 20);
		contentPane.add(textFieldRepite);
		
		JButton btnIrALogin = new JButton("Ya tengo cuenta");
		btnIrALogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirVentanaLogin();
				dispose();
			}
		});
		btnIrALogin.setBounds(288, 39, 136, 23);
		contentPane.add(btnIrALogin);
		
		JButton btnRegistrar = new JButton("Registrarme");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Controlador.RegistroUsuario(textFieldUsuario.getText(), textFieldClave.getText(), textFieldNombre.getText(), textFieldApellidos.getText(), textFieldFecha.getText(), textFieldEmail.getText())) {
					abrirVentanaLogin();
					dispose();
				}
				else JOptionPane.showMessageDialog (null, "Este usuario/email ya esta registrado", "Error!", JOptionPane.ERROR_MESSAGE);
				
				
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.setBounds(261, 144, 129, 34);
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
