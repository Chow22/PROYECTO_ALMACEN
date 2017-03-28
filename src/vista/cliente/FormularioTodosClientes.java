package vista.cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.ControladorCliente;
import controlador.ControladorCliente;
import modelo.Cliente;
import vista.Principal;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class FormularioTodosClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ControladorCliente controladorCliente;
	private JTable tabla;


	public ControladorCliente getControladorCliente() {
		return controladorCliente;
	}

	public void setControladorCliente(ControladorCliente controladorCliente) {
		this.controladorCliente = controladorCliente;
	}




	/**
	 * Create the dialog.
	 */
	public FormularioTodosClientes( JDialog parent, boolean modal) {
		
		super(parent,modal);
		
		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 552, 316);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblConsultasDeClientes = new JLabel("CONSULTAS DE CLIENTES");
		lblConsultasDeClientes.setForeground(Color.WHITE);
		lblConsultasDeClientes.setBounds(110, 29, 300, 24);
		lblConsultasDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultasDeClientes.setFont(new Font("Cambria", Font.BOLD, 25));
		contentPanel.add(lblConsultasDeClientes);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 552, 316);
		contentPanel.add(label);
		label.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 54, 403, 196);
		contentPanel.add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setColumnHeaderView(tabla);
	}

	public void rellenarTabla(ArrayList<Cliente> Clientes) {
		
		DefaultTableModel dtm=new DefaultTableModel();
		
		String[] cabeceras={"NOMBRE","DIRECCION","CODIGO POSTAL","TELEFONO"};
		
		dtm.setColumnIdentifiers(cabeceras);
		
		for (Cliente cliente:Clientes){
			
			String[] fila={cliente.getNombre(),cliente.getDireccion(),cliente.getCodPostal(),cliente.getTelefono()};
			
			//System.out.println(cliente.getNombre()+" "+cliente.getApellido()+" "+cliente.getPoblacion());
			
			dtm.addRow(fila);
		}
		
		tabla.setModel(dtm);
		TableRowSorter<DefaultTableModel> modeloOrdenado = new TableRowSorter<DefaultTableModel>(dtm);
		tabla.setRowSorter(modeloOrdenado);
	}

}
