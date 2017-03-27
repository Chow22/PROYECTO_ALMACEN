package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorArticulo;
import controlador.ControladorArticulo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GestionArticulo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ControladorArticulo controladorArticulo;
	
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

		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JButton nuevo = new JButton("NUEVO PRODUCTO");
			nuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controladorArticulo.abrirNuevoArticulo();
				}
			});
			nuevo.setBounds(125, 89, 189, 23);
			contentPanel.add(nuevo);
		}
		{
			JButton borrar = new JButton("BORRAR PRODUCTO");
			borrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controladorArticulo.abrirBorrarArticulo();
				}
			});
			borrar.setBounds(125, 123, 189, 23);
			contentPanel.add(borrar);
		}

		JButton listar = new JButton("LISTAR PRODUCTOS");
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorArticulo.abrirConsultarArticulo();
			}
		});
		listar.setBounds(125, 157, 189, 23);
		contentPanel.add(listar);
		{
			JLabel lblNewLabel = new JLabel("GESTION PRODUCTO");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(101, 30, 234, 23);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(
					GestionArticulo.class.getResource("/imagenes/Abstract-circles-blue-star-light_m.jpg")));
			label.setBounds(0, 0, 434, 261);
			contentPanel.add(label);
		}
	}
}
