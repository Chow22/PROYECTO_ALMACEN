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

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormularioDeModificado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField direccion;
	private JTextField codPostal;
	private JTextField telefono;
	private JComboBox comboBoxClientes;

	private ControladorCliente controladorCliente;
	private JTextField id;
	private JButton modificar;
	private JButton cancelButton;
	private JLabel label_1;

	/**
	 * Create the dialog.
	 */
	public FormularioDeModificado(GestionCliente parent, boolean modal) {
		super(parent, modal);

		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 552, 316);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Cambria", Font.BOLD, 14));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(103, 146, 65, 14);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Cambria", Font.BOLD, 14));
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setBounds(103, 171, 79, 14);

		JLabel lblCodPostal = new JLabel("Codigo Postal");
		lblCodPostal.setFont(new Font("Cambria", Font.BOLD, 14));
		lblCodPostal.setForeground(Color.WHITE);
		lblCodPostal.setBounds(103, 196, 100, 14);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Cambria", Font.BOLD, 14));
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setBounds(103, 223, 79, 14);
		
		comboBoxClientes = new JComboBox();
		comboBoxClientes.setBounds(253, 90, 173, 20);
		
		comboBoxClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(e.getActionCommand());
				String nombreCliente = (String) comboBoxClientes.getSelectedItem();
				if (nombreCliente != null) {
					String[] partes = nombreCliente.split(":");
					// en la parte 0 esta el id del cliente
					controladorCliente.rellenarFormDeModificado(partes[0]);
				}
			}
		});
		
		JLabel lblSelccionaElAlumno = new JLabel("Selcciona el alumno");
		lblSelccionaElAlumno.setForeground(Color.WHITE);
		lblSelccionaElAlumno.setBounds(103, 92, 122, 15);
		lblSelccionaElAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));

		nombre = new JTextField();
		nombre.setBounds(253, 144, 173, 20);
		nombre.setColumns(10);

		direccion = new JTextField();
		direccion.setBounds(253, 169, 173, 20);
		direccion.setColumns(10);

		codPostal = new JTextField();
		codPostal.setBounds(253, 194, 86, 20);
		codPostal.setColumns(10);

		telefono = new JTextField();
		telefono.setBounds(253, 221, 86, 20);
		telefono.setColumns(10);

		JLabel lblId = new JLabel("id");
		lblId.setFont(new Font("Cambria", Font.BOLD, 14));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(103, 119, 65, 14);

		id = new JTextField();
		id.setBounds(253, 117, 86, 20);
		id.setEnabled(false);
		id.setEditable(false);
		id.setColumns(10);
		{
			modificar = new JButton("MODIFICAR");
			modificar.setFont(new Font("Cambria", Font.BOLD, 12));
			modificar.setBounds(103, 282, 111, 23);
			modificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modificacion();
				}
			});
			modificar.setActionCommand("OK");
			getRootPane().setDefaultButton(modificar);
		}
		{
			cancelButton = new JButton("CANCEL");
			cancelButton.setFont(new Font("Cambria", Font.BOLD, 12));
			cancelButton.setBounds(224, 282, 91, 23);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controladorCliente.cerrarFormularioDeBorrado();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		contentPanel.setLayout(null);
		contentPanel.add(modificar);
		contentPanel.add(cancelButton);
		contentPanel.add(lblNombre);
		contentPanel.add(lblDireccion);
		contentPanel.add(nombre);
		contentPanel.add(id);
		contentPanel.add(direccion);
		contentPanel.add(lblId);
		contentPanel.add(lblCodPostal);
		contentPanel.add(lblTelefono);
		contentPanel.add(telefono);
		contentPanel.add(codPostal);
		contentPanel.add(lblSelccionaElAlumno);
		contentPanel.add(comboBoxClientes);
				
				label_1 = new JLabel("FORMULARIO DE BORRADO");
				label_1.setForeground(Color.WHITE);
				label_1.setFont(new Font("Cambria", Font.BOLD, 26));
				label_1.setBounds(96, 28, 343, 31);
				contentPanel.add(label_1);
		
				JLabel label = new JLabel("");
				label.setBounds(0, 0, 552, 316);
				contentPanel.add(label);
				label.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
	}

	protected void modificacion() {
	
			this.controladorCliente.modificarCliente(this.id.getText(), this.nombre.getText(), this.direccion.getText(), this.codPostal.getText(), this.telefono.getText());
		
		
	}

	public void rellenarComboClientes(ArrayList<Cliente> clientes) {
		Iterator<Cliente> iterator = clientes.iterator();
		while (iterator.hasNext()) {
			Cliente cliente = iterator.next();
			this.comboBoxClientes.addItem(cliente.getId() + ": " + cliente.getNombre() + " " + cliente.getDireccion());
		}
	}

	public ControladorCliente getControladorCliente() {
		return controladorCliente;
	}

	public void setControladorCliente(ControladorCliente controladorCliente) {
		this.controladorCliente = controladorCliente;
	}

	public void rellenarFormulario(Cliente cliente) {
		this.id.setText(String.valueOf(cliente.getId()));
		this.nombre.setText(cliente.getNombre());
		this.direccion.setText(cliente.getDireccion());
		this.codPostal.setText(cliente.getCodPostal());
		this.telefono.setText(cliente.getTelefono());
	}

	public void clear() {
		this.comboBoxClientes.removeAllItems();
		this.id.setText("");
		this.nombre.setText("");
		this.direccion.setText("");
		this.codPostal.setText("");
		this.telefono.setText("");
	}

	public void mostrarMensaje(String string) {
		JOptionPane.showMessageDialog(this, string);
		
	}



	
}
