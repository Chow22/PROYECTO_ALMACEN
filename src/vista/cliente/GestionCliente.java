package vista.cliente;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JButton nuevo = new JButton("NUEVO CLIENTE");
			nuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controladorCliente.abrirFormularioCliente();
				}
			});
			nuevo.setBounds(25, 71, 189, 23);
			contentPanel.add(nuevo);
			{
				JButton borrar = new JButton("BORRAR CLIENTE");
				borrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorCliente.abrirFormDeBorrado();
						
					}
				});
				borrar.setBounds(25, 105, 189, 23);
				contentPanel.add(borrar);
			}
			{
				JButton modificar = new JButton("MODIFICAR CLIENTES");
				modificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorCliente.abrirFormDeModificar();
					}
				});
				
				modificar.setBounds(25, 139, 189, 23);
				contentPanel.add(modificar);
			}
		}
		
		JLabel lblGestionDeClientes = new JLabel("GESTION DE CLIENTES");
		lblGestionDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDeClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGestionDeClientes.setBounds(89, 25, 275, 23);
		contentPanel.add(lblGestionDeClientes);
		
		JButton button = new JButton("BUSCAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorCliente.abrirBusquedaCliente();
				
			}
		});
		button.setBounds(25, 173, 189, 23);
		contentPanel.add(button);
		{
			listar = new JButton("LISTAR CLIENTES");
			listar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					controladorCliente.abrirFormListar();
					
				}
			});
			listar.setBounds(25, 207, 189, 23);
			contentPanel.add(listar);
		}
	}
}
