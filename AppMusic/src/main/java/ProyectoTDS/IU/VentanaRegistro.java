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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldEmail;
	private JTextField textFieldUsuario;
	private JTextField textFieldClave;
	private JTextField textFieldRepite;
	private ProyectoTDS.LogicaNegocio.ControladorAppMusic controlador;

	public VentanaRegistro() {
		controlador = ProyectoTDS.LogicaNegocio.ControladorAppMusic.INSTANCE;
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
		btnIrALogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrirVentanaLogin();
				dispose();
			}
		});
		btnIrALogin.setBounds(382, 243, 136, 30);
		contentPane.add(btnIrALogin);
		
		JDateChooser textFieldFecha = new JDateChooser();
		textFieldFecha.setBounds(395, 64, 79, 19);
		contentPane.add(textFieldFecha);
		
		JButton btnRegistrar = new JButton("Registrarme");
		btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String usuario = textFieldUsuario.getText();
				String contrasena = textFieldClave.getText();
				String repite = textFieldRepite.getText();
				String nombre = textFieldNombre.getText();
				String apellidos = textFieldApellidos.getText();
				String fechaNacimiento = "";
				try {
					fechaNacimiento = textFieldFecha.getDate().toString(); //Si no se hace el getDate.toString siempre devuelve un D MM AA, por lo que no funciona la comprobación de si está vacio
				}
				catch (Exception e1) {
				}
				String email = textFieldEmail.getText();
				//Las comprobaciones las hacemos aquí mismo, ya que como bien dice el patrón experto, tenemos que implementar la funcionalidad allí donde tengamos la información
				//disponible para hacerlo, por lo que las comprovaciones las hacemos a nivel de vista, además esto en un sistema de host-servidor también mejora el tiempo de respuesta

					if (!contrasena.equals(repite)) JOptionPane.showMessageDialog (null, "Las contraseñas no coinciden", "Error!", JOptionPane.ERROR_MESSAGE);
					
					else if (usuario.length()==0 || contrasena.length()==0 || 
							nombre.length()==0 || apellidos.length()==0 || 
							fechaNacimiento.length()<0 || email.length()==0) JOptionPane.showMessageDialog (null, "Todos los campos deben ser rellenados", "Error!", JOptionPane.ERROR_MESSAGE);
					else if (!controlador.RegistroUsuario(usuario, contrasena, repite, nombre, apellidos, fechaNacimiento, email)) {
						JOptionPane.showMessageDialog (null, "Este usuario/email ya esta registrado, el usuario no se ha creado", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						abrirVentanaLogin();
						dispose();
					}
				
				
				
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
