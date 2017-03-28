package vista.cliente;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorCliente;
import vista.Principal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class GestionCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ControladorCliente  controladorCliente;
	private Component consultas;
	private AbstractButton nuevo;
	private JButton listar;

	
	
	public ControladorCliente getControladorCliente() {
		return controladorCliente;
	}



	public void setControladorCliente(ControladorCliente controladorCliente) {
		this.controladorCliente = controladorCliente;
	}


	/**
	 * Create the dialog.
	 */
	public GestionCliente(Principal principal, boolean modal) {
		super(principal, modal);
		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 552, 316);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JButton nuevo = new JButton("NUEVO CLIENTE");
			nuevo.setFont(new Font("Cambria", Font.BOLD, 14));
			nuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controladorCliente.abrirFormularioCliente();
				}
			});
			nuevo.setBounds(175, 100, 189, 23);
			contentPanel.add(nuevo);
			{
				JButton borrar = new JButton("BORRAR CLIENTE");
				borrar.setFont(new Font("Cambria", Font.BOLD, 14));
				borrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorCliente.abrirFormDeBorrado();
						
					}
				});
				borrar.setBounds(175, 134, 189, 23);
				contentPanel.add(borrar);
			}
			{
				JButton modificar = new JButton("MODIFICAR CLIENTES");
				modificar.setFont(new Font("Cambria", Font.BOLD, 14));
				modificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorCliente.abrirFormDeModificar();
					}
				});
				
				modificar.setBounds(175, 168, 189, 23);
				contentPanel.add(modificar);
			}
		}
		
		JLabel lblGestionDeClientes = new JLabel("GESTION DE CLIENTES");
		lblGestionDeClientes.setForeground(Color.WHITE);
		lblGestionDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDeClientes.setFont(new Font("Cambria", Font.BOLD, 26));
		lblGestionDeClientes.setBounds(131, 32, 275, 23);
		contentPanel.add(lblGestionDeClientes);
		
		JButton button = new JButton("BUSCAR");
		button.setFont(new Font("Cambria", Font.BOLD, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorCliente.abrirBusquedaCliente();
				
			}
		});
		button.setBounds(175, 202, 189, 23);
		contentPanel.add(button);
		{
			listar = new JButton("LISTAR CLIENTES");
			listar.setFont(new Font("Cambria", Font.BOLD, 14));
			listar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					controladorCliente.abrirFormListar();
					
				}
			});
			listar.setBounds(175, 236, 189, 23);
			contentPanel.add(listar);
		}
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 552, 316);
		contentPanel.add(label);
		label.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
	}
}
