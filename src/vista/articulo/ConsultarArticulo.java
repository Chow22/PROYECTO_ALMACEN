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

import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;

public class ConsultarArticulo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private ControladorArticulo controladorArticulo;
	private JComboBox nombres;
	private JComboBox proveedores;
	private JComboBox num_pag;
	private JTable tablaPorNombre;

	
	public ConsultarArticulo(JDialog parent, boolean modal) {
		
		super(parent,modal);
		
		setBounds(100, 100, 450, 300);
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
						
						controladorArticulo.seleccionarArticulosPorNombre((String)nombres.getSelectedItem());
							
					}
				});
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 85, 419, 138);
					PorNombre.add(scrollPane);
					{
						tablaPorNombre = new JTable();
						scrollPane.setViewportView(tablaPorNombre);
					}
				}
				nombres.setBounds(126, 29, 232, 20);
				PorNombre.add(nombres);
				
				JLabel nombre = new JLabel("Nombres");
				nombre.setBounds(32, 32, 46, 14);
				PorNombre.add(nombre);
			}
			{
				JPanel porProveedor = new JPanel();
				tabbedPane.addTab("Por Proveedor", null, porProveedor, null);
				porProveedor.setLayout(null);
				{
					JLabel lblProveedores = new JLabel("Proveedores");
					lblProveedores.setBounds(26, 27, 61, 14);
					porProveedor.add(lblProveedores);
				}
				{
					proveedores = new JComboBox();
					proveedores.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
							
							//controladorArticulo.seleccionarArticulosPorProveedor((String)titulos.setSelectedItem());
						}
					});
					proveedores.setBounds(146, 24, 228, 20);
					porProveedor.add(proveedores);
				}
			}
			{
				JPanel PorPrecio = new JPanel();
				tabbedPane.addTab("Por Precio", null, PorPrecio, null);
				PorPrecio.setLayout(null);
				{
					JLabel lblPrecio = new JLabel("Precio");
					lblPrecio.setBounds(54, 30, 76, 14);
					PorPrecio.add(lblPrecio);
				}
				{
					num_pag = new JComboBox();
					num_pag.setModel(new DefaultComboBoxModel(new String[] {"<  5", " > 5 y <  30", "> 30"}));
					num_pag.setBounds(173, 27, 224, 20);
					PorPrecio.add(num_pag);
				}
			}
		}
	}


	public void rellenarTablaPorNombre(ArrayList<Articulo> articulos) {

		DefaultTableModel dtm=new DefaultTableModel();
		
		String[] encabezados={"ID","TITULO","AUTOR","NUM PAGINAS"};
		
		dtm.setColumnIdentifiers(encabezados);
		
		for (Articulo articulo: articulos){
			
			String[]  fila={ String.valueOf(articulo.getId()),articulo.getNombre(),articulo.getProveedor(),String.valueOf(articulo.getPrecio()),String.valueOf(articulo.getExistencias())};
			dtm.addRow(fila);
		}
		tablaPorNombre.setModel(dtm);
		
	}
	public void rellenarTablaPorProveedor(ArrayList<Articulo> articulos) {

		DefaultTableModel dtm=new DefaultTableModel();
				
				String[] encabezados={"ID","TITULO","AUTOR","NUM PAGINAS"};
				
				dtm.setColumnIdentifiers(encabezados);
				
				for (Articulo articulo:articulos){
					
					String[]  fila={ String.valueOf(articulo.getId()),articulo.getNombre(),articulo.getProveedor(),String.valueOf(articulo.getPrecio()),String.valueOf(articulo.getExistencias())};
					dtm.addRow(fila);
				}
				//tablaPorProveedor.setModel(dtm);
				
			}
	

	public ControladorArticulo getControladorArticulo() {
		return controladorArticulo;
	}


	public void setControladorArticulo(ControladorArticulo controladorArticulo) {
		this.controladorArticulo= controladorArticulo;
	}


	public void rellenarListaProveedors(ArrayList<Articulo> articulos) {
		proveedores.removeAllItems();
		
		for (Articulo articulo:articulos){
			proveedores.addItem(articulo.getProveedor());
		}
	}


	public void rellenarListaNombres(ArrayList<String> valores) {
		nombres.removeAllItems();
		
		for (String autor:valores){	
			nombres.addItem(autor);
		}
	}
}
