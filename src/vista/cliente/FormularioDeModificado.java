package vista.cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorCliente;
import modelo.Cliente;

import javax.swing.GroupLayout;
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

public class FormularioDeModificado extends JDialog {

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
	public FormularioDeModificado(GestionCliente parent, boolean modal) {
		super(parent, modal);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblDireccion = new JLabel("Direccion");

		JLabel lblCodPostal = new JLabel("Codigo Postal");

		JLabel lblTelefono = new JLabel("Telefono");

		comboBoxClientes = new JComboBox();
		
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
		lblSelccionaElAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));

		nombre = new JTextField();
		nombre.setColumns(10);

		direccion = new JTextField();
		direccion.setColumns(10);

		codPostal = new JTextField();
		codPostal.setColumns(10);

		telefono = new JTextField();
		telefono.setColumns(10);

		JLabel lblId = new JLabel("id");

		id = new JTextField();
		id.setEnabled(false);
		id.setEditable(false);
		id.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombre)
										.addComponent(lblDireccion))
									.addGap(32)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblId)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCodPostal)
										.addComponent(lblTelefono))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(telefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(codPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(22)
							.addComponent(lblSelccionaElAlumno)
							.addGap(18)
							.addComponent(comboBoxClientes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(237, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxClientes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelccionaElAlumno))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodPostal)
						.addComponent(codPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(telefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton modificar = new JButton("MODIFICAR");
				modificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modificacion();
					}
				});
				modificar.setActionCommand("OK");
				buttonPane.add(modificar);
				getRootPane().setDefaultButton(modificar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorCliente.cerrarFormularioDeBorrado();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
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
