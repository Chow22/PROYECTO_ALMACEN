package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorArticulo;
import controlador.ControladorCliente;

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
	private ControladorCliente controladorCliente;
	
	public void setControladorArticulo(ControladorArticulo controladorArticulo) {
		this.controladorArticulo = controladorArticulo;
	}
	public void setControladorCliente(ControladorCliente controladorCliente) {
		this.controladorCliente = controladorCliente;
	}
	
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(null);

		JLabel almacen = new JLabel("CONTROL ALMACEN");
		almacen.setFont(new Font("Cambria", Font.BOLD, 25));
		almacen.setForeground(Color.WHITE);
		almacen.setBounds(148, 25, 239, 39);
		getContentPane().add(almacen);

		JButton articulos = new JButton("Gestionar Articulos");
		articulos.setFont(new Font("Cambria", Font.BOLD, 15));
		articulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorArticulo.abrirGestionArticulo();
			}
		});
		articulos.setBounds(184, 89, 169, 35);
		getContentPane().add(articulos);

		JButton clientes = new JButton("Gestionar Clientes");
		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorCliente.abrirGestionCliente();
			}
		});
		clientes.setFont(new Font("Cambria", Font.BOLD, 15));
		clientes.setBounds(184, 135, 169, 35);
		getContentPane().add(clientes);

		JButton pedidos = new JButton("Gestionar Pedidos");
		pedidos.setFont(new Font("Cambria", Font.BOLD, 15));
		pedidos.setBounds(184, 181, 169, 35);
		getContentPane().add(pedidos);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
		label.setBounds(0, 0, 552, 316);
		getContentPane().add(label);
	}

}
