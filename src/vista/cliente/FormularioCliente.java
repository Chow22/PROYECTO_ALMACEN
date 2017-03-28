package vista.cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorCliente;
import modelo.Cliente;
import vista.Principal;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class FormularioCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JTextField nombre;
	private JTextField direccion;
	private JTextField codPostal;
	private JTextField telefono;

	private ControladorCliente controladorCliente;
	private JTextField id;

	public ControladorCliente getControladorCliente() {
		return controladorCliente;
	}

	public void setControladorCliente(ControladorCliente controladorCliente) {
		this.controladorCliente = controladorCliente;
	}

	/**
	 * Create the dialog.
	 */
	public FormularioCliente(GestionCliente padre, boolean modal) {
		super(padre, modal);
		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Cambria", Font.BOLD, 14));
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setBounds(121, 114, 65, 14);
		}
		contentPanel.setLayout(null);
		
				JLabel lblDireccion = new JLabel("Direccion");
				lblDireccion.setFont(new Font("Cambria", Font.BOLD, 14));
				lblDireccion.setForeground(Color.WHITE);
				lblDireccion.setBounds(121, 145, 65, 14);
				contentPanel.add(lblDireccion);
		
				JLabel lblProvincia = new JLabel("Codigo Postal");
				lblProvincia.setFont(new Font("Cambria", Font.BOLD, 14));
				lblProvincia.setForeground(Color.WHITE);
				lblProvincia.setBounds(119, 174, 94, 14);
				contentPanel.add(lblProvincia);
		
				JLabel lbltelef = new JLabel("Telefono");
				lbltelef.setFont(new Font("Cambria", Font.BOLD, 14));
				lbltelef.setForeground(Color.WHITE);
				lbltelef.setBounds(121, 202, 65, 14);
				contentPanel.add(lbltelef);
		
		nombre = new JTextField();
		nombre.setBounds(268, 112, 160, 20);
		nombre.setColumns(10);
		contentPanel.add(nombre);
		
				direccion = new JTextField();
				direccion.setBounds(268, 143, 160, 20);
				direccion.setColumns(10);
				contentPanel.add(direccion);
		
				codPostal = new JTextField();
				codPostal.setBounds(268, 172, 86, 20);
				codPostal.setColumns(10);
				contentPanel.add(codPostal);
		
				telefono = new JTextField();
				telefono.setBounds(268, 200, 86, 20);
				telefono.setColumns(10);
				contentPanel.add(telefono);
		
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.setFont(new Font("Cambria", Font.BOLD, 14));
				btnGuardar.setBounds(121, 271, 101, 23);
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				controladorCliente.insertarCliente(id.getText(),nombre.getText(), direccion.getText(), direccion.getText(), codPostal.getText(), telefono.getText());
						controladorCliente.cerrarFormularioCliente();
						
			}
				});
				contentPanel.add(btnGuardar);
		
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setFont(new Font("Cambria", Font.BOLD, 14));
				btnCancelar.setBounds(232, 271, 94, 23);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorCliente.cerrarFormularioCliente();
					}
				});
				contentPanel.add(btnCancelar);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Cambria", Font.BOLD, 14));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(121, 83, 37, 14);
		contentPanel.add(lblId);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(268, 81, 86, 20);
		contentPanel.add(id);
		contentPanel.add(lblNombre);
				
				JLabel lblAltaCliente = new JLabel("ALTA CLIENTE");
				lblAltaCliente.setForeground(Color.WHITE);
				lblAltaCliente.setFont(new Font("Cambria", Font.BOLD, 26));
				lblAltaCliente.setBounds(173, 11, 181, 57);
				contentPanel.add(lblAltaCliente);
		
				JLabel label = new JLabel("");
				contentPanel.add(label);
				label.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
				label.setBounds(0, 0, 552, 316);
	}

	public void clear() {
		this.nombre.setText("");
		this.direccion.setText("");
		this.telefono.setText("");
		this.codPostal.setText("");	
	}
}
