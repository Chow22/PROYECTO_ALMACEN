package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorArticulo;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;

	private ControladorArticulo controladorArticulo;
	
	public void setControladorArticulo(ControladorArticulo controladorArticulo) {
		this.controladorArticulo = controladorArticulo;
	}
	
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(null);

		JLabel menuCompra = new JLabel("MENU DE COMPRA");
		menuCompra.setFont(new Font("Cambria", Font.BOLD, 25));
		menuCompra.setForeground(Color.WHITE);
		menuCompra.setBounds(159, 25, 228, 39);
		getContentPane().add(menuCompra);

		JButton articulos = new JButton("Gestionar Articulos");
		articulos.setFont(new Font("Cambria", Font.BOLD, 14));
		articulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorArticulo.abrirGestionArticulo();
			}
		});
		articulos.setBounds(184, 101, 159, 23);
		getContentPane().add(articulos);

		JButton clientes = new JButton("Gestionar Clientes");
		clientes.setFont(new Font("Cambria", Font.BOLD, 14));
		clientes.setBounds(184, 147, 159, 23);
		getContentPane().add(clientes);

		JButton pedidos = new JButton("Gestionar Pedidos");
		pedidos.setFont(new Font("Cambria", Font.BOLD, 14));
		pedidos.setBounds(184, 193, 159, 23);
		getContentPane().add(pedidos);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
		label.setBounds(0, 0, 552, 316);
		getContentPane().add(label);
	}
}
