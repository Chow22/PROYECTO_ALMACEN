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

public class FormularioDeBorrado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField direccion;
	private JTextField codPostal;
	private JTextField telefono;
	private JComboBox comboBoxClientes;

	private ControladorCliente controladorCliente;
	private JTextField id;

	/**
	 * Create the dialog.
	 */
	public FormularioDeBorrado(GestionCliente parent, boolean modal) {
		super(parent, modal);

		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 552, 316);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(126, 143, 65, 14);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Cambria", Font.BOLD, 13));
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setBounds(126, 172, 65, 14);

		JLabel lblCodPostal = new JLabel("Codigo Postal");
		lblCodPostal.setFont(new Font("Cambria", Font.BOLD, 13));
		lblCodPostal.setForeground(Color.WHITE);
		lblCodPostal.setBounds(126, 197, 86, 14);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Cambria", Font.BOLD, 13));
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setBounds(126, 222, 86, 14);
		
		comboBoxClientes = new JComboBox();
		comboBoxClientes.setBounds(257, 75, 185, 20);
		
		comboBoxClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(e.getActionCommand());
				if(comboBoxClientes.getSelectedIndex() == -1){
					clearTextFields();
				}else{
					String nombreCliente = (String) comboBoxClientes.getSelectedItem();
					if (nombreCliente != null) {
						String[] partes = nombreCliente.split(":");
						// en la parte 0 esta el id del cliente
						controladorCliente.rellenarFormDeBorrado(partes[0]);
					}
				}
				
			}
		});
		

		JLabel lblSelccionaElAlumno = new JLabel("Selcciona el alumno");
		lblSelccionaElAlumno.setForeground(Color.WHITE);
		lblSelccionaElAlumno.setBounds(126, 77, 119, 15);
		lblSelccionaElAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));

		nombre = new JTextField();
		nombre.setBounds(257, 141, 185, 20);
		nombre.setEditable(false);
		nombre.setEnabled(false);
		nombre.setColumns(10);

		direccion = new JTextField();
		direccion.setBounds(257, 166, 185, 20);
		direccion.setEditable(false);
		direccion.setEnabled(false);
		direccion.setColumns(10);

		codPostal = new JTextField();
		codPostal.setBounds(257, 195, 86, 20);
		codPostal.setEditable(false);
		codPostal.setEnabled(false);
		codPostal.setColumns(10);

		telefono = new JTextField();
		telefono.setBounds(257, 220, 86, 20);
		telefono.setEditable(false);
		telefono.setEnabled(false);
		telefono.setColumns(10);

		JLabel lblId = new JLabel("id");
		lblId.setFont(new Font("Cambria", Font.BOLD, 13));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(126, 116, 65, 14);

		id = new JTextField();
		id.setBounds(257, 114, 86, 20);
		id.setEnabled(false);
		id.setEditable(false);
		id.setColumns(10);
		contentPanel.setLayout(null);
		contentPanel.add(lblTelefono);
		contentPanel.add(lblCodPostal);
		contentPanel.add(lblNombre);
		contentPanel.add(lblDireccion);
		contentPanel.add(nombre);
		contentPanel.add(id);
		contentPanel.add(codPostal);
		contentPanel.add(telefono);
		contentPanel.add(direccion);
		contentPanel.add(lblId);
		contentPanel.add(lblSelccionaElAlumno);
		contentPanel.add(comboBoxClientes);
		{
			JButton borrar = new JButton("BORRAR");
			borrar.setFont(new Font("Cambria", Font.BOLD, 13));
			borrar.setBounds(126, 282, 86, 23);
			contentPanel.add(borrar);
			borrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminacion();
				}
			});
			borrar.setActionCommand("OK");
			getRootPane().setDefaultButton(borrar);
		}
		{
			JButton cancelButton = new JButton("CANCEL");
			cancelButton.setFont(new Font("Cambria", Font.BOLD, 13));
			cancelButton.setBounds(222, 282, 91, 23);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controladorCliente.cerrarFormularioDeBorrado();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
				
				JLabel lblFormularioDeBorrado = new JLabel("FORMULARIO DE BORRADO");
				lblFormularioDeBorrado.setForeground(Color.WHITE);
				lblFormularioDeBorrado.setFont(new Font("Cambria", Font.BOLD, 26));
				lblFormularioDeBorrado.setBounds(118, 25, 343, 31);
				contentPanel.add(lblFormularioDeBorrado);
		
				JLabel label = new JLabel("");
				label.setBounds(0, 0, 552, 316);
				contentPanel.add(label);
				label.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
	}

	protected void eliminacion() {
		int respuesta = JOptionPane.showConfirmDialog(this, "Desea realmente eliminar?", "adf", JOptionPane.YES_NO_OPTION);
		System.out.println(respuesta);
		if (respuesta==JOptionPane.YES_OPTION){
			this.controladorCliente.eliminarCliente(this.id.getText());
		}
		
	}

	public void rellenarComboClientes(ArrayList<Cliente> clientes) {
		Iterator<Cliente> iterator = clientes.iterator();
		while (iterator.hasNext()) {
			Cliente cliente = iterator.next();
			this.comboBoxClientes.addItem(cliente.getId() + ": " + cliente.getNombre() + " " + cliente.getDireccion());
		}
		comboBoxClientes.setSelectedIndex(-1);
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

	public void clearForm() {
		this.comboBoxClientes.removeAllItems();
		this.clearTextFields();
	}
	
	public void clearTextFields(){
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
