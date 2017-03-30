package controlador;

import vista.*;
import vista.articulo.BorrarArticulo;
import vista.articulo.ConsultarArticulo;
import vista.articulo.GestionArticulo;
import vista.articulo.ListarArticulo;
import vista.articulo.NuevoArticulo;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.*;

public class ControladorArticulo {

	// un atributo por cada ventana de Articulos-->5
	private ConsultarArticulo consultarArticulo;
	// un atributo por cada Tabla de la BD--> 1
	private GestionArticulo gestionArticulo;
	private NuevoArticulo nuevoArticulo;
	private BorrarArticulo borrarArticulo;
	private ListarArticulo listarArticulo;
	// private ListarArticulos listarArticulos;

	private ModeloArticulo modeloArticulo;

	public ControladorArticulo() {
		super();

	}

	public void abrirGestionArticulo() {

		gestionArticulo.setVisible(true);

	}

	public ListarArticulo getConsultarArticulo() {
		return listarArticulo;
	}

	public void setConsultarArticulo(ListarArticulo consultarArticulo) {
		this.listarArticulo = consultarArticulo;
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
		nuevoArticulo.limpiar();
	}

	public void abrirBorrarArticulo() {
		
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();

		try {
			articulos = modeloArticulo.seleccionarNombres();
			borrarArticulo.rellenarLista(articulos);

			borrarArticulo.setVisible(true);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR LIBRO");
		}

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
			JOptionPane.showMessageDialog(null, "Error al insertar nuevo articulo" + e.getMessage());
		}
	}

	public void seleccionarDatosArticulo(String nombre) {

		try {
			Articulo articulo = modeloArticulo.seleccionarDatosArticulo(nombre);
			borrarArticulo.mostrarDatos(articulo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR ARTICULO");
		}
	}

	public void borrarArticulo(String nombre) {

		try {
			System.out.println("BORRARLIBRO");
			modeloArticulo.borrarArticulo(nombre);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL BORRAR ARTICULO");

		}
	}

	public void abrirListarArticulo() {
		ArrayList<Articulo> articulos;
		try {
			articulos = modeloArticulo.seleccionarTodos();
			listarArticulo.rellenarTabla(articulos);

			listarArticulo.setVisible(true);
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR ARTICULO	"+e.getMessage());
		}
		
	}


	public void seleccionarArticulosPorNombre(String nombre) {
		ArrayList<Articulo> articulos=new ArrayList<Articulo>();
		try {
			articulos=modeloArticulo.seleccionarDatosArticuloNombre(nombre);
			consultarArticulo.rellenarTablaPorNombre(articulos);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR LIBROS");
		}
	}	
	}


