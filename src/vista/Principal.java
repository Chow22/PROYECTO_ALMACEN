package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorArticulo;
import controlador.ControladorPedidos;
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

	private ControladorArticulo controladorProducto;
	private ControladorCliente controladorCliente;
	private ControladorPedidos controladorPedido;

	public Principal() {
		getContentPane().setLayout(null);

		JLabel lblAlmacenLaHuerta = new JLabel("MENU DE COMPRA");
		lblAlmacenLaHuerta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAlmacenLaHuerta.setForeground(Color.WHITE);
		lblAlmacenLaHuerta.setBounds(127, 11, 169, 39);
		getContentPane().add(lblAlmacenLaHuerta);

		JButton btnGestionarArticulos = new JButton("Gestionar Articulos");
		btnGestionarArticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGestionarArticulos.setBounds(139, 81, 139, 23);
		getContentPane().add(btnGestionarArticulos);

		JButton btnGestionarClientes = new JButton("Gestionar Clientes");
		btnGestionarClientes.setBounds(139, 124, 139, 23);
		getContentPane().add(btnGestionarClientes);

		JButton btnGestionarPedidos = new JButton("Gestionar Pedidos");
		btnGestionarPedidos.setBounds(139, 167, 139, 23);
		getContentPane().add(btnGestionarPedidos);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
		label.setBounds(0, 0, 434, 261);
		getContentPane().add(label);
	}
}
