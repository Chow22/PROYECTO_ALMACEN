package controlador;

import vista.*;


import javax.swing.JOptionPane;


import modelo.*;

public class ControladorArticulo {

	// un atributo por cada ventana de Articulos-->5
	// un atributo por cada Tabla de la BD--> 1
	private GestionArticulo gestionArticulo;
	private NuevoArticulo nuevoArticulo;
	private BorrarArticulo borrarArticulo;
	// private ListarArticulos listarArticulos;

	private ModeloArticulo modeloArticulo;

	public ControladorArticulo() {
		super();

	}

	public void abrirGestionArticulo() {

		gestionArticulo.setVisible(true);

	}

	public GestionArticulo getGestionArticulo() {
		return gestionArticulo;
	}

	public void setGestionArticulo(GestionArticulo gestionArticulo) {
		this.gestionArticulo = gestionArticulo;
	}

	public NuevoArticulo getNuevoArticulo() {
		return nuevoArticulo;
	}

	public void setNuevoArticulo(NuevoArticulo nuevoArticulo) {
		this.nuevoArticulo = nuevoArticulo;
	}

	public BorrarArticulo getBorrarArticulo() {
		return borrarArticulo;
	}

	public void setBorrarArticulo(BorrarArticulo borrarArticulo) {
		this.borrarArticulo = borrarArticulo;
	}

	public ModeloArticulo getModeloArticulo() {
		return modeloArticulo;
	}

	public void setModeloArticulo(ModeloArticulo modeloArticulo) {
		this.modeloArticulo = modeloArticulo;
	}

	public void abrirNuevoArticulo() {
		nuevoArticulo.setVisible(true);

	}
	
	public void abrirBorrarArticulo() {
		borrarArticulo.setVisible(true);

	}

	public void insertarArticulo(String nombre, String proveedor, double precio, int existencias) {

		Articulo articulo = new Articulo();

		articulo.setNombre(nombre);
		articulo.setProveedor(proveedor);
		articulo.setPrecio(precio);
		articulo.setExistencias(existencias);

		try {
			modeloArticulo.insertar(articulo);
			JOptionPane.showMessageDialog(null, "Articulo añadido con exito");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al insertar nuevo articulo"+e.getMessage());
		}
	}
		public void seleccionarDatosArticulo(String titulo) {
			
			try {
				Articulo libro=modeloArticulo.seleccionarDatosArticulo(titulo);
				borrarArticulo.mostrarDatos(libro);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR LIBRO");
			}
		}


		public void borrarArticulo(String titulo) {
			
			try {
				System.out.println("BORRARLIBRO");
				modeloArticulo.borrarArticulo(titulo);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR AL BORRAR LIBRO");
			
			}
	}

}
