package vista.articulo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorArticulo;
import vista.Principal;
import controlador.ControladorArticulo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GestionArticulo extends JDialog {

	private ControladorArticulo controladorArticulo;
	private NuevoArticulo nuevoArticulo;
	
	public ControladorArticulo getControladorArticulo() {
		return controladorArticulo;
	}

	public void setControladorArticulo(ControladorArticulo controladorArticulo) {
		this.controladorArticulo = controladorArticulo;
	}
	/**
	 * Create the dialog.
	 */
	public GestionArticulo(Principal parent, boolean modal) {

		super(parent, modal);

		
		setBounds(100, 100, 568, 355);
		getContentPane().setLayout(null);
		{
			JButton nuevo = new JButton("NUEVO ARTICULO");
			nuevo.setFont(new Font("Cambria", Font.BOLD, 13));
			nuevo.setBounds(179, 104, 170, 23);
			getContentPane().add(nuevo);
			{
				JButton borrar = new JButton("BORRAR ARTICULO");
				borrar.setFont(new Font("Cambria", Font.BOLD, 12));
				borrar.setBounds(179, 148, 170, 23);
				getContentPane().add(borrar);
				
						JButton listar = new JButton("LISTAR ARTICULO");
						listar.setFont(new Font("Cambria", Font.BOLD, 12));
						listar.setBounds(179, 237, 170, 23);
						getContentPane().add(listar);
						{
							JLabel lblNewLabel = new JLabel("GESTION ARTICULO");
							lblNewLabel.setBounds(120, 37, 296, 23);
							getContentPane().add(lblNewLabel);
							lblNewLabel.setForeground(Color.WHITE);
							lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
							lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 25));
						}
						
						JButton consultar = new JButton("CONSULTAS ARTICULO");
						consultar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controladorArticulo.abrirConsultarArticulo();
							}
						});
						consultar.setFont(new Font("Cambria", Font.BOLD, 12));
						consultar.setBounds(179, 193, 170, 23);
						getContentPane().add(consultar);
						{
							JLabel label = new JLabel("");
							label.setBounds(0, 0, 552, 316);
							getContentPane().add(label);
							label.setIcon(new ImageIcon(
									GestionArticulo.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
						}
						listar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controladorArticulo.abrirListarArticulo();
							}
						});
				borrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorArticulo.abrirBorrarArticulo();
					}
				});
			}
			nuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controladorArticulo.abrirNuevoArticulo();
					
				}
			});
		}
		
	}
}
