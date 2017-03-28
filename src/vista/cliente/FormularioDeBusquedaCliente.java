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
	private JComboBox comboTelefono;
	private JComboBox comboCodPostal;

	/**
	 * Create the dialog.
	 */
	public FormularioDeBusquedaCliente(GestionCliente parent, boolean modal) {
		super(parent, modal);

		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 552, 316);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(90, 104, 71, 14);
		lblNombre.setFont(new Font("Cambria", Font.BOLD, 14));
		lblNombre.setForeground(Color.WHITE);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(90, 134, 71, 14);
		lblDireccion.setFont(new Font("Cambria", Font.BOLD, 14));
		lblDireccion.setForeground(Color.WHITE);

		JLabel lblCodPostal = new JLabel("Codigo Postal");
		lblCodPostal.setBounds(90, 168, 93, 14);
		lblCodPostal.setFont(new Font("Cambria", Font.BOLD, 14));
		lblCodPostal.setForeground(Color.WHITE);

		JLabel lblSelccionaElAlumno = new JLabel("Busqueda de Cliente");
		lblSelccionaElAlumno.setBounds(133, 33, 259, 31);
		lblSelccionaElAlumno.setForeground(Color.WHITE);
		lblSelccionaElAlumno.setFont(new Font("Cambria", Font.BOLD, 26));

		nombre = new JTextField();
		nombre.setBounds(193, 97, 155, 20);
		nombre.setEditable(true);
		nombre.setEnabled(true);
		nombre.setColumns(10);

		apellido = new JTextField();
		apellido.setBounds(193, 126, 155, 20);
		apellido.setEditable(true);
		apellido.setEnabled(true);
		apellido.setColumns(10);
		
		JButton buscarNombre = new JButton("Buscar");
		buscarNombre.setBounds(358, 96, 88, 23);
		buscarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorCliente.mostrarClientesPorNombre(nombre.getText());
			}
		});
		
		
		
		JButton buscarApellido = new JButton("Buscar");
		buscarApellido.setBounds(358, 125, 88, 23);
		buscarApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorCliente.mostrarClientesPorApellido(apellido.getText());
			}
		});
		
		
		JButton buscarPoblacion = new JButton("Buscar");
		buscarPoblacion.setBounds(358, 159, 88, 23);
		buscarPoblacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorCliente.mostrarClientesPorPoblacion(String.valueOf(comboCodPostal.getSelectedItem()));
			}
		});
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(90, 193, 73, 14);
		lblTelefono.setFont(new Font("Cambria", Font.BOLD, 14));
		lblTelefono.setForeground(Color.WHITE);
		
		comboTelefono = new JComboBox();
		comboTelefono.setBounds(193, 191, 155, 20);
		comboTelefono.setEditable(true);
		
		comboCodPostal = new JComboBox();
		comboCodPostal.setBounds(193, 160, 155, 20);
		comboCodPostal.setEditable(true);
		JButton buscarProvincia = new JButton("Buscar");
		buscarProvincia.setBounds(358, 190, 88, 23);
		buscarProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorCliente.mostrarClientesPorProvincia(String.valueOf(comboTelefono.getSelectedItem()));
			}
		});
		contentPanel.setLayout(null);
		contentPanel.add(lblNombre);
		contentPanel.add(lblDireccion);
		contentPanel.add(lblCodPostal);
		contentPanel.add(lblTelefono);
		contentPanel.add(nombre);
		contentPanel.add(apellido);
		contentPanel.add(comboCodPostal);
		contentPanel.add(comboTelefono);
		contentPanel.add(buscarNombre);
		contentPanel.add(buscarApellido);
		contentPanel.add(buscarPoblacion);
		contentPanel.add(buscarProvincia);
		contentPanel.add(lblSelccionaElAlumno);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 552, 316);
		contentPanel.add(label);
		label.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
		
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
