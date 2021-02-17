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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaLogin extends JFrame {

	private ProyectoTDS.LogicaNegocio.ControladorAppMusic controlador;
	private JPasswordField textFieldContrasena;

	public VentanaLogin() {
		this.controlador = ProyectoTDS.LogicaNegocio.ControladorAppMusic.INSTANCE;
		/////////////////////////////////////////////////////////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Login");
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{60, 79, 85, 0, 0, 60, 0};
		gbl_contentPane.rowHeights = new int[]{33, 0, 0, 25, 19, 0, 19, 0, 39, 25, 32, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel LabelTitulo = new JLabel("AppMusic");
		LabelTitulo.setFont(new Font("Tahoma", Font.BOLD, 23));
		LabelTitulo.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_LabelTitulo = new GridBagConstraints();
		gbc_LabelTitulo.gridwidth = 3;
		gbc_LabelTitulo.anchor = GridBagConstraints.WEST;
		gbc_LabelTitulo.fill = GridBagConstraints.VERTICAL;
		gbc_LabelTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_LabelTitulo.gridx = 2;
		gbc_LabelTitulo.gridy = 2;
		contentPane.add(LabelTitulo, gbc_LabelTitulo);
		
		JLabel LabelUsuario = new JLabel("Usuario:");
		LabelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_LabelUsuario = new GridBagConstraints();
		gbc_LabelUsuario.anchor = GridBagConstraints.NORTHEAST;
		gbc_LabelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario.gridx = 1;
		gbc_LabelUsuario.gridy = 4;
		contentPane.add(LabelUsuario, gbc_LabelUsuario);
		
		JTextField textFieldUsuario = new JTextField();
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsuario.gridwidth = 3;
		gbc_textFieldUsuario.anchor = GridBagConstraints.NORTH;
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsuario.gridx = 2;
		gbc_textFieldUsuario.gridy = 4;
		contentPane.add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel LabelContrasena = new JLabel("Contrase\u00F1a:");
		LabelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_LabelContrasena = new GridBagConstraints();
		gbc_LabelContrasena.anchor = GridBagConstraints.NORTHWEST;
		gbc_LabelContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_LabelContrasena.gridx = 1;
		gbc_LabelContrasena.gridy = 6;
		contentPane.add(LabelContrasena, gbc_LabelContrasena);
		
		textFieldContrasena = new JPasswordField();
		GridBagConstraints gbc_textFieldContrasena = new GridBagConstraints();
		gbc_textFieldContrasena.gridwidth = 3;
		gbc_textFieldContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldContrasena.gridx = 2;
		gbc_textFieldContrasena.gridy = 6;
		contentPane.add(textFieldContrasena, gbc_textFieldContrasena);
		
		/////////////////////////////////////////////////////////////
		JButton btnNewButton_1 = new JButton("Iniciar");
		btnNewButton_1.addActionListener(event -> {
			if (controlador.comprobarLoginUsuario(textFieldUsuario.getText(), textFieldContrasena.getText())) {
					ServicioVentanas.abrirVentanaReciente();
					this.setVisible(false);
				}
				else JOptionPane.showMessageDialog (null, "Usuario y/o contraseña incorrecta", "Error!", JOptionPane.ERROR_MESSAGE);
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 8;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		////////////////////////////////////////////////////////
		
		
		JButton btnNewButton = new JButton("Registro");
		btnNewButton.addActionListener(event -> {
												ServicioVentanas.abrirVentanaRegistro();
												this.setVisible(false);});
		
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 8;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}
	
	
}
