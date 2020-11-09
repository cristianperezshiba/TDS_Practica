package ProyectoTDS.IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtInterprete;
	private JTextField textTitulo;
	private JTextField textEstilo;
	private ProyectoTDS.Controlador.Controlador Controlador;

	public VentanaPrincipal() {
		setTitle("Ventana principal");
		Controlador = Controlador.getUnicaInstancia();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.GRAY);
		panelLeft.setBounds(0, 99, 217, 362);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
		JButton btnExplorar = new JButton("Explorar");
		btnExplorar.setBounds(67, 59, 89, 23);
		panelLeft.add(btnExplorar);
		
		JButton btnNuevaLista = new JButton("Nueva lista");
		btnNuevaLista.setBounds(67, 107, 89, 23);
		panelLeft.add(btnNuevaLista);
		
		JButton btnReciente = new JButton("Reciente");
		btnReciente.setBounds(67, 166, 89, 23);
		panelLeft.add(btnReciente);
		
		JButton btnMisListas = new JButton("Mis listas");
		btnMisListas.setBounds(67, 237, 89, 23);
		panelLeft.add(btnMisListas);
		
		txtInterprete = new JTextField();
		txtInterprete.setText("Interprete");
		txtInterprete.setBounds(250, 121, 149, 20);
		contentPane.add(txtInterprete);
		txtInterprete.setColumns(10);
		
		JButton btnMejoraCuenta = new JButton("Mejora tu cuenta");
		btnMejoraCuenta.setBounds(433, 25, 149, 23);
		contentPane.add(btnMejoraCuenta);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controlador.logout();
				abrirVentanaLogin();
				dispose();
				
			}
		});
		btnLogout.setBounds(634, 25, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(334, 152, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(470, 152, 89, 23);
		contentPane.add(btnCancelar);
		
		textTitulo = new JTextField();
		textTitulo.setText("Titulo");
		textTitulo.setColumns(10);
		textTitulo.setBounds(433, 121, 149, 20);
		contentPane.add(textTitulo);
		
		textEstilo = new JTextField();
		textEstilo.setText("Estilo");
		textEstilo.setColumns(10);
		textEstilo.setBounds(606, 121, 86, 20);
		contentPane.add(textEstilo);
		
		JLabel lblUsuario = new JLabel("Hola " + Controlador.getUsuarioActivo() + "!");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(288, 29, 111, 19);
		contentPane.add(lblUsuario);
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
