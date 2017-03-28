package vista.cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorCliente;
import modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(127, 66, 37, 14);
		}

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(127, 97, 43, 14);

		JLabel lblProvincia = new JLabel("Codigo Postal");
		lblProvincia.setBounds(127, 131, 65, 14);

		JLabel lbltelef = new JLabel("Telefono");
		lbltelef.setBounds(127, 159, 42, 14);

		nombre = new JTextField();
		nombre.setBounds(231, 63, 86, 20);
		nombre.setColumns(10);

		direccion = new JTextField();
		direccion.setBounds(231, 94, 86, 20);
		direccion.setColumns(10);

		codPostal = new JTextField();
		codPostal.setBounds(231, 125, 86, 20);
		codPostal.setColumns(10);

		telefono = new JTextField();
		telefono.setBounds(231, 153, 86, 20);
		telefono.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(121, 227, 71, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorCliente.insertarCliente(id.getText(),nombre.getText(), direccion.getText(), direccion.getText(), codPostal.getText(), telefono.getText());
				controladorCliente.cerrarFormularioCliente();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(242, 227, 75, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorCliente.cerrarFormularioCliente();
			}
		});
		contentPanel.setLayout(null);
		contentPanel.add(lblNombre);
		contentPanel.add(lblDireccion);
		contentPanel.add(lblProvincia);
		contentPanel.add(lbltelef);
		contentPanel.add(nombre);
		contentPanel.add(direccion);
		contentPanel.add(codPostal);
		contentPanel.add(telefono);
		contentPanel.add(btnGuardar);
		contentPanel.add(btnCancelar);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(127, 38, 37, 14);
		contentPanel.add(lblId);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(231, 35, 86, 20);
		contentPanel.add(id);
	}

	public void clear() {
		this.nombre.setText("");
		this.direccion.setText("");
		this.telefono.setText("");
		this.codPostal.setText("");	
	}
}
