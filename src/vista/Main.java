package vista;


import controlador.ControladorArticulo;
import modelo.ModeloArticulo;



public class Main {

	public static void main(String[] args) {

		// Crear controladores como variables locales del main

		ControladorArticulo controladorArticulo = new ControladorArticulo();
		
		ModeloArticulo modeloArticulo = new ModeloArticulo();
		//ModeloCliente modeloCliente = new ModeloCliente();
		//ModeloPedido modeloPedido = new ModeloPedido();
		
		

		Principal principal = new Principal();
		principal.setControladorArticulo(controladorArticulo);
		// Crear ventanas como variables locales del main
		GestionArticulo gestionArticulo = new GestionArticulo(principal, true);
		gestionArticulo.setControladorArticulo(controladorArticulo);

		NuevoArticulo nuevoArticulo = new NuevoArticulo(gestionArticulo, true);
		nuevoArticulo.setControladorArticulo(controladorArticulo);

		BorrarArticulo borrarArticulo = new BorrarArticulo(gestionArticulo, true);
		borrarArticulo.setControladorArticulo(controladorArticulo);
		//rellenar controlador articulo
		controladorArticulo.setNuevoArticulo(nuevoArticulo);
		controladorArticulo.setBorrarArticulo(borrarArticulo);
		//controladorArticulo.setConsultarArticulo(consultarArticulo);
		controladorArticulo.setGestionArticulo(gestionArticulo);
		//controladorArticulo.setListarArticulos(listarArticulos);
		controladorArticulo.setModeloArticulo(modeloArticulo);
		//abrir la ventana principal
		principal.setVisible(true);
	}

}
