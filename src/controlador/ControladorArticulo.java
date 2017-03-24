package controlador;

import vista.*;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.*;

public class ControladorArticulo {

	//un atributo por cada ventana de Articulos-->5
	//un atributo por cada Tabla de la BD-->   1
	private GestionArticulo gestionArticulo;
	private NuevoArticulo nuevoArticulo;
	private BorrarArticulo borrarArticulo;
//	private ListarArticulos  listarArticulos;

	private ModeloArticulo modeloArticulo;

	public ControladorArticulo() {
		super();
		
		
	}
	
	
	public void insertarArticulo(String nombre,String proveedor,double precio,int existencias){
		
		Articulo articulo=new Articulo();
		
		articulo.setNombre(nombre);
		articulo.setProveedor(proveedor);
		articulo.setPrecio(precio);
		articulo.setExistencias(existencias);
		
		try {
			modeloArticulo.insertar(articulo);
			JOptionPane.showMessageDialog(null, "Articulo añadido con exito");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al insertar nuevo Articulo");
		}
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

//	public ConsultarArticulo getConsultarArticulo() {
//		return consultarArticulo;
//	}
//
//	public void setConsultarArticulo(ConsultarArticulo consultarArticulo) {
//		this.consultarArticulo = consultarArticulo;
//	}
//
//	public ListarArticulos getListarArticulos() {
//		return listarArticulos;
//	}
//
//	public void setListarArticulos(ListarArticulos listarArticulos) {
//		this.listarArticulos = listarArticulos;
//	}

	public ModeloArticulo getModeloArticulo() {
		return modeloArticulo;
	}

	public void setModeloArticulo(ModeloArticulo modeloArticulo) {
		this.modeloArticulo = modeloArticulo;
	}


	public void abrirGestionArticulo() {
		
		gestionArticulo.setVisible(true);
		
	}


	public void abrirNuevoArticulo() {

		nuevoArticulo.setVisible(true);
		
	}


//	public void abrirBorrarArticulo() {
//		
//		ArrayList<Articulo> Articulos=new ArrayList<Articulo>();
//		
//		try {
//			Articulos=modeloArticulo.seleccionarTitulos();
//			borrarArticulo.rellenarLista(Articulos);
//
//			borrarArticulo.setVisible(true);
//			
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR Articulo");
//		}
//	}
//
//
//	public void abrirConsultarArticulo() {
//		
//		ArrayList<Articulo> Articulos;
//		try {
//			Articulos = modeloArticulo.seleccionarTodos();
//			consultarArticulo.rellenarTabla(Articulos);
//
//			consultarArticulo.setVisible(true);
//		
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR Articulo");
//		}
//		
//		
//	}
//	public void abrirListarArticulos() {
//
//		listarArticulos.setVisible(true);
//		
//	}
//
//	public void seleccionarDatosArticulo(String titulo) {
//		
//		try {
//			Articulo Articulo=modeloArticulo.seleccionarDatosArticulo(titulo);
//			borrarArticulo.mostrarDatos(Articulo);
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR Articulo");
//		}
//		
//	}
//
//
//	public void borrarArticulo(String titulo) {
//		
//		try {
//			System.out.println("BORRARArticulo");
//			modeloArticulo.borrarArticulo(titulo);
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "ERROR AL BORRAR Articulo");
//		
		//}
		
	}



	


