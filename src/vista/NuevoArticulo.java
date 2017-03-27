package vista;



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

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166549450617381457L;
	private JTextField nombre;
	private JTextField proveedor;
	private JButton guardar;
	private JLabel lblNewLabel;

	private ControladorArticulo controladorArticulo;
	private JLabel lblPrecio;
	private JTextField precio;
	private JTextField existencias;
	private JLabel label;

	public void setControladorArticulo(ControladorArticulo controladorArticulo) {
		this.controladorArticulo = controladorArticulo;
	}
	public ControladorArticulo getControladorArticulo() {
		return controladorArticulo;
	}
	
	/**
	 * Create the dialog.
	 */
	public NuevoArticulo(JDialog parent, boolean modal) {

		super(parent, modal);

		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(null);
		
				JButton btnLimpiar = new JButton("LIMPIAR");
				btnLimpiar.setFont(new Font("Cambria", Font.PLAIN, 12));
				btnLimpiar.setBounds(329, 272, 89, 23);
				getContentPane().add(btnLimpiar);
				
						guardar = new JButton("GUARDAR");
						guardar.setFont(new Font("Cambria", Font.PLAIN, 12));
						guardar.setBounds(230, 272, 89, 23);
						getContentPane().add(guardar);
						
								existencias = new JTextField();
								existencias.setBounds(286, 211, 66, 15);
								getContentPane().add(existencias);
								existencias.setColumns(10);
								
										precio = new JTextField();
										precio.setBounds(286, 174, 66, 16);
										getContentPane().add(precio);
										precio.setColumns(10);
										
												proveedor = new JTextField();
												proveedor.setBounds(286, 136, 157, 16);
												getContentPane().add(proveedor);
												proveedor.setColumns(10);
												
														nombre = new JTextField();
														nombre.setBounds(286, 98, 157, 16);
														getContentPane().add(nombre);
														nombre.setColumns(10);
														
																lblNewLabel = new JLabel("ALTA DE ARTICULO");
																lblNewLabel.setBounds(98, 30, 320, 34);
																getContentPane().add(lblNewLabel);
																lblNewLabel.setForeground(Color.WHITE);
																lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 25));
																lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
																
																		JLabel lblTitulo = new JLabel("NOMBRE");
																		lblTitulo.setFont(new Font("Cambria", Font.BOLD, 14));
																		lblTitulo.setBounds(98, 98, 75, 14);
																		getContentPane().add(lblTitulo);
																		lblTitulo.setForeground(Color.WHITE);
																		
																				JLabel lblAutor = new JLabel("PROVEEDOR");
																				lblAutor.setFont(new Font("Cambria", Font.BOLD, 14));
																				lblAutor.setBounds(98, 136, 90, 14);
																				getContentPane().add(lblAutor);
																				lblAutor.setForeground(Color.WHITE);
																				
																						lblPrecio = new JLabel("PRECIO");
																						lblPrecio.setFont(new Font("Cambria", Font.BOLD, 14));
																						lblPrecio.setBounds(98, 174, 90, 14);
																						getContentPane().add(lblPrecio);
																						lblPrecio.setForeground(Color.WHITE);
																						
																								JLabel lblNumDePaginas = new JLabel("EXISTENCIAS");
																								lblNumDePaginas.setFont(new Font("Cambria", Font.BOLD, 14));
																								lblNumDePaginas.setBounds(98, 211, 90, 14);
																								getContentPane().add(lblNumDePaginas);
																								lblNumDePaginas.setForeground(Color.WHITE);
																								
																										label = new JLabel("");
																										label.setBounds(0, 0, 552, 316);
																										getContentPane().add(label);
																										label.setIcon(
																												new ImageIcon(NuevoArticulo.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
						guardar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								controladorArticulo.insertarArticulo(nombre.getText(), proveedor.getText(), Double.parseDouble(precio.getText()),Integer.parseInt(precio.getText()));
							}
						});
				btnLimpiar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nombre.setText("");
						proveedor.setText("");
						precio.setText("");
						existencias.setText("");
					}
				});
	}
}
