package vista;

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

	private final JPanel contentPanel = new JPanel();
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
	private JLabel lblExistencias;
	private JTextField existencias;

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
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			lista = new JComboBox();
			lista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					controladorArticulo.seleccionarDatosArticulo((String)lista.getSelectedItem());
						
				}
			});
			lista.setModel(new DefaultComboBoxModel(new String[] {"Elige articulo...."}));
			lista.setBounds(88, 25, 217, 23);
			contentPanel.add(lista);
		}
		{
			id = new JTextField();
			id.setEditable(false);
			id.setColumns(10);
			id.setBounds(219, 82, 86, 14);
			contentPanel.add(id);
		}
		{
			lblId = new JLabel("Id ");
			lblId.setForeground(Color.WHITE);
			lblId.setBounds(88, 82, 46, 14);
			contentPanel.add(lblId);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setBounds(88, 107, 46, 14);
			contentPanel.add(lblNombre);
		}
		{
			lblProveedor = new JLabel("Proveedor");
			lblProveedor.setForeground(Color.WHITE);
			lblProveedor.setBounds(88, 132, 64, 14);
			contentPanel.add(lblProveedor);
		}
		{
			lblPrecio = new JLabel("Precio");
			lblPrecio.setForeground(Color.WHITE);
			lblPrecio.setBounds(88, 157, 90, 14);
			contentPanel.add(lblPrecio);
		}
		
		JButton borrar = new JButton("BORRAR");
		borrar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorArticulo.borrarArticulo((String)lista.getSelectedItem());
			}
		});
		borrar.setBounds(219, 227, 86, 23);
		contentPanel.add(borrar);
		
		nombre = new JTextField();
		nombre.setEditable(false);
		nombre.setColumns(10);
		nombre.setBounds(219, 107, 86, 14);
		contentPanel.add(nombre);
		
		proveedor = new JTextField();
		proveedor.setEditable(false);
		proveedor.setColumns(10);
		proveedor.setBounds(219, 132, 86, 14);
		contentPanel.add(proveedor);
		
		precio = new JTextField();
		precio.setEditable(false);
		precio.setColumns(10);
		precio.setBounds(219, 157, 86, 14);
		contentPanel.add(precio);
		{
			lblExistencias = new JLabel("Existencias");
			lblExistencias.setForeground(Color.WHITE);
			lblExistencias.setBounds(88, 182, 90, 14);
			contentPanel.add(lblExistencias);
		}
		{
			existencias = new JTextField();
			existencias.setEditable(false);
			existencias.setColumns(10);
			existencias.setBounds(219, 184, 86, 14);
			contentPanel.add(existencias);
		}
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(BorrarArticulo.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
		label_4.setBounds(0, 0, 434, 261);
		contentPanel.add(label_4);
	
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
