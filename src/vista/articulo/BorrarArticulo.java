package vista.articulo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorArticulo;
import modelo.Articulo;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class BorrarArticulo extends JDialog {
	private JTextField id;

	private ControladorArticulo controladorArticulo;
	
	private JComboBox lista;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblProveedor;
	private JLabel lblPrecio;
	private JTextField nombre;
	private JTextField proveedor;
	private JTextField precio;
	private JTextField existencias;
	private JLabel label;
	private JLabel lblExistencias_1;

	public ControladorArticulo getControladorArticulo() {
		return controladorArticulo;
	}

	public void setControladorArticulo(ControladorArticulo controladorArticulo) {
		this.controladorArticulo = controladorArticulo;
	}

	/**
	 * Create the dialog.
	 */
	public BorrarArticulo(JDialog parent, boolean modal) {
		
		super(parent,modal);
		
		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(null);
		{
			lista = new JComboBox();
			lista.setFont(new Font("Cambria", Font.PLAIN, 13));
			lista.setBounds(56, 49, 327, 23);
			getContentPane().add(lista);
			lista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					controladorArticulo.seleccionarDatosArticulo((String)lista.getSelectedItem());
						
				}
			});
			lista.setModel(new DefaultComboBoxModel(new String[] {"Elige articulo...."}));
		}
		{
			id = new JTextField();
			id.setBounds(214, 110, 86, 19);
			getContentPane().add(id);
			id.setEditable(false);
			id.setColumns(10);
		}
		{
			lblId = new JLabel("Id ");
			lblId.setFont(new Font("Cambria", Font.BOLD, 15));
			lblId.setBounds(56, 107, 46, 23);
			getContentPane().add(lblId);
			lblId.setForeground(Color.WHITE);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Cambria", Font.BOLD, 15));
			lblNombre.setBounds(56, 144, 64, 23);
			getContentPane().add(lblNombre);
			lblNombre.setForeground(Color.WHITE);
		}
		{
			lblProveedor = new JLabel("Proveedor");
			lblProveedor.setFont(new Font("Cambria", Font.BOLD, 15));
			lblProveedor.setBounds(56, 180, 76, 23);
			getContentPane().add(lblProveedor);
			lblProveedor.setForeground(Color.WHITE);
		}
		{
			lblPrecio = new JLabel("Precio");
			lblPrecio.setFont(new Font("Cambria", Font.BOLD, 15));
			lblPrecio.setBounds(56, 214, 76, 23);
			getContentPane().add(lblPrecio);
			lblPrecio.setForeground(Color.WHITE);
		}
		
		JButton borrar = new JButton("BORRAR");
		borrar.setBounds(432, 251, 86, 23);
		getContentPane().add(borrar);
		borrar.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		nombre = new JTextField();
		nombre.setBounds(214, 146, 169, 19);
		getContentPane().add(nombre);
		nombre.setEditable(false);
		nombre.setColumns(10);
		
		proveedor = new JTextField();
		proveedor.setBounds(214, 180, 169, 19);
		getContentPane().add(proveedor);
		proveedor.setEditable(false);
		proveedor.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(214, 216, 86, 19);
		getContentPane().add(precio);
		precio.setEditable(false);
		precio.setColumns(10);
		{
			existencias = new JTextField();
			existencias.setBounds(214, 252, 86, 19);
			getContentPane().add(existencias);
			existencias.setEditable(false);
			existencias.setColumns(10);
		}
		{
			lblExistencias_1 = new JLabel("Existencias");
			lblExistencias_1.setForeground(Color.WHITE);
			lblExistencias_1.setFont(new Font("Cambria", Font.BOLD, 15));
			lblExistencias_1.setBounds(56, 250, 90, 23);
			getContentPane().add(lblExistencias_1);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(BorrarArticulo.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
			label.setBounds(0, 0, 552, 316);
			getContentPane().add(label);
		}
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorArticulo.borrarArticulo((String)lista.getSelectedItem());
				controladorArticulo.abrirBorrarArticulo();
			}
		});
	
	}

	public void rellenarLista(ArrayList<Articulo> articulos) {
		
		lista.removeAllItems();
		
		for (Articulo articulo:articulos){
			
			lista.addItem(articulo.getNombre());
		}
	}

	public void mostrarDatos(Articulo articulo) {
		
		id.setText(String.valueOf(articulo.getId()));
		nombre.setText(articulo.getNombre());
		proveedor.setText(articulo.getProveedor());
		precio.setText(String.valueOf(articulo.getPrecio()));
		existencias.setText(String.valueOf(articulo.getExistencias()));
		
	}
public void limpiar() {
		lista.setSelectedIndex(0);
		id.setText("");
		nombre.setText("");
		proveedor.setText("");
		precio.setText("");
		existencias.setText("");
		
	}
}
