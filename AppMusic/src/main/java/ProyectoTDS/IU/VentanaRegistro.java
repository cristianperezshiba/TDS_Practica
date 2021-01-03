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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaRegistro extends JFrame {

	private ProyectoTDS.LogicaNegocio.ControladorAppMusic controlador;

	public VentanaRegistro() {
		controlador = ProyectoTDS.LogicaNegocio.ControladorAppMusic.INSTANCE;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 323);
		this.setTitle("Registro");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{40, 193, 142, 87, 56, 86, 43, 8, 123, 0};
		gbl_contentPane.rowHeights = new int[]{20, 23, 43, 37, 30, 20, 51, 30, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane); 
		
		JLabel LabelNombre = new JLabel("Nombre:");
		LabelNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_LabelNombre = new GridBagConstraints();
		gbc_LabelNombre.anchor = GridBagConstraints.NORTHEAST;
		gbc_LabelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_LabelNombre.gridx = 1;
		gbc_LabelNombre.gridy = 2;
		contentPane.add(LabelNombre, gbc_LabelNombre);
		
		JTextField textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.anchor = GridBagConstraints.NORTH;
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 2;
		contentPane.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel LabelApellidos = new JLabel("Apellidos:");
		LabelApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_LabelApellidos = new GridBagConstraints();
		gbc_LabelApellidos.anchor = GridBagConstraints.NORTHEAST;
		gbc_LabelApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_LabelApellidos.gridx = 3;
		gbc_LabelApellidos.gridy = 2;
		contentPane.add(LabelApellidos, gbc_LabelApellidos);
		
		JTextField textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		GridBagConstraints gbc_textFieldApellidos = new GridBagConstraints();
		gbc_textFieldApellidos.gridwidth = 2;
		gbc_textFieldApellidos.anchor = GridBagConstraints.NORTH;
		gbc_textFieldApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellidos.gridx = 4;
		gbc_textFieldApellidos.gridy = 2;
		contentPane.add(textFieldApellidos, gbc_textFieldApellidos);
		
		JLabel LabelEmail = new JLabel("Email:");
		LabelEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_LabelEmail = new GridBagConstraints();
		gbc_LabelEmail.anchor = GridBagConstraints.NORTHEAST;
		gbc_LabelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_LabelEmail.gridx = 1;
		gbc_LabelEmail.gridy = 3;
		contentPane.add(LabelEmail, gbc_LabelEmail);
		
		JTextField textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.anchor = GridBagConstraints.NORTH;
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 3;
		contentPane.add(textFieldEmail, gbc_textFieldEmail);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblClave = new GridBagConstraints();
		gbc_lblClave.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblClave.insets = new Insets(0, 0, 5, 5);
		gbc_lblClave.gridx = 3;
		gbc_lblClave.gridy = 3;
		contentPane.add(lblClave, gbc_lblClave);
		
		JTextField textFieldClave = new JPasswordField();
		textFieldClave.setColumns(10);
		GridBagConstraints gbc_textFieldClave = new GridBagConstraints();
		gbc_textFieldClave.anchor = GridBagConstraints.NORTH;
		gbc_textFieldClave.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldClave.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldClave.gridx = 5;
		gbc_textFieldClave.gridy = 3;
		contentPane.add(textFieldClave, gbc_textFieldClave);
		
		JLabel LabelUsuario = new JLabel("Usuario:");
		LabelUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_LabelUsuario = new GridBagConstraints();
		gbc_LabelUsuario.anchor = GridBagConstraints.NORTHEAST;
		gbc_LabelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario.gridx = 1;
		gbc_LabelUsuario.gridy = 4;
		contentPane.add(LabelUsuario, gbc_LabelUsuario);
		
		JTextField textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.anchor = GridBagConstraints.NORTH;
		gbc_textFieldUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsuario.gridx = 2;
		gbc_textFieldUsuario.gridy = 4;
		contentPane.add(textFieldUsuario, gbc_textFieldUsuario);
		
		JLabel LabelRepite = new JLabel("Repite:");
		LabelRepite.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_LabelRepite = new GridBagConstraints();
		gbc_LabelRepite.anchor = GridBagConstraints.NORTHEAST;
		gbc_LabelRepite.insets = new Insets(0, 0, 5, 5);
		gbc_LabelRepite.gridx = 3;
		gbc_LabelRepite.gridy = 4;
		contentPane.add(LabelRepite, gbc_LabelRepite);
		
		JTextField textFieldRepite = new JPasswordField();
		textFieldRepite.setColumns(10);
		GridBagConstraints gbc_textFieldRepite = new GridBagConstraints();
		gbc_textFieldRepite.gridwidth = 2;
		gbc_textFieldRepite.anchor = GridBagConstraints.NORTH;
		gbc_textFieldRepite.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRepite.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRepite.gridx = 4;
		gbc_textFieldRepite.gridy = 4;
		contentPane.add(textFieldRepite, gbc_textFieldRepite);
		
		JDateChooser textFieldFecha = new JDateChooser();
		GridBagConstraints gbc_textFieldFecha = new GridBagConstraints();
		gbc_textFieldFecha.anchor = GridBagConstraints.NORTH;
		gbc_textFieldFecha.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFecha.gridx = 5;
		gbc_textFieldFecha.gridy = 6;
		contentPane.add(textFieldFecha, gbc_textFieldFecha);
		
		JButton btnIrALogin = new JButton("Ya tengo cuenta");
		btnIrALogin.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnIrALogin.addActionListener(event -> {
				ServicioVentanas.abrirVentanaLogin();
				dispose();
			});
		JLabel LabelFechaNacimiento = new JLabel("Fecha de nacimiento:");
		LabelFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_LabelFechaNacimiento = new GridBagConstraints();
		gbc_LabelFechaNacimiento.gridwidth = 2;
		gbc_LabelFechaNacimiento.anchor = GridBagConstraints.NORTHEAST;
		gbc_LabelFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_LabelFechaNacimiento.gridx = 2;
		gbc_LabelFechaNacimiento.gridy = 6;
		contentPane.add(LabelFechaNacimiento, gbc_LabelFechaNacimiento);
		
		JButton btnRegistrar = new JButton("Registrarme");
		btnRegistrar.addActionListener(event -> {
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
						ServicioVentanas.abrirVentanaLogin();
						dispose();
					}
				
		});
		
	
		

		btnRegistrar.setFont(new Font("Dialog", Font.BOLD, 14));
		
		
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.fill = GridBagConstraints.VERTICAL;
		gbc_btnRegistrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistrar.gridx = 2;
		gbc_btnRegistrar.gridy = 7;
		contentPane.add(btnRegistrar, gbc_btnRegistrar);
		GridBagConstraints gbc_btnIrALogin = new GridBagConstraints();
		gbc_btnIrALogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnIrALogin.fill = GridBagConstraints.BOTH;
		gbc_btnIrALogin.gridx = 5;
		gbc_btnIrALogin.gridy = 7;
		contentPane.add(btnIrALogin, gbc_btnIrALogin);
		

	}
	
	
	
}
