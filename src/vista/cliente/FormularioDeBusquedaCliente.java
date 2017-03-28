package vista.cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;

public class FormularioDeBusquedaCliente extends JDialog {
//	public FormularioBusquedaCliente() {
//	}
	
	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField apellido;

	private ControladorCliente controladorCliente;
	private JTable table;
	private JComboBox comboTelefono;
	private JComboBox comboCodPostal;

	/**
	 * Create the dialog.
	 */
	public FormularioDeBusquedaCliente(GestionCliente parent, boolean modal) {
		super(parent, modal);

		setBounds(100, 100, 596, 328);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.SOUTH);

		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblDireccion = new JLabel("Direccion");

		JLabel lblCodPostal = new JLabel("Codigo Postal");
		

		JLabel lblSelccionaElAlumno = new JLabel("Busqueda de Cliente");
		lblSelccionaElAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));

		nombre = new JTextField();
		nombre.setEditable(true);
		nombre.setEnabled(true);
		nombre.setColumns(10);

		apellido = new JTextField();
		apellido.setEditable(true);
		apellido.setEnabled(true);
		apellido.setColumns(10);
		
		JButton buscarNombre = new JButton("Buscar");
		buscarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorCliente.mostrarClientesPorNombre(nombre.getText());
			}
		});
		
		
		
		JButton buscarApellido = new JButton("Buscar");
		buscarApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorCliente.mostrarClientesPorApellido(apellido.getText());
			}
		});
		
		
		JButton buscarPoblacion = new JButton("Buscar");
		buscarPoblacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorCliente.mostrarClientesPorPoblacion(String.valueOf(comboCodPostal.getSelectedItem()));
			}
		});
		
		JLabel lblTelefono = new JLabel("Telefono");
		
		comboTelefono = new JComboBox();
		comboTelefono.setEditable(true);
		
		comboCodPostal = new JComboBox();
		comboCodPostal.setEditable(true);
		
		JButton buscarProvincia = new JButton("Buscar");
		buscarProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorCliente.mostrarClientesPorProvincia(String.valueOf(comboTelefono.getSelectedItem()));
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblDireccion)
								.addComponent(lblCodPostal)
								.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboCodPostal, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboTelefono, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(buscarNombre, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(buscarApellido, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(buscarPoblacion, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(buscarProvincia, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(22)
							.addComponent(lblSelccionaElAlumno))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblSelccionaElAlumno)
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNombre))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(buscarNombre))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblDireccion))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(buscarApellido))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodPostal)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(comboCodPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(buscarPoblacion))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblTelefono))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(comboTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(buscarProvincia))
					.addGap(7)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addGap(12))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setToolTipText("Prueba");
		contentPanel.setLayout(gl_contentPanel);
		
	}

	
	
	

	public ControladorCliente getControladorCliente() {
		return controladorCliente;
	}

	public void setControladorCliente(ControladorCliente controladorCliente) {
		this.controladorCliente = controladorCliente;
	}

	public void rellenarTabla(ArrayList<Cliente> clientes) {
		DefaultTableModel dtm = new DefaultTableModel();

		dtm.setColumnIdentifiers(new Object[] { "NOMBRE", "DIRECCION", "CODIGO POSTAL", "TELEFONO"});

		for (Cliente cliente : clientes) {
			dtm.addRow(new Object[] { cliente.getNombre(), cliente.getDireccion(), cliente.getCodPostal(), cliente.getTelefono()});
		}
		table.setModel(dtm);
		TableRowSorter<DefaultTableModel> modeloOrdenado = new TableRowSorter<DefaultTableModel>(dtm);
		table.setRowSorter(modeloOrdenado);
		
	}


	public void rellenarComboDireccion(ArrayList<String> direcciones) {
		for(String direccion: direcciones){
			//TODO  no existe el comboDirecciones
		}
	}

	
	public void rellenarComboPoblacion(ArrayList<String> pueblos) {
		for(String pueblo: pueblos){
			this.comboCodPostal.addItem(pueblo);
		}
		this.comboCodPostal.setSelectedIndex(-1);
	}

	
	public void rellenarComboProvincia(ArrayList<String> provincias) {
		for(String provincia: provincias){
			this.comboTelefono.addItem(provincia);
		}
		this.comboTelefono.setSelectedIndex(-1);
		
	}





}
