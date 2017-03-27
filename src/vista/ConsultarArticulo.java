package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorArticulo;
import modelo.Articulo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ConsultarArticulo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ControladorArticulo controladorArticulo;
	private JTable tabla;

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
		contentPanel.setLayout(null);

		JLabel lblConsultasDeArticulos = new JLabel("CONSULTAS DE ARTICULOS");
		lblConsultasDeArticulos.setForeground(Color.WHITE);
		lblConsultasDeArticulos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultasDeArticulos.setFont(new Font("Cambria", Font.BOLD, 24));
		lblConsultasDeArticulos.setBounds(79, 11, 380, 39);
		contentPanel.add(lblConsultasDeArticulos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(34, 61, 477, 216);
		contentPanel.add(scrollPane_1);
		
		tabla = new JTable();
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_1.setViewportView(tabla);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ConsultarArticulo.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
		label.setBounds(0, 0, 552, 316);
		contentPanel.add(label);
	}



	public void rellenarTabla(ArrayList<Articulo> articulos) {
		// cargar la tabla
		DefaultTableModel dtm = new DefaultTableModel();

		String [] encabezados={ "NOMBRE", "PROVEEDOR", "PRECIO", "EXISTENCIAS" };
		
		dtm.setColumnIdentifiers(encabezados);
		for (Articulo articulo : articulos) {
			String[] fila={ articulo.getNombre(), articulo.getProveedor(), String.valueOf(articulo.getPrecio()), String.valueOf(articulo.getExistencias()) };
			dtm.addRow(fila);
		}
		tabla.setModel(dtm);
		TableRowSorter<DefaultTableModel> modeloOrdenado = new TableRowSorter<DefaultTableModel>(dtm);
		tabla.setRowSorter(modeloOrdenado);
	}
}
