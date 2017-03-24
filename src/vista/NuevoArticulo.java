package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorArticulo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class NuevoArticulo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField proveedor;
	private JButton guardar;
	private JLabel lblNewLabel;

	private ControladorArticulo controladorArticulo;
	private JLabel lblPrecio;
	private JTextField precio;
	private JTextField existencias;
	private JLabel label;

	/**
	 * Create the dialog.
	 */
	public NuevoArticulo(JDialog parent, boolean modal) {

		super(parent, modal);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(193, 80, 86, 14);
		contentPanel.add(nombre);

		JLabel lblTitulo = new JLabel("NOMBRE");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(34, 78, 46, 14);
		contentPanel.add(lblTitulo);

		proveedor = new JTextField();
		proveedor.setColumns(10);
		proveedor.setBounds(193, 105, 86, 14);
		contentPanel.add(proveedor);

		JLabel lblAutor = new JLabel("PROVEEDOR");
		lblAutor.setForeground(Color.WHITE);
		lblAutor.setBounds(34, 103, 75, 14);
		contentPanel.add(lblAutor);

		JLabel lblNumDePaginas = new JLabel("EXISTENCIAS");
		lblNumDePaginas.setForeground(Color.WHITE);
		lblNumDePaginas.setBounds(34, 153, 90, 14);
		contentPanel.add(lblNumDePaginas);

		guardar = new JButton("GUARDAR");
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		guardar.setBounds(35, 190, 89, 23);
		contentPanel.add(guardar);

		lblNewLabel = new JLabel("ALTA DE ARTICULO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 11, 300, 14);
		contentPanel.add(lblNewLabel);

		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(190, 190, 89, 23);
		contentPanel.add(btnLimpiar);

		lblPrecio = new JLabel("PRECIO");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setBounds(34, 128, 90, 14);
		contentPanel.add(lblPrecio);

		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(193, 130, 86, 14);
		contentPanel.add(precio);

		existencias = new JTextField();
		existencias.setColumns(10);
		existencias.setBounds(193, 153, 86, 14);
		contentPanel.add(existencias);

		label = new JLabel("");
		label.setIcon(
				new ImageIcon(NuevoArticulo.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
		label.setBounds(0, 0, 434, 261);
		contentPanel.add(label);
	}
}
