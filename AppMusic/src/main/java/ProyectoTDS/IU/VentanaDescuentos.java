package ProyectoTDS.IU;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ProyectoTDS.LogicaNegocio.DescuentoMayores;
import ProyectoTDS.LogicaNegocio.DescuentoLimitado;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;




public class VentanaDescuentos extends JFrame {
	
	private ProyectoTDS.LogicaNegocio.ControladorAppMusic controlador;
	
	public VentanaDescuentos() {
		
		setTitle("Ventana descuentos");
		setBounds(100, 100, 450, 300);
		controlador = ProyectoTDS.LogicaNegocio.ControladorAppMusic.INSTANCE;
		
		getContentPane().setLayout(null);
		
		JLabel lblDescActivo = new JLabel("Descuento activo:");
		lblDescActivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescActivo.setBounds(78, 23, 124, 24);
		getContentPane().add(lblDescActivo);
		
		JLabel lblNingunDescuentoActivo = new JLabel("");
		if (controlador.getDescuentoActivo() == null) lblNingunDescuentoActivo.setText("Ningun descuento activo");
		else lblNingunDescuentoActivo.setText(controlador.getDescuentoActivo().toString());
		lblNingunDescuentoActivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNingunDescuentoActivo.setBounds(205, 23, 171, 24);
		getContentPane().add(lblNingunDescuentoActivo);
		
		JButton btnLimitado = new JButton("Limitado -20%");
		btnLimitado.addActionListener(event -> {
				controlador.setDescuentoActivo(new DescuentoLimitado());
				lblNingunDescuentoActivo.setText(controlador.getDescuentoActivo().toString());
			
		});
		btnLimitado.setBounds(110, 127, 229, 32);
		getContentPane().add(btnLimitado);
		
		JButton btnParaMayores = new JButton("-50% para mayores de 65 años");
		btnParaMayores.addActionListener(event -> {
				controlador.setDescuentoActivo(new DescuentoMayores());
		});
		btnParaMayores.setBounds(110, 170, 229, 32);
		getContentPane().add(btnParaMayores);
		
		JLabel lblNewLabel = new JLabel("Descuentos disponibles:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 88, 171, 24);
		getContentPane().add(lblNewLabel);
	}

}
