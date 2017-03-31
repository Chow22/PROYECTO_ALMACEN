package vista.articulo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorArticulo;
import modelo.Articulo;
import modelo.Articulo;
import vista.Principal;

import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class ConsultarArticulo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ControladorArticulo controladorArticulo;
	private JComboBox nombres;
	private JComboBox proveedores;
	private JComboBox precio;

	private JTable tablaPorNombre;
	private JTable tablaPorProveedor;

	public ControladorArticulo getControladorArticulo() {
		return controladorArticulo;
	}

	public void setControladorArticulo(ControladorArticulo controladorArticulo) {
		this.controladorArticulo = controladorArticulo;
	}

	public ConsultarArticulo(JDialog parent, boolean modal) {

		super(parent, modal);

		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			contentPanel.add(tabbedPane, "name_82353901282691");
			{
				JPanel PorNombre = new JPanel();
				tabbedPane.addTab("Por Nombre", null, PorNombre, null);
				PorNombre.setLayout(null);

				nombres = new JComboBox();
				nombres.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {

						controladorArticulo.seleccionarArticulosPorNombre((String) nombres.getSelectedItem());

					}
				});
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(51, 91, 419, 138);
					PorNombre.add(scrollPane);
					{
						tablaPorNombre = new JTable();
						scrollPane.setViewportView(tablaPorNombre);
					}
				}
				nombres.setBounds(187, 29, 232, 20);
				PorNombre.add(nombres);

				JLabel nombre = new JLabel("Nombres");
				nombre.setForeground(Color.WHITE);
				nombre.setBounds(73, 32, 63, 14);
				PorNombre.add(nombre);
				{
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon(
							ConsultarArticulo.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
					label.setBounds(0, 0, 537, 278);
					PorNombre.add(label);
				}
			}
			{
				JPanel porProveedor = new JPanel();
				tabbedPane.addTab("Por Proveedor", null, porProveedor, null);
				porProveedor.setLayout(null);
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(44, 94, 419, 138);
					porProveedor.add(scrollPane);
					{
						tablaPorProveedor = new JTable();
						scrollPane.setViewportView(tablaPorProveedor);
					}
				}
				{
					JLabel lblProveedores = new JLabel("Proveedores");
					lblProveedores.setForeground(Color.WHITE);
					lblProveedores.setBounds(72, 33, 81, 14);
					porProveedor.add(lblProveedores);
				}
				{
					proveedores = new JComboBox();
					proveedores.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {

							controladorArticulo.seleccionarArticulosPorProveedor((String)proveedores.getSelectedItem());
						}
					});
					proveedores.setBounds(221, 30, 228, 20);
					porProveedor.add(proveedores);
				}
				{
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon(
							ConsultarArticulo.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
					label.setBounds(0, 0, 537, 278);
					porProveedor.add(label);
				}
			}
			{
				JPanel PorPrecio = new JPanel();
				tabbedPane.addTab("Por Precio", null, PorPrecio, null);
				PorPrecio.setLayout(null);
				{
					JLabel lblPrecio = new JLabel("Precio");
					lblPrecio.setForeground(Color.WHITE);
					lblPrecio.setBounds(82, 33, 76, 14);
					PorPrecio.add(lblPrecio);
				}
				{
					precio = new JComboBox();
					precio.setModel(new DefaultComboBoxModel(new String[] { "<  5", " > 5 y <  30", "> 30" }));
					precio.setBounds(217, 30, 224, 20);
					PorPrecio.add(precio);
				}

				JLabel label = new JLabel("");
				PorPrecio.add(label);
				label.setIcon(
						new ImageIcon(Principal.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
				label.setBounds(0, 0, 537, 278);
			}
		}
	}

	public void rellenarTablaPorNombre(ArrayList<Articulo> articulos) {

		DefaultTableModel dtm = new DefaultTableModel();

		String[] encabezados = { "ID", "NOMBRE", "PROVEEDOR", "PRECIO", "EXISTENCIAS" };

		dtm.setColumnIdentifiers(encabezados);

		for (Articulo articulo : articulos) {

			String[] fila = { String.valueOf(articulo.getId()), articulo.getNombre(), articulo.getProveedor(),
					String.valueOf(articulo.getPrecio()), String.valueOf(articulo.getExistencias()) };
			dtm.addRow(fila);
		}
		tablaPorNombre.setModel(dtm);

	}
	
	public void rellenarTablaPorProveedor(ArrayList<Articulo> articulos) {

		DefaultTableModel dtm = new DefaultTableModel();

		String[] encabezados = { "ID", "NOMBRE", "PROVEEDOR", "PRECIO", "EXISTENCIAS" };

		dtm.setColumnIdentifiers(encabezados);

		for (Articulo articulo : articulos) {

			String[] fila = { String.valueOf(articulo.getId()), articulo.getNombre(), articulo.getProveedor(),
					String.valueOf(articulo.getPrecio()), String.valueOf(articulo.getExistencias()) };
			dtm.addRow(fila);
		}
		tablaPorProveedor.setModel(dtm);

	}

	public void rellenarListaConsultaNombres(ArrayList<Articulo> articulos) {
		nombres.removeAllItems();

		for (Articulo articulo : articulos) {
			nombres.addItem(articulo.getNombre());
		}

	}

	public void rellenarListaConsultaProveedores(ArrayList<Articulo> articulos) {
		proveedores.removeAllItems();

		for (Articulo articulo : articulos) {
			proveedores.addItem(articulo.getProveedor());
		}
		
	}
}
