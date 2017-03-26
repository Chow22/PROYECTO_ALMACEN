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


	public void abrirGestionArticulo() {
		
		gestionArticulo.setVisible(true);
		
	}




		
	}



	


